package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;

public class Constants
{

  /*
  ██████   ██████  ██████  ████████     ██ ██████  ███████ 
  ██   ██ ██    ██ ██   ██    ██        ██ ██   ██ ██      
  ██████  ██    ██ ██████     ██        ██ ██   ██ ███████ 
  ██      ██    ██ ██   ██    ██        ██ ██   ██      ██ 
  ██       ██████  ██   ██    ██        ██ ██████  ███████ 
  */

  public static final int FRONT_RIGHT_ANGLE_MOTOR_ID                      = 13; //0
  public static final int FRONT_RIGHT_SPEED_MOTOR_ID                      = 12; //1

  public static final int FRONT_LEFT_ANGLE_MOTOR_ID                       = 15; //2
  public static final int FRONT_LEFT_SPEED_MOTOR_ID                       = 14; //3

  public static final int BACK_LEFT_ANGLE_MOTOR_ID                        = 8; //4
  public static final int BACK_LEFT_SPEED_MOTOR_ID                        = 9; //5

  public static final int BACK_RIGHT_ANGLE_MOTOR_ID                       = 10; //6
  public static final int BACK_RIGHT_SPEED_MOTOR_ID                       = 11; //7

  public static final int INTAKE_MOTOR_ID                                 = 0;

  public static final int LAUNCHER_HOOD_ID                                = 0;
  public static final int LAUNCHER_LAUNCH_ID                              = 5;
  public static final int LAUNCHER_ACCELERATE_ID                          = 6;
  public static final int LAUNCHER_INDEX_ID                               = 0;

  public static final int ABS_ENCODER_1_ID                                = 1;
  public static final int ABS_ENCODER_2_ID                                = 2;
  public static final int ABS_ENCODER_3_ID                                = 3;
  public static final int ABS_ENCODER_4_ID                                = 4;



  /*
███████ ██    ██ ██████  ███████ ██    ██ ███████ ████████ ███████ ███    ███ 
██      ██    ██ ██   ██ ██       ██  ██  ██         ██    ██      ████  ████ 
███████ ██    ██ ██████  ███████   ████   ███████    ██    █████   ██ ████ ██ 
     ██ ██    ██ ██   ██      ██    ██         ██    ██    ██      ██  ██  ██ 
███████  ██████  ██████  ███████    ██    ███████    ██    ███████ ██      ██ 
                                                                              
                                                                              
██    ██  █████  ██      ██    ██ ███████ ███████                             
██    ██ ██   ██ ██      ██    ██ ██      ██                                  
██    ██ ███████ ██      ██    ██ █████   ███████                             
 ██  ██  ██   ██ ██      ██    ██ ██           ██                             
  ████   ██   ██ ███████  ██████  ███████ ███████ 
  */



  /* Climber */
  public static final int CLIMB_LEFT_ID                                   = 18;
  public static final int CLIMB_RIGHT_ID                                  = 17;   


  /* Chassis */
  public static final double CHASSIS_MAX_POWER                            = 0.7;
  public static final double K_CHASSIS_TURN_P                             = 0;
  public static final double K_CHASSIS_TURN_I                             = 0;
  public static final double K_CHASSIS_TURN_D                             = 0;

  public static final double K_TURN_TOLERANCE_DEG                         = 0;
  public static final double K_TURN_RATE_TOLERANCE_DEG_PER_SEC            = 0;

  public static final double K_CHASSIS_TURN_VISION_P                      = 0.02;
  public static final double K_CHASSIS_TURN_VISION_MIN                    = 0.1;
  public static final double CHASSIS_TURN_ERROR_THRESHOLD                 = 0.5;
  
  public static final double K_CHASSIS_LEFT_ANGLE_P                       = 0.2245;     //previous: 0.225
  public static final double K_CHASSIS_LEFT_ANGLE_I                       = 0.0000185;  //previous: 0.0002
  public static final double K_CHASSIS_LEFT_ANGLE_D                       = 0.000001;   //previous: 0.0000001

