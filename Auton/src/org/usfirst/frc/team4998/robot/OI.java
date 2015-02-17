package org.usfirst.frc.team4998.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	
	
	public static Joystick stick = new Joystick(RobotMap.JoystickPort);
	
	public static JoystickButton One = new JoystickButton(stick,1);
	public static JoystickButton Two = new JoystickButton(stick,2);
	public static JoystickButton Three = new JoystickButton(stick,3);
	
	
	public double stick1X(){
		return stick.getX();
	}
	
	public double stick1Y(){
		return stick.getY();
	}
	
	public double stick1Twist(){
		return stick.getTwist();
	}
	
	
	Button rightbutton1 = new JoystickButton(stick,1),
			rightbutton2 = new JoystickButton(stick,2),
			rightbutton3 = new JoystickButton(stick,3),
			rightbutton4 = new JoystickButton(stick,4),
			rightbutton5 = new JoystickButton(stick,5),
			rightbutton6 = new JoystickButton(stick,6),
			rightbutton7 = new JoystickButton(stick,7),
			rightbutton8 = new JoystickButton(stick,8),
			rightbutton9 = new JoystickButton(stick,9),
			rightbutton10 = new JoystickButton(stick,10),
			rightbutton11 = new JoystickButton(stick,11),
			rightbutton12 = new JoystickButton(stick,12);
	
}

