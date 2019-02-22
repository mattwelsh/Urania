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

  // -----------------------------------------------------------------------------------------------
  // Protected, package local, & and private methods
  // -----------------------------------------------------------------------------------------------

  private Utilities(){}
}
