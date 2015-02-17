package org.usfirst.frc.team4998.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Sensors extends Subsystem {
 Ultrasonic ultrasonic1 = new Ultrasonic(1 , 2);
 Ultrasonic ultrasonic2 = new Ultrasonic(3 , 4);
 Encoder encoder1 = new Encoder(1 , 2);
 Encoder encoder2 = new Encoder(3 , 4);
    Double x, y;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    
     x = getX();
     y = getY();
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public Double getX(){
     return ultrasonic1.getRangeMM();
    }
    
    public Double getY(){
     return ultrasonic2.getRangeMM();
    }
    
    public void updateX(){
     x = x + encoder1.getDistance();
    }
    
    public void updateY(){
     y = y + encoder2.getDistance();
    }
}