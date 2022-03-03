package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.sensors.CANCoder;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.ProfiledPIDCommand;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class SwerveModule {
    private final WPI_TalonFX m_driveMotor;
    private final WPI_TalonFX m_turnMotor;

    private final CANCoder m_absoluteEncoder;
    private final boolean absoluteEncoderReversed;
    private final double absoluteEncoderOffsetRad;

    private final PIDController m_drivePIDController = new PIDController(Constants.K_CHASSIS_TURN_P, Constants.K_CHASSIS_TURN_I, Constants.K_CHASSIS_TURN_D);
    private final ProfiledPIDController m_turningPIDController = new ProfiledPIDController(Constants.K_CHASSIS_RIGHT_ANGLE_P, Constants.K_CHASSIS_RIGHT_ANGLE_I, Constants.K_CHASSIS_RIGHT_ANGLE_D, 
                                                                 new TrapezoidProfile.Constraints(Constants.K_MODULE_MAX_ANGULAR_VELOCITY, Constants.K_MODULE_MAX_ANGULAR_ACCELERATION));

    private final SimpleMotorFeedforward m_driveFeedforward = new SimpleMotorFeedforward(Constants.K_STATIC_VOLT, Constants.K_VELOCITY_VOLT, Constants.K_ACCELERATION_VOLT);
    private final SimpleMotorFeedforward m_turnFeedforward = new SimpleMotorFeedforward(Constants.K_STATIC_VOLT, Constants.K_VELOCITY_VOLT, Constants.K_ACCELERATION_VOLT);

    public SwerveModule(int driveMotorId, int turningMotorId, boolean driveMotorReversed, boolean turningMotorReversed, int absoluteEncoderId,
        double absoluteEncoderOffset, boolean absoluteEncoderReversed)
        {
            this.absoluteEncoderOffsetRad = absoluteEncoderOffset;
            this.absoluteEncoderReversed = absoluteEncoderReversed;
            m_absoluteEncoder = new CANCoder(absoluteEncoderId);

            m_driveMotor = new WPI_TalonFX(driveMotorId);
            RobotContainer.configureTalonFX(m_driveMotor, false, false, 0, 0, 0, 0);

            m_turnMotor = new WPI_TalonFX(turningMotorId);
            RobotContainer.configureTalonFX(m_turnMotor, false, false, 0, 0, 0, 0);

            m_turningPIDController.enableContinuousInput(-Math.PI, Math.PI); 
        }

    public SwerveModuleState getModuleState()
    {
        return new SwerveModuleState(m_driveMotor.getSelectedSensorVelocity() * Constants.K_ENCODER_DISTANCE_PER_PULSE * 1000, new Rotation2d(m_turnMotor.getSelectedSensorPosition() 
                                     * 2 * Math.PI/Constants.K_ENCODER_TICKS_PER_REVOLUTION));
    }

    /**
     * Sets and optimizes desired state for module
     * @param desiredState Desired ServeModuleState with speed and angle
     */
    public void setDesiredState(SwerveModuleState desiredState)
    {
        // Optimize reference state to avoid spinning > 90 degrees
        SwerveModuleState state = SwerveModuleState.optimize(desiredState, new Rotation2d(m_turnMotor.getSelectedSensorPosition()));

        // Calculate drive motor output from drive PID Controller
        final double driveOutput = m_drivePIDController.calculate(m_turnMotor.getSelectedSensorVelocity() * Constants.K_ENCODER_DISTANCE_PER_PULSE * 1000, state.speedMetersPerSecond);
        final double driveFeedforward = m_driveFeedforward.calculate(state.speedMetersPerSecond);

        // Calculate turning motor output from turning PID Controller
        final double turnOutput = m_turningPIDController.calculate(m_turnMotor.getSelectedSensorPosition(), state.angle.getRadians());
        final double turnFeedforward = m_turnFeedforward.calculate(m_turningPIDController.getSetpoint().velocity);

        m_driveMotor.setVoltage(driveOutput + driveFeedforward);
        m_turnMotor.setVoltage(turnOutput + turnFeedforward);
    }
}
