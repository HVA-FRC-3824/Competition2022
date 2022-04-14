package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.DefenseMode;
import frc.robot.Constants;

public class LEDs extends SubsystemBase{
  //Declare LED objects
  private static AddressableLED m_LEDs; 
  private static AddressableLEDBuffer m_LEDLength;

  // Defense mode variables
  private boolean m_isDefending;
  private int m_periodicIteration = 0;

  //Launching Sequence
  private int m_launchFirstPixelHue;
  private boolean m_isLaunching;

  //Climbing Sequence
  private boolean m_isClimbing;

  private boolean m_isIntaking;

  //Neutral LED Sequence
  private int m_neutralStepValue = 0; //Step G blue, B red, R purple
  private int m_neutralPixelToChange = 0;
  private boolean m_neutralChasingDirection = false; //default inwards; true outwards

  public LEDs(){
    m_LEDs = new AddressableLED(Constants.LEDS_ID);
    m_LEDLength = new AddressableLEDBuffer(Constants.TOTAL_LEDS_COUNT);

    m_LEDs.setLength(m_LEDLength.getLength());

    //Set output data & start LEDs
    m_LEDs.setData(m_LEDLength);
    m_LEDs.start();
  }

  /*
  * This method will be called once per scheduler run
  */
  @Override
  public void periodic(){
    m_isDefending = DefenseMode.getDefenseStatus();
    m_isLaunching = Launcher.isLaunching();
    // m_isClimbing = Climb.isClimbing();
    m_isIntaking = Intake.isIntaking();
    if(m_isLaunching && !m_isDefending){
      this.launchLEDs();
    }else if (m_periodicIteration >= 3 && m_isDefending){
      this.defenseModeLEDs();
      m_periodicIteration = 0;
    }else if(m_isClimbing){
      this.climbLEDs();
    }else if(m_isIntaking){
      this.intakeLEDs();
    }else{
      this.neutral();
    }
    m_LEDs.setData(m_LEDLength);
    m_periodicIteration++;
  }

  //Resets LEDs to neutral
  public void resetSequences(){
    m_isLaunching = false;
  }

  public void defenseModeLEDs(){
    if(m_isDefending == true){
      for(int i = 0; i < Constants.TOTAL_LEDS_COUNT; i++){
        m_LEDLength.setRGB(i, 255, 0, 0);
      }
    }
  }

  public void neutral(){
    //Set swirl LEDs color
    if (m_neutralChasingDirection){
      this.chaseOutward();
    }else if (!m_neutralChasingDirection){
      this.chaseInward();
    }

    //Set top LEDs color based on alliance
    // for (var i = Constants.TOTAL_LEDS_COUNT; i < Constants.TOTAL_LEDS_COUNT + Constants.TOP_LEDS_COUNT; i += 3){
    //   if (DriverStation.getAlliance() == DriverStation.Alliance.Blue){
    //     m_LEDLength.setRGB(i, 0, 101, 180); //FRC blue
    //   }else if (DriverStation.getAlliance() == DriverStation.Alliance.Red){
    //     m_LEDLength.setRGB(i, 236, 26, 35); //FRC red
    //   }else{
    //     m_LEDLength.setRGB(i, 118, 63, 108); //neutral 
    //   }
    // }
  }

  //Gradually change swirl colors in inward sequence
  public void chaseInward(){
    for (var i = 0; i < Constants.TOTAL_LEDS_COUNT; i += 2){
      if (i == m_neutralPixelToChange){
        m_LEDLength.setRGB(i, 0, m_neutralStepValue, 255); //dark to light blue
        m_LEDLength.setRGB(i+1, 0, m_neutralStepValue + 10, 255); //dark to light blue
      }
    }

    if (m_neutralPixelToChange < 230){
      m_neutralPixelToChange += 20;
    }else{
      m_neutralChasingDirection = true; //change to outwards
      m_neutralStepValue = 255;
    }
  }

  //Gradually change swirl colors in outward sequence
  public void chaseOutward(){
    for (var i = 0; i < Constants.TOTAL_LEDS_COUNT; i -= 2){
      if (i == m_neutralPixelToChange){
        m_LEDLength.setRGB(i, 0, m_neutralStepValue, 255); //dark to light blue
        m_LEDLength.setRGB(i - 1, 0, m_neutralStepValue - 10, 255); //dark to light blue
      }
    }

    if (m_neutralPixelToChange >= 20){
      m_neutralPixelToChange -= 20;
    }else{
      m_neutralChasingDirection = false; //change to outwards
      m_neutralStepValue = 0;
    }
  }

  //Change LED colors in rainbow for launch
  public void launchLEDs(){
    for (var i = 0; i < Constants.TOTAL_LEDS_COUNT/2; i++){
      final var hue = (m_launchFirstPixelHue + (i * 180 / (Constants.TOTAL_LEDS_COUNT/2))) % 180;
      m_LEDLength.setHSV(i, hue, 225, 225);
      m_LEDLength.setHSV((Constants.TOTAL_LEDS_COUNT/2 - 1) - i, hue, 255, 255);
    }
    for (var i = Constants.TOTAL_LEDS_COUNT/2 + 1; i < Constants.TOTAL_LEDS_COUNT; i++){
      final var hue = (m_launchFirstPixelHue + (i * 180 / (Constants.TOTAL_LEDS_COUNT/2))) % 180;
      m_LEDLength.setHSV(i, hue, 225, 225);
      m_LEDLength.setHSV((Constants.TOTAL_LEDS_COUNT/2 - 1) - i, hue, 255, 255);
    }
    m_LEDs.setData(m_LEDLength);
  }

  //Change LED colors to blue for launch
  public void climbLEDs(){
    for(int i = 0; i < m_LEDLength.getLength(); i++){
      m_LEDLength.setRGB(i, 0, 0, 255);
    }
    m_LEDs.setData(m_LEDLength);
  }

  public void intakeLEDs(){
    for(int i = 0; i < m_LEDLength.getLength(); i++){
      m_LEDLength.setRGB(i, 255, 115, 0);
    }
    m_LEDs.setData(m_LEDLength);
  }

}