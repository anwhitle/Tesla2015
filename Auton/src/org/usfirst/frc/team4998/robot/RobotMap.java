package org.usfirst.frc.team4998.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	//what auton to use
	//1=PickupAuton
	//other=MoveAuton
	public static final int autonChoice = 1;
		
	//ports for joystick
	public static int Joystick1Port = 0;
	public static int Joystick2Port = 1;
	
	//ports for Victors
	public static final int VictorDriverFront = 0;
	public static final int VictorDriverBack = 1;
	public static final int VictorPassengerFront = 2;
	public static final int VictorPassengerBack = 3;
	
	//ports for talons
	public static final int talon1 = 4;
	public static final int talon2 = 5;
	
	//ports for encoders
	public static final int encoder1port1 = 6;
	public static final int encoder1port2 = 7;
	public static final int encoder2port1 = 8;
	public static final int encoder2port2 = 9;
	
	//port for gyro
	public static final int Gyro = 0;
	
	//ports for ultrasonic sensors
	public static final int ultrasonic1port1 = 0;
	public static final int ultrasonic1port2 = 1;
	public static final int ultrasonic2port1 = 2;
	public static final int ultrasonic2port2 = 3;
	
	//variable for encoders
	public static final double distancePerPulse1 = 1000;
	public static final double distancePerPulse2 = 1000;
	public static final double setMaxPeriod1 = .1;
	public static final double setMaxPeriod2 = .1;
	public static final int setMinRate1 = 10;
	public static final int setMinRate2 = 10;
	public static final int setSamplesToAverage1 = 7;
	public static final int setSamplesToAverage2 = 7;

}
