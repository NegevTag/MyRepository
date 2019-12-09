package frc.robot;

import java.util.function.Supplier;

import frc.wpilib2020.framework.CommandBase;

/**
 * MoveGenericSubsystem
 */
public class MoveGenericSubsystem extends CommandBase {
    public MoveGenericSubsystem(Supplier distanceSupplier, GenericSubsystem subsystem, double distance, double speed) {
        m_distanceSupplier = distanceSupplier;
        m_subsystem = subsystem;
        m_distance = distance;
        speed = m_speed;
        addRequirements(subsystem);
    }

    private Supplier<Double> m_distanceSupplier;
    private GenericSubsystem m_subsystem;
    private double m_distance;
    private double m_speed;

    @Override
    public void initialize() {
        m_subsystem.setSpeed(m_speed);
    }


    @Override
    public boolean isFinished() {
        return m_distanceSupplier.get() < m_distance && m_subsystem.canMove();
    }

    @Override
    public void end(boolean interrupted) {
        m_subsystem.setSpeed(0);

    }

}