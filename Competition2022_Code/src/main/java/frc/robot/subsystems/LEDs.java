package frc.robot.subsystems;

//#region imports
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
//#endregion

//TODO Figure out what LEDs are meant to be on at certain times; remove defense LEDs

public class LEDs extends SubsystemBase{

 //#region LED Indentities

    private static AddressableLED m_launcherLEDs; 
    private static AddressableLEDBuffer m_LEDLength;

    //launching LEDs

    private boolean m_isLaunching = false; //have strobe lights going outward

    //Defense LEDs

    //private boolean m_defenseLEDs = false; 
    //private boolean m_isCurrentlyDefending = false;

    //Loaded LEDs
    private boolean m_oneLoadedLEDs = false; //have the light appear as yellow
    private boolean m_twoLoadedLEDs = false; //have the light appear as green

    //Global LEDs
    private int m_neutralColorToChange = 0;

 //#endregion

   public LEDs(){

       m_launcherLEDs = new AddressableLED(Constants.LEDS_ID);
       m_LEDLength = new AddressableLEDBuffer(Constants.LEDS_BUFFER_ID);
       m_launcherLEDs.setLength(m_LEDLength.getLength());

   }

   /*public void defenseModeLEDs(){

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
   }*/

   public void resetSequences(){m_isLaunching = false;}

   public void strobeOutward(){
       for(int i = (Constants.LAUNCHER_NUM_OF_LEDS / 2); i>=0; i--) // The reason for the total over 2 is because both sides are counting toward the total
       {
            if(i == m_neutralColorToChange){
                m_LEDLength.setRGB(i, 255, 255, 255);
            }
       }
       if(m_neutralColorToChange > 0){m_neutralColorToChange--;}
   }
   public void toggleableLauncherLEDS(){
        if(m_twoLoadedLEDs){
            for(int i=0; i< Constants.TOTAL_LEDS; i++){
                m_LEDLength.setRGB(i, 0, 255, 0);
            }
            m_twoLoadedLEDs = true;
        }
        else if(m_oneLoadedLEDs){
            for(int i=0; i< Constants.TOTAL_LEDS; i++){
                m_LEDLength.setRGB(i, 255, 255, 0);
            }
            m_oneLoadedLEDs = true;
        }
        else{
            for(int i=0; i< Constants.TOTAL_LEDS; i++){
                m_LEDLength.setRGB(i, 0, 0, 0);
            }
        }
   }
}
