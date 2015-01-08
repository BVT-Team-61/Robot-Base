
package edu.wpi.first.wpilibj.BasicRobot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.BasicRobot.RobotMap;
import edu.wpi.first.wpilibj.BasicRobot.commands.LaunchOn;
import edu.wpi.first.wpilibj.BasicRobot.commands.LaunchOff;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {   

   private static boolean reverseDriveMode=false ;
   
   // Define Joystick Objects
   Joystick jLeft = new Joystick(RobotMap.leftStick);    
   Joystick jRight = new Joystick(RobotMap.rightStick);
   Joystick jRear = new Joystick(RobotMap.rearStick);
   Joystick jLift = new Joystick(RobotMap.liftStick);
   
   // Define Joystick Buttons
   Button forwardButton = new JoystickButton (jRight,2);
   Button reverseButton = new JoystickButton (jRight,1);
   Button shootButton = new JoystickButton(jLift,1);
   Button stopButton = new JoystickButton(jLift,2);
   
    // Placeholder method. Does nothing yet.
    public OI(){
        shootButton.whenPressed(new LaunchOn());
        stopButton.whenPressed(new LaunchOff());
    }
    public boolean weAreDriving() {
        return true;
    }
    
    // Determines if robot in reverse.
    public boolean weAreReversing (){
        // If the reverse button is hit, then we are reversing.
        if (reverseButton.get()) {
            reverseDriveMode = false;
        }
        // If the forward button is hit, then we are not reversing.
        else if (forwardButton.get()) {
            reverseDriveMode= true;
        }
        // Otherwise, just return whatever it was before
        return reverseDriveMode ;
    }
    
    // Method to return the left joystick Y Axis.
    public double getLeftSpeed() {
        return (jLeft.getY()); 
    }
    
    // Same thing but for the right joystick Y Axis.
    public double getRightSpeed() {
        return (jRight.getY());
    }
    public double getRearSpeed()
    {
        return(jRear.getY());
    }
    public double getLiftSpeed()
    {
        return(jLift.getY());
    }
}

