package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SwerveChassis extends SubsystemBase
{
  // Declaring swerve objects; module = speed + angle motor
  private SwerveModule m_moduleFR;
  private SwerveModule m_moduleFL;
  private SwerveModule m_moduleBL;
  private SwerveModule m_moduleBR;

  private AHRS m_ahrs;

  private SwerveDriveKinematics m_kinematics;
  private SwerveDriveOdometry m_odometry;

  public SwerveChassis()
  {
    /*
    * Try to instantiate NavX Gyro with exception catch
    */
    try 
    {
        m_ahrs = new AHRS(SPI.Port.kMXP);
    } 
    catch (RuntimeException ex) 
    {
        System.out.println("\nError instantiating navX-MXP:\n" + ex.getMessage() + "\n");
    }

    //Instantiate motors and controllers
    m_moduleFR = new SwerveModule(Constants.FRONT_RIGHT_SPEED_MOTOR_ID, Constants.FRONT_RIGHT_ANGLE_MOTOR_ID, false, false, Constants.ABS_ENCODER_FR_ID);
    m_moduleFL = new SwerveModule(Constants.FRONT_LEFT_SPEED_MOTOR_ID, Constants.FRONT_LEFT_ANGLE_MOTOR_ID, false, false, Constants.ABS_ENCODER_FL_ID);
    m_moduleBL = new SwerveModule(Constants.BACK_LEFT_SPEED_MOTOR_ID, Constants.BACK_LEFT_ANGLE_MOTOR_ID, false, false, Constants.ABS_ENCODER_BL_ID);
    m_moduleBR = new SwerveModule(Constants.BACK_RIGHT_SPEED_MOTOR_ID, Constants.BACK_RIGHT_ANGLE_MOTOR_ID, false, false, Constants.ABS_ENCODER_BR_ID);

    m_kinematics = new SwerveDriveKinematics(Constants.FRONT_RIGHT_WHEEL_LOCATION, Constants.FRONT_LEFT_WHEEL_LOCATION, 
    Constants.BACK_LEFT_WHEEL_LOCATION, Constants.BACK_RIGHT_WHEEL_LOCATION);
    m_odometry = new SwerveDriveOdometry(m_kinematics, m_ahrs.getRotation2d());

    //Set gyro to zero
    // m_ahrs.reset();
  }   

  //Give modules desired direction & magnitude from velocity
  public void driveWithJoystick(double xSpeed, double ySpeed, double xTurn, boolean fieldRelative)
  {
    var swerveModuleStates = m_kinematics.toSwerveModuleStates(fieldRelative
                            ? ChassisSpeeds.fromFieldRelativeSpeeds(xSpeed, ySpeed, xTurn, m_ahrs.getRotation2d())
                            : new ChassisSpeeds(xSpeed, ySpeed, xTurn));

    SwerveDriveKinematics.desaturateWheelSpeeds(swerveModuleStates, Constants.K_MAX_VELOCITY);
    m_moduleFR.setDesiredState(swerveModuleStates[0]);
    m_moduleFL.setDesiredState(swerveModuleStates[1]);
    m_moduleBL.setDesiredState(swerveModuleStates[2]);
    m_moduleBR.setDesiredState(swerveModuleStates[3]);
  }

  //Update robot field-relative position
  public void updateOdometry()
  {
    m_odometry.update(m_ahrs.getRotation2d(), 
    m_moduleFR.getModuleState(), m_moduleFL.getModuleState(), 
    m_moduleBL.getModuleState(), m_moduleBR.getModuleState());
  }
}