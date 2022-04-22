package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.RobotContainer;

//import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TurnToTarget extends CommandBase
{
  private double m_turnOutput; //Value to give turn motors
  private double m_turnError; //Offset

  public TurnToTarget()
  {
  /**
   * Require chassis to take over all chassis input.
   * Allows command to set chassis angle based on vision.
   */
    addRequirements(RobotContainer.m_chassis);
  }

  /**
 * Called when the command is initially scheduled.
 */
  @Override
  public void initialize()
  {
    m_turnOutput = 0.0;
    m_turnError = 0.0;
    RobotContainer.m_chassis.limelightTurn = true;

    RobotContainer.m_limelight.setModeVision();
  }

  /**
  * Called every time the scheduler runs while the command is scheduled.
  */
  @Override
  public void execute(){
    //Get position of limelight vision
    m_turnError = RobotContainer.m_limelight.getTargetOffsetX();
    SmartDashboard.putNumber("Target Horizontal Offset", RobotContainer.m_limelight.getTargetOffsetX());

    //Use limelight output to designate or adjust turn value
    if (m_turnError >= Constants.CHASSIS_TURN_ERROR_THRESHOLD){
      m_turnOutput = Constants.K_CHASSIS_TURN_VISION_P * m_turnError - Constants.K_CHASSIS_TURN_VISION_MIN;
    }
    else if (m_turnError <= Constants.CHASSIS_TURN_ERROR_THRESHOLD){
      m_turnOutput = Constants.K_CHASSIS_TURN_VISION_P * m_turnError + Constants.K_CHASSIS_TURN_VISION_MIN;
    }

    //Give robot turn value
    RobotContainer.m_chassis.convertSwerveValues(0, 0, m_turnOutput);

    SmartDashboard.putNumber("Turn Output", m_turnOutput);
  }

  /**
  * Returns true when the command should end.
  */
  @Override
  public boolean isFinished(){
    RobotContainer.m_chassis.limelightTurn = false;
    return false;
  }
}
