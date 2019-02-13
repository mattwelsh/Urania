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
 * <p>This class extends the Coordinate class and implements the reduceToRange method to ensure the
 * angle represented is between 0 to 360 degrees, and adds the astronomy standard Hours field.
 *
 * @author Matt Welsh (mitya.welsh@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class RightAscension extends Coordinate {

  protected int hour;

  /**
   * Create an instance of a RightAscension class using the passed decimal degrees.
   *
   * @param decimalDegrees The value of the coordinate represented by this class. This will
   * cause a recalculation of all fields in this object.
   */
  public RightAscension(double decimalDegrees) {
    super(decimalDegrees);
    hour = (int) (decimalDegrees/15);
  }

  /**
   * Sets the value of the coordinate represented by this class.
   *
   * @param decimalDegrees The value of the coordinate represented by this class. This will cause a
   * recalculation of all fields in this object.
   */
  public void setDecimalDegrees(double decimalDegrees) {
    this.decimalDegrees = decimalDegrees;
    super.normalize();
    hour = (int) (this.decimalDegrees/15);
  }

  /**
   * Sets the value of the coordinate represented by this class.
   *
   * @param hour The hour of the coordinate represented by this class. This will cause a
   * recalculation of all fields in this object.
   */
  public void setHour(int hour) {
    double hourAsDegrees = (double)(hour * 15.0);
    hourAsDegrees += this.decimalDegrees - (long)this.decimalDegrees;
    setDecimalDegrees(hourAsDegrees);
  }

  /**
   * Gets the value of the coordinate represented by this class.
   *
   * @return The hour of the coordinate represented by this class.
   */
  public int getHour() {
    return this.hour;
  }

  // ------------------------------------------------------------------------------------------------
  // Private and protected methods
  // ------------------------------------------------------------------------------------------------

  protected void reduceToRange() {
    if(decimalDegrees > 360.0) {
      decimalDegrees = decimalDegrees - 360.0 * ((long)(decimalDegrees/360.0));
    }

    if(decimalDegrees < 0.0) {
      decimalDegrees = decimalDegrees + 360.0 * ((long)Math.abs(decimalDegrees/360.0) + 1);
    }

  }
}
