package org.usfirst.frc.team4998.robot.subsystems;

import org.usfirst.frc.team4998.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Chassis extends Subsystem {
    VictorSP frontLeft,frontRight,rearLeft,rearRight;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	frontLeft   = new VictorSP (RobotMap.VictorDriverFront);
        frontRight  = new VictorSP (RobotMap.VictorPassengerFront);
        rearLeft    = new VictorSP (RobotMap.VictorDriverBack);
        rearRight   = new VictorSP (RobotMap.VictorPassengerBack);
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void drive(double x, double y, double z){
    	if (Math.abs(y) >= 0.1){   			
    		frontLeft.set(y*-1);
    		frontRight.set(y);
    		rearLeft.set(y*-1);
    		rearRight.set(y);
    	} else if(Math.abs(x) >= 0.1){
    		frontLeft.set(x);
    		frontRight.set(x);
    		rearLeft.set(x*-1);
    		rearRight.set(x*-1);
    	} else if (Math.abs(z) >= 0.1){
    		frontLeft.set(z);
    		frontRight.set(z);
    		rearLeft.set(z);
    		rearRight.set(z);
    	} else {
    		frontLeft.set(0);
    		frontRight.set(0);
    		rearLeft.set(0);
    		rearRight.set(0);
    	}
    }
}

