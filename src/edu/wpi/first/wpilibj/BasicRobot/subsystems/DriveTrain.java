/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.BasicRobot.subsystems;

import edu.wpi.first.wpilibj.BasicRobot.RobotMap;
import edu.wpi.first.wpilibj.BasicRobot.commands.DriveWithJoysticks;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 * @author FrankAdmin
 */
public class DriveTrain extends PIDSubsystem {
    

    private static final double Kp = 0.0;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;
    
    //private RobotDrive drive = new RobotDrive(RobotMap.leftMotor,RobotMap.rightMotor);
    
    private SpeedController leftMotor = new Victor(RobotMap.leftMotor);
    private SpeedController rightMotor = new Victor(RobotMap.rightMotor);
    
    // private DigitalInput leftTopLimit = new DigitalInput(RobotMap.leftTopLimitChannel);
    // private DigitalInput leftBottomLimit = new DigitalInput(RobotMap.leftBottomLimitChannel);

    // Initialize your subsystem here
    public DriveTrain() {
        super("DriveTrain", Kp, Ki, Kd);

        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
        
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveWithJoysticks());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return 0.0;
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
    
    /**
     * Tank drive for main drivetrain.
     * @param left Left motor value
     * @param right Right motor value
     */
    public void tankDrive(double left, double right) {
        leftMotor.set(left*-1.0);
        rightMotor.set(right);
    }
    
    /**
     * Reversed tankDrive.
     * @param left Right motor value
     * @param right Left motor value
     */
    public void reverseTankDrive(double left, double right) {
        leftMotor.set(right*-1.0);
        rightMotor.set(left);
    }
    
    /**
     * Climbs the robot.
     * @param right Arm movement
     */
    public void climb(double right) {
        //System.out.println("joystick value = " + right);
        moveLeftMotor(right);
        moveRightMotor(right);
    }
    /**
     * 
     * @param speed 
     */
    
    private void moveLeftMotor(double speed)
    {
        //leftMotor.set(speed*-1.0);
      
       if (speed < 0.0 )
       { 
           leftMotor.set (speed*-1.0);
               
       }
               
        else if (speed > 0.0)
        {
            leftMotor.set(0.0);
        }
        else
        {
            leftMotor.set(speed*-1.0);
        }
        
    }
    
    private void moveRightMotor(double speed)
    {
      //rightMotor.set(speed);
        //System.out.println("limit = " + bottomLimit.getSmartDashboardType());      
        if (speed< 0.0)
        {
            rightMotor.set(speed);
        }
       
        else if (speed > 0.0)
        {
            rightMotor.set(0.0);
        }
        else
        {
            rightMotor.set(speed);
        }
        
    }

}
 