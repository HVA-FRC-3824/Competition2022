package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
//import frc.robot.Constants;
import frc.robot.RobotContainer;

public class AutonomousRight extends SequentialCommandGroup {
  public AutonomousRight(){
    addCommands(
      //Move off tarmac
      new InstantCommand(() -> RobotContainer.m_chassis.convertSwerveValues(0.2, 0.4, 0)),

      //Wait for path following
      new WaitCommand(1.3),

      //Stop chassis
      new InstantCommand(() -> RobotContainer.m_chassis.convertSwerveValues(0, 0, 0))
    );
  }
}
