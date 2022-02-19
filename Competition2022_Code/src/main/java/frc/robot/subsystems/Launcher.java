package frc.robot.subsystems;

import frc.robot.subsystems.*;
import frc.robot.RobotContainer;
import frc.robot.Constants;
import frc.robot.commands.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Launcher extends SubsystemBase 
{
  private WPI_TalonFX m_launcherHood;
  private WPI_TalonFX m_launcherLaunch;
  private WPI_TalonFX m_launcherAccelerate;
  private WPI_TalonSRX m_launcherIndex;


  public Launcher()
  {
    m_launcherHood = new WPI_TalonFX(Constants.LAUNCHER_HOOD_ID);
    RobotContainer.configureTalonFX(m_launcherHood, false, false, Constants.LAUNCHER_HOOD_F, Constants.LAUNCHER_HOOD_P,
                                    Constants.LAUNCHER_HOOD_I, Constants.LAUNCHER_HOOD_D);

    m_launcherLaunch = new WPI_TalonFX(Constants.LAUNCHER_LAUNCH_ID);
    RobotContainer.configureTalonFX(m_launcherLaunch, false, false, Constants.LAUNCHER_LAUNCH_F, Constants.LAUNCHER_LAUNCH_P,
                                    Constants.LAUNCHER_LAUNCH_I, Constants.LAUNCHER_LAUNCH_D);
    
    m_launcherAccelerate = new WPI_TalonFX(Constants.LAUNCHER_ACCELERATE_ID);
    RobotContainer.configureTalonFX(m_launcherAccelerate, false, false, Constants.LAUNCHER_ACCELERATE_F, Constants.LAUNCHER_ACCELERATE_P,
                                    Constants.LAUNCHER_ACCELERATE_I, Constants.LAUNCHER_ACCELERATE_D);


    m_launcherIndex = new WPI_TalonSRX(Constants.LAUNCHER_INDEX_ID);
    RobotContainer.configureTalonSRX(m_launcherIndex, false, FeedbackDevice.CTRE_MagEncoder_Relative, false, false, 
                                    Constants.INTAKE_F, Constants.INTAKE_P,
                                    Constants.INTAKE_I, Constants.INTAKE_D, 0, 0, false);
 }

 public void setLauncherSpeed(double power)
 {
   m_launcherLaunch.set(ControlMode.PercentOutput, power);
   SmartDashboard.putNumber("Launcher", power);
 }

 public void setAcceleratorSpeed(double power)
 {
   m_launcherAccelerate.set(ControlMode.PercentOutput, power);
   SmartDashboard.putNumber("Accelerate", power);
 }

 public void setIndexSpeed(double power)
 {
   m_launcherIndex.set(ControlMode.PercentOutput, power);
 }

}