package org.usfirst.frc.team4998.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team4998.robot.OI;
import org.usfirst.frc.team4998.robot.subsystems.*;
/**
 *
 */
public class CommandBase extends CommandGroup {
	//this file is used to initialize each subsystem that we will be using
    static OI oi = new OI();
    static Lift lift = new Lift();
    static Chassis chassis = new Chassis();
    //Sensors sensors = new Sensors();
    //MechanumChassis chassis = new MechanumChassis(); 
    
    public  CommandBase() {
        
    }
}
