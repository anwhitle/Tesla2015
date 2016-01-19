package org.usfirst.frc.team4998.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Teleop extends CommandBase {
	//this file controls the entire tele-operated section of the match
	
	//boolean diableDrive = false;
	boolean disableLiftSwitch1, disableLiftSwitch2;
	
	//Command alignBot;
	
    public Teleop() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(chassis);
    	requires(lift);
    
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	disableLiftSwitch1 = false;
    	disableLiftSwitch2 = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//chassis.driveMecanum_Polar(oi.stick1Y(), oi.stick1X(), oi.stick1Twist());
    	/*
    	if (oi.getStick1Button3()){
    		if (diableDrive)
    			diableDrive = false;
    		else
    			diableDrive = true;
    	}
    	*/
    	/*
    	if(oi.getStick1Button3()){
    		alignBot = new AlignBot();
    		alignBot.start();
    	}
    	
    	if(oi.getStick1Button4()){
    		alignBot.cancel();
    	}
    	*/
    	//if (!diableDrive){
    	//we have this here to ignore joystick values if they are miniscule
    		if (Math.abs(oi.stick1Twist()) >= 0.5){
    			chassis.drive(0, 0, oi.stick1Twist()/2, 0);
    		} else if (Math.abs(oi.stick1X()) >= 0.2){
    			chassis.drive(oi.stick1X(), 0, 0, 0);
    		} else if (Math.abs(oi.stick1Y()) >= 0.2){
    			chassis.drive(0,oi.stick1Y(), 0, 0);
    		} else {
    			chassis.drive(0, 0, 0, 0);
    		}
    		//chassis.drive(oi.stick1X(), oi.stick1Y(), oi.stick1Twist());
    	//}
    	
		if (oi.getStick1Button3()){
    		disableLiftSwitch1 = true;
    	}
    		
    	if (oi.getStick1Button4()){
    		disableLiftSwitch1 = false;
    	}
    	
    	SmartDashboard.putBoolean("Disable Switch", disableLiftSwitch1);
    	
    	/*
    	if (oi.getStick2Button2()){
    		disableLiftSwitch2 = !disableLiftSwitch2;
    	}
    	*/
    	//change to getStick2Button# for operator control
    	
    	//this is used to move our lift up and down
    	if (oi.getStick1Button1()){
    		lift.move(1.0, disableLiftSwitch1, disableLiftSwitch2);
    	} else if (oi.getStick1Button2()){
    		lift.move(-1.0, disableLiftSwitch1, disableLiftSwitch2);
    	} else {
    		lift.move(0, disableLiftSwitch1, disableLiftSwitch2);
    	}
    	
    	lift.switchToDash();
    	//sensors.sensorsToDash();
    	//sensors.updateX();
    	//sensors.updateY();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
