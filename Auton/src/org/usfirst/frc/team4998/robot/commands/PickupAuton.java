package org.usfirst.frc.team4998.robot.commands;


import edu.wpi.first.wpilibj.Timer;


/**
 *
 */
public class PickupAuton extends CommandBase {
	double driveTime;
	Timer timer;
    public PickupAuton() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(chassis);
    	requires(lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {  	
    	timer = new Timer();
    	timer.start();
    	driveTime = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	driveTime = timer.get() + 1.0;
    	while(timer.get()< driveTime){		//lift for 1 second
    		lift.move(0.5);
    	}
    	
    	lift.move(0);						//stop lift
    	
    	driveTime = timer.get() + 0.5;
    	while(timer.get()< driveTime){		//turn right for 0.5 seconds		
    		chassis.drive(0, 0, 0.5, 0);
    	}
    	
    	chassis.drive(0, 0, 0, 0);			//stop turning
    	
    	driveTime = timer.get() + 5;
    	while(timer.get()< driveTime){		//Move forward for 5 seconds
    		chassis.drive(0, -0.5, 0, 0);
    	}
    	
    	chassis.drive(0, 0, 0, 0);			//Stop moving
    
    	driveTime = timer.get() + 1.0;
    	while(timer.get()< driveTime){		//drop for 1 second
    		lift.move(-0.5);
    	}
    	
    	lift.move(0);						//stop droping
    	
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
