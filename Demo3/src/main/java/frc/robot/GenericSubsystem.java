package frc.robot;

import java.util.function.Predicate;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SpeedController;
import frc.wpilib2020.framework.SubsystemBase;

/**
 * GenericSubsystem
 */
public class GenericSubsystem extends SubsystemBase {
    private SpeedController m_motor;
    private AnalogInput m_distanceSensor;
    private Predicate<Double> m_moveAbilityTester;
    private Convertor<Double> m_toCm;

    public GenericSubsystem(SpeedController motor, AnalogInput distanceSensor, Predicate<Double> moveAbilityTester,Convertor<Double> toCm) {
        m_motor = motor;
        m_distanceSensor = distanceSensor;
        m_moveAbilityTester = moveAbilityTester;
        m_toCm = toCm;
    }
    //TODO: stop when test returns false
    public boolean setSpeed(double speed) {
        if(m_moveAbilityTester.test(m_toCm.convert(m_distanceSensor.getVoltage()))){  
        m_motor.set(speed);
            return true;
        }else{
            return false;
        }
    }
    public boolean canMove(){
        return m_moveAbilityTester.test(m_toCm.convert(m_distanceSensor.getVoltage()));
    }
    
    

}