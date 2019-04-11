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

import com.mattwelsh.astronomy.object.VSOP87a.jupiter.JupiterRectangularDataReader;
import com.mattwelsh.astronomy.time.JulianDate;

/**
 * This class computes the rectangular (X, Y, Z) coordinates in AU for the planet Jupiter
 * with respect to equinox J2000 using VSOP87a Series Version A. This series should have an accuracy
 * of ±1 arc sec over the span 2000 BC to 6000 AD. R is then calculated as R*R = X*X + Y*Y + Z*Z.
 *
 * <p>In these series t = (JD - 2451545.0) / 365250.0
 *
 * <p>Ref: Planetary Theories in Rectangular and Spherical Variables VSOP87a Solutions Pierre
 * Bretagnon, Gerard Francou Journal of Astronomy & Astrophysics vol. 202, p309-p315 1988
 *
 * @author Matt Welsh (mitya.welsh@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class JupiterComputer {

  private JupiterRectangularDataReader rectDataReader;
  private JulianDate julianDate;
  private double rectX;
  private double rectY;
  private double rectZ;
  private double t;

  /**
   * Initializes a computer using the passed JulianDate.
   *
   * @param jd The JulianDate to use to initialize this object.
   */
  public JupiterComputer(JulianDate jd) {
    setJulianDate(jd);
  }

  /**
   * Sets the julian date that the computer uses for calculations. Calling this method will trigger
   * a recalculation of all of it's fields.
   *
   * @param jd The julian date that the computer uses for calculations.
   */
  public void setJulianDate(JulianDate jd) {
    this.julianDate = jd;
    updateFields();
  }

  /**
   * Returns the value of the X coordinate of Jupiter's position in AU.
   *
   * @return The value of the X coordinate of Jupiter's position in AU.
   */
  public double getRectX() {
    return this.rectX;
  }

  /**
   * Returns the value of the Y coordinate of Jupiter's position in AU.
   *
   * @return The value of the Y coordinate of Jupiter's position in AU.
   */
  public double getRectY() {
    return this.rectY;
  }

  /**
   * Returns the value of the Z coordinate of Jupiter's position in AU.
   *
   * @return The value of the Z coordinate of Jupiter's position in AU.
   */
  public double getRectZ() {
    return this.rectZ;
  }

  // -----------------------------------------------------------------------------------------------
  // Protected, package local, & and private methods
  // -----------------------------------------------------------------------------------------------

  private void updateFields() {
    this.t = computeT(julianDate.getJulianDayNumber());
    rectDataReader = new JupiterRectangularDataReader(t);
    this.rectX = rectDataReader.getX();
    this.rectY = rectDataReader.getY();
    this.rectZ = rectDataReader.getZ();
  }

  private double computeT(double jDN) {
    return (jDN - 2451545.0) / 365250.0;
  }

}
