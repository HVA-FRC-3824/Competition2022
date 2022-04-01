package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.RobotContainer;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

/*
* Auto path for moving straight out of the tarmac and launch held cargo
*/
public class AutonomousOneBall extends SequentialCommandGroup{
  public AutonomousOneBall(){
    addCommands(
      //follow path off Tarmac
      new InstantCommand(() -> RobotContainer.m_chassis.convertSwerveValues(0.0, 0.4, 0.0)), //0.45

      //wait for path following
      new WaitCommand(1.3), //1.1, didn't get far enough

      //stop chassis
      new InstantCommand(() -> RobotContainer.m_chassis.convertSwerveValues(0.0, 0.0, 0.0)),
          
      //start launcher
      new InstantCommand(() -> RobotContainer.m_launcher.setPresetVel(Constants.LAUNCHER_LAUNCH_RPM, Constants.LAUNCHER_ACCEL_RPM)).alongWith(
        new WaitCommand(2.05)).andThen(new InstantCommand(() -> RobotContainer.m_launcher.setIndexPower(Constants.AUTO_LAUNCHER_TARMAC_INDEX_POWER))),

      //stop launcher
      new InstantCommand(() -> RobotContainer.m_launcher.setPresetVel(0, 0)),

      //stop index
      new InstantCommand(() -> RobotContainer.m_launcher.setIndexPower(0.0))
    );
  }
}