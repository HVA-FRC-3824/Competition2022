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
public class AutonomousTwoBall extends SequentialCommandGroup{
    public AutonomousTwoBall(){
        addCommands(
        //start launcher and index
        new InstantCommand(() -> RobotContainer.m_launcher.setIndexSpeed(0.2)).alongWith(new InstantCommand(() -> RobotContainer.m_launcher.setPreset
                                 (Constants.AUTO_LAUNCHER_TARMAC_LAUNCH_POWER, Constants.AUTO_LAUNCHER_TARMAC_ACCELERATE_POWER))),
        //wait for balls to launch
        new WaitCommand(1.5),
        //stop launcher
        new InlineCommands().m_stopLaunchSequence.alongWith(new InlineCommands().m_stopLaunchIndex)
        //follow path off Tarmac 356133
        );
    }

}