package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;

public class LEDs extends SubsystemBase{

    private static AddressableLED m_launcherLEDs; 
    private static AddressableLEDBuffer m_LEDLength;

    //launching LEDs

    private boolean m_isLaunching = false;

    //Defense LEDs

    private boolean m_defenseLEDs = false; 
    private boolean m_isCurrentlyDefending = false;

    //Loaded LEDs

    private boolean m_loadedLEDs = false; 

   public LEDs(){
       m_launcherLEDs = new AddressableLED(Constants.LEDS_ID);
       m_LEDLength = new AddressableLEDBuffer(Constants.LEDS_BUFFER_ID);
       m_launcherLEDs.setLength(m_LEDLength.getLength());
   }
   //public void defenseMode(){}
   public void defenseModeLEDs(){
       if(m_defenseLEDs){
           for(int i = 0; i < Constants.TOTAL_LEDS; i++)
           {
               m_LEDLength.setRGB(i, 255, 0, 0);
             
           }
            m_defenseLEDs = true;
       }
           else{
               for(int i = 0; i < Constants.TOTAL_LEDS; i++)
           {
               m_LEDLength.setRGB(i, 0, 0, 0);
           }
        m_defenseLEDs = false;
       }
   }
}
