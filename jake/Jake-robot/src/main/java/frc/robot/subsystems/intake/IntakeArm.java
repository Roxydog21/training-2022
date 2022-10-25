// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.intake;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeArm extends SubsystemBase {
  private static final class Config {
    public static final int kIntakeArmID = 10;
    public static final double kIntakeArmSpeed = 0.7;
  }

  private WPI_TalonFX m_IntakeArm = new WPI_TalonFX(Config.kIntakeArm);

  public Hopper() {
    m_hopperMotor.setInverted(true);
    
  }
  public IntakeArm() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}