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

package com.mattwelsh.astronomy.object.VSOP87b.earth;

import com.mattwelsh.astronomy.object.VSOP87b.LbrDataReader;

/**
 * This subclass of LbrDataReader is used to read the VSOP data files for Earth and compute
 * the heliocentric longitude, latitude, and radius vector.
 *
 * @author Matt Welsh (mitya.welsh@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class EarthLbrDataReader extends LbrDataReader {

  public EarthLbrDataReader(double t) {
    super(t);
  }

  // -----------------------------------------------------------------------------------------------
  // Protected, package local, & and private methods
  // -----------------------------------------------------------------------------------------------

  /**
   * Compute the heliocentric longitude.
   *
   * @return The heliocentric longitude.
   */
  @Override
  protected double computeHeliocentricLongitude() {
    double x0 = computeSeries(getClass().getResourceAsStream("longitude0.data"));
    double x1 = computeSeries(getClass().getResourceAsStream("longitude1.data"));
    double x2 = computeSeries(getClass().getResourceAsStream("longitude2.data"));
    double x3 = computeSeries(getClass().getResourceAsStream("longitude3.data"));
    double x4 = computeSeries(getClass().getResourceAsStream("longitude4.data"));
    double x5 = computeSeries(getClass().getResourceAsStream("longitude5.data"));
    return x0 + (x1 * t) + (x2 * t2) + (x3 * t3) + (x4 * t4) + (x5 * t5);
  }

  /**
   * Compute the heliocentric latitude.
   *
   * @return The heliocentric latitude.
   */
  @Override
  protected double computeHeliocentricLatitude() {
    double y0 = computeSeries(getClass().getResourceAsStream("latitude0.data"));
    double y1 = computeSeries(getClass().getResourceAsStream("latitude1.data"));
    double y2 = computeSeries(getClass().getResourceAsStream("latitude2.data"));
    double y3 = computeSeries(getClass().getResourceAsStream("latitude3.data"));
    double y4 = computeSeries(getClass().getResourceAsStream("latitude4.data"));
    double y5 = computeSeries(getClass().getResourceAsStream("latitude5.data"));
    return y0 + (y1 * t) + (y2 * t2) + (y3 * t3) + (y4 * t4) + (y5 * t5);
  }

  /**
   * Compute the heliocentric radius vector.
   *
   * @return The heliocentric radius vector.
   */
  @Override
  protected double computeRadiusVector() {
    double z0 = computeSeries(getClass().getResourceAsStream("radius0.data"));
    double z1 = computeSeries(getClass().getResourceAsStream("radius1.data"));
    double z2 = computeSeries(getClass().getResourceAsStream("radius2.data"));
    double z3 = computeSeries(getClass().getResourceAsStream("radius3.data"));
    double z4 = computeSeries(getClass().getResourceAsStream("radius4.data"));
    double z5 = computeSeries(getClass().getResourceAsStream("radius5.data"));
    return z0 + (z1 * t) + (z2 * t2) + (z3 * t3) + (z4 * t4) + (z5 * t5);
  }
}
