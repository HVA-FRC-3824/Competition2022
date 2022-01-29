package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class OI
{
  /**
   * Declare all joysticks and buttons here.
   */
  /* 
   * Driver Joystick 
   */
  private static Joystick       m_driverJoystick;
  private static JoystickButton m_setHeadingBtn;
  private static JoystickButton m_setMotorPosition;
  private static JoystickButton m_resetMotorPosition;

  public OI() 
  {
    /**
     * Instantiate the declared joysticks and joystick buttons here.
     */

    /*
    //  * Driver Joystick 
     */
    m_driverJoystick                  = new Joystick(Constants.DRIVER_JOYSTICK_PORT);

    m_setHeadingBtn                   = new JoystickButton(m_driverJoystick, Constants.DRIVER_SET_HEADING_BTN_ID);

    m_setMotorPosition                = new JoystickButton(m_driverJoystick, Constants.DRIVER_SET_MOTOR_POSITION_BTN_ID);

    m_resetMotorPosition              = new JoystickButton(m_driverJoystick, Constants.DRIVER_RESET_MOTOR_POSITION_BTN_ID);
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
  }
}
