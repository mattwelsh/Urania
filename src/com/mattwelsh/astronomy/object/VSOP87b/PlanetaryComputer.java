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

package com.mattwelsh.astronomy.object.VSOP87b;

import com.mattwelsh.astronomy.time.JulianDate;
import com.mattwelsh.astronomy.utilities.Utilities;

public abstract class PlanetaryComputer {

  /**
   * Initializes a computer using the passed JulianDate.
   *
   * @param jd The JulianDate to use to initialize this object.
   */
  public PlanetaryComputer(JulianDate jd) {
    setJulianDate(jd);
  }

  protected LbrDataReader dataReader;
  protected JulianDate julianDate;
  protected double t;
  protected double heliocentricLongitude;
  protected double heliocentricLatitude;
  protected double radiusVector;

  /**
   * Sets the julian date that the computer uses for calculations. Calling this method will trigger
   * a recalculation of all of it's fields.
   *
   * @param jd The julian date that the computer uses for calculations.
   */
  public void setJulianDate(JulianDate jd) {
    this.julianDate = jd;
    this.t = computeT(julianDate.getJulianDayNumber());
    initializeDataReader();
    updateFields();
  }

  /**
   * Returns the heliocentric longitude.
   *
   * @return The heliocentric longitude.
   */
  public double getHeliocentricLongitude() {
    return this.heliocentricLongitude;
  }

  /**
   * Returns the heliocentric latitude.
   *
   * @return The heliocentric latitude.
   */
  public double getHeliocentricLatitude() {
    return this.heliocentricLatitude;
  }

  /**
   * Returns the radius vector (AU).
   *
   * @return The radius vector.
   */
  public double getRadiusVector() {
    return this.radiusVector;
  }

  protected double computeT(double jDN) {
    return (jDN - 2451545.0) / 365250.0;
  }

  protected abstract void initializeDataReader();

  // -----------------------------------------------------------------------------------------------
  // Protected, package local, & and private methods
  // -----------------------------------------------------------------------------------------------

  protected void updateFields() {
    this.t = computeT(julianDate.getJulianDayNumber());
    this.heliocentricLongitude = Utilities.reduceTo2pi(dataReader.getHeliocentricLongitude());
    this.heliocentricLatitude = Utilities.reduceToRangePIOver2(dataReader.getHeliocentricLatitude());
    this.radiusVector = dataReader.getRadiusVector();
  }

}
