package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class AutonomousSabotage extends SequentialCommandGroup{
  public AutonomousSabotage(){
    addCommands(
      //Reverse systems
      new InstantCommand(() -> RobotContainer.m_launcher.toggleLauncher()).alongWith(new InstantCommand(() -> RobotContainer.m_intake.toggleIntake())),

      //Run index
      new InstantCommand(() -> RobotContainer.m_launcher.setIndexPower(Constants.LAUNCHER_INDEX_POWER)),

      //Run intake
      new InstantCommand(() -> RobotContainer.m_intake.setIntakeVelocity(Constants.INTAKE_WHEEL_RPM)),

      //Wait for release
      new WaitCommand(1.2),

      //Stop systems
      new InstantCommand(() -> RobotContainer.m_intake.setIntakePower(0.0)),
      new InstantCommand(() -> RobotContainer.m_launcher.setIndexPower(0.0)),

      //Reverse back to normal
      new InstantCommand(() -> RobotContainer.m_launcher.toggleLauncher()).alongWith(new InstantCommand(() -> RobotContainer.m_intake.toggleIntake())),

      //Move off of tarmac
      new InstantCommand(() -> RobotContainer.m_chassis.convertSwerveValues(0, 0.4, 0)),

      //Wait for path off tarmac
      new WaitCommand(1.8),

      //Stop chassis
      new InstantCommand(() -> RobotContainer.m_chassis.convertSwerveValues(0, 0.0, 0))
    );
  }
}