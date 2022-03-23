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

  public static final int FRONT_RIGHT_ANGLE_MOTOR_ID                      = 2; //0
  public static final int FRONT_RIGHT_SPEED_MOTOR_ID                      = 3; //1

  public static final int FRONT_LEFT_ANGLE_MOTOR_ID                       = 15; //2
  public static final int FRONT_LEFT_SPEED_MOTOR_ID                       = 12; //3

  public static final int BACK_LEFT_ANGLE_MOTOR_ID                        = 14; //4
  public static final int BACK_LEFT_SPEED_MOTOR_ID                        = 13; //5

  public static final int BACK_RIGHT_ANGLE_MOTOR_ID                       = 0; //6
  public static final int BACK_RIGHT_SPEED_MOTOR_ID                       = 1; //7

  public static final int INTAKE_MOTOR_ID                                 = 0;

  public static final int LAUNCHER_LAUNCH_ID                              = 5;
  public static final int LAUNCHER_ACCELERATE_ID                          = 6;
  public static final int LAUNCHER_INDEX_TOP_ID                           = 0;
  public static final int LAUNCHER_INDEX_BOTTOM_ID                        = 100;

  public static final int ABS_ENCODER_FR_ID                               = 1;
  public static final int ABS_ENCODER_FL_ID                               = 4;
  public static final int ABS_ENCODER_BL_ID                               = 3;
  public static final int ABS_ENCODER_BR_ID                               = 2;



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
  public static final double LAUNCHER_LAUNCH_P                            = 0;  
  public static final double LAUNCHER_LAUNCH_I                            = 0.01;  
  public static final double LAUNCHER_LAUNCH_D                            = 0.0001;  
  public static final double LAUNCHER_LAUNCH_F                            = 0;  
  
  public static final double LAUNCHER_ACCELERATE_P                        = 0;  
  public static final double LAUNCHER_ACCELERATE_I                        = 0.01;  
  public static final double LAUNCHER_ACCELERATE_D                        = 0.0001;  
  public static final double LAUNCHER_ACCELERATE_F                        = 0;  

  public static final double LAUNCHER_INDEX_P                             = 0;  
  public static final double LAUNCHER_INDEX_I                             = 0.1;  
  public static final double LAUNCHER_INDEX_D                             = 0.001;  
  public static final double LAUNCHER_INDEX_F                             = 0;  

  public static final double AUTO_LAUNCHER_TARMAC_ACCELERATE_POWER        = 0.42; //0.45
  public static final double AUTO_LAUNCHER_TARMAC_LAUNCH_POWER            = 0.9;
  public static final double AUTO_LAUNCHER_TARMAC_INDEX_TOP_POWER         = -0.4;
  public static final double AUTO_LAUNCHER_TARMAC_INDEX_BOTTOM_POWER      = -0.4;
 
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
  public static final int LAUNCHER_INDEX_BTN_ID                           = 5;
  public static final int INTAKE_REVERSE_BTN_ID                           = 3;
  public static final int INTAKE_BTN_ID                                   = 1;
  public static final int LEFT_CLIMB_BTN_ID                               = 4;
  public static final int RIGHT_CLIMB_BTN_ID                              = 2;
  public static final int TOGGLE_CLIMB_BTN_ID                             = 7;
  public static final int TURN_TO_TARGET_BTN_ID                           = 2004;
  public static final int TOGGLE_LIMELIGHT_BTN_ID                         = 213;




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

  public static final double K_MAX_VELOCITY                               = 3.0; // m/s
  public static final double K_MODULE_MAX_ANGULAR_VELOCITY                = Math.PI; // 0.5 rotations/sec
  public static final double K_MODULE_MAX_ANGULAR_ACCELERATION            = 2 * Math.PI; //radians/sec^2
  public static final double K_MAX_ACCELERATION_METERS_PER_SECOND_SQUARED = 3.0; 
 


  public static final int K_ABSOLUTE_ENCODER_UPR                          = 4096; //units per rotation

  /* Wheel Specs */
  public static final Translation2d BACK_LEFT_WHEEL_LOCATION              = new Translation2d(-12.5 , 10.75);
  public static final Translation2d BACK_RIGHT_WHEEL_LOCATION             = new Translation2d(-12.5 , -10.75);
  public static final Translation2d FRONT_LEFT_WHEEL_LOCATION             = new Translation2d(12.5 , 10.75);        
  public static final Translation2d FRONT_RIGHT_WHEEL_LOCATION            = new Translation2d(12.5 , -10.75);

  public static final double SWERVE_DRIVE_WHEEL_AXLE_LENGTH               = 36;
  public static final double SWERVE_DRIVE_WHEEL_AXLE_WIDTH                = 48;
  public static final double SWERVE_DRIVE_WHEEL_AXLE_DIAGONAL             = 60;
  public static final double K_WHEEL_DIAMETER_METERS                      = 0.1524;

  public static final boolean K_GYRO_REVERSED                             = true;

  public static final double WHEEL_MOTOR_TICKS_PER_REVOLUTION             = 2048 * 12; //kSensorUnitsPerRotation / kGearRatio;

  public static final int K_ENCODER_TICKS_PER_REVOLUTION                  = 28300;
  public static final double K_ENCODER_DISTANCE_PER_PULSE                 = (K_WHEEL_DIAMETER_METERS * Math.PI) / 
          
                                                                            (double) K_ENCODER_TICKS_PER_REVOLUTION;


  /* Use robot characterization tool for these values. */
  public static final double K_STATIC_VOLT                                = 0.372; // volts
  public static final double K_VELOCITY_VOLT                              = 3.09; // volt seconds / meter
  public static final double K_ACCELERATION_VOLT                          = 0.154; // volt seconds ^2/meter
  // public static final double K_P_DRIVE_VEL                                = 0.00425;
  // public static final double K_TRACK_WIDTH_METERS                         = 0.774;


  // public static final int K_MAX_VOLTAGE                                   = 10;   // Maximum voltage is 10V rather than nominal battery voltage 
  //                                                                                 // of 12V for "headroom" in dealing with voltage sag." */

  // public static final double K_RAMSETE_B                                  = 2;  //TODO check these out
  // public static final double K_RAMSETE_ZETA                               = 0.7;


}
