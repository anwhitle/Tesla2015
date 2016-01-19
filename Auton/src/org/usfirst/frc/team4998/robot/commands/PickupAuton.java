package org.usfirst.frc.team4998.robot.commands;


import edu.wpi.first.wpilibj.Timer;


/**
 *
 */
public class PickupAuton extends CommandBase {
	//another auton mode that we used
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
    	
    	driveTime = timer.get() + 2.0;
    	while(timer.get()< driveTime){		//lift for 2 seconds
    		lift.move(0.5, false, false);
    	}
    	
    	lift.move(0, false, false);						//stop lift
    	/*
    	driveTime = timer.get() + 0.5;
    	while(timer.get()< driveTime){		//turn right for 0.5 seconds		
    		chassis.drive(0, 0, 0.5, 0);
    	}
    	*/
    	//chassis.drive(0, 0, 0, 0);			//stop turning
    	
    	driveTime = timer.get() + 3;
    	while(timer.get()< driveTime){		//Move forward for 3 seconds
    		chassis.drive(0, -0.5, 0, 0);
    	}
    	
    	chassis.drive(0, 0, 0, 0);			//Stop moving
/*    
    	driveTime = timer.get() + 2.0;
    	while(timer.get()< driveTime){		//drop for 2 seconds
    		lift.move(-0.5, false, false);
    	}
  */  	
    	lift.move(0, false, false);						//stop droping
    	
    }


    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
