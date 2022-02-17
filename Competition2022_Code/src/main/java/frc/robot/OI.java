package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class OI
{
  /**
   * Declare all joysticks and buttons here.
   */




//Driver Joystick 
  private static Joystick       m_driverJoystick;

  private static JoystickButton m_setHeadingBtn;
  private static JoystickButton m_setMotorPosition;
  private static JoystickButton m_resetMotorPosition;


// Operator Joystick
  private static Joystick       m_operatorJoystick;

  //#region Launcher
  private static JoystickButton m_startLaunchSequenceBtn;
  private static JoystickButton m_indexLauncherBtn;
  private static JoystickButton m_accelerateLauncherBtn;
  //#endregion

  //#region Intake
  private static JoystickButton m_startIntakeBtn;
  //#endregion

  //#region Climb
  public static JoystickButton m_extendClimb;
  public static JoystickButton m_retractClimb;
  public static JoystickButton m_stopClimb;
  //#endregion

  public OI() 
  {
    /**
     * Instantiate the declared joysticks and joystick buttons here.
     */


    //#region Joysticks
    m_driverJoystick                  = new Joystick(Constants.DRIVER_JOYSTICK_PORT);
    m_operatorJoystick                  = new Joystick(Constants.OPERATOR_JOYSTICK_PORT);
    //#endregion

    //#region Driver joystick
    // m_setHeadingBtn                   = new JoystickButton(m_driverJoystick, Constants.DRIVER_SET_HEADING_BTN_ID);
    // m_setMotorPosition                = new JoystickButton(m_driverJoystick, Constants.DRIVER_SET_MOTOR_POSITION_BTN_ID);
    // m_resetMotorPosition              = new JoystickButton(m_driverJoystick, Constants.DRIVER_RESET_MOTOR_POSITION_BTN_ID);
    //#endregion
    
  //#region Operator joystick
    //#region Launcher
    m_startLaunchSequenceBtn          = new JoystickButton(m_operatorJoystick, Constants.LAUNCH_BTN_ID);
    m_indexLauncherBtn                = new JoystickButton(m_operatorJoystick, Constants.LAUNCHER_INDEX__BTN_ID);
    m_accelerateLauncherBtn           = new JoystickButton(m_operatorJoystick, Constants.LAUNCHER_ACCELERATE_BTN_ID);
    //#endregion

    //#region Intake
    m_startIntakeBtn                  = new JoystickButton(m_operatorJoystick, Constants.INTAKE_BTN_ID);
    //#endregion

    //#region Climb
    m_extendClimb = new JoystickButton(m_operatorJoystick, Constants.EXTEND_CLIMB_BTN_ID);
    m_retractClimb = new JoystickButton(m_operatorJoystick, Constants.EXTEND_CLIMB_BTN_ID);
    //#endregion
  //#endregion
  
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
    m_setHeadingBtn.whenPressed(RobotContainer.m_inlineCommands.m_setHeading);

    m_setMotorPosition.whenPressed(RobotContainer.m_inlineCommands.m_setMotorPosition);

    m_resetMotorPosition.whenPressed(RobotContainer.m_inlineCommands.m_resetMotorPosition);


    m_startLaunchSequenceBtn.whenPressed(RobotContainer.m_inlineCommands.m_startLaunchSequence);
    m_startLaunchSequenceBtn.whenReleased(RobotContainer.m_inlineCommands.m_stopLaunchSequence);

    m_startIntakeBtn.whenPressed(RobotContainer.m_inlineCommands.m_startIntake);
    m_startIntakeBtn.whenReleased(RobotContainer.m_inlineCommands.m_stopIntake);

    m_accelerateLauncherBtn.whenPressed(RobotContainer.m_inlineCommands.m_startLaunchAccelerate);
    m_accelerateLauncherBtn.whenReleased(RobotContainer.m_inlineCommands.m_stopLaunchAccelerate);

    m_indexLauncherBtn.whenPressed(RobotContainer.m_inlineCommands.m_startLaunchIndex);
    m_indexLauncherBtn.whenPressed(RobotContainer.m_inlineCommands.m_stopLaunchIndex);
  }
}
