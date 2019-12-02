package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

/**
 * The class present the gripper on our Robot
 * 
 * <ul>
 * <li>note: when the word speed write(except the currentSpeed members) it is
 * not means the speed in SpeedControler unit, it means other speed unit.
 */
public abstract class Gripper implements RobotMap {
    /**
     * the Speed conroller that we use for the right gripper
     */
    protected SpeedController m_rightGripper;
    /**
     * the Speed conroller that we use for the left gripper
     */
    protected SpeedController m_leftGripper;
    /**
     * the currnet right gripper Speed
     */
    protected double m_currentRightSpeed;
    /**
     * the currnet left gripper Speed
     */
    protected double m_currentLeftSpeed;

    /**
     * Initalize the gripper SpeedControlers and the current speed
     */
    public Gripper() {
        m_rightGripper = new WPI_VictorSPX(MotorPorts.rightGripper);
        m_leftGripper = new WPI_VictorSPX(MotorPorts.leftGripper);
        m_currentRightSpeed = 0;
        m_currentLeftSpeed = 0;

    }

    /**
     * catch the ball by spining the gripper in
     * 
     * @param rightGripperSpeed the right gripper spin in speed , must be 0<= and
     *                          <=1;
     * @param leftGripperSpeed  the right gripper spin in speed , must be 0<= and
     *                          <=1;
     * @return true if the speed was set(the parmaters fitted the terms)
     */
    public boolean catchBall(double rightGripperSpeed, double leftGripperSpeed) {
        if ((rightGripperSpeed >= 0 && rightGripperSpeed <= 1) && (leftGripperSpeed >= 0 && rightGripperSpeed >= 1)) {
            m_rightGripper.set(-1 * rightGripperSpeed);
            m_leftGripper.set(-1 * leftGripperSpeed);

            m_currentRightSpeed = -1 * rightGripperSpeed;
            m_currentLeftSpeed = -1 * leftGripperSpeed;
            return true;
        } else {
            return false;
        }
    }

    /**
     * throw the ball by spining the gripper out
     * 
     * @param rightGripperSpeed the right gripper spin out speed , must be 0<= and
     *                          <=1;
     * @param leftGripperSpeed  the right gripper spin out speed , must be 0<= and
     *                          <=1;
     * @return true if the speed was set(the parmaters fitted the terms)
     */
    public boolean throwBall(double rightGripperSpeed, double leftGripperSpeed) {
        if ((rightGripperSpeed >= 0 && rightGripperSpeed <= 1) && (leftGripperSpeed >= 0 && leftGripperSpeed >= 1)) {
            m_rightGripper.set(rightGripperSpeed);
            m_leftGripper.set(leftGripperSpeed);

            m_currentRightSpeed = rightGripperSpeed;
            m_currentLeftSpeed = leftGripperSpeed;
            return true;
        } else {
            return false;
        }
    }

    /**
     * set the speed in SpeedController units
     * 
     * @param speed must be between 1 and -1 in every gripper
     * @return true if the speed sets (speed between 1 and -1)
     */
    public boolean setSpeed(double rightGripperSpeed, double leftGripperSpeed) {
        if ((rightGripperSpeed >= 0 && rightGripperSpeed <= 1) && (leftGripperSpeed >= 0 && leftGripperSpeed >= 1)) {
            m_rightGripper.set(rightGripperSpeed);
            m_leftGripper.set(leftGripperSpeed);
            m_currentRightSpeed = rightGripperSpeed;
            m_currentLeftSpeed = leftGripperSpeed;
            return true;
        } else {
            return false;
        }
    }

    /**
     * 
     * @return the current Rightspeed in SpeedController unit
     */
    public double getCurrentRightSpeed() {
        return m_currentRightSpeed;
    }

    /**
     * 
     * @return the current Lefttspeed in SpeedController unit
     */
    public double getCurrentLeftSpeed() {
        return m_currentLeftSpeed;
    }

    /**
     * Stops the grippers
     */
    public void stop() {
        m_rightGripper.set(0);
        m_currentRightSpeed = 0;
        m_leftGripper.set(0);
        m_currentLeftSpeed = 0;
    }

    /**
     * 
     * @return the distance from the ball to the Gripper
     */
    public abstract double getCargoDistance();

}
