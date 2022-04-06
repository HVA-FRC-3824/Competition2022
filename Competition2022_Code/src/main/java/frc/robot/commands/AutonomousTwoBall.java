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
    addCommands
    (
      //Get launcher to target RPM

      //Wait for launch speed-up

      //Start index

      //Wait for launch

      //Stop launch & index

      //Turn around 

      //Wait for turn

      //Follow path to pick up 2nd cargo

      //Start intake

      //Wait for intake & path following

      //Stop chassis & turn around

      //Stop intake

      //Start launcher

      //Wait for turn

      //Stop chassis

      //Wait for launch speed-up

      //Start index

      //Wait for launch

      //Stop launcher & index
    );
  }
}