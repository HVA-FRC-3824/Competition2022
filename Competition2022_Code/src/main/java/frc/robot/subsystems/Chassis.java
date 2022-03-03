package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.SPI;
import com.ctre.phoenix.sensors.CANCoder;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;

public class Chassis extends SubsystemBase
{
 /**
   * Declaring objects for the drivetrain
   */

  private AHRS m_ahrs;

  private WPI_TalonFX m_angleMotorFrontRight;
  private WPI_TalonFX m_speedMotorFrontRight;
  
  private WPI_TalonFX m_angleMotorFrontLeft;
  private WPI_TalonFX m_speedMotorFrontLeft;

  private WPI_TalonFX m_angleMotorBackLeft;
  private WPI_TalonFX m_speedMotorBackLeft;

  private WPI_TalonFX m_angleMotorBackRight;
  private WPI_TalonFX m_speedMotorBackRight;

  public CANCoder AbsEncoder1 = new CANCoder(Constants.ABS_ENCODER_1_ID);
  public CANCoder AbsEncoder2 = new CANCoder(Constants.ABS_ENCODER_2_ID);
  public CANCoder AbsEncoder3 = new CANCoder(Constants.ABS_ENCODER_3_ID);
  public CANCoder AbsEncoder4 = new CANCoder(Constants.ABS_ENCODER_4_ID);

  // private SwerveDriveKinematics m_swerveDriveKinematics;
  // private SwerveDriveOdometry m_swerveDriveOdometry;

  //{VX, VY, Speed, Angle, Previous Angle, Offset}
  public double [] frontRight = {0, 0, 0, 0, 0, 0};
  public double [] frontLeft = {0, 0, 0, 0, 0, 0};
  public double [] backLeft = {0, 0, 0, 0, 0, 0};
  public double [] backRight = {0, 0, 0, 0, 0, 0};

  /**
   * Declaring objects for autonomous path following.
   */

