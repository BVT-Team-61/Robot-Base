/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.BasicRobot.subsystems;

import edu.wpi.first.wpilibj.BasicRobot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.BasicRobot.commands.LiftBall;
import edu.wpi.first.wpilibj.Relay;

/**
 *
 * @author Richard
 */
public class Lift extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private SpeedController liftMotor = new Victor(RobotMap.liftMotor);
    private Relay spike = new Relay(RobotMap.LaunchMotor);
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new LiftBall());
    }
    public void liftBall(double vel){
        moveLift(vel);
    }
    private void moveLift(double vel){
        liftMotor.set(vel);
    }
    public void launchOn(){
        System.out.println("Motor Start");
        spike.set(Relay.Value.kForward);
    }
    public void launchOff(){
        System.out.println("Motor Stopped");
        spike.set(Relay.Value.kOff);
    }
    public void launchToggle(){
        if(spike.get()== Relay.Value.kOff){
            launchOn();
        }
        else{
            launchOff();
        }
    
    }
}
