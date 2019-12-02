package frc.robot;

/**
 * RobotMap
 */
public interface RobotMap {
   public interface MotorPorts{
    public final int rightGripper = 9;
    public final int leftGripper = 4;
    public final int elevator1 = 3;
    public final int elevator2 = 6;

   }
   public interface JoystickPorts{
      public final int button = 2;
   }
   public interface AnalogPorts{
      //TODO: find the right laserPort
      public final int elevatorLaser = 1;
   }
}