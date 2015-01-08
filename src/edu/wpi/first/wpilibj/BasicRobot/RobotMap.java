package edu.wpi.first.wpilibj.BasicRobot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    //Joysticks
    public static final int leftStick = 1;
    public static final int rightStick = 2;
    public static final int liftStick = 3;
    public static final int rearStick = 4;

    
    //Motors
    public static final int leftMotor = 1; // Left motor in port 1
    public static final int rightMotor = 2; // Right motor in port 2
    public static final int rearMotor = 3;
    public static final int liftMotor = 4; 
    
    //Relay
    public static final int LaunchMotor = 1;
}
