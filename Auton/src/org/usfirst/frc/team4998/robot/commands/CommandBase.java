package org.usfirst.frc.team4998.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team4998.robot.OI;
import org.usfirst.frc.team4998.robot.subsystems.*;
/**
 *
 */
public class CommandBase extends CommandGroup {
    MechanumChassis mechChassis = new MechanumChassis();
    OI oi = new OI();
    
    public  CommandBase() {
        
    }
}
