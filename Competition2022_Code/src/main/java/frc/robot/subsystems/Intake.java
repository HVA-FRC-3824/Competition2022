package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.RobotContainer;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase{
  //Declare intake objects
  public WPI_TalonSRX m_intake;
  public int m_toggleIntake;

  public Intake(){
    //Set toggle intake to take cargo in
    m_toggleIntake = 1;
    //Configure intake motor
    m_intake = new WPI_TalonSRX(Constants.INTAKE_MOTOR_ID);
      RobotContainer.configureTalonSRX(m_intake, false, FeedbackDevice.CTRE_MagEncoder_Relative, false, false, 
      Constants.INTAKE_F, Constants.INTAKE_P, Constants.INTAKE_I, Constants.INTAKE_D, 0, 0, false);

    //Set neutral mode to coast
    m_intake.setNeutralMode(NeutralMode.Coast);
  }

  //Get intake motor for use in commands
  public WPI_TalonSRX getWheelIntakeTalonSRX(){
    return m_intake;
  }

  //Set intake power
  public void setIntakePower(double power){
    m_intake.set(ControlMode.PercentOutput, power);
  }

  //Set intake velocity & display desired vel on Dashboard
  public void setIntakeVelocity(int rpm){
    m_intake.set(ControlMode.Velocity, RobotContainer.convertRPMToVelocity(rpm * m_toggleIntake, Constants.INTAKE_TPR));
    SmartDashboard.putNumber("Intake Desired Vel", RobotContainer.convertRPMToVelocity(rpm, Constants.INTAKE_TPR));
  }

  public void toggleIntake(){
    if(m_toggleIntake == -1){
      m_toggleIntake = 1;
    }else{
      m_toggleIntake = -1;
    }
  }

  //Get intake vel for continuous update
  public double getIntakeVel(){
    return m_intake.getSelectedSensorVelocity();
  }

  //Get intake temp for continuous update
  public double getIntakeTemp(){
    return m_intake.getTemperature();
  }
}