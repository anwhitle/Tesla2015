package org.usfirst.frc.team4998.robot.subsystems;

import org.usfirst.frc.team4998.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;

public class Chassis {
	final VictorSP Vic0 = new VictorSP(RobotMap.VictorDriverFront);	// right side
	final VictorSP Vic1 = new VictorSP(RobotMap.VictorDriverBack);	// left side
	final VictorSP Vic2 = new VictorSP(RobotMap.VictorPassengerFront);	// right side
	final VictorSP Vic3 = new VictorSP(RobotMap.VictorPassengerBack);	// left side
	RobotDrive drive = new RobotDrive(Vic0,Vic1);
	RobotDrive mechanumDrive = new RobotDrive(Vic0,Vic1,Vic2,Vic3);
	
	public Chassis() {
		
	}
	
	public void driveTank(double rightSpeed, double leftSpeed){
		drive.tankDrive(leftSpeed, rightSpeed);
	}
	
	//use cartesian for auton, use polar for teleop
	public void driveMecanum_Cartesinian(double x, double y, double rotation, double gyroAngle){
		mechanumDrive.mecanumDrive_Cartesian(x, y, rotation, gyroAngle);
	}
	public void driveMecanum_Polar(double magnitude, double direction, double rotation){
		mechanumDrive.mecanumDrive_Polar(magnitude, direction, rotation);
	}
}
