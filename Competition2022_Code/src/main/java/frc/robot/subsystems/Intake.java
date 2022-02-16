package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.RobotContainer;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake {
    WPI_TalonSRX m_intake;

    public Intake()
    {
        m_intake = new WPI_TalonSRX(Constants.INTAKE_MOTOR_ID);
        RobotContainer.configureTalonSRX(m_intake, true, FeedbackDevice.CTRE_MagEncoder_Relative, false, false, 
                                        Constants.INTAKE_F, Constants.INTAKE_P, Constants.INTAKE_I, Constants.INTAKE_D, 0, 0, true);

    }
    public void setIntakePower(double power)
    {
        m_intake.set(ControlMode.PercentOutput, power);
    }
}
