package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;

import java.time.Instant;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

/*
[Placeholder text]
*/
public class AutonomousOneBall extends SequentialCommandGroup{
    public AutonomousOneBall(){
        addCommands(

        //follow path off Tarmac
        new InstantCommand(() -> RobotContainer.m_chassis.convertSwerveValues(-0.12, 0.4, 0.0)), //0.45

        //wait for path following
        new WaitCommand(1.1),

        //stop chassis
        // new InstantCommand(() -> RobotContainer.m_chassis.autoDrive(0.7)))
        new InstantCommand(() -> RobotContainer.m_chassis.convertSwerveValues(0.0, 0.0, 0.0))

        // //start launcher and index
        // new InstantCommand(() -> RobotContainer.m_launcher.setPreset(Constants.AUTO_LAUNCHER_TARMAC_LAUNCH_POWER, Constants.AUTO_LAUNCHER_TARMAC_ACCELERATE_POWER)).alongWith(
        //                          new WaitCommand(1)).andThen(new InstantCommand(() -> RobotContainer.m_launcher.setIndexSpeed(-0.4))),

        // //wait for launch
        // new WaitCommand(1),

        // //stop launcher
        // new InstantCommand(() -> RobotContainer.m_launcher.setPreset(0.0, 0.0)).alongWith(new InstantCommand(() -> RobotContainer.m_launcher.setIndexSpeed(0.0)))

    
        );
    }

}