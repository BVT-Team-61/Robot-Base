/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.BasicRobot.commands;

/**
 *
 * @author Richard
 */
public class LaunchOff extends CommandBase {
    
    public LaunchOff() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(lift);
        setTimeout(0.2);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("Stop Button Pressed");
        lift.launchOff();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
        //return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
