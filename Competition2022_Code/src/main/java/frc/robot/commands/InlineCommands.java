package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.RobotContainer;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;

/** Inline commands allow the creation of new commands without a new CommandBase file.
 *  Usage: single/double commands (Example: extending a piston)
 *  Can be used in other files (other commands or OI.java for binding commands to buttons).
 *  For chains of commands (Example: ten-ball autonomous command sequence), create a separate CommandBase/CommandGroup file.
 */
public class InlineCommands {



  /*
  ██████  ███████  ██████ ██       █████  ██████  ███████    
  ██   ██ ██      ██      ██      ██   ██ ██   ██ ██             
  ██   ██ █████   ██      ██      ███████ ██████  █████           
  ██   ██ ██      ██      ██      ██   ██ ██   ██ ██                  
  ██████  ███████  ██████ ███████ ██   ██ ██   ██ ███████                                                                     
  */


    
  /* Chassis */
  public final Command m_driveWithJoystick;
  public final Command m_turnToTarget;

  /* Climb */
  public final Command m_moveLeftClimb;
  public final Command m_moveRightClimb;

  public final Command m_stopLeftClimb;
  public final Command m_stopRightClimb;

  public final Command m_toggleClimb;

  /* Intake */
  public final Command m_startIntake;
  public final Command m_stopIntake;
   
  /* Launch */
  public final Command m_startLaunchSequence;
  public final Command m_stopLaunchSequence;
  public final Command m_startLaunchIndex;
  public final Command m_stopLaunchIndex;

  /* Limelight */
  public final Command m_toggleLimelight;

  /* Testing */
  // public final Command m_launcherSetPos;
  // public final Command m_accelSetPos;
  // public final Command m_indexTopSetPos;
  // public final Command m_indexBottomSetPos;
  
  public InlineCommands(){


    /**
    ██ ███    ██ ███████ ████████  █████  ███    ██ ████████ ██  █████  ████████ ███████ 
    ██ ████   ██ ██         ██    ██   ██ ████   ██    ██    ██ ██   ██    ██    ██      
    ██ ██ ██  ██ ███████    ██    ███████ ██ ██  ██    ██    ██ ███████    ██    █████   
    ██ ██  ██ ██      ██    ██    ██   ██ ██  ██ ██    ██    ██ ██   ██    ██    ██      
    ██ ██   ████ ███████    ██    ██   ██ ██   ████    ██    ██ ██   ██    ██    ██████
     */


    /* Chassis */
    m_driveWithJoystick =
      new RunCommand(() -> RobotContainer.m_chassis.convertSwerveValues(RobotContainer.m_OI.getDriverJoystick().getRawAxis(0), 
        RobotContainer.m_OI.getDriverJoystick().getRawAxis(1), RobotContainer.m_OI.getDriverJoystick().getRawAxis(4)), RobotContainer.m_chassis);

    m_turnToTarget = 
      new TurnToTarget().andThen(new InstantCommand(() -> RobotContainer.m_limelight.setModeDriver()));
  
    /* Climb */
    m_moveLeftClimb =
      new InstantCommand(() -> RobotContainer.m_climb.setLeftClimbPower(Constants.CLIMB_POWER));
    m_moveRightClimb =
      new InstantCommand(() -> RobotContainer.m_climb.setRightClimbPower(Constants.CLIMB_POWER));

    m_stopLeftClimb = 
      new InstantCommand(() -> this.m_moveLeftClimb.cancel()).andThen(new InstantCommand(() -> RobotContainer.m_climb.setLeftClimbPower(0)));
    m_stopRightClimb = 
      new InstantCommand(() -> this.m_moveRightClimb.cancel()).andThen(new InstantCommand(() -> RobotContainer.m_climb.setRightClimbPower(0)));

    m_toggleClimb =
      new InstantCommand(() -> RobotContainer.m_climb.toggleClimb());

    /* Intake */
    m_startIntake =
      new InstantCommand(() -> RobotContainer.m_intake.setIntakeVelocity(Constants.INTAKE_WHEEL_RPM));
    m_stopIntake =
      new InstantCommand(() -> RobotContainer.m_intake.setIntakePower(0));
    
    /* Launcher */
    m_startLaunchSequence = 
      new InstantCommand(() -> RobotContainer.m_launcher.setLauncherVelocity(Constants.LAUNCHER_LAUNCH_RPM)).alongWith(
        new InstantCommand(() -> RobotContainer.m_launcher.setAcceleratorVelocity(Constants.LAUNCHER_ACCEL_RPM)));

    m_stopLaunchSequence =
      new InstantCommand(() -> this.m_startLaunchSequence.cancel()).alongWith(new InstantCommand(() -> RobotContainer.m_launcher.setLauncherVelocity(0)).alongWith(
        new InstantCommand(() -> RobotContainer.m_launcher.setAcceleratorVelocity(0))));

    m_startLaunchIndex = 
      new InstantCommand(() -> RobotContainer.m_launcher.setIndexPower(Constants.LAUNCHER_INDEX_POWER));
    m_stopLaunchIndex =
      new InstantCommand(() -> RobotContainer.m_launcher.setIndexPower(0));

    /* Limelight */
    m_toggleLimelight =
      new InstantCommand(() -> RobotContainer.m_limelight.toggleMode());

    // /* LEDs Inline Command Instantiations */
    // m_chaseInwards =
    //   new RunCommand(() -> RobotContainer.m_LEDs.strobeOutward()); 
    // m_chaseOutwards =
    //   new RunCommand(() -> RobotContainer.m_LEDs.toggleableLauncherLEDS()()); 
    // m_rainbow =
    //   new RunCommand(() -> RobotContainer.m_LEDs.rainbow()); 
    // m_neutral = 
    //   new RunCommand(() -> RobotContainer.m_LEDs.neutral());

    /* Swerve */
    // m_driveWithJoystick =
    //   new RunCommand(() -> RobotContainer.m_swerveChassis.driveWithJoystick(RobotContainer.m_OI.getDriverJoystick().getRawAxis(0), 
    //                        RobotContainer.m_OI.getDriverJoystick().getRawAxis(1), RobotContainer.m_OI.getDriverJoystick().getRawAxis(4), true), RobotContainer.m_swerveChassis);

    /* Testing */
    // m_launcherSetPos =
    //   new InstantCommand(() -> RobotContainer.m_launcher.setLaunchPosition(3000));
  }
}