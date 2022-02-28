package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class OI
{
  /**
   * Declare all joysticks and buttons here.
   */




  /* Driver Joystick */
  private static Joystick       m_driverJoystick;

  /* Operator Joystick */
  private static Joystick       m_operatorJoystick;

  /* Launcher */
  private static JoystickButton m_launchSequenceBtn;
  private static JoystickButton m_indexLauncherBtn;

  /* Intake */
  private static JoystickButton m_startIntakeBtn;

  /* Climb */
  public static JoystickButton m_leftClimbBtn;
  public static JoystickButton m_rightClimbBtn;
  public static JoystickButton m_toggleClimbBtn;

  /* Limelight */
  public static JoystickButton m_toggleLimelightBtn;
  public static JoystickButton m_turnToTargetBtn;

  public OI() 
  {
    /**
     * Instantiate the declared joysticks and joystick buttons here.
     */

    /*
    //  * Driver Joystick 
     */

    m_driverJoystick                  = new Joystick(Constants.DRIVER_JOYSTICK_PORT);
    m_operatorJoystick                  = new Joystick(Constants.OPERATOR_JOYSTICK_PORT);

    /* Chassis */
    // m_setHeadingBtn                   = new JoystickButton(m_driverJoystick, Constants.DRIVER_SET_HEADING_BTN_ID);
    // m_setMotorPosition                = new JoystickButton(m_driverJoystick, Constants.DRIVER_SET_MOTOR_POSITION_BTN_ID);
    // m_resetMotorPosition              = new JoystickButton(m_driverJoystick, Constants.DRIVER_RESET_MOTOR_POSITION_BTN_ID);
    
    /* 
    // Operator joystick
    */

    /* Launcher */
    m_launchSequenceBtn          = new JoystickButton(m_operatorJoystick, Constants.LAUNCH_BTN_ID);
    m_indexLauncherBtn                = new JoystickButton(m_operatorJoystick, Constants.LAUNCHER_INDEX_BTN_ID);

    /* Intake */
    m_startIntakeBtn                  = new JoystickButton(m_operatorJoystick, Constants.INTAKE_BTN_ID);

    /* Climb */
    m_leftClimbBtn  = new JoystickButton(m_operatorJoystick, Constants.LEFT_CLIMB_BTN_ID);
    m_rightClimbBtn = new JoystickButton(m_operatorJoystick, Constants.RIGHT_CLIMB_BTN_ID);
    m_toggleClimbBtn  = new JoystickButton(m_operatorJoystick, Constants.TOGGLE_CLIMB_BTN_ID);  

    /* Limelight */
    m_toggleLimelightBtn = new JoystickButton(m_operatorJoystick, Constants.TOGGLE_LIMELIGHT_BTN_ID);
    m_turnToTargetBtn = new JoystickButton(m_operatorJoystick, Constants.TURN_TO_TARGET_BTN_ID);
  }

  /**
   * Allows use of driverJoystick/operatorJoystick object outside of OI class.
   * @return access to driverJoystick/operatorJoystick values/attributes.
   */
  public Joystick getDriverJoystick() 
  {
    return m_driverJoystick;
  }

  public void configureButtonBindings()
  {
    // m_setHeadingBtn.whenPressed(RobotContainer.m_inlineCommands.m_setHeading);

    // m_setMotorPosition.whenPressed(RobotContainer.m_inlineCommands.m_setMotorPosition);

    // m_resetMotorPosition.whenPressed(RobotContainer.m_inlineCommands.m_resetMotorPosition);


    m_launchSequenceBtn.whenPressed(RobotContainer.m_inlineCommands.m_startLaunchSequence);
    m_launchSequenceBtn.whenReleased(RobotContainer.m_inlineCommands.m_stopLaunchSequence);

    m_startIntakeBtn.whenPressed(RobotContainer.m_inlineCommands.m_startIntake);
    m_startIntakeBtn.whenReleased(RobotContainer.m_inlineCommands.m_stopIntake);

    m_indexLauncherBtn.whenPressed(RobotContainer.m_inlineCommands.m_startLaunchIndex);
    m_indexLauncherBtn.whenReleased(RobotContainer.m_inlineCommands.m_stopLaunchIndex);

    m_leftClimbBtn.whenPressed(RobotContainer.m_inlineCommands.m_moveLeftClimb);
    m_leftClimbBtn.whenReleased(RobotContainer.m_inlineCommands.m_stopLeftClimb);
    m_rightClimbBtn.whenPressed(RobotContainer.m_inlineCommands.m_moveRightClimb);
    m_rightClimbBtn.whenPressed(RobotContainer.m_inlineCommands.m_stopRightClimb);

    m_toggleClimbBtn.whenPressed(RobotContainer.m_inlineCommands.m_toggleClimb);

    m_turnToTargetBtn.whenPressed(RobotContainer.m_inlineCommands.m_turnToTarget);
    m_turnToTargetBtn.whenReleased(RobotContainer.m_inlineCommands.m_driveWithJoystick);
    m_toggleLimelightBtn.whenPressed(RobotContainer.m_inlineCommands.m_toggleLimelight);

  }
}
