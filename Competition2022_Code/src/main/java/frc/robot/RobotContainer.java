package frc.robot;

import frc.robot.subsystems.*;
import frc.robot.commands.*;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
//import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
//import com.ctre.phoenix.sensors.CANCoder;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * Declare robot structure (subsystems, commands, button mapping) here.
 * 
 * Since Command-based is a "declarative" paradigm, very little robot logic should
 * be handled in periodic methods (other than scheduler calls).
 */
public class RobotContainer{
  /* Instantiate subsystems for global usage */
  public static final Chassis m_chassis = new Chassis();
  public static final Climb m_climb = new Climb();
  public static final Intake m_intake = new Intake();
  public static final Launcher m_launcher = new Launcher();
  // public static final SwerveChassis m_swerveChassis = new SwerveChassis();

  public static final Limelight m_limelight = Limelight.getInstance();
  public static final LEDs m_LEDs = new LEDs();

  /**
   * Instantiate inline commands before OI because OI requires commands before binding to buttons
   * Inline commands requires OI when retrieving joystick values. 
   */
  public static final InlineCommands m_inlineCommands = new InlineCommands();
  public static final OI m_OI = new OI();
  
  /* Instantiate autonomous chooser for selection of auto mode before match starts */
  private final SendableChooser<String> m_autoChooser = new SendableChooser<>();

  /**
   * This code runs at robotInit.
   */
  public RobotContainer(){
    /* Bind commands to joystick buttons */
    m_OI.configureButtonBindings();

    /* Initialize various systems on robotInit. */
    this.initializeStartup();

    /* Initialize autonomous command chooser & display on the SmartDashboard. */
    this.initializeAutoChooser();
  }

  /**
   * Various methods to run when robot is initialized. Cannot put these in
   * robotInit() in Robot.java because subsystems may not be instantiated at that
   * point.
   */
  private void initializeStartup(){
    /* Turn off Limelight LED when first started up */
    m_limelight.turnOffLED();
  }

  /**
   * Set default command for subsystems. Default commands are commands that run
   * automatically whenever a subsystem is not being used by another command. If
   * default command is set to null, there will be no default command for the subsystem.
   */
  public static void initializeDefaultCommands(){
    m_chassis.setDefaultCommand(m_inlineCommands.m_driveWithJoystick);
    // m_swerveChassis.setDefaultCommand(m_inlineCommands.m_driveWithJoystick);
  }

  /**
   * Set auto options & display them on SmartDashboard. 
   * 
   * Using string chooser rather than command chooser because if using a command chooser, 
   * will instantiate all the autonomous commands. May cause mix ups between commands.
   */
  private void initializeAutoChooser(){
    /* Add options (which autonomous commands can be selected) to chooser. */
    m_autoChooser.setDefaultOption("DEFAULT COMMAND NAME HERE", "default");
    m_autoChooser.addOption("ONE BALL", "one_Ball");
    m_autoChooser.addOption("ONE BALL RIGHT", "one_Ball_Right");
    m_autoChooser.addOption("TWO BALL", "two_Ball");
    m_autoChooser.addOption("SABOTAGE", "sabotage");

    /* Display chooser on SmartDashboard */
    SmartDashboard.putData("Autonomous Command", m_autoChooser);
  }

  /**
   * TIP:
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   * 
   * This method is used to pass the autonomous command to the main Robot class.
   * Add new case for new command path
   * @return the command to run during the autonomous period.
   */
  public Command getAutonomousCommand(){
    switch (m_autoChooser.getSelected()){
      case "default":
        return new AutonomousOneBall();
      case "one_Ball":
        return new AutonomousOneBall();
      case "one_Ball_Right":
        return new AutonomousRight();
      case "two_Ball":
        return new AutonomousTwoBall();
      case "sabotage":
        return new AutonomousSabotage();
      default:
        System.out.println("\nError selecting autonomous command:\nCommand selected: " + m_autoChooser.getSelected() + "\n");
        return null;
    }
  }

