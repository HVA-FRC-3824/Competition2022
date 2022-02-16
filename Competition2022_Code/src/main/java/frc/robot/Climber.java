package frc.robot;

import frc.robot.subsystems.*;
import frc.robot.commands.*;

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

public class Climber extends SubsystemBase
{

  private WPI_TalonFX m_climberLeft;
  private WPI_TalonFX m_climberRight;
  
  public Climber()
  {
    m_climberLeft = new WPI_TalonFX(Constants.CLIMBER_LEFT_ID);
    RobotContainer.configureTalonFX(m_climberLeft, true, false, 0.0, 0.0, 0.0, 0.0);
    /* Set brake mode to prevent the robot from falling after the match ends. */
    
    m_climberRight  = new WPI_TalonFX(Constants.CLIMBER_RIGHT_ID);
    RobotContainer.configureTalonFX(m_climberRight, true, false, 0.0, 0.0, 0.0, 0.0);
    /* Set brake mode to prevent the robot from falling after the match ends. */
    
  }
 
  /**
   * This method will be called once per scheduler run.
   */
  @Override
  public void periodic()
  {
  }

  /**
   * Methods for Robot.java to get TalonFX/TalonSRX objects to pass to the SetPIDValues command to configure PIDs via SmartDashboard.
   * @return TalonFX/TalonSRX object to be configured.
   */
  public WPI_TalonSRX getReelLeftTalonSRX()
  {
    return m_reelLeft;
  }
  public WPI_TalonSRX getReelRightTalonSRX()
  {
    return m_reelRight;
  }
  public WPI_TalonFX getLiftLeftTalonFX()
  {
    return m_liftLeft;
  }
  public WPI_TalonFX getLiftRightTalonFX()
  {
    return m_liftRight;
  }

  /**
   * Method to extend/retract climber poles with power.
   * @param power range is from 1.0 to -1.0
   */
  public void setLeftReelPower(double power)
  {
    m_reelLeft.set(ControlMode.PercentOutput, power);
  }

  public void setRightReelPower(double power)
  {
    m_reelRight.set(ControlMode.PercentOutput, power);
  }

  /**
   * Method to extend/retract climber poles with power.
   * @param power range is from 1.0 to -1.0
   */
  public void setLeftLiftPower(double power)
  {
    if (-m_liftLeft.getSelectedSensorPosition() <= 0 && power > 0.0)
    {
      m_liftLeft.set(ControlMode.PercentOutput, 0.0);
    } else
    {
      m_liftLeft.set(ControlMode.PercentOutput, power);
    }
  }

  public void setRightLiftPower(double power)
  {
    if (-m_liftRight.getSelectedSensorPosition() <= 0 && power > 0.0)
    {
      m_liftRight.set(ControlMode.PercentOutput, 0.0);
    } else
    {
      m_liftRight.set(ControlMode.PercentOutput, power);
    }
  }
}
  