package frc.robot.subsystems;



import frc.robot.Constants;
import frc.robot.RobotContainer;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Climber {
    
    WPI_TalonFX m_climbRight;
    WPI_TalonFX m_climberLeft;

    public Climber() {
        m_climbRight = new WPI_TalonFX(Constants.CLIMBER_RIGHT_ID);
        RobotContainer.configureTalonFX(m_climbRight, true, false, 0.0, 0.0, 0.0, 0.0);
        /* Set brake mode to prevent the robot from falling after the match ends. */
        m_climbRight.setNeutralMode(NeutralMode.Brake);

        m_climberLeft = new WPI_TalonFX(Constants.CLIMBER_LEFT_ID);
        RobotContainer.configureTalonFX(m_climberLeft, true, false, 0.0, 0.0, 0.0, 0.0);
        /* Set brake mode to prevent the robot from falling after the match ends. */
        m_climberLeft.setNeutralMode(NeutralMode.Brake);
    
    }

}
