package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.RobotContainer;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;

/** Inline commands allow the creation of new commands without a new CommandBase file.
 * Usage: single/double commands (Example: extending a piston)
 * Can be used in other files (other commands or OI.java for binding commands to buttons).
 * For chains of commands (Example: ten-ball autonomous command sequence), create a separate CommandBase/CommandGroup file.
 */
public class InlineCommands {
  //#region Declare commands
  /* Chassis */
  public final Command m_driveWithJoystick;
  public final Command m_turnToTarget;
  public final Command m_toggleDefenseMode;
  public final Command m_toggleDriveMode;

  /* Climb */
   public final Command m_moveLeftClimb;
   public final Command m_moveRightClimb;

   public final Command m_stopLeftClimb;
   public final Command m_stopRightClimb;

   public final Command m_toggleClimb;

  /* Intake */
  public final Command m_startIntake;
  public final Command m_stopIntake;
  public final Command m_intakeLEDs;
   
  /* Launch */
  public final Command m_startLaunchSequence;
  public final Command m_stopLaunchSequence;
  public final Command m_startLaunchIndex;
  public final Command m_stopLaunchIndex;

  public final Command m_toggleSystems;

  /* Limelight */
  public final Command m_toggleLimelight;

  /* LEDs */
  // public final Command m_launchLEDs;
  public final Command m_defenseLEDs;
  public final Command m_neutral;

  /* Swerve */
  // public final Command m_driveWithJoystick;

  /* Test */
  public final Command m_autoTurnChassis;
  public final Command m_autoTarmacLaunch;
  public final Command m_autoHubLaunch;
  public final Command m_autoOnePath;
  public final Command m_autoTwoPath;
  //#endregion
  
  public InlineCommands(){
    //#region Instantiate commands    
    /* Chassis */
    m_driveWithJoystick =
      new RunCommand(() -> RobotContainer.m_chassis.convertSwerveValues(RobotContainer.m_OI.getDriverJoystick().getRawAxis(0), 
        RobotContainer.m_OI.getDriverJoystick().getRawAxis(1), RobotContainer.m_OI.getDriverJoystick().getRawAxis(4)), RobotContainer.m_chassis);

    m_turnToTarget = 
      new TurnToTarget().andThen(new InstantCommand(() -> RobotContainer.m_limelight.setModeDriver()));

    m_toggleDefenseMode =
      new InstantCommand(() -> RobotContainer.m_chassis.toggleDefenseMode());

    m_toggleDriveMode =
      new InstantCommand(() -> RobotContainer.m_chassis.toggleDriveMode());
    
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
      new InstantCommand(() -> RobotContainer.m_launcher.setLauncherVelocity(Constants.LAUNCHER_LAUNCH_RPM)).alongWith(new InstantCommand(()
      -> RobotContainer.m_launcher.setAcceleratorVelocity(Constants.LAUNCHER_ACCEL_RPM)));

    m_stopLaunchSequence =
      new InstantCommand(() -> this.m_startLaunchSequence.cancel()).alongWith(new InstantCommand(() -> RobotContainer.m_launcher.setLauncherVelocity(0)).alongWith(new InstantCommand(() 
      -> RobotContainer.m_launcher.setAcceleratorVelocity(0))));

    m_startLaunchIndex = 
      new InstantCommand(() -> RobotContainer.m_launcher.setIndexPower(Constants.LAUNCHER_INDEX_POWER));

    m_stopLaunchIndex =
      new InstantCommand(() -> RobotContainer.m_launcher.setIndexPower(0));

    m_toggleSystems =
    new InstantCommand(() -> RobotContainer.m_launcher.toggleLauncher()).alongWith(new InstantCommand(() -> RobotContainer.m_intake.toggleIntake()));

    /* Limelight */
    m_toggleLimelight =
      new InstantCommand(() -> RobotContainer.m_limelight.toggleMode());

    /* LEDs Inline Command Instantiations */
    // m_chaseInwards =
    //   new RunCommand(() -> RobotContainer.m_LEDs.strobeOutward()); 
    // m_chaseOutwards =
    //   new RunCommand(() -> RobotContainer.m_LEDs.toggleableLauncherLEDS()()); 
    // m_launchLEDs =
    //   new RunCommand(() -> RobotContainer.m_LEDs.launchLEDs()); 
    m_neutral = 
      new RunCommand(() -> RobotContainer.m_LEDs.neutral());
    m_defenseLEDs =
      new RunCommand(() -> RobotContainer.m_LEDs.defenseModeLEDs());
    m_intakeLEDs = 
      new RunCommand(() -> RobotContainer.m_LEDs.intakeLEDs());

    /* Swerve */
    // m_driveWithJoystick =
    //   new RunCommand(() -> RobotContainer.m_swerveChassis.driveWithJoystick(RobotContainer.m_OI.getDriverJoystick().getRawAxis(0), 
    //     RobotContainer.m_OI.getDriverJoystick().getRawAxis(1), RobotContainer.m_OI.getDriverJoystick().getRawAxis(4), true), RobotContainer.m_swerveChassis);

    /* Test */
    m_autoTurnChassis =
      new InstantCommand(() -> RobotContainer.m_chassis.convertSwerveValues(0.0, 0.0, 0.21)).alongWith(new WaitCommand(1.8)).andThen(new InstantCommand (() -> 
        RobotContainer.m_chassis.convertSwerveValues(0.0, 0.0, 0.0)));

    m_autoTarmacLaunch =
      new InstantCommand(() -> RobotContainer.m_launcher.setPresetVel(Constants.AUTO_TARMAC_EDGE_LAUNCH_RPM, Constants.AUTO_TARMAC_EDGE_ACCEL_RPM));
    m_autoHubLaunch =
      new InstantCommand(() -> RobotContainer.m_launcher.setPresetVel(Constants.AUTO_HUB_LAUNCH_RPM, Constants.AUTO_HUB_ACCEL_RPM));
    
    m_autoOnePath =
      new InstantCommand(() -> RobotContainer.m_chassis.convertSwerveValues(0.0 , 0.4, 0.0)).alongWith(new WaitCommand(2.25)).andThen(new InstantCommand(() -> 
        RobotContainer.m_chassis.convertSwerveValues(0.0, 0.0, 0.0)));
    
    m_autoTwoPath =
    this.m_autoTurnChassis.andThen(this.m_autoOnePath);

    //#endregion
  }
}