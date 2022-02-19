package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;

/** Inline commands allow the creation of new commands without a new CommandBase file.
 *  Usage: single/double commands (Example: extending a piston)
 * Can be used in other files (other commands or OI.java for binding commands to buttons).
 * For chains of commands (Example: ten-ball autonomous command sequence), create a separate CommandBase/CommandGroup file.
 */
public class InlineCommands {



  /*
  ██████  ███████  ██████ ██       █████  ██████  ███████                  
  ██   ██ ██      ██      ██      ██   ██ ██   ██ ██                       
  ██   ██ █████   ██      ██      ███████ ██████  █████                    
  ██   ██ ██      ██      ██      ██   ██ ██   ██ ██                       
  ██████  ███████  ██████ ███████ ██   ██ ██   ██ ███████                  
                                                                          
                                                                          
  ██████  ██████  ███    ███ ███    ███  █████  ███    ██ ██████  ███████ 
  ██      ██   ██ ████  ████ ████  ████ ██   ██ ████   ██ ██   ██ ██      
  ██      ██   ██ ██ ████ ██ ██ ████ ██ ███████ ██ ██  ██ ██   ██ ███████ 
  ██      ██   ██ ██  ██  ██ ██  ██  ██ ██   ██ ██  ██ ██ ██   ██      ██ 
  ██████  ██████  ██      ██ ██      ██ ██   ██ ██   ████ ██████  ███████ 
  */
    
  

  /* Chassis */
  public final Command m_driveWithJoystick;

  // public final Command m_setHeading;
  // public final Command m_setMotorPosition;
  // public final Command m_resetMotorPosition;


  public final Command m_startLaunchSequence;
  public final Command m_stopLaunchSequence;
  public final Command m_startLaunchAccelerate;
  public final Command m_stopLaunchAccelerate;
  public final Command m_startLaunchIndex;
  public final Command m_stopLaunchIndex;
  public final Command m_startIntake;
  public final Command m_stopIntake;

//Climber Inline Command Declarations
   public final Command m_extendClimb;
   public final Command m_retractClimb;
   public final Command m_stopClimb;

//   public final Command m_extendClimberRight;
//   public final Command m_retractClimberRight;
//   public final Command m_stopClimberRight;

