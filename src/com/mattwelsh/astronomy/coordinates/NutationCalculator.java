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

/**
 * This interface defines the API that NutationCalculators must implement. There can be many
 * implementations, and this design is to make the system flexible when new methods are defined.
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
public interface NutationCalculator {

  /**
   * Returns the nutation in longitude and obliquity for a particular julian date.
   *
   * @return The nutation in longitude for a particular passed julian date.
   */
  Nutation getNutation();

}