    public Chassis()
    {
    /**
     * Instantiating drivetrain objects
     */

     /**
     * Try to instantiate the navx gyro with exception catch
     */
    try 
    {
      m_ahrs = new AHRS(SPI.Port.kMXP);
    } catch (RuntimeException ex) 
    {
      System.out.println("\nError instantiating navX-MXP:\n" + ex.getMessage() + "\n");
    }

    /**
     * Pneumatics objects
     */
    // m_compressor = new Compressor();

    // m_gearShift = new DoubleSolenoid(Constants.CHASSIS_GEARSHIFT_PORT_A, Constants.CHASSIS_GEARSHIFT_PORT_B);

    // m_swerveDriveKinematics = new SwerveDriveKinematics(Constants.FRONT_RIGHT_WHEEL_LOCATION, Constants.FRONT_LEFT_WHEEL_LOCATION, 
    // Constants.BACK_LEFT_WHEEL_LOCATION, Constants.BACK_RIGHT_WHEEL_LOCATION);
    // m_swerveDriveOdometry = new SwerveDriveOdometry(m_swerveDriveKinematics, Rotation2d.fromDegrees(this.getHeading()));

    /**
     * Autonomous path following objects
     */

    /* Used for tracking robot pose. */

    /**
     * doubleious methods to call when chassis subsystem first starts up.
     */
    /* Reset encoders & gyro to ensure autonomous path following is correct. */
    this.zeroHeading();

    m_angleMotorFrontRight = new WPI_TalonFX(Constants.FRONT_RIGHT_ANGLE_MOTOR_ID);
    RobotContainer.configureTalonFX(m_angleMotorFrontRight, false, false, 0.0, Constants.K_CHASSIS_RIGHT_ANGLE_P, 
    Constants.K_CHASSIS_RIGHT_ANGLE_I, Constants.K_CHASSIS_RIGHT_ANGLE_D);

    m_speedMotorFrontRight = new WPI_TalonFX(Constants.FRONT_RIGHT_SPEED_MOTOR_ID);
    RobotContainer.configureTalonFX(m_speedMotorFrontRight, false, false, 0.0, 0.0, 0.0, 0.0);

    m_angleMotorFrontLeft = new WPI_TalonFX(Constants.FRONT_LEFT_ANGLE_MOTOR_ID);
    RobotContainer.configureTalonFX(m_angleMotorFrontLeft, false, false, 0.0, Constants.K_CHASSIS_LEFT_ANGLE_P, 
    Constants.K_CHASSIS_LEFT_ANGLE_I, Constants.K_CHASSIS_LEFT_ANGLE_D);

    m_speedMotorFrontLeft = new WPI_TalonFX(Constants.FRONT_LEFT_SPEED_MOTOR_ID);
    RobotContainer.configureTalonFX(m_speedMotorFrontLeft, false, false, 0.0, 0.0, 0.0, 0.0);
    
    m_angleMotorBackLeft = new WPI_TalonFX(Constants.BACK_LEFT_ANGLE_MOTOR_ID);
    RobotContainer.configureTalonFX(m_angleMotorBackLeft, false, false, 0.0, Constants.K_CHASSIS_LEFT_ANGLE_P, 
    Constants.K_CHASSIS_LEFT_ANGLE_I, Constants.K_CHASSIS_LEFT_ANGLE_D);

    m_speedMotorBackLeft = new WPI_TalonFX(Constants.BACK_LEFT_SPEED_MOTOR_ID);
    RobotContainer.configureTalonFX(m_speedMotorBackLeft, false, false, 0.0, 0.0, 0.0, 0.0);

    m_angleMotorBackRight = new WPI_TalonFX(Constants.BACK_RIGHT_ANGLE_MOTOR_ID);
    RobotContainer.configureTalonFX(m_angleMotorBackRight, false, false, 0.0, Constants.K_CHASSIS_RIGHT_ANGLE_P, 
    Constants.K_CHASSIS_RIGHT_ANGLE_I, Constants.K_CHASSIS_RIGHT_ANGLE_D);

    m_speedMotorBackRight = new WPI_TalonFX(Constants.BACK_RIGHT_SPEED_MOTOR_ID);
    RobotContainer.configureTalonFX(m_speedMotorBackRight, false, false, 0.0, 0.0, 0.0, 0.0);

    // frontRight[3] = AbsEncoder1.getAbsolutePosition();
    // frontLeft[3] = AbsEncoder2.getAbsolutePosition();
    // backRight[3] = AbsEncoder3.getAbsolutePosition();
    // backLeft[3] = AbsEncoder4.getAbsolutePosition();

    }

    /**
   * This method will be called once per scheduler run.
   */
  @Override
  public void periodic()
  {
    /* Update odometry/position tracking of robot. */
    // this.updateOdometry();

    /* Update drivetrain information on SmartDashboard for testing. */
    // this.displayDrivetrainInfo();

    SmartDashboard.putNumber("FR Angle Motor Position", m_angleMotorFrontRight.getSelectedSensorPosition());
    SmartDashboard.putNumber("FR Angle Motor Position Graph", m_angleMotorFrontRight.getSelectedSensorPosition());

    SmartDashboard.putNumber("FL Angle Motor Position", m_angleMotorFrontLeft.getSelectedSensorPosition());
    SmartDashboard.putNumber("BR Angle Motor Position", m_angleMotorBackRight.getSelectedSensorPosition());
    SmartDashboard.putNumber("BL Angle Motor Position", m_angleMotorBackLeft.getSelectedSensorPosition());

    SmartDashboard.putNumber("Encoder  1Value", AbsEncoder1.getPosition());
    SmartDashboard.putNumber("Absolute Encoder 1 Value", AbsEncoder1.getAbsolutePosition());
    SmartDashboard.putNumber("Encoder 2 Value", AbsEncoder2.getPosition());
    SmartDashboard.putNumber("Absolute Encoder 2 Value", AbsEncoder2.getAbsolutePosition());
    SmartDashboard.putNumber("Encoder 3 Value", AbsEncoder3.getPosition());
    SmartDashboard.putNumber("Absolute Encoder 3 Value", AbsEncoder3.getAbsolutePosition());
    SmartDashboard.putNumber("Encoder 4 Value", AbsEncoder4.getPosition());
    SmartDashboard.putNumber("Absolute Encoder 4 Value", AbsEncoder4.getAbsolutePosition());

  }

