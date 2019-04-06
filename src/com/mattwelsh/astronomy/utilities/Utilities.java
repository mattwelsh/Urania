/*
 *  Copyright (C) 2019 by Matt Welsh
 *  This library is free software; you can redistribute it and/or modify it under the terms of the
 *  GNU Lesser General Public License as published by the Free Software Foundation; either version
 *  2.1 of the License, or any later version.
 *
 *  This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *  See the GNU General Public License for more details. You should have received a copy of the GNU
 *  Lesser General Public License along with this library; if not, write to the Free Software
 *  Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
 */

package com.mattwelsh.astronomy.utilities;

import com.mattwelsh.astronomy.time.DeltaTCalculator;
import com.mattwelsh.astronomy.time.JulianDate;

/**
 * This class implements utility methods that are used in the library.
 * 
 * <p>NutationCalculatorFactory is a periodic oscillation of the rotational axis of the earth. It's split into two
 * components, one parallel to the ecliptic called the nutation in longitude, and one perpendicular
 * to the ecliptic, called the nutation in obliquity.</p>
 *
 * <p>The quantities are needed to calculate the apparent position of an astronomical object, and
 * for the apparent sidereal time.</p>
 *
 * @author Matt Welsh (mitya.welsh@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class Utilities {

  /**
   * Reduces a passed angle in degrees to the range 0-360.
   * @param number The number to reduce.
   * @return A number in the range 0-360.
   */
  public static double reduceToRange360(double number) {
    if (number > 360.0) {
      number = number - 360.0 * ((long) (number / 360.0));
    }

    if (number < 0.0) {
      number = number + 360.0 * ((long) Math.abs(number / 360.0) + 1);
    }
    return number;
  }

  /**
   * Reduces a passed angle in degrees to the range 0-360.
   * @param hourAngle The number to reduce.
   * @return A number in the range 0-360.
   */
  public static double reduceToRange24(double hourAngle) {
    if (hourAngle > 24.0) {
      hourAngle = hourAngle - 24.0 * ((long) (hourAngle / 24.0));
    }

    if (hourAngle < 0.0) {
      hourAngle = hourAngle + 24.0 * ((long) Math.abs(hourAngle / 24.0) + 1);
    }
    return hourAngle;
  }


  /**
   * Ensure the angle is between -90 to 90 degrees. Below are some examples of the result of calling
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
   * north your latitude increases until you reach the pole, where it then begins to decrease. As
   * you continue moving your finger down you reach zero at the equator and moving still farther
   * south the latitude continues to decrease until you reach the south pole where the latitude is
   * of course -90 degrees.
   */
  public static double reduceToRange90(double decDegrees) {
    double decimalDegrees = Utilities.reduceToRange360(decDegrees);

    int signum = 1;
    if (decimalDegrees > 180.0) {
      signum = -1;
      decimalDegrees -= 180.0;
    }

    if (decimalDegrees > 90.0) {
      decimalDegrees = 180 - decimalDegrees;
    }
    decimalDegrees *= signum;
    return decimalDegrees;
  }

  // -----------------------------------------------------------------------------------------------
  // Protected, package local, & and private methods
  // -----------------------------------------------------------------------------------------------

  private Utilities(){}
}
