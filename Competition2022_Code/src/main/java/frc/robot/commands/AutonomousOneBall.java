package frc.robot.commands;

import frc.robot.Constants;
//import frc.robot.Robot;
import frc.robot.RobotContainer;

//import java.time.Instant;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

/*
* Auto path for moving straight out of the tarmac and launch held cargo
*/
public class AutonomousOneBall extends SequentialCommandGroup{
  public AutonomousOneBall(){
    addCommands
    (
      //Get launcher to target RPM
      new InstantCommand(() -> RobotContainer.m_launcher.setPresetVel(Constants.LAUNCHER_AUTO_RPM, Constants.LAUNCHER_ACCEL_RPM)),

      //Follow path off tarmac
      new InstantCommand(() -> RobotContainer.m_chassis.convertSwerveValues(0.0, 0.4, 0.0)),

      //Wait for path to finish
      new WaitCommand(2.25), //1.4

      //Stop chassis
      new InstantCommand(() -> RobotContainer.m_chassis.convertSwerveValues(0, 0, 0.21)),

      //Wait for turning to finish
      new WaitCommand(0.4), //0.5

      //Stop chassis
      new InstantCommand(() -> RobotContainer.m_chassis.convertSwerveValues(0, 0, 0.0)),

      //Buffer time
      new WaitCommand(2),

      //Set index to target output
      new InstantCommand(() -> RobotContainer.m_launcher.setIndexPower(Constants.LAUNCHER_INDEX_POWER)),

      new WaitCommand(4), //2.5

      //Stop launcher
      new InstantCommand(() -> RobotContainer.m_launcher.setPresetVel(0, 0)),

      //Stop index
      new InstantCommand(() -> RobotContainer.m_launcher.setIndexPower(0.0))
      );
  }
}