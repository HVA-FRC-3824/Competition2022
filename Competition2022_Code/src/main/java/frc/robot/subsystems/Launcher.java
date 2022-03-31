package frc.robot.subsystems;

import frc.robot.RobotContainer;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Launcher extends SubsystemBase 
{
  private WPI_TalonFX m_launcherLaunch;
  private WPI_TalonFX m_launcherAccelerate;
  private WPI_TalonSRX m_launcherIndexTop;
  private WPI_TalonSRX m_launcherIndexBottom;


  public Launcher()
  {
    m_launcherLaunch = new WPI_TalonFX(Constants.LAUNCHER_LAUNCH_ID);
    RobotContainer.configureTalonFX(m_launcherLaunch, false, false, Constants.LAUNCHER_LAUNCH_F, Constants.LAUNCHER_LAUNCH_P,
                                    Constants.LAUNCHER_LAUNCH_I, Constants.LAUNCHER_LAUNCH_D);
    
    m_launcherAccelerate = new WPI_TalonFX(Constants.LAUNCHER_ACCELERATE_ID);
    RobotContainer.configureTalonFX(m_launcherAccelerate, false, false, Constants.LAUNCHER_ACCELERATE_F, Constants.LAUNCHER_ACCELERATE_P,
                                    Constants.LAUNCHER_ACCELERATE_I, Constants.LAUNCHER_ACCELERATE_D);


    m_launcherIndexTop = new WPI_TalonSRX(Constants.LAUNCHER_INDEX_TOP_ID);
    RobotContainer.configureTalonSRX(m_launcherIndexTop, false, FeedbackDevice.CTRE_MagEncoder_Relative, false, false, 
                                    Constants.INTAKE_F, Constants.INTAKE_P,
                                    Constants.INTAKE_I, Constants.INTAKE_D, 0, 0, false);

    m_launcherIndexBottom = new WPI_TalonSRX(Constants.LAUNCHER_INDEX_BOTTOM_ID);
    RobotContainer.configureTalonSRX(m_launcherIndexTop, false, FeedbackDevice.CTRE_MagEncoder_Relative, false, false, 
                                    Constants.INTAKE_F, Constants.INTAKE_P,
                                    Constants.INTAKE_I, Constants.INTAKE_D, 0, 0, false);

    // SmartDashboard.putNumber("Launch Motor Pos", m_launcherLaunch.getSelectedSensorPosition());
    // SmartDashboard.putNumber("Accel Motor Pos", m_launcherAccelerate.getSelectedSensorPosition());
    // SmartDashboard.putNumber("Index Bot Motor Pos", m_launcherIndexBottom.getSelectedSensorPosition());
    // SmartDashboard.putNumber("Index Top Motor Pos", m_launcherIndexTop.getSelectedSensorPosition());




 }

 public double getLaunchVel()
 {
   return m_launcherLaunch.getSelectedSensorVelocity();
 }

 public double getAcceleratorVel()
 {
   return m_launcherAccelerate.getSelectedSensorVelocity();
 }

 public void setLauncherPower(double power)
 {
   m_launcherLaunch.set(ControlMode.PercentOutput, power);
   SmartDashboard.putNumber("Launcher", power);
 }

 public void setAcceleratorPower(double power)
 {
   m_launcherAccelerate.set(ControlMode.PercentOutput, power);
   SmartDashboard.putNumber("Accelerate", power);
 }

 public void setLauncherVelocity(int rpm)
 {
   m_launcherLaunch.set(ControlMode.Velocity, RobotContainer.convertRPMToVelocity(rpm, Constants.TALON_FX_TPR));
   SmartDashboard.putNumber("Launch Desired Vel", RobotContainer.convertRPMToVelocity(rpm, Constants.TALON_FX_TPR));
 }

 public void setAcceleratorVelocity(int rpm)
 {
   m_launcherAccelerate.set(ControlMode.Velocity,  RobotContainer.convertRPMToVelocity(rpm, Constants.TALON_FX_TPR));
   SmartDashboard.putNumber("Accelerator Desired Vel", RobotContainer.convertRPMToVelocity(rpm, Constants.TALON_FX_TPR));
 }

 public void setIndexSpeed(double power)
 {
   m_launcherIndexTop.set(ControlMode.PercentOutput, power);
   m_launcherIndexBottom.set(ControlMode.PercentOutput, -power);
 }

 public void setPresetPos(double launchPower, double acceleratePower)
 {
    this.setLauncherPower(launchPower);
    this.setAcceleratorPower(acceleratePower);
 }

 public void setPresetVel(int launchRPM, int accelRPM)
 {
    this.setLauncherVelocity(launchRPM);
    this.setAcceleratorVelocity(accelRPM);
 }

 public void setLaunchPosition (int pos)
 {
    m_launcherLaunch.set(ControlMode.Position, pos);
 }
 
}