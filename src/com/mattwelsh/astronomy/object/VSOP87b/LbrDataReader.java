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

package com.mattwelsh.astronomy.object.VSOP87b;

import com.mattwelsh.astronomy.object.VSOPDataReader;

/**
 * This class is used to read the VSOP data files and are subclassed for the planets Mercury to
 * Uranus. It also contains a method to compute the series sum for the data, common to all of the
 * planets and subclasses compute the heliocentric longitude, latitude, and radius vector.
 *
 * @author Matt Welsh (mitya.welsh@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public abstract class LbrDataReader extends VSOPDataReader {

  protected double heliocentricLongitude;
  protected double heliocentricLatitude;
  protected double radiusVector;

  /**
   * Create an instance of a data reader using the specified julian date to compute the series sum.
   *
   * @param t The specified julian date to compute the series sum.
   */
  public LbrDataReader(double t) {
    super(t);
    this.heliocentricLongitude = computeHeliocentricLongitude();
    this.heliocentricLatitude = computeHeliocentricLatitude();
    this.radiusVector = computeRadiusVector();
  }

  /**
   * Return the heliocentric longitude.
   *
   * @return The heliocentric longitude.
   */
  public double getHeliocentricLongitude() {
    return heliocentricLongitude;
  }

  /**
   * Return the heliocentric latitude.
   *
   * @return The heliocentric latitude.
   */
  public double getHeliocentricLatitude() {
    return heliocentricLatitude;
  }

  /**
   * Return the heliocentric radius vector.
   *
   * @return The heliocentric radius vector.
   */
  public double getRadiusVector() {
    return radiusVector;
  }

  /**
   * Compute the heliocentric longitude.
   *
   * @return The heliocentric longitude.
   */
  protected abstract double computeHeliocentricLongitude();

  /**
   * Compute the heliocentric latitude.
   *
   * @return The heliocentric latitude.
   */
  protected abstract double computeHeliocentricLatitude();

  /**
   * Compute the heliocentric radius vector.
   *
   * @return The heliocentric radius vector.
   */
  protected abstract double computeRadiusVector();

}
