package org.usfirst.frc.team4998.robot.subsystems;

//import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class Lift extends Subsystem {
	Talon talon1 = new Talon(4);
	Talon talon2 = new Talon(5);
    // Put methods for controlling this subsystem
    // here. Call these from Commands
	//DigitalInput topStop = new DigitalInput(0);
	//DigitalInput bottomStop = new DigitalInput(1);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void move(double speed){
    
	    //if ((topStop.get() && speed<0) || (bottomStop.get() && speed>0) || (!topStop.get() && !bottomStop.get())){
	    	talon1.set(speed);
	    	talon2.set(speed);
	    /*} else {
	    	talon1.set(0);
	    	talon2.set(0);
	    }*/
    }
}