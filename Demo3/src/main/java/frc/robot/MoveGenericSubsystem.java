package frc.robot;

import java.util.function.Supplier;

import frc.wpilib2020.framework.CommandBase;

/**
 * MoveGenericSubsystem
 */
public class MoveGenericSubsystem extends CommandBase {
    public MoveGenericSubsystem(Supplier<Double> distanceSupplier, GenericSubsystem subsystem, double distance, double speed) {
        m_speedSupplier = distanceSupplier;
        m_subsystem = subsystem;
        addRequirements(subsystem);
    }

    private Supplier<Double> m_speedSupplier;
    private GenericSubsystem m_subsystem;
   

    @Override
    public void initialize() {
        m_subsystem.setSpeed(m_speedSupplier.get());
    }


    @Override
    public boolean isFinished() {
        return m_subsystem.canMove();
    }

    @Override
    public void end(boolean interrupted) {
        m_subsystem.setSpeed(0);

    }

}