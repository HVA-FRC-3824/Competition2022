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
public class AutonomousTwoBall extends SequentialCommandGroup{
  public AutonomousTwoBall(){
    addCommands(
      //Get launcher to target RPM
      new InstantCommand(() -> RobotContainer.m_launcher.setPresetVel(Constants.AUTO_HUB_LAUNCH_RPM, Constants.AUTO_HUB_ACCEL_RPM)),

      //Wait for launch speed-up
      new WaitCommand(2.5),

      //Start index
      new InstantCommand(() -> RobotContainer.m_launcher.setIndexPower(Constants.LAUNCHER_INDEX_POWER)),

      //Wait for launch
      new WaitCommand(3),

      //Stop launch & index
      new InstantCommand(() -> RobotContainer.m_launcher.setPresetVel(0, 0)).
        alongWith(new InstantCommand(() -> RobotContainer.m_launcher.setIndexPower(0.0))),

      //Turn around 
      new InstantCommand(() -> RobotContainer.m_chassis.convertSwerveValues(0, 0, 0.21)),

      //Wait for turn
      new WaitCommand(1.8),

      //Follow path to pick up 2nd cargo
      new InstantCommand(() -> RobotContainer.m_chassis.convertSwerveValues(0, 0.4, 0)),

      //Start intake
      new InstantCommand(() -> RobotContainer.m_intake.setIntakePower(Constants.INTAKE_WHEEL_POWER)),

      //Wait for intake & path following
      new WaitCommand(2.25),

      //Stop chassis & turn around
      new InstantCommand(() -> RobotContainer.m_chassis.convertSwerveValues(0, 0, 0.21)),

      //Stop intake
      new InstantCommand(() -> RobotContainer.m_intake.setIntakePower(0.0)),

      //Wait for turn
      new WaitCommand(1.8),

      //Stop chassis
      new InstantCommand(() -> RobotContainer.m_chassis.convertSwerveValues(0, 0, 0)),

      //Start launcher
      new InstantCommand(() -> RobotContainer.m_launcher.setPresetVel(Constants.AUTO_TARMAC_EDGE_LAUNCH_RPM, Constants.AUTO_TARMAC_EDGE_ACCEL_RPM)),

      //Wait for launch speed-up
      new WaitCommand(2.5),

      //Start index      
      new InstantCommand(() -> RobotContainer.m_launcher.setIndexPower(Constants.LAUNCHER_INDEX_POWER)),

      //Wait for launch
      new WaitCommand(3),

      //Stop launcher & index
      new InstantCommand(() -> RobotContainer.m_launcher.setPresetVel(0, 0)).
        alongWith(new InstantCommand(() -> RobotContainer.m_launcher.setIndexPower(0.0)))
    );
  }
}