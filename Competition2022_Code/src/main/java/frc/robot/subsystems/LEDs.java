package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class LEDs extends SubsystemBase{
  //Declare LED objects
  private static AddressableLED m_LEDs; 
  private static AddressableLEDBuffer m_LEDBuffer;

  private int m_rainbowFirstPixelHue;

  //Status
  private boolean m_isClimbing;
  private boolean m_isIntaking;
  private boolean m_isLaunching;
  private boolean m_isIndexing;
  private boolean m_isDefending;

  public LEDs(){
    m_LEDs = new AddressableLED(Constants.LEDS_ID);
    m_LEDBuffer = new AddressableLEDBuffer(Constants.TOTAL_LEDS_COUNT);
    m_LEDs.setLength(m_LEDBuffer.getLength());

    //Set output data & start LEDs
    m_LEDs.setData(m_LEDBuffer);
    m_LEDs.start();
  }

  /*
  * This method will be called once per scheduler run
  */
  @Override
  public void periodic(){
    //evaluate status of subsystems
    m_isClimbing = RobotContainer.m_climb.isClimbing();
    m_isLaunching = RobotContainer.m_launcher.isLaunching();
    m_isIntaking = RobotContainer.m_intake.isIntaking();
    m_isIndexing = RobotContainer.m_launcher.isIndexing();
    m_isDefending = RobotContainer.m_chassis.getDefenseStatus();
      
    if(m_isDefending){
      this.defenseModeLEDs();
    }else if(m_isClimbing || m_isLaunching){
      this.rainbow();
    }else if(m_isIntaking){
      this.intakeLEDs();
    }else if(m_isIndexing){
      this.indexLEDs();
    }else{
      this.neutral();
    }
    m_LEDs.setData(m_LEDBuffer);
  }

  //Turns LEDs off
  public void turnLEDsOff(){
    for(int i = 0; i > Constants.TOTAL_LEDS_COUNT; i++){
      m_LEDBuffer.setRGB(i, 0, 0, 0);
    }
    m_LEDs.setData(m_LEDBuffer);
  }

  //set color to red
  public void defenseModeLEDs(){
    for(int i = 0; i < Constants.TOTAL_LEDS_COUNT; i++){
      m_LEDBuffer.setRGB(i, 255, 0, 0);
    }
  }

  //sets color to blue
  public void neutral(){
    for(int i = 0; i < Constants.TOTAL_LEDS_COUNT; i++){
      m_LEDBuffer.setRGB(i, 0, 0, 255);
    }
  }

  //sets color to alliance
  public void alliance(){
    for (var i = 0; i < Constants.TOTAL_LEDS_COUNT; i++){
      if (DriverStation.getAlliance() == DriverStation.Alliance.Blue){
        m_LEDBuffer.setRGB(i, 0, 101, 180); //FRC blue
      }else if (DriverStation.getAlliance() == DriverStation.Alliance.Red){
        m_LEDBuffer.setRGB(i, 236, 26, 35); //FRC red
      }else{
        this.neutral(); 
      }
    }
  }

  public void rainbow(){
    // For every pixel
    for (var i = 0; i < Constants.TOTAL_LEDS_COUNT; i++){
      // Calculate the hue - hue is easier for rainbows because the color
      // shape is a circle so only one value needs to precess
      final var hue = (m_rainbowFirstPixelHue + (i * 180 / Constants.TOTAL_LEDS_COUNT)) % 180;
      // Set the value
      m_LEDBuffer.setHSV(i, hue, 255, 128);
    }
    // Increase by to make the rainbow "move"
    m_rainbowFirstPixelHue += 3;
    // Check bounds
    m_rainbowFirstPixelHue %= 180;
  }

  //Change LED colors to orange for intake
  public void intakeLEDs(){
    for(int i = 0; i < Constants.TOTAL_LEDS_COUNT; i++){
      m_LEDBuffer.setRGB(i, 255, 115, 0);
    }
  }

  public void indexLEDs(){
    for(int i = 0; i < Constants.TOTAL_LEDS_COUNT; i++){
      m_LEDBuffer.setRGB(i, 60, 255, 100);
    }
  }
}