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

package com.mattwelsh.astronomy.object.VSOP87a;

import com.mattwelsh.astronomy.object.VSOPDataReader;
import java.io.InputStream;
import java.util.Scanner;

/**
 * This class is used to read the VSOP data files and are subclassed for the planets Mercury to
 * Uranus. It also contains a method to compute the series sum for the data, common to all of the
 * planets.
 *
 * @author Matt Welsh (mitya.welsh@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public abstract class RectangularDataReader extends VSOPDataReader {

  protected double xCoord;
  protected double yCoord;
  protected double zCoord;

  /**
   * Create an instance of a data reader using the specified julian date to compute the series sum.
   *
   * @param t The specified julian date to compute the series sum.
   */
  public RectangularDataReader(double t) {
    super(t);
    xCoord = computeX();
    yCoord = computeY();
    zCoord = computeZ();
  }

  /**
   * Return the X component of the coordinate triple.
   *
   * @return The X component of the coordinate triple.
   */
  public double getX() {
    return xCoord;
  }

  /**
   * Return the Y component of the coordinate triple.
   *
   * @return The Y component of the coordinate triple.
   */
  public double getY() {
    return yCoord;
  }

  /**
   * Return the Z component of the coordinate triple.
   *
   * @return The Z component of the coordinate triple.
   */
  public double getZ() {
    return zCoord;
  }

  /**
   * Compute the X component of the coordinate triple.
   *
   * @return The X component of the coordinate triple.
   */
  protected abstract double computeX();

  /**
   * Compute the Y component of the coordinate triple.
   *
   * @return The Y component of the coordinate triple.
   */
  protected abstract double computeY();

  /**
   * Compute the Z component of the coordinate triple.
   *
   * @return The Z component of the coordinate triple.
   */
  protected abstract double computeZ();


}
