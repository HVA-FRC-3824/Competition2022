// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.DefenseMode;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot{
  private Command m_autonomousCommand;
  public static RobotContainer m_robotContainer;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    m_robotContainer = new RobotContainer();
    CameraServer.startAutomaticCapture(0);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic(){
    CommandScheduler.getInstance().run();
    SmartDashboard.putBoolean("Defense mode:", DefenseMode.getDefenseStatus());
  }

  @Override
  public void autonomousInit(){
    // Runs auto if command isn't null
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();
    if (m_autonomousCommand != null) m_autonomousCommand.schedule();
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic(){
    // RobotContainer.m_swerveChassis.updateOdometry();
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit(){
    //Cancels auto at start of teleop, initialize teleop commands, & set Limelight to Vision Mode
    if (m_autonomousCommand != null) m_autonomousCommand.cancel();
    RobotContainer.initializeDefaultCommands();
    RobotContainer.m_limelight.setModeVision();
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic(){
    // SmartDashboard.putNumber("Limelight X", RobotContainer.m_limelight.getTargetOffsetX());
    // SmartDashboard.putNumber("Limelight Y", RobotContainer.m_limelight.getTargetOffsetY());
    // SmartDashboard.putNumber("Limelight Area", RobotContainer.m_limelight.getTargetArea());

    SmartDashboard.putNumber("Launch Current Vel", RobotContainer.m_launcher.getLaunchVel());
    SmartDashboard.putNumber("Accel Current Vel", RobotContainer.m_launcher.getAcceleratorVel());
    SmartDashboard.putNumber("Intake Current Vel", RobotContainer.m_intake.getIntakeVel());
    SmartDashboard.putNumber("Intake Temp", RobotContainer.m_intake.getIntakeTemp());    
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit(){
    RobotContainer.m_limelight.turnOffLED();
  }

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}