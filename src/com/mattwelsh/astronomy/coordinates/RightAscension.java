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
package com.mattwelsh.astronomy.coordinates;

import com.mattwelsh.astronomy.utilities.Utilities;

/**
 * <p>This class extends the Coordinate class and implements the reduceToRange method to ensure the
 * angle represented is between 0 to 360 degrees, and adds the astronomy standard Hours field.
 *
 * @author Matt Welsh (mitya.welsh@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class RightAscension extends Coordinate {

  protected int hour;
  protected double decimalHours;

  /**
   * Create an instance of a RightAscension class using the passed decimal degrees.
   *
   * @param dDegrees The value of the coordinate represented by this class. This will
   * cause a recalculation of all fields in this object.
   */
  public RightAscension(double dDegrees) {
    super(dDegrees / 15);
    hour = this.integerDegrees;
    decimalHours = decimalDegrees;
    decimalDegrees = dDegrees;
  }

  /**
   * Sets the value of the coordinate using the passed decimal degrees. This will cause a
   * recalculation of all fields in this object.
   *
   * @param dDegrees Sets the value of the coordinate using the passed decimal degrees.
   */
  public void setDecimalDegrees(double dDegrees) {
    this.decimalDegrees = dDegrees / 15;
    super.normalize();
    decimalHours = this.decimalDegrees;
    hour = this.integerDegrees;
    this.decimalDegrees = dDegrees;
    //hour = (int) (this.decimalDegrees/15);
  }

  /**
   * Sets the value of the coordinate using the passed decimal hours. This will cause a
   * recalculation of all fields in this object.
   *
   * @param dHours The hour of the coordinate represented by this class. This will cause a
   * recalculation of all fields in this object.
   */
  public void setDecimalHours(double dHours) {
    setDecimalDegrees(dHours * 15);
  }

  /**
   * Gets the value of the coordinate represented by this class.
   *
   * @return The hour of the coordinate represented by this class.
   */
  public int getHour() {
    return this.hour;
  }

  /**
   * Gets the value of the coordinate expressed in decimal hours.
   *
   * @return The value of the coordinate expressed in decimal hours.
   */
  public double getDecimalHours() {
    return this.decimalHours;
  }

  // ------------------------------------------------------------------------------------------------
  // Private and protected methods
  // ------------------------------------------------------------------------------------------------

  protected void reduceToRange() {
    decimalDegrees = Utilities.reduceToRange24(decimalDegrees);
  }
}
