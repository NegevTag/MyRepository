package frc.robot;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.Preferences;

/**
 * DashboardConstants 
 */
public class DashboardConstants {
    public Supplier addDouble(String key, double defultValue) {
        Preferences.getInstance().putDouble(key, defultValue);
        return () -> Preferences.getInstance().getDouble(key, defultValue);
    }

}