  /**
   * Configures TalonSRX objects with passed in parameters.
   * @param controlMode If true, configure with Motion Magic. If false, configure
   *                    without Motion Magic. (Motion Magic not required for
   *                    TalonSRXs that will set with ControlMode.Velocity).
   */
  public static void configureTalonSRX(WPI_TalonSRX talonSRX, boolean controlMode, FeedbackDevice feedbackDevice, boolean setInverted,
    boolean setSensorPhase, double kF, double kP, double kI, double kD, int kCruiseVelocity, int kAcceleration, boolean resetPos){
    /* Reset TalonSRX to prevent unexpected behavior. */
    talonSRX.configFactoryDefault();

    /* Configure Sensor Source for Primary PID. */
    talonSRX.configSelectedFeedbackSensor(feedbackDevice, Constants.K_PID_LOOP_IDX, Constants.K_TIMEOUT_MS);

    /* Configure TalonSRX to drive forward when LED is green. */
    talonSRX.setInverted(setInverted);

    /* Configure TalonSRX's sensor to increment its value as it moves forward. */
    talonSRX.setSensorPhase(setSensorPhase);

    // Determine if the internal PID is being used
    if (controlMode){
      /* Set relevant frame periods (Base_PIDF0 and MotionMagic) to periodic rate (10ms). */
      talonSRX.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, Constants.K_TIMEOUT_MS);
      talonSRX.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, Constants.K_TIMEOUT_MS);
    }

    /**
     * Configure nominal and peak output forward/reverse.
     * 
     * Nominal Output: minimum motor output allowed during closed-loop. 
     * Peak Output: maximum motor output allowed during closed-loop.
     */
    talonSRX.configNominalOutputForward(0, Constants.K_TIMEOUT_MS);
    talonSRX.configNominalOutputReverse(0, Constants.K_TIMEOUT_MS);
    talonSRX.configPeakOutputForward(1, Constants.K_TIMEOUT_MS);
    talonSRX.configPeakOutputReverse(-1, Constants.K_TIMEOUT_MS);

    /* Set Motion Magic/Velocity gains (FPID) in slot0. */
    talonSRX.selectProfileSlot(Constants.K_SLOT_IDX, Constants.K_PID_LOOP_IDX);
    talonSRX.config_kF(Constants.K_SLOT_IDX, kF, Constants.K_TIMEOUT_MS);
    talonSRX.config_kP(Constants.K_SLOT_IDX, kP, Constants.K_TIMEOUT_MS);
    talonSRX.config_kI(Constants.K_SLOT_IDX, kI, Constants.K_TIMEOUT_MS);
    talonSRX.config_kD(Constants.K_SLOT_IDX, kD, Constants.K_TIMEOUT_MS);

    // Determine if the internal PID is being used
    if (controlMode){
      /* Set acceleration and cruise velocity for Motion Magic. */
      talonSRX.configMotionCruiseVelocity(kCruiseVelocity, Constants.K_TIMEOUT_MS);
      talonSRX.configMotionAcceleration(kAcceleration, Constants.K_TIMEOUT_MS);
    }

    /* Reset the TalonSRX's sensor. */
    if (resetPos){
      talonSRX.setSelectedSensorPosition(0, Constants.K_PID_LOOP_IDX, Constants.K_TIMEOUT_MS);
    }
  }

  /**
   * Configures TalonFX (Falcon 500) objects with passed in parameters. 
   * Motion Magic not required for launch/chassis TalonFXs due to 
   * having PIDController with Gyro/Vision or ControlMode.Velocity
   */
  public static void configureTalonFX(WPI_TalonFX talonFX, boolean setInverted, boolean setSensorPhase, double kF,
    double kP, double kI, double kD){
    /* Factory default to reset TalonFX and prevent unexpected behavior. */
    talonFX.configFactoryDefault();

    /* Configure Sensor Source for Primary PID. */
    talonFX.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, Constants.K_PID_LOOP_IDX, Constants.K_TIMEOUT_MS);

    /* Configure TalonFX to drive forward when LED is green. */
    talonFX.setInverted(setInverted);

    /* Configure TalonFX's sensor to increment its value as it moves forward. */
    talonFX.setSensorPhase(setSensorPhase);
    
    /**
     * Configure the nominal and peak output forward/reverse.
     * 
     * Nominal Output: minimum motor output allowed during closed-loop. 
     * Peak Output: maximum motor output allowed during closed-loop.
     */
    talonFX.configNominalOutputForward(0, Constants.K_TIMEOUT_MS);
    talonFX.configNominalOutputReverse(0, Constants.K_TIMEOUT_MS);
    talonFX.configPeakOutputForward(1, Constants.K_TIMEOUT_MS);
    talonFX.configPeakOutputReverse(-1, Constants.K_TIMEOUT_MS);

    /* Set the Velocity gains (FPID) in slot0. */
    talonFX.selectProfileSlot(Constants.K_SLOT_IDX, Constants.K_PID_LOOP_IDX);
    talonFX.config_kF(Constants.K_SLOT_IDX, kF, Constants.K_TIMEOUT_MS);
    talonFX.config_kP(Constants.K_SLOT_IDX, kP, Constants.K_TIMEOUT_MS);
    talonFX.config_kI(Constants.K_SLOT_IDX, kI, Constants.K_TIMEOUT_MS);
    talonFX.config_kD(Constants.K_SLOT_IDX, kD, Constants.K_TIMEOUT_MS);

    /**
     * Reset the TalonFX's sensor. Will be required for implementation into
     * chassis (position considered), but not launcher (velocity only).
     */
    talonFX.setSelectedSensorPosition(0, Constants.K_PID_LOOP_IDX, Constants.K_TIMEOUT_MS);
  }

  /**
   * Method to display position, velocity, error, and motor ouput of a TalonSRX.
   * Primarily used for PID tuning.
   */
  public static void displayTalonSRXInfo(WPI_TalonSRX talonSRX, String label){
    SmartDashboard.putNumber(label + " Setpoint", talonSRX.getClosedLoopTarget());
    SmartDashboard.putNumber(label + " Position", talonSRX.getSelectedSensorPosition());
    SmartDashboard.putNumber(label + " Velocity", talonSRX.getSelectedSensorVelocity());
    SmartDashboard.putNumber(label + " Error",    talonSRX.getClosedLoopError());
    SmartDashboard.putNumber(label + " Output",   talonSRX.getMotorOutputVoltage());
  }

  /**
   * Method to display position, velocity, error, and motor ouput of a TalonFX.
   * Primarily used for PID tuning.
   */
  public static void displayTalonFXInfo(WPI_TalonFX talonFX, String label){
    SmartDashboard.putNumber(label + " Setpoint", talonFX.getClosedLoopTarget());
    SmartDashboard.putNumber(label + " Position", talonFX.getSelectedSensorPosition());
    SmartDashboard.putNumber(label + " Position Graph", talonFX.getSelectedSensorPosition());
    SmartDashboard.putNumber(label + " Velocity", talonFX.getSelectedSensorVelocity());
    SmartDashboard.putNumber(label + " Error",    talonFX.getClosedLoopError());
    SmartDashboard.putNumber(label + " Output",   talonFX.getMotorOutputVoltage());
  }

  /**
   * Convert RPM to units/100ms for TalonSRX/TalonFX to use for ControlMode.Velocity.
   * @param rpm is desired revolutions per minute.
   * @param tpr is the encoder ticks per revolution.
   */
  public static double convertRPMToVelocity(int rpm, int tpr){
    /* (RPM * TPR Units/Revolution / 600 ms/min) */
    return rpm * tpr / 600;
  }
}