  /* Control Panel Command Declarations */
  // public final Command m_setControlPanelSpinnerPower;
  // public final Command m_setControlPanelSpinnerRPM;
  // public final Command m_stopControlPanelSpinner;
  
//   /* Defense Mode Commands */
//   public final Command m_toggleDefenseMode;
  
//   /* Intake Inline Command Declarations */
//   public final Command m_toggleIntakePistons;

//   public final Command m_setIntakeWheelsRPM;
//   public final Command m_stopIntakeWheels;

//   /* Launcher Inline Command Declarations */
//   public final Command m_jogLauncherAngleUp;
//   public final Command m_jogLauncherAngleDown;
//   public final Command m_stopLauncherAngle;

//   public final Command m_setLauncherVision; // Turns chassis and sets launcher angle & rpms.
//   public final Command m_setLauncherPreset; // Set launcher angle & rpms to a specified setpoint.
//   public final Command m_stopLaunchSequence; // Enables teleop driving and stops launcher angle & rpms.

//   /* LED Inline Command Declarations */
//   public final Command m_chaseInwards;
//   public final Command m_chaseOutwards;
//   public final Command m_rainbow;
//   public final Command m_neutral;


  
  public InlineCommands()
  {
    /**
     * Instantiate inline commands here.
     */

    /* Chamber Inline Command Instantiations */
    // m_setChamberBaseRPM =
    //   new InstantCommand(() -> RobotContainer.m_chamber.setBaseRPM(Constants.CHAMBER_BASE_RPM));
    // m_stopChamberBase =
    //   new InstantCommand(() -> RobotContainer.m_chamber.setBasePower(0.0));

    // m_setChamberElevatorToLaunch =
    //   new InstantCommand(() -> RobotContainer.m_chamber.setElevatorPower(-0.3));
    // m_setChamberElevatorDown =
    //   new InstantCommand(() -> RobotContainer.m_chamber.setElevatorPower(0.3));
    // m_stopChamberElevator =
    //   new InstantCommand(() -> RobotContainer.m_chamber.setElevatorPower(0.0));

    /* Chassis Inline Command Instantiations */
    // m_driveWithJoystick =
    //   new RunCommand(() -> RobotContainer.m_chassis.teleopDrive(RobotContainer.m_OI.getDriverJoystick().getY(), 
    //                 RobotContainer.m_OI.getDriverJoystick().getTwist()), RobotContainer.m_chassis);
                    
    m_driveWithJoystick =
    new RunCommand(() -> RobotContainer.m_chassis.convertSwerveValues(RobotContainer.m_OI.getDriverJoystick().getRawAxis(0), 
                  RobotContainer.m_OI.getDriverJoystick().getRawAxis(1), RobotContainer.m_OI.getDriverJoystick().getRawAxis(4)), 
                  RobotContainer.m_chassis);
  
    // m_toggleLimelight =
    //   new InstantCommand(() -> RobotContainer.m_limelight.toggleMode());

    // m_setHeading =
    //   new InstantCommand(() -> RobotContainer.m_chassis.zeroHeading());

    // m_setMotorPosition =
    //   new RunCommand(() -> RobotContainer.m_chassis.getMotorFR().set(TalonFXControlMode.Position, 3000));

    // m_resetMotorPosition =
    //   new RunCommand(() -> RobotContainer.m_chassis.getMotorFR().set(TalonFXControlMode.Position, 0));

    m_startLaunchSequence = 
      new InstantCommand(() -> RobotContainer.m_launcher.setLauncherSpeed(0.8));

    m_stopLaunchSequence =
      new InstantCommand(() -> RobotContainer.m_launcher.setLauncherSpeed(0));

    m_startLaunchAccelerate =
      new InstantCommand(() -> RobotContainer.m_launcher.setAcceleratorSpeed(0.6));

    m_stopLaunchAccelerate =
      new InstantCommand(() -> RobotContainer.m_launcher.setAcceleratorSpeed(0));

    m_startLaunchIndex = 
      new InstantCommand(() -> RobotContainer.m_launcher.setIndexSpeed(0.2));

    m_stopLaunchIndex =
      new InstantCommand(() -> RobotContainer.m_launcher.setIndexSpeed(0));

    m_startIntake =
      new InstantCommand(() -> RobotContainer.m_intake.setIntakePower(0));

    m_stopIntake =
      new InstantCommand(() -> RobotContainer.m_intake.setIntakePower(0));

    // /* Climber Inline Command Instantiations */
    // m_extendClimberLeft =
    //   new ClimberSetLeftPower(1);
    // m_retractClimberLeft =
    //   new ClimberSetLeftPower(-1);
    // m_stopClimberLeft =
    //   new InstantCommand(() -> this.m_extendClimberLeft.cancel()).alongWith(new InstantCommand(() -> this.m_retractClimberLeft.cancel()))
    //     .andThen(new InstantCommand(() -> RobotContainer.m_climber.setLeftLiftPower(0.0)).alongWith(new InstantCommand(() -> RobotContainer.m_climber.setLeftReelPower(0.0))));


    //#region Climb commands

      m_extendClimb =
        new InstantCommand(() -> RobotContainer.m_climb.setClimbPower(0.25));
      m_retractClimb =
        new InstantCommand(() -> RobotContainer.m_climb.setClimbPower(-0.25));
      m_stopClimb = 
        new InstantCommand(() -> this.m_extendClimb.cancel()).alongWith(new InstantCommand(() -> this.m_retractClimb.cancel()))
        .andThen(new InstantCommand(() -> RobotContainer.m_climb.setClimbPower(0)).alongWith(new InstantCommand(() -> RobotContainer.m_climb.setClimbPower(0))));

    //#endregion
        
    //#region Intake

    // m_intakeSuck = 
    // new InstantCommand(() -> RobotContainer.m_intake.setIntakePower(-0.5), RobotContainer.m_intake); //tem
    // m_intakeUnsuck = 
    // new InstantCommand(() -> RobotContainer.m_intake.setIntakePower(0.5), RobotContainer.m_intake); 
    // m_intakeStopSucking = 
    // new InstantCommand(() -> RobotContainer.m_intake.setIntakePower(0), RobotContainer.m_intake); 

    //#endregion

    
        /* Control Panel Command Instantiations */
    // m_setControlPanelSpinnerPower =
    //   new InstantCommand(() -> RobotContainer.m_controlPanel.setPanelSpinnerPower(Constants.CONTROL_PANEL_SPINNER_POWER));
    // m_setControlPanelSpinnerRPM = 
    //   new InstantCommand(() -> RobotContainer.m_controlPanel.setPanelSpinnerRPM(Constants.CONTROL_PANEL_SPINNER_RPM));
    // m_stopControlPanelSpinner =
    //   new InstantCommand(() -> RobotContainer.m_controlPanel.setPanelSpinnerPower(0.0));

//     /* Defense Mode Command Instantiations */
//     m_toggleDefenseMode =
//       new InstantCommand(() -> RobotContainer.m_LEDs.toggleDefenseMode());

//     /* Intake Inline Command Instantiations */ 
//     m_toggleIntakePistons =
//       new InstantCommand(() -> RobotContainer.m_intake.toggleExtender());

//     m_setIntakeWheelsRPM = 
//       new InstantCommand(() -> RobotContainer.m_intake.setWheelPower(0.5), RobotContainer.m_intake);
//     m_stopIntakeWheels = 
//       new InstantCommand(() -> RobotContainer.m_intake.setWheelPower(0.0), RobotContainer.m_intake);
      
//     /* Launcher Inline Command Instantiations */
//     m_jogLauncherAngleUp =
//       new RunCommand(() -> RobotContainer.m_launcher.setPivotPower(-Constants.LAUNCHER_PIVOT_JOG_MAGNITUDE));
//     m_jogLauncherAngleDown =
//       new RunCommand(() -> RobotContainer.m_launcher.setPivotPower(Constants.LAUNCHER_PIVOT_JOG_MAGNITUDE));
//     m_stopLauncherAngle =
//       new InstantCommand(() -> RobotContainer.m_launcher.setPivotPower(0.0)).alongWith(new InstantCommand(() -> this.m_jogLauncherAngleUp.cancel()), new InstantCommand(() -> this.m_jogLauncherAngleDown.cancel()));

//     m_setLauncherVision =
//       new ChassisTurnToTarget().andThen(new InstantCommand(() -> RobotContainer.m_limelight.setModeDriver()));
//       //.alongWith(new LauncherAimForTarget(), new InstantCommand(() -> RobotContainer.m_LEDs.setLaunchingStatus(true)))
//     m_setLauncherPreset =
//       new LauncherSetPreset().alongWith(new InstantCommand(() -> RobotContainer.m_LEDs.setLaunchingStatus(true)));
//     m_stopLaunchSequence =
//       new InstantCommand(() -> RobotContainer.m_launcher.stopLauncher(), RobotContainer.m_launcher);

//     /* LEDs Inline Command Instantiations */
//     m_chaseInwards =
//       new RunCommand(() -> RobotContainer.m_LEDs.chaseInward()); 
//     m_chaseOutwards =
//       new RunCommand(() -> RobotContainer.m_LEDs.chaseOutward()); 
//     m_rainbow =
//       new RunCommand(() -> RobotContainer.m_LEDs.rainbow()); 
//     m_neutral = 
//       new RunCommand(() -> RobotContainer.m_LEDs.neutral());
   }
}