package org.usfirst.frc.team4998.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team4998.robot.OI;
import org.usfirst.frc.team4998.robot.subsystems.*;
/**
 *
 */
public class CommandBase extends CommandGroup {
    OI oi = new OI();
    Lift lift = new Lift();
    Chassis chassis = new Chassis();
    Sensors sensors = new Sensors();
    //MechanumChassis chassis = new MechanumChassis(); 
    
    public  CommandBase() {
        
    }
}
