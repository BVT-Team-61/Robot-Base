/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.BasicRobot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author FrankAdmin
 */
public class AutonomousGroup extends CommandGroup {
    
    public AutonomousGroup() {        
        // Drive forward for 2.5 seconds
        addSequential(new DriveForTime(2.5, 0.7, true));
        // Then stop
        addSequential(new DriveForTime(0.5, 0.0, false));
    }
}
