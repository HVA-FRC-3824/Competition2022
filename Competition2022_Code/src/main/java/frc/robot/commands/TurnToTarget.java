package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.RobotContainer;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class TurnToTarget extends CommandBase
{
    private double m_turnOutput;
    private double m_turnError;

    public TurnToTarget()
    {
        /**
     * Require launcher to takeover all launcher input.
     * This will allow this command to set the launcher angle and wheel speeds based on vision.
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

        RobotContainer.m_limelight.setModeVision();
    }

    /**
   * Called every time the scheduler runs while the command is scheduled.
   */
    @Override
    public void execute()
    {
    /* Start by getting the position of the limelight vision */
    m_turnError = RobotContainer.m_limelight.getTargetOffsetX();

    /* Use limelight output to designate how to drive the motors*/
    if (m_turnError >= Constants.CHASSIS_TURN_ERROR_THRESHOLD)
    {
        m_turnOutput = Constants.K_CHASSIS_TURN_VISION_P * m_turnError - Constants.K_CHASSIS_TURN_VISION_MIN;
    }
    else if (m_turnError <= Constants.CHASSIS_TURN_ERROR_THRESHOLD)
    {
        m_turnOutput = Constants.K_CHASSIS_TURN_VISION_P * m_turnError + Constants.K_CHASSIS_TURN_VISION_MIN;
    }
    else
    {
        m_turnOutput = 0.0;
    }

    /* Give the robot the turn value */
    RobotContainer.m_chassis.convertSwerveValues(0, 0, m_turnOutput);
    }

   /**
   * Returns true when the command should end.
   */
    @Override
    public boolean isFinished()
    {
        return false;
    }
}
