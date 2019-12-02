package frc.robot;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import frc.wpilib2020.framework.CommandBase;

/**
 * Controll the elevator speed by Joistick
 */
public class ElevatorJoystickSpeedControl extends CommandBase implements RobotMap {
    /**
     * the Joystick that we use for the elevator
     */
    public Joystick m_elevatorJoystick;
    /**
     * the ratio between the joystick to the speed
     */
    public double JOYSTICK_RATIO;

    /**
     * intiliaze the joystick and set that the Command requiers the elevator that
     * belong to groot
     */
    @Override
    public void initialize() {
        m_elevatorJoystick = new Joystick(JoystickPorts.button);
        addRequirements(Groot.m_elevator);
        Preferences.getInstance().putDouble("joystick elevator ratio", 2);
    }

    /**
     * not finish until something interapted to it
     */
    @Override
    public boolean isFinished() {
        return false;
    }

    /**
     * move the elevator regarding to the joystick
     */
    public void execute() {
        JOYSTICK_RATIO = Preferences.getInstance().getDouble("joystick elevator ratio", 2);
        if (m_elevatorJoystick.getY() > 0) {
            Groot.m_elevator.moveElevatorUp(m_elevatorJoystick.getY() / JOYSTICK_RATIO);
        } else if (m_elevatorJoystick.getY() < 0) {
            Groot.m_elevator.moveElevatorDown(m_elevatorJoystick.getY() / JOYSTICK_RATIO);
        } else {
            Groot.m_elevator.stop();
        }
    }

    /**
     * if finished stop the elevator
     */

    @Override
    public void end(boolean interrupted) {
        Groot.m_elevator.stop();
    }

}