/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Groot extends TimedRobot implements RobotMap {
  public static SpeedController m_elevatorMotor;
  public Joystick m_elevatorJoystick;
  public static Elevator m_elevator;
  public static Chassis m_Chassis;

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
    @Override
  public void robotInit() {
    
  }

  @Override
  public void robotPeriodic() {

  }

  @Override
  public void autonomousInit() {

  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
  m_elevator = new Elevator();
  }

  @Override
  public void teleopPeriodic() {
   
  }

  @Override
  public void testInit() {
    m_elevatorJoystick = new Joystick(JoystickPorts.button);
    m_elevatorMotor = new SpeedControllerGroup(new WPI_VictorSPX(MotorPorts.elevator1),
        new WPI_VictorSPX(MotorPorts.elevator2));
    
   
  }

  @Override
  public void testPeriodic() {
    m_elevatorMotor.set(m_elevatorJoystick.getY()/2);
    System.out.println(m_elevatorJoystick.getY()/2);
  }

  

}