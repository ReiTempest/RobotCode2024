// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
  private static Intake m_Instance;
  public static Intake getInstance(){
    if(m_Instance == null){
      m_Instance = new Intake();
    }
      return m_Instance;
  }

 final CANSparkMax m_intakemotor; 
  
  private Intake() { 
  
    m_intakemotor= new CANSparkMax(Constants.Intake.m_intakeMotorID, MotorType.kBrushless);
    m_intakemotor.restoreFactoryDefaults();
  }

  public void runIntake(){
    m_intakemotor.set(Constants.Intake.m_intakeSpeed);
  }
  public void ejectIntake(){
    m_intakemotor.set(Constants.Intake.m_ejectSpeed);
  }
  public void stopIntake(){
    m_intakemotor.set(0);
  }
    public Command getIntakeCommand() {
    // The startEnd helper method takes a method to call when the command is initialized and one to
    // call when it ends
    return this.startEnd(
        // When the command is initialized, set the wheels to the intake speed values
        () -> {
         m_intakemotor.set(Constants.Intake.m_intakeSpeed);
        },
        // When the command stops, stop the wheels
        () -> {
          m_intakemotor.set(0);
        });
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
