package frc.robot.subsystems;

import frc.robot.RobotContainer;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Launcher extends SubsystemBase{
  //Declare launcher objects
  private static WPI_TalonFX m_launcherLaunch;
  private WPI_TalonFX m_launcherAccel;
  private static WPI_TalonSRX m_launcherIndexTop;
  private static WPI_TalonSRX m_launcherIndexBottom;
  private int m_toggleLaunch;
  public static boolean isLaunching;
  public static boolean isIndexing;

  public Launcher(){
    //Set toggle launch to launch ball forward
    m_toggleLaunch = 1;
    //Configure launch motors
    m_launcherLaunch = new WPI_TalonFX(Constants.LAUNCHER_LAUNCH_ID);
      RobotContainer.configureTalonFX(m_launcherLaunch, false, false, Constants.LAUNCHER_LAUNCH_F, Constants.LAUNCHER_LAUNCH_P, Constants.LAUNCHER_LAUNCH_I, Constants.LAUNCHER_LAUNCH_D);
    
    m_launcherAccel = new WPI_TalonFX(Constants.LAUNCHER_ACCEL_ID);
      RobotContainer.configureTalonFX(m_launcherAccel, false, false, Constants.LAUNCHER_ACCEL_F, Constants.LAUNCHER_ACCEL_P, Constants.LAUNCHER_ACCEL_I, Constants.LAUNCHER_ACCEL_D);

    m_launcherIndexTop = new WPI_TalonSRX(Constants.LAUNCHER_INDEX_TOP_ID);
      RobotContainer.configureTalonSRX(m_launcherIndexTop, false, FeedbackDevice.CTRE_MagEncoder_Relative, false, false, Constants.INTAKE_F, 
      Constants.INTAKE_P, Constants.INTAKE_I, Constants.INTAKE_D, 0, 0, false);

    m_launcherIndexBottom = new WPI_TalonSRX(Constants.LAUNCHER_INDEX_BOTTOM_ID);
      RobotContainer.configureTalonSRX(m_launcherIndexTop, false, FeedbackDevice.CTRE_MagEncoder_Relative, false, false, Constants.INTAKE_F, Constants.INTAKE_P,
      Constants.INTAKE_I, Constants.INTAKE_D, 0, 0, false);
  }

  //Get motor velocity for use in commands
  public double getLaunchVel(){
    return m_launcherLaunch.getSelectedSensorVelocity();
  }
  public double getAcceleratorVel(){
    return m_launcherAccel.getSelectedSensorVelocity();
  }

  //Set motor power
  public void setLauncherPower(double power){
    m_launcherLaunch.set(ControlMode.PercentOutput, power);
  }
  public void setAcceleratorPower(double power){
    m_launcherAccel.set(ControlMode.PercentOutput, power);
  }
  public void setIndexPower(double power){
    m_launcherIndexTop.set(ControlMode.PercentOutput, power * m_toggleLaunch);
    m_launcherIndexBottom.set(ControlMode.PercentOutput, -power * m_toggleLaunch);
  }

  //Set launch & accel velocity
  public void setLauncherVelocity(int rpm){
    m_launcherLaunch.set(ControlMode.Velocity, RobotContainer.convertRPMToVelocity(rpm * m_toggleLaunch , Constants.TALON_FX_TPR));
    SmartDashboard.putNumber("Launch Desired Vel", RobotContainer.convertRPMToVelocity(rpm * m_toggleLaunch, Constants.TALON_FX_TPR));
  }
  public void setAcceleratorVelocity(int rpm){
    m_launcherAccel.set(ControlMode.Velocity,  RobotContainer.convertRPMToVelocity(rpm * m_toggleLaunch, Constants.TALON_FX_TPR));
    SmartDashboard.putNumber("Accel Desired Vel", RobotContainer.convertRPMToVelocity(rpm * m_toggleLaunch, Constants.TALON_FX_TPR));
  }

  //Set preset power for auto
  public void setPresetPower(double launchPower, double acceleratePower){
    this.setLauncherPower(launchPower);
    this.setAcceleratorPower(acceleratePower);
  }

  //Set preset velocities for auto
  public void setPresetVel(int launchRPM, int accelRPM){
    this.setLauncherVelocity(launchRPM);
    this.setAcceleratorVelocity(accelRPM);
  }

  public void toggleLauncher(){
    if(m_toggleLaunch == -1){
      m_toggleLaunch = 1;
    }else{
      m_toggleLaunch = -1;
    }
  }


  //Check if the launcher is launching by acessing the launcher velocity
  public static boolean isLaunching(){
    if(m_launcherLaunch.getSelectedSensorVelocity() > 0.3){
      isLaunching = true;
    }else{
      isLaunching = false;
    }
    return isLaunching;
  }

  public static boolean isIndexing(){
    if(m_launcherIndexTop.getSelectedSensorVelocity() > 1 || m_launcherIndexBottom.getSelectedSensorVelocity() > 1){
      isIndexing = true;
    }else{
      isIndexing = false;
    }
    return isIndexing;
  }
}