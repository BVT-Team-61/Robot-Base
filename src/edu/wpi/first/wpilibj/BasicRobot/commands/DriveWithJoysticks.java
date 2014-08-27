/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.BasicRobot.commands;

/**
 *
 * @author Frank 
 */
public class DriveWithJoysticks extends CommandBase {
        
    public DriveWithJoysticks() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(drivetrain);
        // System.out.println("Class name is [" + this.getClass().getName() + "]");
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (oi.weAreDriving()) {
           
          if (oi.weAreReversing()){
              drivetrain.reverseTankDrive(oi.getLeftSpeed()*-1.0,oi.getRightSpeed());
          }
           else
          {
              drivetrain.tankDrive(oi.getLeftSpeed(),oi.getRightSpeed());
          }
        }
        else {
            drivetrain.climb(oi.getRightSpeed());
        
        }
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
