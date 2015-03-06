package org.usfirst.frc.team4998.robot.subsystems;

import org.usfirst.frc.team4998.robot.RobotMap;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Sensors extends Subsystem {
	/*Ultrasonic ultrasonic1;
	Ultrasonic ultrasonic2;
	Encoder encoder1;
	Encoder encoder2;
	Double x , y , previousX , previousY;
    Gyro gyro;
    */
    public void initDefaultCommand() {
    	/*
    	ultrasonic1 = new Ultrasonic(RobotMap.ultrasonic1port1 , RobotMap.ultrasonic1port2);
    	ultrasonic2 = new Ultrasonic(RobotMap.ultrasonic2port1 , RobotMap.ultrasonic2port2);
    	encoder1 = new Encoder(RobotMap.encoder1port1 , RobotMap.encoder1port2, true, EncodingType.k4X);
    	encoder2 = new Encoder(RobotMap.encoder2port1 , RobotMap.encoder2port2, true, EncodingType.k4X);
    	gyro = new Gyro(RobotMap.Gyro);
    	
    	previousX = 0.0;
    	previousY = 0.0;
    
     //x = getX();
     //y = getY();
     
    	x = 0.0;
    	y = 0.0;
     
     encoder1.setMaxPeriod(RobotMap.setMaxPeriod1);
     encoder2.setMaxPeriod(RobotMap.setMaxPeriod2);
     
     encoder1.setMinRate(RobotMap.setMinRate1);
     encoder2.setMinRate(RobotMap.setMinRate2);
    	
     encoder1.setDistancePerPulse(RobotMap.distancePerPulse1);
     encoder2.setDistancePerPulse(RobotMap.distancePerPulse2);
     
     encoder1.setSamplesToAverage(RobotMap.setSamplesToAverage1);
     encoder2.setSamplesToAverage(RobotMap.setSamplesToAverage2);
     */
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    //public Double getX(){
     //return ultrasonic1.getRangeMM();
    //}
    
    //public Double getY(){
    // return ultrasonic2.getRangeMM();
    //}
    
    //public void updateX(){
	  //  previousX = x;
	    // x = x + encoder1.getDistance();
	     /*
	     System.out.println("Xget" + encoder1.get());
	     System.out.println("XRaw" + encoder1.getRaw());
	     System.out.println("XPeriod" + encoder1.getPeriod());
	     System.out.println("Xvalue" + x);
	     System.out.println("Xdistance" + encoder1.getDistance()); 
	     SmartDashboard.putNumber("Xget", encoder1.get());
	     SmartDashboard.putNumber("XRaw", encoder1.getRaw());
	     SmartDashboard.putNumber("XPeriod", encoder1.getPeriod());
	     SmartDashboard.putNumber("Xvalue", x);
	     SmartDashboard.putNumber("Xdistance", encoder1.getDistance());
	     */ 
    //}
    
    //public void updateY(){
	 //   previousY = y;
	   //  y = y + encoder2.getDistance();
	     /*
	     System.out.println("Yget" + encoder2.get());
	     System.out.println("YRaw" + encoder2.getRaw());
	     System.out.println("YPeriod" + encoder2.getPeriod());
	     System.out.println("Yvalue" + y);
	     System.out.println("Ydistance" + encoder2.getDistance()); 
	     SmartDashboard.putNumber("Yget", encoder2.get());
	     SmartDashboard.putNumber("YRaw", encoder2.getRaw());
	     SmartDashboard.putNumber("YPeriod", encoder2.getPeriod());
	     SmartDashboard.putNumber("Yvalue", y);
	     SmartDashboard.putNumber("Ydistance", encoder2.getDistance());
	     */ 
    //}
    /*
    public double calculateCX(){
    	return x - previousX;
    }
    public double calculateCY(){
    	return y - previousY;
    }
    
    public void sensorsToDash(){
    	SmartDashboard.putNumber("Gyro", gyro.getAngle());
    	SmartDashboard.putNumber("Ultrasonic1", ultrasonic1.getRangeMM());
    	SmartDashboard.putNumber("Ultrasonic2", ultrasonic2.getRangeMM());
    	SmartDashboard.putNumber("Encoder1", encoder1.getDistance());
    	SmartDashboard.putNumber("Encoder2", encoder2.getDistance());
    }
    */
}