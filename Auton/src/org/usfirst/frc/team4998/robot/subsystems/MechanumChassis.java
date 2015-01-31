package org.usfirst.frc.team4998.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Victor;

import org.usfirst.frc.team4998.robot.RobotMap;

public class MechanumChassis extends Subsystem {
    private Victor frontLeft, frontRight, rearLeft, rearRight;
    private Gyro gyro;
 
    private double SECS_TO_FULL_SPEED;
    private double INIT_SPEED;
    double REDUCE = 1;
    public boolean useGyro = false;
    
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
        gyro = new Gyro(RobotMap.Gyro);
        
        frontLeft   = new Victor (RobotMap.VictorDriverFront);
        frontRight  = new Victor (RobotMap.VictorPassengerFront);
        rearLeft    = new Victor (RobotMap.VictorDriverBack);
        rearRight   = new Victor (RobotMap.VictorPassengerBack);
 
        SECS_TO_FULL_SPEED = 1.5;
        INIT_SPEED = 0.3;
		
	}
 
    public void drive(double right, double forward, double clockwise) {
        if (Math.abs(clockwise) < 0.1)
            clockwise = 0;
 
        if (Math.abs(right*right + forward*forward) < 0.1) {
            forward = 0;
            right = 0;
        }
 
        double gyroDeg = gyro.getAngle() % 360 + 180;
        if (!useGyro) gyroDeg = 180;
 
        // this section should stop the rapid flip-flop of pos/neg values.
        if (-2 < gyroDeg    && gyroDeg < 2)     gyroDeg = 0;
        if (88 < gyroDeg    && gyroDeg < 92)    gyroDeg = 90;
        if (178 < gyroDeg   && gyroDeg < 182)   gyroDeg = 180;
        if (268 < gyroDeg   && gyroDeg < 272)   gyroDeg = 270;
 
        if (-92 < gyroDeg   && gyroDeg < -88)   gyroDeg = -90;
        if (-182 < gyroDeg  && gyroDeg < -178)  gyroDeg = -180;
        if (-272 < gyroDeg  && gyroDeg < -268)  gyroDeg = -270;
        if (-358 > gyroDeg)                     gyroDeg = 0;
 
        // 'right' is the magnitude of the vector.
        // cos(...) and sin(...) gets the x and y components
        // of the rotated vector (rotated by gyroDeg).
        // magnitude <cos(Θ), sin(Θ)>
        // ^^this just broken apart into cos and sin components is below
        double gyroRad = Math.toRadians(gyroDeg);
 
        double xComRight = right * Math.cos(gyroRad);
        double yComRight = right * Math.sin(gyroRad);
 
        // 'forward' is the magnitude of the vector. must rotate 90 deg
        // in order to start from "0" for y. otherwise same as above.
        gyroRad = Math.toRadians(gyroDeg + 90);
 
        double xComFor = forward * Math.cos(gyroRad);
        double yComFor = forward * Math.sin(gyroRad);
 
        // now that we have the extracted components of motion for each axis,
        // we can add them together to get the final motion
        right   = xComRight + xComFor;
        forward = yComRight + yComFor;
 
 
        // viewing the video at https://www.youtube.com/watch?v=T1VZbFio5_E
        // will be very helpful in considering this part of the code.
        double frontLeftForce   = forward + clockwise + right;
        double frontRightForce  = forward - clockwise - right;
        double rearLeftForce    = forward + clockwise - right;
        double rearRightForce   = forward - clockwise + right;
 
        double max = normalize(
            frontLeftForce, frontRightForce, rearLeftForce, rearRightForce
        );
 
        if (max > 1) {
            frontLeftForce /= max;
            frontRightForce /= max;
            rearLeftForce /= max;
            rearRightForce /= max;
        }
 
        frontLeftForce  = limitSpeed(frontLeftForce,    frontLeft);
        frontRightForce = limitSpeed(frontRightForce,   frontRight);
        rearLeftForce   = limitSpeed(rearLeftForce,     rearLeft);
        rearRightForce  = limitSpeed(rearRightForce,    rearRight);
 
        frontLeft.set(REDUCE * frontLeftForce);
        frontRight.set(REDUCE * -frontRightForce);
        rearLeft.set(REDUCE * rearLeftForce);
        rearRight.set(REDUCE * -rearRightForce);
    }
 
    public int sign(double num) {
        return (int)(num / Math.abs(num));
    }
 
    private double limitingFunc(double x) {
        if (x >= SECS_TO_FULL_SPEED)
            return 1.0;
 
        double y = x * (1 / SECS_TO_FULL_SPEED);
 
        return y;
    }
 
    private double invLimitingFunc(double y) {
        if (y >= 1.0) return SECS_TO_FULL_SPEED;
 
        double x = SECS_TO_FULL_SPEED * y;
 
        return x;
    }
 
    private double limitSpeed(double force, Victor motor) {
        final int sign = sign(force);
 
        force = Math.abs(force);
        final double curTime = invLimitingFunc(Math.abs(motor.get()) + INIT_SPEED);
 
        if (force > limitingFunc(curTime + 0.02)) {
            force = limitingFunc(curTime + 0.02);
        }
 
        return force * sign;
    }
 
    public void setAllMotors(double speed) {
        frontLeft.set(speed);
        frontRight.set(-speed);
        rearLeft.set(speed);
        rearRight.set(-speed);
    }
 
    // this makes sure that no wheel speed exceeds magnitude of ±1.
    // this is just the beginning; it is less awkward
    // to just let drive(...) do the final steps
    private double normalize(double fl, double fr, double rl, double rr) {
        double max = Math.abs(fl);
 
        if (Math.abs(fr) > max) max = Math.abs(fr);
        if (Math.abs(rl) > max) max = Math.abs(rl);
        if (Math.abs(rr) > max) max = Math.abs(rr);
 
        return max;
    }
 
    public void setSecsToFullSpeed(double secs) {
        this.SECS_TO_FULL_SPEED = secs;
    }
 
    public double getSecsToFullSpeed() {
        return this.SECS_TO_FULL_SPEED;
    }
 
    public void setInitSpeed(double speed) {
        this.INIT_SPEED = speed;
    }
 
    public double getInitSpeed() {
        return this.INIT_SPEED;
    }
}