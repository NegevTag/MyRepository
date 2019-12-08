package frc.robot;

import java.util.function.Supplier;

/**
 * MoveGenericSubsystem
 */
public class MoveGenericSubsystem {
    public MoveGenericSubsystem(Supplier distanceSupplier, GenericSubsystem subsystem) {
        m_distanceSupplier = distanceSupplier;
        m_subsystem = subsystem;
    }

    private Supplier<Double> m_distanceSupplier;
    private GenericSubsystem m_subsystem;

    public boolean moveToDistance(double distance, double speed) {
        m_subsystem.setSpeed(speed);
        while (m_distanceSupplier.get() < distance && m_subsystem.canMove()) {

        }
        m_subsystem.setSpeed(0);
        return m_subsystem.canMove();

    }

}