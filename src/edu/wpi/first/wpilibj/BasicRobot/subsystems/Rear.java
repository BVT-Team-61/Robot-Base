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
import edu.wpi.first.wpilibj.BasicRobot.commands.MoveRear;

/**
 *
 * @author Richard
 */
public class Rear extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private SpeedController RearMotor = new Victor(RobotMap.rearMotor);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new MoveRear());
    }
    private void moveRearMotor(double vel)
    {
        moveRear(vel);
    }
    public void moveRear(double vel)
    {
        RearMotor.set(vel*.8);
    }
}
