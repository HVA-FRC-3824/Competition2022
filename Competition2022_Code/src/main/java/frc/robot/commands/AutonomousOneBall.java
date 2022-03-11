package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;

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
        // //start launcher and index
        new InstantCommand(() -> RobotContainer.m_launcher.setPreset(Constants.AUTO_LAUNCHER_TARMAC_LAUNCH_POWER, Constants.AUTO_LAUNCHER_TARMAC_ACCELERATE_POWER)).alongWith(
                                 new WaitCommand(0.7)).andThen(new InstantCommand(() -> RobotContainer.m_launcher.setIndexSpeed(-0.4))),

        // //wait for balls to launch
        new WaitCommand(1),

        // //stop launcher
        new InstantCommand(() -> RobotContainer.m_launcher.setPreset(0.0, 0.0)).alongWith(new InstantCommand(() -> RobotContainer.m_launcher.setIndexSpeed(0.0))),

        //start intake
        new InstantCommand(() -> RobotContainer.m_intake.setIntakePower(0.35)),

        //follow path off Tarmac
        new InstantCommand(() -> RobotContainer.m_chassis.convertSwerveValues(0.0, 0.45, 0.0)),

        //wait for path following
        new WaitCommand(1.5),

        //stop chassis
        // new InstantCommand(() -> RobotContainer.m_chassis.autoDrive(0.7)))
        new InstantCommand(() -> RobotContainer.m_chassis.convertSwerveValues(0.0, 0.0, 0.0)),

        //start launcher and index
        new InstantCommand(() -> RobotContainer.m_launcher.setPreset(Constants.AUTO_LAUNCHER_TARMAC_LAUNCH_POWER, Constants.AUTO_LAUNCHER_TARMAC_ACCELERATE_POWER)).alongWith(
                                 new WaitCommand(0.8)).andThen(new InstantCommand(() -> RobotContainer.m_launcher.setIndexSpeed(-0.4))),

        //wait for launch
        new WaitCommand(1),

        //stop launcher and intake
        new InstantCommand(() -> RobotContainer.m_launcher.setPreset(0.0, 0.0)).alongWith(new InstantCommand(() -> RobotContainer.m_launcher.setIndexSpeed(0.0)))

    
        );
    }

}