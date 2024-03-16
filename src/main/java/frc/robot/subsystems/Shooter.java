// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
 final CANSparkMax m_shootermotor1;
 final CANSparkMax m_shootermotor2;
 final CANSparkMax m_feedermotor1;
 final CANSparkMax m_feedermotor2;

  private static Shooter m_Instance;
  public static Shooter getInstance(){
    if(m_Instance == null){
      m_Instance = new Shooter();
    }
    return m_Instance;
  }
  public Shooter(){
    m_shootermotor1 = new CANSparkMax(Constants.Shooter.m_shooterMotor1, MotorType.kBrushless);
    m_shootermotor2 = new CANSparkMax(Constants.Shooter.m_shooterMotor2,MotorType.kBrushless);
    m_feedermotor1 = new CANSparkMax(Constants.Shooter.m_feederMotor1, MotorType.kBrushless);
    m_feedermotor2 = new CANSparkMax(Constants.Shooter.m_feederMotor2, MotorType.kBrushless);

    m_shootermotor1.restoreFactoryDefaults();
    m_shootermotor2.restoreFactoryDefaults();
    m_feedermotor1.restoreFactoryDefaults();
    m_feedermotor2.restoreFactoryDefaults();

    m_feedermotor1.setInverted(true);
  }

  public void runFeeder(){
    m_feedermotor1.set(Constants.Shooter.m_feederSpeed);
    m_feedermotor2.set(Constants.Shooter.m_feederSpeed);
  }
  public Command getFeederCommand(){
      return this.startEnd(
      ()->{
        m_feedermotor1.set(Constants.Shooter.m_feederSpeed);
        m_feedermotor2.set(Constants.Shooter.m_feederSpeed);
      },
       ()->{
        m_feedermotor1.set(0);
        m_feedermotor2.set(0);
       });
   
  }
  public void runShooter(){
    m_shootermotor1.set(Constants.Shooter.m_shooterSpeed);
    m_shootermotor1.set(Constants.Shooter.m_shooterSpeed);
  }
    public Command getShooterCommand(){
      return this.startEnd(
      ()->{
        m_shootermotor1.set(Constants.Shooter.m_shooterSpeed);
        m_shootermotor2.set(Constants.Shooter.m_shooterSpeed);
      },
       ()->{
        m_shootermotor1.set(0);
        m_shootermotor2.set(0);
       });

    }
  }



