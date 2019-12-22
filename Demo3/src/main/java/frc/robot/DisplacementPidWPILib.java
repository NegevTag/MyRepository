package frc.robot;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import frc.wpilib2020.deps.PIDController;
import frc.wpilib2020.framework.CommandBase;

/**
 * GenericSubsystemPid
 */
public class DisplacementPidWPILib extends CommandBase  {
    private GenericSubsystem m_plant;
    private double m_distance;
    private double m_kProportional, m_kIntegral, m_kDerivative;
    private double m_waitSecends;
    private PIDController m_pidController;

    public DisplacementPidWPILib(GenericSubsystem plant, double distance, double kProportional, double kIntegral,
            double kDerivative, double waitSecends) {
        m_plant = plant;
        m_distance = distance;
        m_kProportional = kProportional;
        m_kIntegral = kIntegral;
        m_kDerivative = kDerivative;
        m_waitSecends = waitSecends;
        addRequirements(m_plant);

    }

    @Override
    public void initialize() {
        m_pidController = new PIDController(m_kProportional, m_kIntegral, m_kDerivative);
        m_pidController.setSetpoint(m_distance);
        m_pidController.setIntegratorRange(-1.0,1.0); //this line makes the code more readable but not needed
    }

    @Override
    public void execute() {
        m_plant.setSpeed(m_pidController.calculate(m_plant.getDistance()));
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return false;
    }
    

}