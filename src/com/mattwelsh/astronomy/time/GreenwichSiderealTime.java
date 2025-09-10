/*
 * Copyright (C) 2019-2025 by Matt Welsh
 * This library is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details. You should have received a copy of the GNU
 * Lesser General Public License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
 */
package com.mattwelsh.astronomy.time;

/**
 * This class represents Greenwich Sidereal Time, and can calculate the mean sidereal time at
 * Greenwich. In the  future it will be enhanced to also compute the apparent sidereal time
 * (the Greenwich hour angle of the true vernal equinox) which is the mean sidereal time corrected
 * for the nutation in right ascension and the true obliquity of the ecliptic.
 *
 * @author Matt Welsh (mitya.welsh@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class GreenwichSiderealTime {

  private JulianDate julianDate;
  private double meanSiderealTime;
  private int meanSiderealTimeHour;
  private int meanSiderealTimeMinute;
  private int meanSiderealTimeSecond;

  /**
   * Create a GreenwichSiderealTime object for the passed JulianDate (UT).
   *
   * @param julianDate The JulianDate to be used to create the sidereal time (UT).
   */
  public GreenwichSiderealTime(JulianDate julianDate) {
    this.julianDate = julianDate;
    computeFields();
  }

  /**
   * Returns the JulianDate to be used to create the sidereal time.
   *
   * @return The JulianDate to be used to create the sidereal time.
   */
  public JulianDate getJulianDate() {
    return this.julianDate;
  }

  /**
   * Returns the mean sidereal time represented by this object in decimal degrees.
   *
   * @return The mean sidereal time represented by this object.
   */
  public double getMeanSiderealTime() {
    return this.meanSiderealTime;
  }

  /**
   * Returns the mean sidereal time represented by this object in decimal hours.
   *
   * @return The mean sidereal time represented by this object.
   */
  public double getMeanSiderealTimeDecimalHours() {
    return this.meanSiderealTime / 15.0;
  }

  /**
   * Returns the hour of the mean sidereal time represented by this object.
   *
   * @return The hour of the mean sidereal time represented by this object.
   */
  public int getMeanSiderealTimeHour() {
    return this.meanSiderealTimeHour;
  }

  /**
   * Returns the minute of the mean sidereal time represented by this object.
   *
   * @return The minute of the mean sidereal time represented by this object.
   */
  public int getMeanSiderealTimeMinute() {
    return this.meanSiderealTimeMinute;
  }

  /**
   * Returns the second of the mean sidereal time represented by this object.
   *
   * @return The second of the mean sidereal time represented by this object.
   */
  public int getMeanSiderealTimeSecond() {
    return this.meanSiderealTimeSecond;
  }

  // -----------------------------------------------------------------------------------------------
  // Protected and private methods
  // -----------------------------------------------------------------------------------------------

  private void computeFields() {
    double t = (this.julianDate.getJulianDayNumber() - 2451545.0) / 36525;
    double tempMST = 280.46061837 +
        (360.98564736629 * (this.julianDate.getJulianDayNumber() - 2451545.0)) +
        (0.000387933 * t * t) -
        (t * t * t /38710000.0);
    this.meanSiderealTime = reduceToRange(tempMST);

    this.meanSiderealTimeHour = (int)(this.meanSiderealTime / 15.0);

    double decMin = ((this.meanSiderealTime / 15.0) - (this.meanSiderealTimeHour)) * 60;

    this.meanSiderealTimeMinute = (int)decMin;
    double decSec = (decMin - this.meanSiderealTimeMinute) * 60;
    this.meanSiderealTimeSecond = (int)decSec;
  }

  protected double reduceToRange(double decimalDegrees) {
    while (decimalDegrees > 360.0) {
      decimalDegrees -= 360.0;
    }

    while (decimalDegrees < 0.0) {
      decimalDegrees += 360.0;
    }
    return decimalDegrees;
  }
}
