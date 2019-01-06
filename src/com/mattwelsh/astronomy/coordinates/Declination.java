/*
 * Copyright (C) 2019 by Matt Welsh
 * This library is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or any later version.
 *
 * This library is distributed in the
 * hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details. You should have received a copy of the GNU Lesser General Public License along
 * with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street,
 * Fifth Floor, Boston, MA 02110-1301 USA
 */

package com.mattwelsh.astronomy.coordinates;

/**
 * <p>This class extends the Coordinate class and implements the reduceToRange method to ensure the
 * angle represented is between -90 to 90 degrees. Below are some examples of the result of calling
 * this method:
 *
 * <p>
 *
 * <ul>
 *   <li>45 degrees -> 45 degrees
 *   <li>
 *   <li>90 degrees -> 90 degrees
 *   <li>
 *   <li>135 degrees -> 45 degrees
 *   <li>
 *   <li>225 degrees -> -45 degrees
 *   <li>
 *   <li>241.23917 degrees -> -61.23917 degrees
 *   <li>
 *   <li>-517.9103 degrees -> -22.0897 degrees
 *   <li>
 * </ul>
 *
 * <p>This translation is similar to how latitude on earth works. You can visualize these
 * translations as if you were moving your finger on a globe. If you start at the equator and move
 * north your latitude increases until you reach the pole, where it then begins to decrease. As you
 * continue moving your finger down you reach zero at the equator and moving still farther south the
 * latitude continues to decrease until you reach the south pole where the latitude is of course -90
 * degrees.
 *
 * @author Matt Welsh (mitya.welsh@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class Declination extends Coordinate {

  public Declination(double decimalDegrees) {
    super(decimalDegrees);
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
  }

  // ------------------------------------------------------------------------------------------------
  // Private and protected methods
  // ------------------------------------------------------------------------------------------------

  /**
   * Ensure the angle is between -90 to 90 degrees. Below are some examples of the result of calling
   * this method:
   *
   * <p>
   * <ul>
   * <li>45 degrees -> 45 degrees<li>
   * <li>90 degrees -> 90 degrees<li>
   * <li>135 degrees -> 45 degrees<li>
   * <li>225 degrees -> -45 degrees<li>
   * <li>241.23917 degrees -> -61.23917 degrees<li>
   * <li>-517.9103 degrees -> -22.0897 degrees<li>
   * </ul>
   * </p>
   *
   * <p>
   * This translation is similar to how latitude on earth works. You can visualize these
   * translations as if you were moving your finger on a globe. If you start at the equator and
   * move north your latitude increases until you reach the pole, where it then begins to decrease.
   * As you continue moving your finger down you reach zero at the equator and moving still farther
   * south the latitude continues to decrease until you reach the south pole where the latitude is
   * of course -90 degrees.
   * </p>
   */
  protected void reduceToRange() {
    while (decimalDegrees > 360.0) {
      decimalDegrees -= 360.0;
    }

    while (decimalDegrees < 0.0) {
      decimalDegrees += 360.0;
    }

    int signum = 1;
    if (decimalDegrees > 180.0) {
      signum = -1;
      decimalDegrees -= 180.0;
    }

    if (decimalDegrees > 90.0) {
      decimalDegrees = 180 - decimalDegrees;
    }
    decimalDegrees *= signum;
  }
}
