package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class DefenseMode extends CommandBase{
    public boolean isDefending = false;

    public DefenseMode()
    {
      RobotContainer.m_chassis.swervePower = 1.0;
    }

    @Override
    public void initialize()
    {
    }

    @Override
    public void execute()
    {
    }

    @Override
    public void end(boolean interupted)
    {
    }

    @Override
    public boolean isFinished()
    {
      RobotContainer.m_chassis.swervePower = Constants.SWERVE_POWER;
      return isDefending;
    }
}
