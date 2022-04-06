package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DefenseMode extends CommandBase{
    public boolean isDefending = false;

    public DefenseMode()
    {
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
      return isDefending;
    }
}
