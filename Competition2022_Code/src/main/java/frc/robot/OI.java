package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class OI
{
  //Joystick declaration
  private static Joystick       m_driverJoystick;
  private static Joystick       m_operatorJoystick;

  //Button declaration
  /* Climb */
  public static JoystickButton m_leftClimbBtn;
  public static JoystickButton m_rightClimbBtn;
  public static JoystickButton m_toggleClimbBtn;

  /* Intake */
  private static JoystickButton m_startIntakeBtn;

  /* Launcher */
  private static JoystickButton m_launchSequenceBtn;
  private static JoystickButton m_indexLauncherBtn;

  /* Limelight */
  public static JoystickButton m_toggleLimelightBtn;
  public static JoystickButton m_turnToTargetBtn;

  public OI() 
  {
    //Instantiate joysticks
    m_driverJoystick     = new Joystick(Constants.DRIVER_JOYSTICK_PORT);
    m_operatorJoystick   = new Joystick(Constants.OPERATOR_JOYSTICK_PORT);

    //Instantiate buttons

    /* Climb */
    m_leftClimbBtn       = new JoystickButton(m_operatorJoystick, Constants.LEFT_CLIMB_BTN_ID);
    m_rightClimbBtn      = new JoystickButton(m_operatorJoystick, Constants.RIGHT_CLIMB_BTN_ID);
    m_toggleClimbBtn     = new JoystickButton(m_operatorJoystick, Constants.TOGGLE_CLIMB_BTN_ID);  

    /* Intake */
    m_startIntakeBtn     = new JoystickButton(m_operatorJoystick, Constants.INTAKE_BTN_ID);

    /* Launcher */
    m_launchSequenceBtn  = new JoystickButton(m_operatorJoystick, Constants.LAUNCH_BTN_ID);
    m_indexLauncherBtn   = new JoystickButton(m_operatorJoystick, Constants.LAUNCHER_INDEX_BTN_ID);

    /* Limelight */
    m_toggleLimelightBtn = new JoystickButton(m_operatorJoystick, Constants.TOGGLE_LIMELIGHT_BTN_ID);
    m_turnToTargetBtn    = new JoystickButton(m_operatorJoystick, Constants.TURN_TO_TARGET_BTN_ID);
  }

  //Get driver joystick for use in commands
  public Joystick getDriverJoystick(){
    return m_driverJoystick;
  }

  //Bind commands to buttons
  public void configureButtonBindings()
  {
    //Chassis
    m_turnToTargetBtn.whenPressed(RobotContainer.m_inlineCommands.m_turnToTarget);
    m_turnToTargetBtn.whenReleased(RobotContainer.m_inlineCommands.m_driveWithJoystick);
    m_toggleLimelightBtn.whenPressed(RobotContainer.m_inlineCommands.m_toggleLimelight);

    //Climb
    m_leftClimbBtn.whenPressed(RobotContainer.m_inlineCommands.m_moveLeftClimb);
    m_leftClimbBtn.whenReleased(RobotContainer.m_inlineCommands.m_stopLeftClimb);
    m_rightClimbBtn.whenPressed(RobotContainer.m_inlineCommands.m_moveRightClimb);
    m_rightClimbBtn.whenReleased(RobotContainer.m_inlineCommands.m_stopRightClimb);

    m_toggleClimbBtn.whenPressed(RobotContainer.m_inlineCommands.m_toggleClimb);

    //Intake
    m_startIntakeBtn.whenPressed(RobotContainer.m_inlineCommands.m_startIntake);
    m_startIntakeBtn.whenReleased(RobotContainer.m_inlineCommands.m_stopIntake);

    //Launch
    m_indexLauncherBtn.whenPressed(RobotContainer.m_inlineCommands.m_startLaunchIndex);
    m_indexLauncherBtn.whenReleased(RobotContainer.m_inlineCommands.m_stopLaunchIndex);

    m_launchSequenceBtn.whenPressed(RobotContainer.m_inlineCommands.m_startLaunchSequence);
    m_launchSequenceBtn.whenReleased(RobotContainer.m_inlineCommands.m_stopLaunchSequence);
  }
}