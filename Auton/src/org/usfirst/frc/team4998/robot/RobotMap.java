package org.usfirst.frc.team4998.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	//variable for joystick
public static int Joystick1Port = 0;
public static int Joystick2Port = 1;

	//variables for Victors
public static final int VictorDriverFront = 0;
public static final int VictorDriverBack = 1;
public static final int VictorPassengerFront = 2;
public static final int VictorPassengerBack = 3;

   //variables for sensors
public static final int Gyro = 0;

public static final double distancePerPulse1 = 1000;
public static final double distancePerPulse2 = 1000;

public static final int ultrasonic1port1 = 0;
public static final int ultrasonic1port2 = 1;
public static final int ultrasonic2port1 = 2;
public static final int ultrasonic2port2 = 3;

public static final int encoder1port1 = 6;
public static final int encoder1port2 = 7;
public static final int encoder2port1 = 8;
public static final int encoder2port2 = 9;

public static final double setMaxPeriod1 = .1;
public static final double setMaxPeriod2 = .1;

public static final int setMinRate1 = 10;
public static final int setMinRate2 = 10;

public static final int setSamplesToAverage1 = 7;
public static final int setSamplesToAverage2 = 7;

public static final int autonChoice = 1;

public static final int talon1 = 4;
public static final int talon2 = 5;
}
