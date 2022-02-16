package frc.robot.subsystems;

import frc.robot.subsystems.*;
import frc.robot.RobotContainer;
import frc.robot.Constants;
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
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Launcher extends SubsystemBase 
{
  private WPI_TalonFX m_launcherMiddle;
  private WPI_TalonFX m_launcherTop;
  private WPI_TalonSRX m_launcherBottom;

  public Launcher()
  {
    m_launcherMiddle = new WPI_TalonFX(Constants.LAUNCHER_MIDDLE_ID);
    RobotContainer.configureTalonFX(m_launcherMiddle, false, false, Constants.LAUNCHER_MIDDLE_F, Constants.LAUNCHER_MIDDLE_P,
                                    Constants.LAUNCHER_MIDDLE_I, Constants.LAUNCHER_MIDDLE_D);

    m_launcherTop = new WPI_TalonFX(Constants.LAUNCHER_TOP_ID);
        RobotContainer.configureTalonFX(m_launcherTop, false, false, Constants.LAUNCHER_TOP_F, Constants.LAUNCHER_TOP_P,
                                        Constants.LAUNCHER_TOP_I, Constants.LAUNCHER_TOP_D);


    m_launcherBottom = new WPI_TalonSRX(Constants.LAUNCHER_BOTTOM_ID);
    RobotContainer.configureTalonSRX(m_launcherBottom, false, FeedbackDevice.CTRE_MagEncoder_Relative, false, false, 
                                    Constants.LAUNCHER_BOTTOM_F, Constants.LAUNCHER_BOTTOM_P,
                                    Constants.LAUNCHER_BOTTOM_I, Constants.LAUNCHER_BOTTOM_D, 0, 0, false);
 }

}