  public WPI_TalonFX getMotorFR ()
  {
    return m_angleMotorFrontRight;
  }
  public WPI_TalonFX getMotorFL ()
  {
    return m_angleMotorFrontLeft;
  }
  public WPI_TalonFX getMotorBL ()
  {
    return m_angleMotorBackLeft;
  }
  public WPI_TalonFX getMotorBR ()
  {
    return m_angleMotorBackRight;
  }

  public void convertSwerveValues (double x1, double y1, double x2)
  {
      //width and length
      double w = 21.5;
      double l = 25;
      
      //width and length relative ratios
      double wr;
      double lr;

      // Input velocities and turn
      double vX = 0;
      double vY = 0;
      double turn = 0;

      //implificaton for adding turn and strafe velocity for each wheel
      double a;
      double b;
      double c;
      double d;


      //setting deadzone
      if (Math.abs(x2) > 0.2) {turn = x2 *0.7;}    

      //similar triangle to chassis with radius 1 for turn vectors
      double turn_angle = Math.atan2(l, w);
      wr = Math.cos(turn_angle);
      lr = Math.sin(turn_angle);

      //input velocities deadzone
      if (Math.abs(x1) > 0.15) {vX = x1;}
      if (Math.abs(y1) > 0.15) {vY = -y1;}

      //Swerve Gyro Difference Establishing
      // double gyro_current = m_ahrs.getPitch();  
      double gyro_current = m_ahrs.getYaw();
      //adjust strafe vector so that moving forward goes in the set direction and not towards where the robot is facing
      double r = Math.sqrt(vX * vX + vY * vY);
      double strafe_angle = Math.atan2(vY, vX);

      strafe_angle += (gyro_current) / 360 * 2 * Math.PI;
      vX = r * Math.cos(strafe_angle);
      vY = r * Math.sin(strafe_angle);


      //simplification for adding strafe and turn vectors for each wheel
      a = vX - turn * lr;
      b = vX + turn * lr;
      c = vY - turn * wr;
      d = vY + turn * wr;

      //X and Y velocities for each wheel (not sent to wheels)
      //[vx, vy, speed, angle, last angle, offset];
      frontRight[0] = b;
      frontRight[1] = c;
      frontLeft[0] = b;
      frontLeft[1] = d;
      backLeft[0] = a;
      backLeft[1] = d;
      backRight[0] = a;
      backRight[1] = c;

      // finding speed of each wheel based off their x and y velocities
      frontRight[2] = Math.sqrt(Math.abs(b * b + c * c));
      frontLeft[2] = Math.sqrt(Math.abs(b * b + d * d));
      backLeft[2] = Math.sqrt(Math.abs(a * a + d * d));
      backRight[2] = Math.sqrt(Math.abs(a * a + c * c));

      //adjust for exceeding max speed of wheels
      double highestSpeed = Math.max(Math.max(Math.max(frontRight[2], frontLeft[2]), backLeft[2]), backRight[2]);
      if (highestSpeed > 1) {
          frontRight[2] = frontRight[2] / highestSpeed;
          frontLeft[2] = frontLeft[2] / highestSpeed;
          backLeft[2] = backLeft[2] / highestSpeed;
          backRight[2] = backRight[2] / highestSpeed;
      }

      // Update last angle
      frontRight[4] = frontRight[3];
      frontLeft[4] = frontLeft[3];
      backLeft[4] = backLeft[3];
      backRight[4] = backRight[3];

      // Set new angles
      if (!(vX == 0 && vY == 0 && turn == 0)) {
          // Find angle of each wheel based on velocities
          frontRight[3] = Math.atan2(c, b) - Math.PI / 2;
          frontLeft[3] = Math.atan2(d, b) - Math.PI / 2;
          backLeft[3] = Math.atan2(d, a) - Math.PI / 2;
          backRight[3] = Math.atan2(c, a) - Math.PI / 2;
      }

      //when a wheel moves more than PI in one direction, offset so it goes the other way around
      if (Math.abs(frontRight[4] - frontRight[3]) > Math.PI && frontRight[4] < frontRight[3]) {frontRight[5] -= 2 * Math.PI;}
      if (Math.abs(frontRight[4] - frontRight[3]) > Math.PI && frontRight[4] > frontRight[3]) {frontRight[5] += 2 * Math.PI;}
      if (Math.abs(frontLeft[4] - frontLeft[3]) > Math.PI && frontLeft[4] < frontLeft[3]) {frontLeft[5] -= 2 * Math.PI;}
      if (Math.abs(frontLeft[4] - frontLeft[3]) > Math.PI && frontLeft[4] > frontLeft[3]) {frontLeft[5] += 2 * Math.PI;}

      if (Math.abs(backLeft[4] - backLeft[3]) > Math.PI && backLeft[4] < backLeft[3]) {backLeft[5] -= 2 * Math.PI;}
      if (Math.abs(backLeft[4] - backLeft[3]) > Math.PI && backLeft[4] > backLeft[3]) {backLeft[5] += 2 * Math.PI;}
      if (Math.abs(backRight[4] - backRight[3]) > Math.PI && backRight[4] < backRight[3]) {backRight[5] -= 2 * Math.PI;}
      if (Math.abs(backRight[4] - backRight[3]) > Math.PI && backRight[4] > backRight[3]) {backRight[5] += 2 * Math.PI;}

      drive(m_speedMotorFrontRight, m_angleMotorFrontRight, -frontRight[2], -(frontRight[3] + frontRight[5])  / (Math.PI * 2) * Constants.WHEEL_MOTOR_TICKS_PER_REVOLUTION);
      drive(m_speedMotorFrontLeft, m_angleMotorFrontLeft, frontLeft[2], -(frontLeft[3] + frontLeft[5]) / (Math.PI * 2) * Constants.WHEEL_MOTOR_TICKS_PER_REVOLUTION);
      drive(m_speedMotorBackLeft, m_angleMotorBackLeft, backLeft[2], -(backLeft[3] + backLeft[5])  / (Math.PI * 2) * Constants.WHEEL_MOTOR_TICKS_PER_REVOLUTION);
      drive(m_speedMotorBackRight, m_angleMotorBackRight, backRight[2], -(backRight[3] + backRight[5]) / (Math.PI * 2) * Constants.WHEEL_MOTOR_TICKS_PER_REVOLUTION);

      SmartDashboard.putNumber("Wheel one offset", frontRight[5]);
      //SmartDashboard.putNumber("Wheel 3 total encoder ticks",  -(backLeft[3] + backLeft[5])  / (Math.PI * 2) * Constants.WHEEL_MOTOR_TICKS_PER_REVOLUTION);
      //SmartDashboard.putNumber("Wheel 3 Current Pos", m_angleMotorBackLeft.getSelectedSensorPosition());
      //SmartDashboard.putNumber("Wheel 3 Setpoint", m_angleMotorBackLeft.getClosedLoopTarget());
      //SmartDashboard.putNumber("Total Angle ", (frontRight[3] + frontRight[5]));
      //SmartDashboard.putNumber("Last Angle", frontRight[4]);
      SmartDashboard.putNumber("Current Angle 1", frontRight[4]);  
      SmartDashboard.putNumber("Current Angle 2", frontLeft[4]);  
      SmartDashboard.putNumber("Current Angle 3", backLeft[4]);  
      SmartDashboard.putNumber("Current Angle 4", backRight[4]);  

      SmartDashboard.putNumber("Angle 1", -(frontRight[3] + frontRight[5])  / (Math.PI * 2) * Constants.WHEEL_MOTOR_TICKS_PER_REVOLUTION);
      SmartDashboard.putNumber("Angle 2", -(frontLeft[3] + frontLeft[5]) / (Math.PI * 2) * Constants.WHEEL_MOTOR_TICKS_PER_REVOLUTION);
      SmartDashboard.putNumber("Angle 3",  -(backLeft[3] + backLeft[5])  / (Math.PI * 2) * Constants.WHEEL_MOTOR_TICKS_PER_REVOLUTION);
      SmartDashboard.putNumber("Angle 4", -(backRight[3] + backRight[5]) / (Math.PI * 2) * Constants.WHEEL_MOTOR_TICKS_PER_REVOLUTION);

      SmartDashboard.putNumber("Speed 1", frontRight[2]);
      SmartDashboard.putNumber("Speed 2", frontLeft[2]);
      SmartDashboard.putNumber("Speed 3", backLeft[2]);
      SmartDashboard.putNumber("Speed 4", backRight[2]);

      SmartDashboard.putNumber("Swerve Yaw", m_ahrs.getYaw());
      // SmartDashboard.putNumber("Swerve Angle", m_ahrs.getAngle());
      //SmartDashboard.putNumber("Swerve Compass", m_ahrs.getCompassHeading());

    }

