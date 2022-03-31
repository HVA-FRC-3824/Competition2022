package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.RobotContainer;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase
{

    public WPI_TalonSRX m_intake;

    public Intake()
    {
        m_intake = new WPI_TalonSRX(Constants.INTAKE_MOTOR_ID);
        RobotContainer.configureTalonSRX(m_intake, false, FeedbackDevice.CTRE_MagEncoder_Relative, false, false, 
        Constants.INTAKE_F, Constants.INTAKE_P,
        Constants.INTAKE_I, Constants.INTAKE_D, 0, 0, false);
        m_intake.setNeutralMode(NeutralMode.Coast);
    }

      /**
   * Methods for Robot.java to get TalonFX/TalonSRX objects to pass to the SetPIDValues command to configure PIDs via SmartDashboard.
   * @return TalonFX/TalonSRX object to be configured.
   */
  public WPI_TalonSRX getWheelIntakeTalonSRX()
  {
      return m_intake;
  }

  public void setIntakePower(double power)
  {
      m_intake.set(ControlMode.PercentOutput, power);
  }

  public void setIntakeVelocity(int rpm)
  {
      m_intake.set(ControlMode.Velocity, RobotContainer.convertRPMToVelocity(rpm, Constants.INTAKE_TPR));
      SmartDashboard.putNumber("Intake Desired Vel", RobotContainer.convertRPMToVelocity(rpm, Constants.INTAKE_TPR));
  }

  public double getIntakeVel()
  {
      return m_intake.getSelectedSensorVelocity();
  }

  public double getIntakeTemp()
  {
      return m_intake.getTemperature();
  }

}