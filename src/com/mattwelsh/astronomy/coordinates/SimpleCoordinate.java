/*
 *  Copyright (C) 2019-2025 by Matt Welsh
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

package com.mattwelsh.astronomy.coordinates;

import com.mattwelsh.astronomy.utilities.Utilities;

/**
 * This class implements a simple coordinate in degrees within the range 0-360 degrees.
 *
 * @author Matt Welsh (mitya.welsh@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class SimpleCoordinate extends Coordinate {

  /**
   * Create an instance of SimpleCoordinate. The passed value will be reduced to the range 0-360
   * degrees.
   *
   * @param decimalDegrees The value of the simple coordinate in degrees. If this value isn't in the
   * range 0-360, it will be reduced to be.
   */
  public SimpleCoordinate(double decimalDegrees) {
    super(decimalDegrees);
  }

  /**
   * Ensures that coordinate expressed is within the range 0-360 degrees.
   */
  @Override
  protected void reduceToRange() {
    decimalDegrees = Utilities.reduceToRange360(decimalDegrees);
  }

}
