package frc.robot.subsystems;

import javax.xml.xpath.XPathExpression;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.wpilibj.SPI;

import frc.robot.Constants;
import frc.robot.RobotContainer;

public class SwerveChassis {
    // Declaring modules FR = Front Right
    private SwerveModule m_ModuleFR = new SwerveModule(Constants.FRONT_RIGHT_SPEED_MOTOR_ID, Constants.FRONT_RIGHT_ANGLE_MOTOR_ID, false, false, Constants.ABS_ENCODER_FR_ID);
    private SwerveModule m_ModuleFL = new SwerveModule(Constants.FRONT_LEFT_SPEED_MOTOR_ID, Constants.FRONT_LEFT_ANGLE_MOTOR_ID, false, false, Constants.ABS_ENCODER_FL_ID);
    private SwerveModule m_ModuleBL = new SwerveModule(Constants.BACK_LEFT_SPEED_MOTOR_ID, Constants.BACK_LEFT_ANGLE_MOTOR_ID, false, false, Constants.ABS_ENCODER_BL_ID);
    private SwerveModule m_ModuleBR = new SwerveModule(Constants.BACK_RIGHT_SPEED_MOTOR_ID, Constants.BACK_RIGHT_ANGLE_MOTOR_ID, false, false, Constants.ABS_ENCODER_BR_ID);

    private AHRS m_ahrs;

    private SwerveDriveKinematics m_kinematics;
    private SwerveDriveOdometry m_odometry;

    public SwerveChassis()
    {
        /**
         * Try to instantiate the navx gyro with exception catch
         */
        try 
        {
            m_ahrs = new AHRS(SPI.Port.kMXP);
        } 
        catch (RuntimeException ex) 
        {
            System.out.println("\nError instantiating navX-MXP:\n" + ex.getMessage() + "\n");
        }

        m_kinematics = new SwerveDriveKinematics(Constants.FRONT_RIGHT_WHEEL_LOCATION, Constants.FRONT_LEFT_WHEEL_LOCATION, 
        Constants.BACK_LEFT_WHEEL_LOCATION, Constants.BACK_RIGHT_WHEEL_LOCATION);
        m_odometry = new SwerveDriveOdometry(m_kinematics, m_ahrs.getRotation2d());

        m_ahrs.reset();
    }   

    public void driveWithJoystick(double xSpeed, double ySpeed, double xTurn, boolean fieldRelative)
    {
        var swerveModuleStates = m_kinematics.toSwerveModuleStates(
                                 fieldRelative
                                 ? ChassisSpeeds.fromFieldRelativeSpeeds(xSpeed, ySpeed, xTurn, m_ahrs.getRotation2d())
                                 : new ChassisSpeeds(xSpeed, ySpeed, xTurn));

        SwerveDriveKinematics.desaturateWheelSpeeds(swerveModuleStates, Constants.K_MAX_VELOCITY);
        m_ModuleFR.setDesiredState(swerveModuleStates[0]);
        m_ModuleFL.setDesiredState(swerveModuleStates[1]);
        m_ModuleBL.setDesiredState(swerveModuleStates[2]);
        m_ModuleBR.setDesiredState(swerveModuleStates[3]);
    }

    public void updateOdometry()
    {
        m_odometry.update(m_ahrs.getRotation2d(), 
        m_ModuleFR.getModuleState(), m_ModuleFL.getModuleState(), 
        m_ModuleBL.getModuleState(), m_ModuleBR.getModuleState());
    }
}
