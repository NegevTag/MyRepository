package frc.robot;

import java.lang.module.ModuleDescriptor.Requires;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.wpilib2020.framework.SubsystemBase;

/**
 * The class present the elevator on our Robot
 * <ul>
 * <li>note: when the word speed write(except the currentSpeed) it is not means
 * the speed in SpeedControler unit, it means other speed unit.
 * 
 */
public class Elevator extends SubsystemBase implements RobotMap {
    /**
     * the Speed conroller that we use for the elevator
     */
    protected SpeedController m_elevatorMotor;
    /**
     * the currnet Motor Speed(in the Speedcontroler unit)
     */
    protected double m_currentSpeed;

    public static final double MAXIMUM_HEIGHT = 225.0;
    /**
     * the speed that make the elevator stop
     */
    public static final double STOP_SPEED = 0.13;

    /**
     * Initalize the elevator SpeedControler and the current speed
     */
    public Elevator() {
        m_elevatorMotor = new SpeedControllerGroup(new WPI_VictorSPX(MotorPorts.elevator1),
                new WPI_VictorSPX(MotorPorts.elevator2));
        m_currentSpeed = 0;

    }

    /**
     * Moves up the elevator
     * 
     * @param speed the elevator raised speed (speed must be 0< and =>1 )
     * @return true if the elevator were moved up(0< speed =>1)
     */
    public boolean moveElevatorUp(double speed) {
        if (speed > 0 && speed <= 1.0 - STOP_SPEED) {
            m_elevatorMotor.set(STOP_SPEED + (speed * (1.0 - STOP_SPEED)));
            m_currentSpeed = STOP_SPEED + (speed * (1.0 - STOP_SPEED));
            return true;
        } else {
            return false;
        }
    }

    /**
     * Moves down the elevator
     * 
     * @param speed the elevator fall speed (speed must be 0< and =>+1)
     * @return true if the elevator were moved down(0< and =>1)
     */
    public boolean moveElevatorDown(double speed) {
        if (speed > 0 && speed <= 1.0) {
            m_elevatorMotor.set(STOP_SPEED - (speed * (1.0 + STOP_SPEED)));
            m_currentSpeed = STOP_SPEED - (speed * (1.0 + STOP_SPEED));
            return true;
        } else {
            return false;
        }
    }

    /**
     * set the speed in SpeedController units
     * 
     * @param speed must be between 1 and -1
     * @return true if the speed sets (speed between 1 and -1)
     */
    public boolean setSpeed(double speed) {
        if (speed <= -1 && speed <= 0) {
            m_elevatorMotor.set(speed);
            m_currentSpeed = speed;
            return true;
        } else {
            return false;
        }
    }

    /**
     * 
     * @return the current speed in SpeedControler unit
     */
    public double getCurrentSpeed() {
        return m_currentSpeed;
    }

    /**
     * Stops the elevator
     */
    public void stop() {
        m_elevatorMotor.set(STOP_SPEED);
        m_currentSpeed = STOP_SPEED;
    }

    public boolean moveToHeight(double height, double speed) {
        if (speed > 0 && speed <= 1&&height>=0&&height<=MAXIMUM_HEIGHT) {
            if (getDistance() < height) {
                moveElevatorUp(speed);
                while (getDistance() < height) {
                }
                stop();
            } else if (getDistance() > height) {
                moveElevatorDown(speed);
                while (getDistance() > height) {
                }
            }else{
                stop();
            }
            return true;
        }
        return false;
    }

    /**
     * 
     * @return the distance from the elevator to the ground in cm
     */
    public double getDistance() {
        return toCM(new AnalogInput(AnalogPorts.elevatorLaser).getVoltage());
    }
    // TODO: add correct calculation

    protected double toCM(double voltege) {
        return voltege * 2;
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new ElevatorJoystickSpeedControl());
    }
    

}
