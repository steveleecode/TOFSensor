// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.playingwithfusion.TimeOfFlight;
import com.playingwithfusion.TimeOfFlight.RangingMode;


public class TOFSensor extends SubsystemBase {
  private int id;
  private TimeOfFlight TOF;
  /** Creates a new TOFSensor. */
  /**
   * 
   * @param id ID for the sensor
   */
  public TOFSensor(int id) {
    id = this.id;
    TOF = new TimeOfFlight(id);
  }
  public int getID() {
    return id;
  }

  public void setRange(int topLeftX, int topLeftY, int bottomRightX, int bottomRightY) {
    TOF.setRangeOfInterest(topLeftX, topLeftY, bottomRightX, bottomRightY);
  }

  public double getRangeInches() {
    return Math.round(((TOF.getRange())/(25.4))*100.0)/100.0;
  }

  public double getRangeRaw() {
    return TOF.getRange();
  }

  public void close() {
    TOF.close();
  }



  /**
   * Short mode (default) works the best in bright lighting conditions, but can only measure 1.3 meters. Long mode can measure up to 4 meters in the dark, but may only be able to measure shorter distances depending on the lighting conditions. See the Vl53L1x datasheet for more information The sample time specifies the how frequently the time of flight sensor attempts to measure the distance to a target. The sample time must be between 24 and 1000 milliseconds.
   * 
   * @param mode setMode ("short", "medium", or "long")
   * @param sampleTime Set the sample time (24ms - 1000ms)
   */

  public void setRange(String sMode, double sampleTime) {
    switch(sMode) {
      case "short": //Use short only if less than 1.3 meters off the ground and bright light
        TOF.setRangingMode(RangingMode.Short, sampleTime);
      case "long": //Use for dark lighting up to 4 meters

        TOF.setRangingMode(RangingMode.Long, sampleTime);
      case "medium": //Use medium if there could potentially be dark lighting
        TOF.setRangingMode(RangingMode.Medium, sampleTime);

    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    System.out.println(TOF.getRange());
  }
}
