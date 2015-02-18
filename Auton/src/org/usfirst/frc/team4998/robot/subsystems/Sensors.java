package org.usfirst.frc.team4998.robot.subsystems;

import org.usfirst.frc.team4998.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Sensors extends Subsystem {
 Ultrasonic ultrasonic1 = new Ultrasonic(RobotMap.ultrasonic1port1 , RobotMap.ultrasonic1port2);
 Ultrasonic ultrasonic2 = new Ultrasonic(RobotMap.ultrasonic2port1 , RobotMap.ultrasonic2port2);
 Encoder encoder1 = new Encoder(RobotMap.encoder1port1 , RobotMap.encoder1port2);
 Encoder encoder2 = new Encoder(RobotMap.encoder2port1 , RobotMap.encoder2port2);
    Double x , y , previousX , previousY;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	previousX = 0.0;
    	previousY = 0.0;
    
     //x = getX();
     //y = getY();
     
    	x = 0.0;
    	y = 0.0;
     encoder1.setDistancePerPulse(RobotMap.distancePerPulse1);
     encoder2.setDistancePerPulse(RobotMap.distancePerPulse2);
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public Double getX(){
     return ultrasonic1.getRangeMM();
    }
    
    public Double getY(){
     return ultrasonic2.getRangeMM();
    }
    
    public void updateX(){
	    previousX = x;
	     x = x + encoder1.getDistance();
	     SmartDashboard.putNumber("Xget", encoder1.get());
	     SmartDashboard.putNumber("XRaw", encoder1.getRaw());
	     SmartDashboard.putNumber("XPeriod", encoder1.getPeriod());
	     SmartDashboard.putNumber("Xvalue", x);
	     SmartDashboard.putNumber("Xdistance", encoder1.getDistance()); 
    }
    
    public void updateY(){
    	previousY = y;
	     y = y + encoder2.getDistance();
	     SmartDashboard.putNumber("Yvalue", y);
    }
    public double calculateCX(){
    	return x - previousX;
    }
    public double calculateCY(){
    	return y - previousY;
    }
}