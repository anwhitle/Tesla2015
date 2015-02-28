package org.usfirst.frc.team4998.robot.subsystems;

import org.usfirst.frc.team4998.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Chassis extends Subsystem {
    VictorSP frontLeft,frontRight,rearLeft,rearRight;
    double fixVictorIssue1 = 0.95;
    double fixVictorIssue2 = 0.98;
    double fixVictorIssue3 = 1.00;
    double fixVictorIssue4 = 0.98;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	frontLeft   = new VictorSP (RobotMap.VictorDriverFront);
        frontRight  = new VictorSP (RobotMap.VictorPassengerFront);
        rearLeft    = new VictorSP (RobotMap.VictorDriverBack);
        rearRight   = new VictorSP (RobotMap.VictorPassengerBack);
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void drive(double x, double y, double z, double c){
    	if (Math.abs(y) >= 0.2){   			
    		/*frontLeft.set((y + c)*-1 * calcPropValue( y , c ) );
    		frontRight.set((y - c)* calcPropValue( y , c ) );
    		rearLeft.set((y + c)*-1 * calcPropValue( y , c ) );
    		rearRight.set((y - c)* calcPropValue( y , c ) );*/
    		frontLeft.set(y * fixVictorIssue1 * -1);
    		frontRight.set(y * fixVictorIssue2);
    		rearLeft.set(y * -1 * fixVictorIssue3);
    		rearRight.set(y * fixVictorIssue4);
    		if (y < 0) {
        		frontLeft.set(y * -1 * fixVictorIssue1);
        		frontRight.set(y * fixVictorIssue2);
        		rearLeft.set(y * -1 * fixVictorIssue3);
        		rearRight.set(y * fixVictorIssue4);
    		}
    	} else if(Math.abs(x) >= 0.2){
    		/*frontLeft.set((x + c)* calcPropValue( x , c ) );
    		frontRight.set((x + c)* calcPropValue( x , c ) );
    		rearLeft.set((x - c)*-1 * calcPropValue( x , c ) );
    		rearRight.set((x - c)*-1 * calcPropValue( x , c ) );*/
    		frontLeft.set(x * fixVictorIssue1);
    		frontRight.set(x * fixVictorIssue2);
    		rearLeft.set(x * -1 * fixVictorIssue3);
    		rearRight.set(x * -1 * fixVictorIssue4);
    	} else if (Math.abs(z) >= 0.2){
    		frontLeft.set(z * fixVictorIssue1);
    		frontRight.set(z * fixVictorIssue2);
    		rearLeft.set(z * fixVictorIssue3);
    		rearRight.set(z * fixVictorIssue4);
    	} else {
    		frontLeft.set(0);
    		frontRight.set(0);
    		rearLeft.set(0);
    		rearRight.set(0);
    	}
    }
    
    public double calcPropValue(double value, double c){
    	return value / (c + value);
    }
}

