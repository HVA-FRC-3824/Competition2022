package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.RobotContainer;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Climb {
    
    WPI_TalonFX m_climbRight;
    WPI_TalonFX m_climbLeft;

    public Climb() {
        m_climbRight = new WPI_TalonFX(Constants.CLIMB_RIGHT_ID);
        RobotContainer.configureTalonFX(m_climbRight, true, false, 0.0, 0.0, 0.0, 0.0);
        /* Set brake mode to prevent the robot from falling after the match ends. */
        m_climbRight.setNeutralMode(NeutralMode.Brake);

        m_climbLeft = new WPI_TalonFX(Constants.CLIMB_LEFT_ID);
        RobotContainer.configureTalonFX(m_climbLeft, true, false, 0.0, 0.0, 0.0, 0.0);
        /* Set brake mode to prevent the robot from falling after the match ends. */
        m_climbLeft.setNeutralMode(NeutralMode.Brake);
    
    }
    /**
    * Methods for Robot.java to get TalonFX/TalonSRX objects to pass to the SetPIDValues command to configure PIDs via SmartDashboard.
    * @return TalonFX/TalonSRX object to be configured.
    */
    public WPI_TalonFX getClimbLeft(){
        return m_climbLeft;
    }
    public WPI_TalonFX getClimbRight(){
        return m_climbRight;
    }
    /**
    * Method to retract climber poles with power.
    * @param power range is from 1.0 to -1.0
    */

    //#region Commands

    public void setClimbPower(double power)
    {
        setLeftClimbPower(0);
        setRightClimbPower(power);
    }
    void setLeftClimbPower(double power){
        m_climbLeft.set(ControlMode.PercentOutput, power);
    }
    void setRightClimbPower(double power){
        m_climbRight.set(ControlMode.PercentOutput, power);
    }

    //#endregion

}