  public static final double K_CHASSIS_RIGHT_ANGLE_P                      = 0.2245;    //previous: 0.225
  public static final double K_CHASSIS_RIGHT_ANGLE_I                      = 0.0000185; //previous: 0.0002
  public static final double K_CHASSIS_RIGHT_ANGLE_D                      = 0.000003;  //previous: 0.000005


  /* Intake */
  public static final int INTAKE_P                                        = 0;
  public static final int INTAKE_I                                        = 0;
  public static final int INTAKE_D                                        = 0;
  public static final int INTAKE_F                                        = 0;

  public static final int AUTO_INTAKE_WHEEL_POWER                         = 3000;


  /* Launcher */
  public static final int LAUNCHER_HOOD_P                                 = 0;  
  public static final int LAUNCHER_HOOD_I                                 = 0;  
  public static final int LAUNCHER_HOOD_D                                 = 0;  
  public static final int LAUNCHER_HOOD_F                                 = 0;  

  public static final int LAUNCHER_LAUNCH_P                               = 0;  
  public static final int LAUNCHER_LAUNCH_I                               = 0;  
  public static final int LAUNCHER_LAUNCH_D                               = 0;  
  public static final int LAUNCHER_LAUNCH_F                               = 0;  
  
  public static final int LAUNCHER_ACCELERATE_P                           = 0;  
  public static final int LAUNCHER_ACCELERATE_I                           = 0;  
  public static final int LAUNCHER_ACCELERATE_D                           = 0;  
  public static final int LAUNCHER_ACCELERATE_F                           = 0;  

  public static final int LAUNCHER_INDEX_P                                = 0;  
  public static final int LAUNCHER_INDEX_I                                = 0;  
  public static final int LAUNCHER_INDEX_D                                = 0;  
  public static final int LAUNCHER_INDEX_F                                = 0;  

  public static final int LAUNCHER_AUTO_TARMAC_ACCELERATE_RPM             = 0;
  public static final int LAUNCHER_AUTO_TARMAC_LAUNCH_RPM                 = 0;
 
  /* LEDS */
  public static final int TOTAL_LEDS                                      = 0;
  public static final int LEDS_ID                                         = 0;
  public static final int LEDS_BUFFER_ID                                  = 0;
  public static final int LAUNCHER_NUM_OF_LEDS                            = 0;


  


  /*
       ██  ██████  ██    ██ ███████ ████████ ██  ██████ ██   ██ 
       ██ ██    ██  ██  ██  ██         ██    ██ ██      ██  ██  
       ██ ██    ██   ████   ███████    ██    ██ ██      █████   
  ██   ██ ██    ██    ██         ██    ██    ██ ██      ██  ██ 
   █████   ██████     ██    ███████    ██    ██  ██████ ██   ██ 
                                                                
  ██████  ██    ██ ████████ ████████  ██████  ███    ██ ███████ 
  ██   ██ ██    ██    ██       ██    ██    ██ ████   ██ ██      
  ██████  ██    ██    ██       ██    ██    ██ ██ ██  ██ ███████ 
  ██   ██ ██    ██    ██       ██    ██    ██ ██  ██ ██      ██ 
  ██████   ██████     ██       ██     ██████  ██   ████ ███████
  */



  /* Joysticks */
  public static final int DRIVER_JOYSTICK_PORT                            = 0;
  public static final int OPERATOR_JOYSTICK_PORT                          = 1;

  /* Buttons */
  public static final int LAUNCH_BTN_ID                                   = 6;
  public static final int LAUNCHER_INDEX__BTN_ID                          = 1;
  public static final int LAUNCHER_ACCELERATE_BTN_ID                      = 5;
  public static final int INTAKE_BTN_ID                                   = 3;
  public static final int LEFT_CLIMB_BTN_ID                               = 4;
  public static final int RIGHT_CLIMB_BTN_ID                              = 2;
  public static final int TOGGLE_CLIMB_BTN_ID                             = 7;




