package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class AutonomousRight extends SequentialCommandGroup {
    public AutonomousRight()
    {
    addCommands(

        //start launcher and index
        new InstantCommand(() -> RobotContainer.m_launcher.setPresetPos(Constants.AUTO_LAUNCHER_TARMAC_LAUNCH_POWER, Constants.AUTO_LAUNCHER_TARMAC_ACCELERATE_POWER)).alongWith(
                                 new WaitCommand(0.8)).andThen(new InstantCommand(() -> RobotContainer.m_launcher.setIndexSpeed(Constants.AUTO_LAUNCHER_TARMAC_INDEX_POWER))),

        //wait for launch
        new WaitCommand(1),

        //stop launcher
<<<<<<< HEAD
        new InstantCommand(() -> RobotContainer.m_launcher.setPresetPos(0.0, 0.0))   
=======
        new InstantCommand(() -> RobotContainer.m_launcher.setPreset(0.0, 0.0)),
        
        //follow path off Tarmac
        new InstantCommand(() -> RobotContainer.m_chassis.convertSwerveValues(0.2, 0.45, 0.0)),

        //wait for path following
        new WaitCommand(1.7),

        //stop chassis
        // new InstantCommand(() -> RobotContainer.m_chassis.autoDrive(0.7)))
        new InstantCommand(() -> RobotContainer.m_chassis.convertSwerveValues(0.0, 0.0, 0.0)) 
>>>>>>> master
        );
    }
}
