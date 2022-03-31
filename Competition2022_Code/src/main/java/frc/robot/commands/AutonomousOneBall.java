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

        // //start launcher and index
        new InstantCommand(() -> RobotContainer.m_launcher.setPreset(Constants.AUTO_LAUNCHER_TARMAC_LAUNCH_POWER, Constants.AUTO_LAUNCHER_TARMAC_ACCELERATE_POWER)).alongWith(
                                 new WaitCommand(1)).andThen(new InstantCommand(() -> RobotContainer.m_launcher.setIndexSpeed(-0.4))),

        // //wait for launch
        new WaitCommand(1),

        // //stop launcher
        new InstantCommand(() -> RobotContainer.m_launcher.setPreset(0.0, 0.0)).alongWith(new InstantCommand(() -> RobotContainer.m_launcher.setIndexSpeed(0.0))),

        //follow path off Tarmac
<<<<<<< HEAD
        new InstantCommand(() -> RobotContainer.m_chassis.convertSwerveValues(0.0, 0.4, 0.0)), //0.45
=======
        new InstantCommand(() -> RobotContainer.m_chassis.convertSwerveValues(0.12, 0.4, 0.0)), //0.45
>>>>>>> master

        //wait for path following
        new WaitCommand(1.1), //1.5

        //stop chassis
        // new InstantCommand(() -> RobotContainer.m_chassis.autoDrive(0.7)))
        new InstantCommand(() -> RobotContainer.m_chassis.convertSwerveValues(0.0, 0.0, 0.0)),
        
        //start launcher
        new InstantCommand(() -> RobotContainer.m_launcher.setPresetVel(Constants.LAUNCHER_LAUNCH_RPM, Constants.LAUNCHER_ACCEL_RPM)).alongWith(
                                 new WaitCommand(2.05)).andThen(new InstantCommand(() -> RobotContainer.m_launcher.setIndexSpeed(Constants.AUTO_LAUNCHER_TARMAC_INDEX_POWER))),

        //stop launcher
        new InstantCommand(() -> RobotContainer.m_launcher.setPresetVel(0, 0)),

        //stop index
        new InstantCommand(() -> RobotContainer.m_launcher.setIndexSpeed(0.0))
        );
    }

}