  public void drive (WPI_TalonFX speedMotor, WPI_TalonFX angleMotor, double speed, double angle)
  {
    speedMotor.set(speed); //speed*0.75

    double setpoint = angle * (Constants.SWERVE_DRIVE_MAX_VOLTAGE * 1.5);
    
    if (setpoint < 0) 
    {
      setpoint += Constants.SWERVE_DRIVE_MAX_VOLTAGE;
    }

    if (setpoint > Constants.SWERVE_DRIVE_MAX_VOLTAGE)
    {
      setpoint -= setpoint;
    }

    angleMotor.set(TalonFXControlMode.Position, angle); //0

    System.out.println("Speed" + speed);
    SmartDashboard.putNumber("Angle", angle);
  }

  /**
   * Get heading of the robot (no domain).
   * @return the angle of the gyro in degrees.
   */
  public double getAngle()
  {
    return m_ahrs.getAngle();
  }

  /**
   * Reset gyro to zero the heading of the robot.
   */
  public void zeroHeading()
  {
    m_ahrs.reset();
    m_ahrs.setAngleAdjustment(0.0);
  }

  /**
   * Set gyro to a certain heading.
   */
  public void setHeading(double heading)
  {
    m_ahrs.setAngleAdjustment(heading);
  }

  /**
   * Get the distance the left and right sides of the robot have driven with encoder feedback.
   * Convert position (units) to distance (meters).
   * @return the distance travelled of the specified drive train side.
   */
//   public double getLeftEncoderDistance()
//   {
//     return m_rightMaster.getSelectedSensorPosition() * Constants.K_ENCODER_DISTANCE_PER_PULSE;
//   }
//   public double getRightEncoderDistance()
//   {
//     return -m_leftMaster.getSelectedSensorPosition() * Constants.K_ENCODER_DISTANCE_PER_PULSE;
//   }

  /**
   * Get gyro heading between -180 to 180.
   * Uses Math.IEEEremainder to get range of -180 to 180 --> dividend - (divisor * Math.Round(dividend / divisor)).
   * @return the robot's heading in degrees.
   */
  public double getHeading()
  {
    return Math.IEEEremainder(m_ahrs.getAngle(), 360) * (Constants.K_GYRO_REVERSED ? -1.0 : 1.0);
  }



}

