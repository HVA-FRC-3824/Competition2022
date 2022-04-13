package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class DefenseMode extends CommandBase{
  public static boolean isDefending = false;
  private double defenseSwervePower;

  public DefenseMode(){
    defenseSwervePower = 0.9;
    this.stopSubsystems();
  }

  @Override
  public void initialize(){
    isDefending = true;
    RobotContainer.m_chassis.swervePower = defenseSwervePower;
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

  public static boolean getDefenseStatus(){
    return isDefending;
  }

  public void stopSubsystems(){
    RobotContainer.m_climb.getClimbLeft().stopMotor();
    RobotContainer.m_climb.getClimbRight().stopMotor();
  }
}
