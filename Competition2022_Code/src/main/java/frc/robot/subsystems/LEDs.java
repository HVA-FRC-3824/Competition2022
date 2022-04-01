package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;

public class LEDs extends SubsystemBase
{
  //Declare LED objects
  private static AddressableLED m_launcherLEDs; 
  private static AddressableLEDBuffer m_LEDBuffer;

  //launching LEDs status
  private boolean m_isLaunching = false; //have strobe lights going outward

  //Defense LEDs status
  // private boolean m_defenseLEDs = false; 
  // private boolean m_isDefending = false;

  //Index LEDs
  private boolean m_oneLoadedLEDs = false;
  private boolean m_twoLoadedLEDs = false;

  //Neutral LED color
  private int m_neutralColor = 0;

  public LEDs()
  {
    m_launcherLEDs = new AddressableLED(Constants.LEDS_ID);
    m_LEDBuffer = new AddressableLEDBuffer(Constants.LEDS_LENGTH);
    m_launcherLEDs.setLength(m_LEDBuffer.getLength());
  }

  /*
  * Runs periodically
  */
  @Override
  public void periodic(){
    if(m_isLaunching){
      this.strobeOutward();
    } //I do not know what to put here since the github has defense
  }

  // public void defenseModeLEDs()
  // {
  //   if(m_defenseLEDs){
  //     for(int i = 0; i < Constants.TOTAL_LEDS; i++){
  //       m_LEDLength.setRGB(i, 255, 0, 0);}
  //     m_defenseLEDs = true;
  //   }
  //   else{
  //     for(int i = 0; i < Constants.TOTAL_LEDS; i++){
  //       m_LEDLength.setRGB(i, 0, 0, 0);}
  //     m_defenseLEDs = false;
  //   }
  // }

  public void resetSequences(){
    m_isLaunching = false;}

  public void strobeOutward()
  {
    for(int i = (Constants.LAUNCHER_NUM_OF_LEDS / 2); i >= 0; i--) // The reason for the total over 2 is because both sides are counting toward the total
    {
      if(i == m_neutralColor){
        m_LEDBuffer.setHSV(i, 255, 0, 255);
      }        
    }
    if(m_neutralColor > 0){
      m_neutralColor--;}
    else{
      m_neutralColor = Constants.LAUNCHER_NUM_OF_LEDS;
    }
  }

  public void toggleableLauncherLEDS()
  {
    if(m_twoLoadedLEDs){
      for(int i = 0; i < Constants.TOTAL_LEDS; i++){
        m_LEDBuffer.setRGB(i, 0, 255, 0);}
      m_twoLoadedLEDs = true;
    }
    else if(m_oneLoadedLEDs){
      for(int i = 0; i < Constants.TOTAL_LEDS; i++){
        m_LEDBuffer.setRGB(i, 255, 255, 0);}
      m_oneLoadedLEDs = true;
    }
    else{
      for(int i = 0; i < Constants.TOTAL_LEDS; i++){
        m_LEDBuffer.setRGB(i, 0, 0, 0);}
    }
    for(var LED = 0; LED < m_LEDBuffer.getLength(); LED++){
      m_LEDBuffer.setHSV(LED, 0, 0, 0);}
  }
}
