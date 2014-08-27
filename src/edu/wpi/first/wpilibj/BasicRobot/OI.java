
package edu.wpi.first.wpilibj.BasicRobot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {   

   private static boolean reverseDriveMode=false ;
    
   Joystick jLeft = new Joystick(1);    
   Joystick jRight = new Joystick(2); 
   
   Button forwardButton = new JoystickButton (jRight,2);
   Button reverseButton = new JoystickButton (jRight,1);
   
    public boolean weAreDriving() {
        return true;
    }
    public boolean weAreReversing (){
        
        if (reverseButton.get()) {
            reverseDriveMode = false;
        }
    else if (forwardButton.get()) {
        reverseDriveMode= true;
    }
    return reverseDriveMode ;
    }
    
    public double getLeftSpeed() {
        return (jLeft.getY()); 
    }
    
    public double getRightSpeed() {
        return (jRight.getY());
    }
}

