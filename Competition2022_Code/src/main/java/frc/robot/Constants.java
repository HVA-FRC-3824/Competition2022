package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.trajectory.TrapezoidProfile.Constraints;

public class Constants
{
    /**
   * Robot Map
   * A collection of ports and IDs for various objects representing hardware.
   */

   /* CAN IDs */
   public static final int FRONT_RIGHT_ANGLE_MOTOR_ID                          = 13; //0
  public static final int FRONT_RIGHT_SPEED_MOTOR_ID                          = 12; //1

  public static final int FRONT_LEFT_ANGLE_MOTOR_ID                          = 15; //2
  public static final int FRONT_LEFT_SPEED_MOTOR_ID                          = 14; //3

  public static final int BACK_LEFT_ANGLE_MOTOR_ID                        = 8; //4
  public static final int BACK_LEFT_SPEED_MOTOR_ID                        = 9; //5

  public static final int BACK_RIGHT_ANGLE_MOTOR_ID                         = 10; //6
  public static final int BACK_RIGHT_SPEED_MOTOR_ID                         = 11; //7

  public static final int LAUNCHER_SPEED_MOTOR_ID                           = 7;
  public static final int LAUNCHER_HOOD_MOTOR_ID                           = 0;
  public static final int LAUNCHER_FEED_MOTOR_ID                           = 0;

  public static final int INTAKE_MOTOR_ID                                   = 0;

  public static final int ABS_ENCODER_1_ID                                  = 1;
  public static final int ABS_ENCODER_2_ID                                  = 2;
  public static final int ABS_ENCODER_3_ID                                  = 3;
  public static final int ABS_ENCODER_4_ID                                  = 4;

  /* Chassis */
  public static final double K_CHASSIS_TURN_P                               = 0;
  public static final double K_CHASSIS_TURN_I                               = 0;
  public static final double K_CHASSIS_TURN_D                               = 0;

  public static final double K_TURN_TOLERANCE_DEG                           = 0;
  public static final double K_TURN_RATE_TOLERANCE_DEG_PER_SEC              = 0;

  public static final double K_CHASSIS_TURN_VISION_P                        = 0.02;
  public static final double K_CHASSIS_TURN_VISION_MIN                      = 0.1;
  public static final double CHASSIS_TURN_ERROR_THRESHOLD                   = 0.5;

  public static final double K_CHASSIS_RIGHT_ANGLE_P                              = 0.2245;    //previous: 0.225
  public static final double K_CHASSIS_RIGHT_ANGLE_I                              = 0.0000185; //previous: 0.0002
  public static final double K_CHASSIS_RIGHT_ANGLE_D                              = 0.000003;  //previous: 0.000005

  public static final double K_CHASSIS_LEFT_ANGLE_P                              = 0.2245;     //previous: 0.225
  public static final double K_CHASSIS_LEFT_ANGLE_I                              = 0.0000185;  //previous: 0.0002
  public static final double K_CHASSIS_LEFT_ANGLE_D                              = 0.000001;   //previous: 0.0000001

  /**
   * Subsystem-Specific Values For Commands
   */


  //#region Launcher
  public static final int LAUNCHER_BOTTOM_ID                                                       = 0;
  public static final int LAUNCHER_MIDDLE_ID                                                       = 0;
  public static final int LAUNCHER_TOP_ID                                                       = 0;
  public static final int LAUNCHER_BOTTOM_P                                                        = 0; //These are all temporary values
  public static final int LAUNCHER_BOTTOM_I                                                        = 0; //These are all temporary values
  public static final int LAUNCHER_BOTTOM_D                                                        = 0; //These are all temporary values
  public static final int LAUNCHER_BOTTOM_F                                                        = 0; //These are all temporary values
 
  public static final int LAUNCHER_MIDDLE_P                                                        = 0; //These are all temporary values
  public static final int LAUNCHER_MIDDLE_I                                                        = 0; //These are all temporary values
  public static final int LAUNCHER_MIDDLE_D                                                        = 0; //These are all temporary values
  public static final int LAUNCHER_MIDDLE_F                                                        = 0; //These are all temporary values
  
  public static final int LAUNCHER_TOP_P                                                        = 0; //These are all temporary values
  public static final int LAUNCHER_TOP_I                                                        = 0; //These are all temporary values
  public static final int LAUNCHER_TOP_D                                                        = 0; //These are all temporary values
  public static final int LAUNCHER_TOP_F                                                        = 0; //These are all temporary values
  //#endregion

  //#region Intake
  public static final int INTAKE_ID                                                          = 0;

