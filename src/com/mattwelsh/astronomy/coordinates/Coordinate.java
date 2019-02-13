/*
 * Copyright (C) 2019 by Matt Welsh
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
package com.mattwelsh.astronomy.coordinates;

/**
 * This class represents an abstract astronomical coordinate. This class exists because typical
 * astronomical coordinates come in several flavors, including right ascension, declination,
 * altitude, and azimuth.
 *
 * <p>Subclasses of this class must implement the reduceToRange() method which ensures the value of
 * the angle represented by the coordinate falls within the correct range, which can vary between
 * implementations. For example, right ascension is usually expressed in hour, minutes, and seconds,
 * which in turn are within the range 0-360 degrees, while declination has a valid range between -90
 * and 90.
 *
 * <p>This class doesn't implement any setters because some subclasses may be designed to be
 * immutable.
 *
 * @author Matt Welsh (mitya.welsh@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public abstract class Coordinate {

  protected double decimalDegrees;
  protected double decimalRadians;
  protected int integerDegrees;
  protected int minutes;
  protected double seconds;

  /**
   * Create and instance of a coordinate using the passed value for the angle represented.
   *
   * @param decimalDegrees
   */
  public Coordinate(double decimalDegrees) {
    this.decimalDegrees = decimalDegrees;
    normalize();
  }

  /**
   * Return the value of the angle represented by this coordinate as a decimal in degrees.
   *
   * @return The value of the coordinate in decimal degrees.
   */
  public double getDecimalDegrees() {
    return decimalDegrees;
  }

  /**
   * Return the interger part of the angle represented by this coordinate.
   *
   * @return The integer value of the coordinate in degrees.
   */
  public int getIntegerDegrees() {
    return integerDegrees;
  }

  /**
   * Return the arc minutes of the coordinate as an integer.
   *
   * @return The value of the arc minutes of the coordinate.
   */
  public int getMinutes() {
    return minutes;
  }

  /**
   * Return the arc seconds value of the coordinate as a double.
   *
   * @return The arc seconds value of the coordinate
   */
  public double getSeconds() {
    return seconds;
  }

  /**
   * Return the value of the angle represented by this coordinate as a decimal in radians.
   *
   * @return The value of the coordinate in decimal degrees.
   */
  public double getRadians() {
    return decimalRadians;
  }

  // ------------------------------------------------------------------------------------------------
  // Private and protected methods
  // ------------------------------------------------------------------------------------------------

  /**
   * Subclasses should implement this method to ensure the value of the angle represented by the
   * coordinate falls within the correct range. For example, right ascension is usually expressed in
   * hour, minutes, and seconds, which in turn are within the range 0-360 degrees, while declination
   * has a valid range * between -90 and 90. Some subclasses may choose to do nothing if the range
   * for the value being expressed doesn't matter.
   */
  protected abstract void reduceToRange();

  protected void normalize() {
    reduceToRange();
    decimalRadians = decimalDegrees * Math.PI / 180.0;
    calculateMinutesAndSeconds();
  }

  private void calculateMinutesAndSeconds() {
    integerDegrees = (int) decimalDegrees;
    double tempMin = (decimalDegrees - (int) decimalDegrees) * 60.0;
    seconds = tempMin - (int) tempMin;
    minutes = (int) (tempMin - seconds);
    seconds = seconds * 60;
  }
}
