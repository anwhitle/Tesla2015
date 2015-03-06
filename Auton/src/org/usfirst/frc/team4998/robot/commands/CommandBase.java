package org.usfirst.frc.team4998.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team4998.robot.OI;
import org.usfirst.frc.team4998.robot.subsystems.*;
/**
 *
 */
public class CommandBase extends CommandGroup {
    static OI oi = new OI();
    static Lift lift = new Lift();
    static Chassis chassis = new Chassis();
    //Sensors sensors = new Sensors();
    //MechanumChassis chassis = new MechanumChassis(); 
    
    public  CommandBase() {
        
    }
}