  public static final int INTAKE_P                                                           = 0;
  public static final int INTAKE_I                                                           = 0;
  public static final int INTAKE_D                                                           = 0;
  public static final int INTAKE_F                                                           = 0;
  ////#endregion

  //#region Climber
  public static final int CLIMBER_LEFT_ID                                                           = 0;
  public static final int CLIMBER_RIGHT_ID                                                           = 0;
  ////#endregion
  

  /* Chassis */
  public static final double CHASSIS_MAX_POWER                              = 0.7;
  public static final double WHEEL_MOTOR_TICKS_PER_REVOLUTION               = 2048 * 12; //kSensorUnitsPerRotation / kGearRatio;

  public static final double SWERVE_DRIVE_WHEEL_AXLE_LENGTH                 = 36;
  public static final double SWERVE_DRIVE_WHEEL_AXLE_WIDTH                  = 48;
  public static final double SWERVE_DRIVE_WHEEL_AXLE_DIAGONAL               = 60;
  
  /**
   * Driver Joystick Map
   */

  /* Joystick */
  public static final int    DRIVER_JOYSTICK_PORT                           = 0;
  public static final int    OPERATOR_JOYSTICK_PORT                         = 1;

  /* Buttons */

//#region Launcher

  public static final int    LAUNCH_BTN_ID                             = 6;
  public static final int    INTAKE_BTN_ID                               = 5;

//#endregion

  public static final int    DRIVER_SET_HEADING_BTN_ID                      = 4;
  public static final int    DRIVER_SET_MOTOR_POSITION_BTN_ID               = 1;
  public static final int    DRIVER_RESET_MOTOR_POSITION_BTN_ID             = 2;

    /**
     * PID Constants
     */
    public static final int    K_PID_LOOP_IDX                               = 0;
    public static final int    K_SLOT_IDX                                   = 0;
    public static final int    K_TIMEOUT_MS                                 = 30;

  /**
   * Autonomous Constants
   */
  public static final int    K_ENCODER_TICKS_PER_REVOLUTION                 = 28300;
  public static final double K_WHEEL_DIAMETER_METERS                        = 0.1524;
  public static final double K_ENCODER_DISTANCE_PER_PULSE                   = (K_WHEEL_DIAMETER_METERS * Math.PI) / 
                                                                              (double) K_ENCODER_TICKS_PER_REVOLUTION;

  public static final boolean K_GYRO_REVERSED                               = true;

  /* Use robot characterization tool for these values. */
  public static final double K_S_VOLTS                                      = 0.372;
  public static final double K_V_VOLT_SECONDS_PER_METER                     = 3.09;
  public static final double K_A_VOLT_SECONDS_SQUARED_PER_METER             = 0.154;
  public static final double K_P_DRIVE_VEL                                  = 0.00425;
  public static final double K_TRACK_WIDTH_METERS                           = 0.774;
  public static final DifferentialDriveKinematics K_DRIVE_KINEMATICS        = new DifferentialDriveKinematics(K_TRACK_WIDTH_METERS);

  /* Maximum voltage is 10V rather than nominal battery voltage of 12V for 
    "headroom" in dealing with voltage sag." */
  public static final int    K_MAX_VOLTAGE                                  = 10;
  
  public static final double K_MAX_ACCELERATION_METERS_PER_SECOND_SQUARED   = 3.0;

  public static final double K_RAMSETE_B                                    = 2;
  public static final double K_RAMSETE_ZETA                                 = 0.7;

  /**
   * Swerve Constants
   */
  public static final double SWERVE_DRIVE_MAX_VOLTAGE                      = 4.95;
  public static final double SWERVE_GEAR_RATIO                 = 0.0833333; //wheel spins per angle motor spin    
  public static final double SWERVE_TPR                        = 2048 / SWERVE_GEAR_RATIO; //motors ticks per revolution of wheel

  public static final Translation2d BACK_LEFT_WHEEL_LOCATION   = new Translation2d(-12.5 , 10.75); //TODO forward is +X and left is +Y
  public static final Translation2d BACK_RIGHT_WHEEL_LOCATION  = new Translation2d(-12.5 , -10.75); //TODO forward is +X and left is +Y
  public static final Translation2d FRONT_LEFT_WHEEL_LOCATION  = new Translation2d(12.5 , 10.75); //TODO forward is +X and left is +Y        
  public static final Translation2d FRONT_RIGHT_WHEEL_LOCATION = new Translation2d(12.5 , -10.75); //TODO forward is +X and left is +Y

  public static final Constraints ANGLE_CONTROLLER_CONSTRAINTS = new Constraints(0.0, 0.0);
}
