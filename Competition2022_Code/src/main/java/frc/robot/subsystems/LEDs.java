package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LEDs extends SubsystemBase{
  //Declare LED objects
  private static AddressableLED m_LEDs; 
  //private static AddressableLED m_LEDs2;
  private static AddressableLEDBuffer m_LEDLength;
  //private static AddressableLEDBuffer m_LEDLength2;

  // Defense mode variables
  // private boolean m_isDefending;
  // private int m_periodicIteration = 0;

  //Launching Sequence
  private int m_rainbowFirstPixelHue;
  private boolean m_isLaunching;
  // private boolean m_isIndexing;

  //Climbing Sequence
  // private boolean m_isClimbing;

  // private boolean m_isIntaking;

  public LEDs(){
    m_LEDs = new AddressableLED(Constants.LEDS_ID);
    m_LEDLength = new AddressableLEDBuffer(Constants.TOTAL_LEDS_COUNT_2);
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
    // m_isDefending = RobotContainer.m_chassis.getDefenseStatus();
    // m_isLaunching = Launcher.isLaunching();
    // m_isIndexing = Launcher.isIndexing();
    // // m_isClimbing = Climb.isClimbing();
    // m_isIntaking = Intake.isIntaking();

    // if (m_isDefending){ //m_periodicIteration >= 3
    //   this.defenseModeLEDs();
    //   // m_periodicIteration = 0;
    // }else if(m_isLaunching){
    //   this.rainbow();
    // }else if(m_isClimbing){
    //   this.rainbow();
    // }else if(m_isIntaking){
    //   this.intakeLEDs();
    // }else if(m_isIndexing){
    //   this.indexLEDs();
    // }else{
    //   this.neutral();
    // }

    // m_LEDs.setData(m_LEDLength);
    // // m_LEDs2.setData(m_LEDLength2);
    // m_periodicIteration++;
  }

  //Resets LEDs to neutral
  public void resetSequences(){
    m_isLaunching = false;
  }

  //set color to red
  public void defenseModeLEDs(){
    for(int i = 0; i < Constants.TOTAL_LEDS_COUNT_2; i++){
      m_LEDLength.setRGB(i, 255, 0, 0);
    }
  }

  //sets color to blue
  public void neutral(){
    for(int i = 0; i < Constants.TOTAL_LEDS_COUNT_2; i++){
      m_LEDLength.setRGB(i, 0, 0, 255);
    }    
  }

  //sets color to alliance
  public void alliance(){
    for (var i = 0; i < Constants.TOTAL_LEDS_COUNT_2; i++){
      if (DriverStation.getAlliance() == DriverStation.Alliance.Blue){
        m_LEDLength.setRGB(i, 0, 101, 180); //FRC blue
      }else if (DriverStation.getAlliance() == DriverStation.Alliance.Red){
        m_LEDLength.setRGB(i, 236, 26, 35); //FRC red
      }else{
        this.neutral(); 
      }
    }
  }

  public void rainbow(){
    // For every pixel
    for (var i = 0; i < Constants.TOTAL_LEDS_COUNT_2; i++){
      // Calculate the hue - hue is easier for rainbows because the color
      // shape is a circle so only one value needs to precess
      final var hue = (m_rainbowFirstPixelHue + (i * 180 / Constants.TOTAL_LEDS_COUNT_2)) % 180;
      // Set the value
      m_LEDLength.setHSV(i, hue, 255, 128);
    }
    // Increase by to make the rainbow "move"
    m_rainbowFirstPixelHue += 3;
    // Check bounds
    m_rainbowFirstPixelHue %= 180;
  }

  //Change LED colors to blue for climb
  public void climbLEDs(){
    for(int i = 0; i < m_LEDLength.getLength(); i++){
      m_LEDLength.setRGB(i, 0, 0, 255);
    }
    m_LEDs.setData(m_LEDLength);
  }

  //Change LED colors to orange for intake
  public void intakeLEDs(){
    for(int i = 0; i < m_LEDLength.getLength(); i++){
      m_LEDLength.setRGB(i, 255, 115, 0);
    }
    m_LEDs.setData(m_LEDLength);
  }

  public void indexLEDs(){
    for(int i = 0; i < Constants.TOTAL_LEDS_COUNT_2; i++){
      m_LEDLength.setRGB(i, 60, 255, 100);
    }
    m_LEDs.setData(m_LEDLength);
  }
}