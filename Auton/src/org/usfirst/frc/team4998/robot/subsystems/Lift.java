package org.usfirst.frc.team4998.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class Lift extends Subsystem {
	Talon victor1 = new Talon(4);
	Talon victor2 = new Talon(5);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void move(double speed){
    	victor1.set(speed);
    	victor2.set(speed);
    }
}