  /*
  ███████ ██      ███████  ██████ ████████ ██████   ██████  ███    ██ ██  ██████ ███████ 
  ██      ██      ██      ██         ██    ██   ██ ██    ██ ████   ██ ██ ██      ██      
  █████   ██      █████   ██         ██    ██████  ██    ██ ██ ██  ██ ██ ██      ███████ 
  ██      ██      ██      ██         ██    ██   ██ ██    ██ ██  ██ ██ ██ ██           ██ 
  ███████ ███████ ███████  ██████    ██    ██   ██  ██████  ██   ████ ██  ██████ ███████ 
                                                                                        
                                                                                        
  ███████ ██████  ███████  ██████ ███████                                                
  ██      ██   ██ ██      ██      ██                                                     
  ███████ ██████  █████   ██      ███████                                                
       ██ ██      ██      ██           ██                                                  
  ███████ ██      ███████  ██████ ███████                                              
  */



  /* Motor Configuration */
  public static final int K_PID_LOOP_IDX                                  = 0;
  public static final int K_SLOT_IDX                                      = 0;
  public static final int K_TIMEOUT_MS                                    = 30;

  /* Swerve */
  public static final double SWERVE_DRIVE_MAX_VOLTAGE                     = 4.95;
  public static final double SWERVE_GEAR_RATIO                            = 0.0833333; //wheel spins per angle motor spin    
  public static final double SWERVE_TPR                                   = 2048 / SWERVE_GEAR_RATIO; //motors ticks per revolution of wheel

  public static final Translation2d BACK_LEFT_WHEEL_LOCATION              = new Translation2d(-12.5 , 10.75);
  public static final Translation2d BACK_RIGHT_WHEEL_LOCATION             = new Translation2d(-12.5 , -10.75);
  public static final Translation2d FRONT_LEFT_WHEEL_LOCATION             = new Translation2d(12.5 , 10.75);        
  public static final Translation2d FRONT_RIGHT_WHEEL_LOCATION            = new Translation2d(12.5 , -10.75);

  public static final double K_MAX_ACCELERATION_METERS_PER_SECOND_SQUARED = 3.0;

  public static final boolean K_GYRO_REVERSED                             = true;

  public static final double SWERVE_DRIVE_WHEEL_AXLE_LENGTH               = 36;
  public static final double SWERVE_DRIVE_WHEEL_AXLE_WIDTH                = 48;
  public static final double SWERVE_DRIVE_WHEEL_AXLE_DIAGONAL             = 60;

  public static final double WHEEL_MOTOR_TICKS_PER_REVOLUTION             = 2048 * 12; //kSensorUnitsPerRotation / kGearRatio;

  public static final int K_ENCODER_TICKS_PER_REVOLUTION                  = 28300;
  public static final double K_WHEEL_DIAMETER_METERS                      = 0.1524;
  public static final double K_ENCODER_DISTANCE_PER_PULSE                 = (K_WHEEL_DIAMETER_METERS * Math.PI) / 
                                                                            (double) K_ENCODER_TICKS_PER_REVOLUTION;

  /* Use robot characterization tool for these values. */
  // public static final double K_S_VOLTS                                    = 0.372; //TODO check these out
  // public static final double K_V_VOLT_SECONDS_PER_METER                   = 3.09;
  // public static final double K_A_VOLT_SECONDS_SQUARED_PER_METER           = 0.154;
  // public static final double K_P_DRIVE_VEL                                = 0.00425;
  // public static final double K_TRACK_WIDTH_METERS                         = 0.774;


  // public static final int K_MAX_VOLTAGE                                   = 10;   // Maximum voltage is 10V rather than nominal battery voltage 
  //                                                                                 // of 12V for "headroom" in dealing with voltage sag." */

  // public static final double K_RAMSETE_B                                  = 2;  //TODO check these out
  // public static final double K_RAMSETE_ZETA                               = 0.7;


}
