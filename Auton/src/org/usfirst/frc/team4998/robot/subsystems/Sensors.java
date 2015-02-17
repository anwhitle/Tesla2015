package org.usfirst.frc.team4998.robot.subsystems;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Sensors extends Subsystem {
	Ultrasonic ultrasonic1 = new Ultrasonic(1 , 2);
	Ultrasonic ultrasonic2 = new Ultrasonic(3 , 4);
	
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void getX(){
    	ultrasonic1.getDistanceUnits();
    }
    
}

