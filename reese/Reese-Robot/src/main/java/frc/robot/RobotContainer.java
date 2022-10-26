// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ArcadeDrive;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.intake.Hopper;
import frc.robot.subsystems.intake.IntakeArm;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private static final class Config{
    public static final int kjoystickID = 0;
    public static final int kJoystickButtonIDIntakeOut = 90;
    public static final int kJoystickButtonIDIntakeIn = 99;
    public static final int kJoystickButtonIDIntakeArmIn = 92;
    public static final int kJoystickButtonIDIntakeArmOut = 95;
  }
  

  // The robot's subsystems and commands are defined here..
  private Joystick m_joyStick =  new Joystick(Config.kjoystickID);
  private Drivetrain m_drivetrain = new Drivetrain();
  private ArcadeDrive m_ArcadeDrive = new ArcadeDrive(m_drivetrain, m_joyStick);
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }
  private IntakeArm m_intakeArm = new IntakeArm();
  private Hopper m_hopper = new Hopper();
  private JoystickButton m_IntakeIn = new JoystickButton(m_joyStick, Config.kJoystickButtonIDIntakeIn);
  private JoystickButton m_IntakeOut = new JoystickButton(m_joyStick,Config.kJoystickButtonIDIntakeOut);
  private JoystickButton m_intakeArmOut = new JoystickButton(m_joyStick,Config.kJoystickButtonIDIntakeArmOut);
  private JoystickButton m_intakeArmIn = new JoystickButton(m_joyStick,Config.kJoystickButtonIDIntakeArmIn);


  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  // runs commands
  private void configureButtonBindings() {
    m_IntakeIn.whenPressed(m_intakeArm.SolenoidArmIn());
    m_IntakeOut.whenPressed(m_intakeArm.SolenoidArmOut());
  
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
  return null;
  }
  public Command getTeleopCommand() {
    m_drivetrain.setDefaultCommand(m_ArcadeDrive);
    return null;
  }
}

