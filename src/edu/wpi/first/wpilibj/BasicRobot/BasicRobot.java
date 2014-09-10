/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.BasicRobot;


import edu.wpi.first.wpilibj.BasicRobot.commands.AutonomousGroup;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.BasicRobot.commands.CommandBase;
import edu.wpi.first.wpilibj.DriverStationLCD;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class BasicRobot extends IterativeRobot {

    Command autonomousCommand;

    public final String teamNo = "  61";
    public final String versionNo = "2014-09-09.01";
            
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
        autonomousCommand = new AutonomousGroup();
        
        // Initialize all subsystems
        CommandBase.init();
        
        // Ouput program info to system log.
        System.out.println("+---------------------------------------------+");
        System.out.println("| Team "+teamNo+" - Software Version: "+versionNo+" |");
        System.out.println("+---------------------------------------------+");
        
        // Output program info to driver station.
        DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser1, 1, "Team: "+teamNo+" - Software Version: "+versionNo);
        DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser2, 2, "Robot initialized.");
        DriverStationLCD.getInstance().updateLCD();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        //autonomousCommand.start();
        
        // Ouput status info to driver station.
        DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser3, 2, "Started Autonomous.");
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        autonomousCommand.cancel();
        
        // Output status info to driver station.
        DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser3, 2, "Started Tele-op.");
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
        
        // Output status info to driver station.
        DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser3, 2, "Started Test Mode.");
    }
}
