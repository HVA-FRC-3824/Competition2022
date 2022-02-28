package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.sensors.CANCoder;

import frc.robot.RobotContainer;

public class SwerveModule {
    private final WPI_TalonFX m_driveMotor;
    private final WPI_TalonFX m_turnMotor;

    private final CANCoder m_absoluteEncoder;
    private final boolean absoluteEncoderReversed;
    private final double absoluteEncoderOffsetRad;

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

            
        }
}
