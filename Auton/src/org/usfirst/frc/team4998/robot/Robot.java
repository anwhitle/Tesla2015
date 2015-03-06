
package org.usfirst.frc.team4998.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
//import edu.wpi.first.wpilibj.CameraServer;
import org.usfirst.frc.team4998.robot.commands.Teleop;
import org.usfirst.frc.team4998.robot.commands.PickupAuton;
import org.usfirst.frc.team4998.robot.commands.MoveAuton;
//import com.ni.vision.NIVision;
//import com.ni.vision.NIVision.Image;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;

	//CameraServer server;
    //int session;
    //Image frame;

    Command autonomousCommand, teleopCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
        // instantiate the command used for the autonomous period
        teleopCommand = new Teleop();
        
        if (RobotMap.autonChoice == 1){
        	autonomousCommand = new PickupAuton();
        } else {
        	autonomousCommand = new MoveAuton();
        }
        
        //frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);

        // the camera name (ex "cam0") can be found through the roborio web interface
        //session = NIVision.IMAQdxOpenCamera("cam0", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        //NIVision.IMAQdxConfigureGrab(session);
        
        //server = CameraServer.getInstance();
        //server.setQuality(50);
        //the camera name (ex "cam0") can be found through the roborio web interface
        //server.startAutomaticCapture("cam0");
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        teleopCommand.start();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	  if (teleopCommand != null) teleopCommand.cancel();
    	  //NIVision.IMAQdxStopAcquisition(session);
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        //NIVision.IMAQdxGrab(session, frame, 1);
        //CameraServer.getInstance().setImage(frame);
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
