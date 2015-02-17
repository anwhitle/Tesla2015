package org.usfirst.frc.team4998.robot.commands;


/**
 *
 */
public class Teleop extends CommandBase {
	boolean diableDrive = false;
    public Teleop() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//chassis.driveMecanum_Polar(oi.stick1Y(), oi.stick1X(), oi.stick1Twist());
    	if (oi.Three.get()){
    		if (diableDrive)
    			diableDrive = false;
    		else
    			diableDrive = true;
    	}
    	
    	if (!diableDrive)
    		if (Math.abs(oi.stick1Y()) >= 0.15){
    			chassis.drive(0,oi.stick1Y(), 0);
    		} else if (Math.abs(oi.stick1X()) >= 0.15){
    			chassis.drive(oi.stick1X(), 0, 0);
    		} else if (Math.abs(oi.stick1Twist()) >= 0.15){
    			chassis.drive(0, 0, oi.stick1Twist());
    		} else {
    			chassis.drive(0, 0, 0);
    		}
    		//chassis.drive(oi.stick1X(), oi.stick1Y(), oi.stick1Twist());
    	
    	if (oi.One.get()){
    		lift.move(1);
    	} else if (oi.Two.get()){
    		lift.move(-1);
    	} else {
    		lift.move(0);
    	}
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
