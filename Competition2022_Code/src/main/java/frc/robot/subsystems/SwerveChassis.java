package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.RobotContainer;

public class SwerveChassis {
    // Declaring modules FR = Front Right
    private final SwerveModule m_ModuleFR = new SwerveModule(Constants.FRONT_RIGHT_SPEED_MOTOR_ID, Constants.FRONT_RIGHT_ANGLE_MOTOR_ID, false, false, Constants.ABS_ENCODER_FR_ID);
    private final SwerveModule m_ModuleFL = new SwerveModule(Constants.FRONT_LEFT_SPEED_MOTOR_ID, Constants.FRONT_LEFT_ANGLE_MOTOR_ID, false, false, Constants.ABS_ENCODER_FL_ID);
    private final SwerveModule m_ModuleBL = new SwerveModule(Constants.BACK_LEFT_SPEED_MOTOR_ID, Constants.BACK_LEFT_ANGLE_MOTOR_ID, false, false, Constants.ABS_ENCODER_BL_ID);
    private final SwerveModule m_ModuleBR = new SwerveModule(Constants.BACK_RIGHT_SPEED_MOTOR_ID, Constants.BACK_RIGHT_ANGLE_MOTOR_ID, false, false, Constants.ABS_ENCODER_BR_ID);

}
