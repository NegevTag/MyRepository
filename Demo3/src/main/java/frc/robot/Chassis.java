package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedController;
import frc.wpilib2020.framework.SubsystemBase;

/**
 * Chassis
 */
// TODO: add javadoc
public class Chassis extends SubsystemBase implements RobotMap {
    SpeedController m_rightChassis;
    SpeedController m_leftChassis;
    public double m_currentRightSpeed;
    public double m_currentLeftSpeed;

    public Chassis() {
        m_rightChassis = new WPI_VictorSPX(MotorPorts.rightChasiss);
        m_leftChassis = new WPI_VictorSPX(MotorPorts.leftChasiss);
        m_currentRightSpeed = 0;
        m_currentLeftSpeed = 0;
        setDefaultCommand(new TankJoystickControl());
    }

    public boolean moveForward(double speed) {
        if (speed >= 0 && speed <= 1) {
            m_rightChassis.set(speed);
            m_leftChassis.set(speed);
            m_currentRightSpeed = speed;
            m_currentRightSpeed = speed;
            return true;
        } else {
            return false;
        }
    }

    public boolean moveBack(double speed) {
        if (speed >= 0 && speed <= 1) {
            m_rightChassis.set(-1 * speed);
            m_leftChassis.set(-1 * speed);
            m_currentRightSpeed = -1 * speed;
            m_currentRightSpeed = -1 * speed;
            return true;
        } else {
            return false;
        }
    }

    public boolean turn(boolean toRight, double speed) {
        if (speed >= 0 && speed <= 1) {
            int coefficient = 1;
            if (!toRight) {
                coefficient = -1;
            }
            m_rightChassis.set(coefficient * speed);
            m_leftChassis.set(-1 * coefficient * speed);
            m_currentRightSpeed = coefficient * speed;
            m_currentRightSpeed = -1 * coefficient * speed;
            return true;
        } else {
            return false;
        }
    }

    public boolean setSpeed(double rightChasissSpeed, double leftChasissSpeed) {
        if (rightChasissSpeed >= -1 && rightChasissSpeed <= 1 && leftChasissSpeed >= -1 && leftChasissSpeed <= 1) {
            m_rightChassis.set(rightChasissSpeed);
            m_leftChassis.set(leftChasissSpeed);
            m_currentRightSpeed = rightChasissSpeed;
            m_currentRightSpeed = leftChasissSpeed;
            return true;
        } else {
            return false;
        }
    }

    public void stop() {
        m_rightChassis.set(0);
        m_leftChassis.set(0);
        m_currentRightSpeed = 0;
        m_currentRightSpeed = 0;
    }
}
