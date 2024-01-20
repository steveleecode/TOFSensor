// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.TOFSensor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TOFCommand extends Command {
  private final TOFSensor m_tof;

  /** Creates a new TOFCommand. */
  public TOFCommand(TOFSensor tof) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_tof = tof;
    addRequirements(tof);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
      m_tof.setRange("Short", 33);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putNumber("Distance Inches", m_tof.getRangeInches());
    SmartDashboard.putNumber("Distance Raw", m_tof.getRangeRaw());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_tof.close();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
