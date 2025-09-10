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

package com.mattwelsh.astronomy.object.VSOP87a.venus;

import com.mattwelsh.astronomy.object.VSOP87a.RectangularDataReader;

/**
 * This subclass of RectangularDataReader is used to read the VSOP data files for Venus and compute
 * the series for the X, Y, and Z coordinates (in AU).
 *
 * @author Matt Welsh (mitya.welsh@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class VenusRectangularDataReader extends RectangularDataReader {

  public VenusRectangularDataReader(double t) {
    super(t);
  }

  /**
   * Return the X component of the coordinate triple.
   *
   * @return The X component of the coordinate triple.
   */
  @Override
  public double getX() {
    return xCoord;
  }

  /**
   * Return the Y component of the coordinate triple.
   *
   * @return The Y component of the coordinate triple.
   */
  @Override
  public double getY() {
    return yCoord;
  }

  /**
   * Return the Z component of the coordinate triple.
   *
   * @return The Z component of the coordinate triple.
   */
  @Override
  public double getZ() {
    return zCoord;
  }

  // -----------------------------------------------------------------------------------------------
  // Protected, package local, & and private methods
  // -----------------------------------------------------------------------------------------------

  protected double computeX() {
    double x0 = computeSeries(getClass().getResourceAsStream("x0.data"));
    double x1 = computeSeries(getClass().getResourceAsStream("x1.data"));
    double x2 = computeSeries(getClass().getResourceAsStream("x2.data"));
    double x3 = computeSeries(getClass().getResourceAsStream("x3.data"));
    double x4 = computeSeries(getClass().getResourceAsStream("x4.data"));
    double x5 = computeSeries(getClass().getResourceAsStream("x5.data"));
    return x0 + (x1 * t) + (x2 * t2) + (x3 * t3) + (x4 * t4) + (x5 * t5);
  }

  protected double computeY() {
    double y0 = computeSeries(getClass().getResourceAsStream("y0.data"));
    double y1 = computeSeries(getClass().getResourceAsStream("y1.data"));
    double y2 = computeSeries(getClass().getResourceAsStream("y2.data"));
    double y3 = computeSeries(getClass().getResourceAsStream("y3.data"));
    double y4 = computeSeries(getClass().getResourceAsStream("y4.data"));
    double y5 = computeSeries(getClass().getResourceAsStream("y5.data"));
    return y0 + (y1 * t) + (y2 * t2) + (y3 * t3) + (y4 * t4) + (y5 * t5);
  }

  protected double computeZ() {
    double z0 = computeSeries(getClass().getResourceAsStream("z0.data"));
    double z1 = computeSeries(getClass().getResourceAsStream("z1.data"));
    double z2 = computeSeries(getClass().getResourceAsStream("z2.data"));
    double z3 = computeSeries(getClass().getResourceAsStream("z3.data"));
    double z4 = computeSeries(getClass().getResourceAsStream("z4.data"));
    double z5 = computeSeries(getClass().getResourceAsStream("z5.data"));
    return z0 + (z1 * t) + (z2 * t2) + (z3 * t3) + (z4 * t4) + (z5 * t5);
  }
}
