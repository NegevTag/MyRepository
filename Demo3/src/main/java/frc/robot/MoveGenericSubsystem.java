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

    public void moveToDistance(double distance, double speed) {

        while (m_distanceSupplier.get() < distance && m_subsystem.canMove()) {
            m_subsystem.setSpeed(speed);
        }
        m_subsystem.setSpeed(0);

    }

}