package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Preferences;
import frc.wpilib2020.framework.CommandBase;

/**
 * TankJoystickControl
 */
public class TankJoystickControl extends CommandBase implements RobotMap{
    public Joystick m_rightChassisJoystick;
    public Joystick m_leftChassisJoystick;
    public double JOYSTICK_RATIO;

    @Override
    public void initialize() {
        addRequirements(Groot.m_Chassis);
        m_rightChassisJoystick = new Joystick(JoystickPorts.rightChasiss);
        m_leftChassisJoystick = new Joystick(JoystickPorts.leftChasiss);
        Preferences.getInstance().putDouble("joystick chassis ratio", 2);
    }
    @Override
    public void execute() {
        JOYSTICK_RATIO = Preferences.getInstance().getDouble("joystick elevator ratio", 2);
        Groot.m_Chassis.setSpeed(m_rightChassisJoystick.getY(), m_leftChassisJoystick.getY());
    }
    
    @Override
    public boolean isFinished() {
        return false;
    }
    @Override
    public void end(boolean interrupted) {
        Groot.m_Chassis.stop();
    }

}