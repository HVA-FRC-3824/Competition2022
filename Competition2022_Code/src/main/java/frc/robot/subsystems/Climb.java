package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.RobotContainer;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class Climb {
  //Declare climb objects
  private WPI_TalonFX m_climbRight;
  private WPI_TalonFX m_climbLeft;
  private double m_toggleExtend;

  public Climb(){
    //Set extend up to be 12.655% faster than down
    m_toggleExtend = 1.12655;

    //Configure climb motors
    m_climbRight = new WPI_TalonFX(Constants.CLIMB_RIGHT_ID);
      RobotContainer.configureTalonFX(m_climbRight, true, false, 0.0, 0.0, 0.0, 0.0);
    m_climbLeft = new WPI_TalonFX(Constants.CLIMB_LEFT_ID);
      RobotContainer.configureTalonFX(m_climbLeft, true, false, 0.0, 0.0, 0.0, 0.0);

    //Set brake to prevent fall after match ends
    m_climbRight.setNeutralMode(NeutralMode.Brake);
    m_climbLeft.setNeutralMode(NeutralMode.Brake);
  }

  //Get motors for use in commands
  public WPI_TalonFX getClimbLeft(){
    return m_climbLeft;
  }
  public WPI_TalonFX getClimbRight(){
    return m_climbRight;
  }
    
  //Move climb with power
  public void setLeftClimbPower(double power){
    m_climbLeft.set(ControlMode.PercentOutput, power *m_toggleExtend);
  }
  public void setRightClimbPower(double power){
    m_climbRight.set(ControlMode.PercentOutput, power *m_toggleExtend);
  }

  //Toggles climb from up (+) to down(-) & vice versa
  public void toggleClimb(){
    if(m_toggleExtend == -1){
      m_toggleExtend = 1.12655;
    }else{
      m_toggleExtend = -1;
    }
  }
}
