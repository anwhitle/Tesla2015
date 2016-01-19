package org.usfirst.frc.team4998.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;

import org.usfirst.frc.team4998.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 */
public class Lift extends Subsystem {
	//talons are motor controlers like victors and jaguares
	Talon talon1 = new Talon(RobotMap.talon1);
	Talon talon2 = new Talon(RobotMap.talon2);
	Boolean switch1, switch2;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands
	DigitalInput topStop, bottomStop;	//switches to tell if lift hit top or bottom
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	topStop = new DigitalInput(RobotMap.liftSwitch1);
    	bottomStop = new DigitalInput(RobotMap.liftSwitch2);
    }
    public void move(double speed, boolean disableSwitch1, boolean disableSwitch2){
    	//SmartDashboard.putBoolean("disable switch", disableSwitch1);
    	/*
    	if (disableSwitch1){
    		switch1 = true;
    	} else {
    		switch1 = topStop.get();
    	}
    	if (disableSwitch2){
    		switch2 = true;
    	} else {
    		switch2 = bottomStop.get();
    	}
    	*/
    	if (!disableSwitch1) {		//we had to implement a way to disable the switches during the match since they were breaking, this was the solution
		    if ((!topStop.get() && speed<0) || (!bottomStop.get() && speed>0) || (topStop.get() && bottomStop.get())){	//&& means 'and'; || means 'or'; ! before something means 'not'
		    	if (!(!topStop.get() && !bottomStop.get())){
		    		talon1.set(speed);
		    		talon2.set(speed);
		    	} else {
		    		talon1.set(0);
			    	talon2.set(0);
		    	}	
		    } else {
		    	talon1.set(0);
		    	talon2.set(0);
		    }
    	} else {
    		if (speed != 0){
    			talon1.set(speed);
    			talon2.set(speed);
    		} else {
    			talon1.set(0);
		    	talon2.set(0);
    		}
    	}
    }
    public void switchToDash(){
    	SmartDashboard.putBoolean("top switch", topStop.get());
    	SmartDashboard.putBoolean("bottom switch", bottomStop.get());
    }
}