package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class OI{
  //#region Declaration
  /* Joystick */
  private static Joystick       m_driverJoystick;
  private static Joystick       m_operatorJoystick;
  private static Joystick       m_testJoystick;

  /* Button */

  //Chassis
  public static JoystickButton m_toggleLimelightBtn;
  public static JoystickButton m_turnToTargetBtn;
  public static JoystickButton m_toggleDriveModeBtn;

  //Climb
  public static JoystickButton m_leftClimbBtn;
  public static JoystickButton m_rightClimbBtn;
  public static JoystickButton m_toggleClimbBtn;

  //Defense mode
  public static JoystickButton m_toggleDefenseModeBtn;

  //Intake
  private static JoystickButton m_startIntakeBtn;

  //Launcher
  private static JoystickButton m_launchSequenceBtn;
  private static JoystickButton m_indexLauncherBtn;

  private static JoystickButton m_toggleSystemsBtn;

  //Test
  private static JoystickButton m_autoTurnChassisBtn;
  private static JoystickButton m_autoTarmacLaunchBtn;
  private static JoystickButton m_autoHubLaunchBtn;
  private static JoystickButton m_autoOnePathBtn;
  private static JoystickButton m_autoTwoPathBtn;
  private static JoystickButton m_indexTestBtn;
  //#endregion

  public OI(){
    //#region Instantiate
    /* Joysticks */
    m_driverJoystick     = new Joystick(Constants.DRIVER_JOYSTICK_PORT);
    m_operatorJoystick   = new Joystick(Constants.OPERATOR_JOYSTICK_PORT);
    m_testJoystick       = new Joystick(Constants.TEST_JOYSTICK_PORT);

    /* Buttons */

    //Chassis
    m_toggleLimelightBtn = new JoystickButton(m_operatorJoystick, Constants.TOGGLE_LIMELIGHT_BTN_ID);
    m_turnToTargetBtn    = new JoystickButton(m_operatorJoystick, Constants.TURN_TO_TARGET_BTN_ID);
    m_toggleDriveModeBtn = new JoystickButton(m_driverJoystick, Constants.TOGGLE_DRIVE_MODE_BTN_ID);

    //Climb
    m_leftClimbBtn       = new JoystickButton(m_operatorJoystick, Constants.LEFT_CLIMB_BTN_ID);
    m_rightClimbBtn      = new JoystickButton(m_operatorJoystick, Constants.RIGHT_CLIMB_BTN_ID);
    m_toggleClimbBtn     = new JoystickButton(m_operatorJoystick, Constants.TOGGLE_CLIMB_BTN_ID);  

    //Defense
    m_toggleDefenseModeBtn = new JoystickButton(m_operatorJoystick, Constants.TOGGLE_DEFENSE_BTN_ID);

    //Intake
    m_startIntakeBtn       = new JoystickButton(m_operatorJoystick, Constants.INTAKE_BTN_ID);

    //Launcher
    m_launchSequenceBtn    = new JoystickButton(m_operatorJoystick, Constants.LAUNCH_BTN_ID);
    m_indexLauncherBtn     = new JoystickButton(m_operatorJoystick, Constants.LAUNCHER_INDEX_BTN_ID);

    m_toggleSystemsBtn     = new JoystickButton(m_operatorJoystick, Constants.TOGGLE_SYSTEMS_BTN_ID);

    //Test
    m_autoTurnChassisBtn   = new JoystickButton(m_testJoystick, Constants.AUTO_TURN_CHASSIS_BTN_ID);
    m_autoTarmacLaunchBtn  = new JoystickButton(m_testJoystick, Constants.AUTO_TARMAC_LAUNCH_BTN_ID);
    m_autoHubLaunchBtn     = new JoystickButton(m_testJoystick, Constants.AUTO_HUB_LAUNCH_BTN_ID);
    m_autoOnePathBtn       = new JoystickButton(m_testJoystick, Constants.AUTO_ONE_PATH_BTN_ID);
    m_autoTwoPathBtn       = new JoystickButton(m_testJoystick, Constants.AUTO_TWO_PATH_BTN_ID);
    m_indexTestBtn         = new JoystickButton(m_testJoystick, Constants.INDEX_TEST_BTN_ID);
    //#endregion
  }

  //Get driver joystick for use in commands
  public Joystick getDriverJoystick(){
    return m_driverJoystick;
  }

  //Bind commands to buttons
  public void configureButtonBindings(){
    //Chassis
    m_turnToTargetBtn.whenPressed(RobotContainer.m_inlineCommands.m_turnToTarget);
    m_turnToTargetBtn.whenReleased(RobotContainer.m_inlineCommands.m_driveWithJoystick);
    m_toggleLimelightBtn.whenPressed(RobotContainer.m_inlineCommands.m_toggleLimelight);  
    m_toggleDriveModeBtn.whenPressed(RobotContainer.m_inlineCommands.m_toggleDriveMode);

    //Climb
    m_leftClimbBtn.whenPressed(RobotContainer.m_inlineCommands.m_moveLeftClimb);
    m_leftClimbBtn.whenReleased(RobotContainer.m_inlineCommands.m_stopLeftClimb);
    m_rightClimbBtn.whenPressed(RobotContainer.m_inlineCommands.m_moveRightClimb);
    m_rightClimbBtn.whenReleased(RobotContainer.m_inlineCommands.m_stopRightClimb);

    m_toggleClimbBtn.whenPressed(RobotContainer.m_inlineCommands.m_toggleClimb);

    //Defense
    m_toggleDefenseModeBtn.whenPressed(RobotContainer.m_inlineCommands.m_toggleDefenseMode);

    //Intake
    m_startIntakeBtn.whenPressed(RobotContainer.m_inlineCommands.m_startIntake);
    m_startIntakeBtn.whenReleased(RobotContainer.m_inlineCommands.m_stopIntake);

    //Launch
    m_indexLauncherBtn.whenPressed(RobotContainer.m_inlineCommands.m_startLaunchIndex);
    m_indexLauncherBtn.whenReleased(RobotContainer.m_inlineCommands.m_stopLaunchIndex);

    m_launchSequenceBtn.whenPressed(RobotContainer.m_inlineCommands.m_startLaunchSequence);
    m_launchSequenceBtn.whenReleased(RobotContainer.m_inlineCommands.m_stopLaunchSequence);

    m_toggleSystemsBtn.whenPressed(RobotContainer.m_inlineCommands.m_toggleSystems);

    //Test
    m_autoTurnChassisBtn.whenPressed(RobotContainer.m_inlineCommands.m_autoTurnChassis);

    m_autoTarmacLaunchBtn.whenPressed(RobotContainer.m_inlineCommands.m_autoTarmacLaunch);
    m_autoHubLaunchBtn.whenPressed(RobotContainer.m_inlineCommands.m_autoHubLaunch);

    m_autoOnePathBtn.whenPressed(RobotContainer.m_inlineCommands.m_autoOnePath);
    m_autoTwoPathBtn.whenPressed(RobotContainer.m_inlineCommands.m_autoTwoPath);

    m_indexTestBtn.whenPressed(RobotContainer.m_inlineCommands.m_startLaunchIndex);
    m_indexTestBtn.whenReleased(RobotContainer.m_inlineCommands.m_stopLaunchIndex);
  }
}