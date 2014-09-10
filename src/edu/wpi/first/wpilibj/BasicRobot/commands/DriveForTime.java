/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.BasicRobot.commands;

/**
 *
 * @author Team-61
 */
public class DriveForTime extends CommandBase {
    
    private double speed;
    private boolean keepMoving;
    
    // sec: how long to move
    // vel: how fast to move
    // moving: true = continue moving | false = stop moving
    public DriveForTime( double sec, double vel, boolean moving ) {
        requires(drivetrain);
        setTimeout(sec); // Stop command after timeout.
        speed = vel;
        keepMoving = moving;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        drivetrain.tankDrive(speed,speed); // Drive at speed while running.
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        
        // if keepMoving is true then stop.
        if (keepMoving) {
            drivetrain.tankDrive(0.0, 0.0);
        }
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
