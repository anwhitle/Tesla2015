package org.usfirst.frc.team4998.robot.subsystems;

import org.usfirst.frc.team4998.robot.RobotMap;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;

public class Chassis {
	final Jaguar Jag0 = new Jaguar(RobotMap.Jag0Port);	// right side
	final Jaguar Jag1 = new Jaguar(RobotMap.Jag1Port);	// left side
	RobotDrive drive = new RobotDrive(Jag0,Jag1);
	
	public Chassis() {
		
	}
	
	public void driveTank(double rightSpeed, double leftSpeed){
		drive.tankDrive(leftSpeed, rightSpeed);
	}
	
	//use cartesian for auton, use polar for teleop
	public void driveMecanum_Cartesinian(double x, double y, double rotation, double gyroAngle){
		drive.mecanumDrive_Cartesian(x, y, rotation, gyroAngle);
	}
	public void driveMecanum_Polar(double magnitude, double direction, double rotation){
		drive.mecanumDrive_Polar(magnitude, direction, rotation);
	}
}
