/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.BasicRobot.subsystems;

import edu.wpi.first.wpilibj.BasicRobot.RobotMap;
import edu.wpi.first.wpilibj.BasicRobot.commands.DriveWithJoysticks;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Team-61
 */
public class DriveTrain extends Subsystem {
    


    private SpeedController leftMotor = new Victor(RobotMap.leftMotor);
    private SpeedController rightMotor = new Victor(RobotMap.rightMotor);

    // Initialize your subsystem here
    public DriveTrain() {
        super("DriveTrain");  
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveWithJoysticks());
    }
    
    /**
     * Tank drive for main drivetrain.
     * @param left Left motor value
     * @param right Right motor value
     */
    public void tankDrive(double left, double right) {
        moveLeftMotor(left);
        moveRightMotor(right);
    }
    
    /**
     * Reversed controls tankDrive.
     * @param right Right motor value
     * @param left Left motor value
     */
    public void reverseTankDrive(double right, double left) {
        moveRightMotor(right);
        moveLeftMotor(left);
    }
    
    /**
     * 
     * @param speed 
     */
    
    private void moveLeftMotor(double speed)
    {
        speed = speed*-1.0;
        leftMotor.set(speed);
    }
    
    /**
     * 
     * @param speed 
     */
    
    private void moveRightMotor(double speed)
    {
        rightMotor.set(speed);
    }

}
 