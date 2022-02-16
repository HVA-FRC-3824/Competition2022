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


public class Launcher {
    WPI_TalonFX m_launcherSpeed;
    WPI_TalonFX m_launcherHood;
    WPI_TalonFX m_launcherFeed;

    boolean[] m_readyToLaunch;

    public Launcher()
    {
        m_launcherSpeed = new WPI_TalonFX(Constants.LAUNCHER_SPEED_MOTOR_ID);
        RobotContainer.configureTalonFX(m_launcherSpeed, false, false, Constants.LAUNCHER_SPEED_F, Constants.LAUNCHER_SPEED_P,
                                        Constants.LAUNCHER_SPEED_I, Constants.LAUNCHER_SPEED_D);

         m_launcherHood = new WPI_TalonFX(Constants.LAUNCHER_HOOD_MOTOR_ID);
        RobotContainer.configureTalonFX(m_launcherHood, false, false, Constants.LAUNCHER_HOOD_F, Constants.LAUNCHER_HOOD_P,
                                        Constants.LAUNCHER_HOOD_I, Constants.LAUNCHER_HOOD_D);

        m_launcherFeed = new WPI_TalonFX(Constants.LAUNCHER_FEED_MOTOR_ID);
        RobotContainer.configureTalonFX(m_launcherFeed, false, false, Constants.LAUNCHER_FEED_F, Constants.LAUNCHER_FEED_P,
                                        Constants.LAUNCHER_FEED_I, Constants.LAUNCHER_FEED_D);
    }

    public void setLauncherSpeed(double power)
    {
        m_launcherSpeed.set(ControlMode.PercentOutput, power);
    }

    public void setLauncherFeed(double power)
    {
        m_launcherFeed.set(ControlMode.PercentOutput, power);
    }
}
