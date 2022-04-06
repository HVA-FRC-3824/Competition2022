package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class DefenseMode extends CommandBase{
    public static boolean isDefending = false;
    private double defenseSwervePower;

    public DefenseMode()
    {
      defenseSwervePower = 0.9;
      RobotContainer.m_chassis.swervePower = defenseSwervePower;
    }

    @Override
    public void initialize()
    {
      isDefending = true;
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

    public static boolean isDefending(){
      return isDefending;
    }
}
