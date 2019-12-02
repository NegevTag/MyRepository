package frc.robot;

/**
 * RobotMap
 */
public interface RobotMap {
   public interface MotorPorts {
      public final int rightGripper = 9;
      public final int leftGripper = 4;
      public final int elevator1 = 3;
      public final int elevator2 = 6;
      // TODO add right port number;
      public final int rightChasiss = 3;
      // TODO add right port number;
      public final int leftChasiss = 7;

   }

   public interface JoystickPorts {
      public final int button = 2;
      //TODO: add right port
      public final int rightChasiss = 0;
      //TODO: add right port
      public final int leftChasiss = 1;

   }

   public interface AnalogPorts {
      // TODO: find the right laserPort
      public final int elevatorLaser = 1;
   }
}