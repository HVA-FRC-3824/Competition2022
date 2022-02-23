package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.RobotContainer;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

/*
[Placeholder text]
*/
public class AutonomousTwoBall extends SequentialCommandGroup{
    public AutonomousTwoBall(){
        addCommands(
        //start launcher
        new InstantCommand(() -> RobotContainer.m_launcher.setPreset(Constants.LAUNCHER_AUTO_TARMAC_LAUNCH_RPM,
                                 Constants.LAUNCHER_AUTO_TARMAC_ACCELERATE_RPM)),
        //wait for balls to launch
        new WaitCommand(1.5),
        //stop launcher
        new InlineCommands().m_stopLaunchSequence,
        //start intake
        new InstantCommand(() -> RobotContainer.m_intake.setIntakePower(Constants.AUTO_INTAKE_WHEEL_POWER)),
        //follow path to pick up ball

        //TODO Write running code

        //wait for reset
        new WaitCommand(0.5),
        //stop intake
        new InstantCommand(() -> RobotContainer.m_intake.setIntakePower(0)),
        //follow path back to launch point

        //TODO Write running code

        //start launcher
        new InstantCommand(() -> RobotContainer.m_launcher.setPreset(Constants.LAUNCHER_AUTO_TARMAC_LAUNCH_RPM,
                                 Constants.LAUNCHER_AUTO_TARMAC_ACCELERATE_RPM)),
        //wait for balls to launch
        new WaitCommand(1.5),
        //stop launcher
        new InlineCommands().m_stopLaunchSequence
        );
    }

}