package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class AutonomousSabotage extends SequentialCommandGroup{
  public AutonomousSabotage(){
    addCommands(
      //Reverse systems
      new InstantCommand(() -> RobotContainer.m_launcher.toggleLauncher()).alongWith(new InstantCommand(() -> RobotContainer.m_intake.toggleIntake())),

      //Run index
      new InstantCommand(() -> RobotContainer.m_launcher.setIndexPower(Constants.LAUNCHER_INDEX_POWER))

      //Run intake

      //Stop systems

      //Reverse back to normal

      //Move off of tarmac
    );
  }
}