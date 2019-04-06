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

import com.mattwelsh.astronomy.object.VSOP87b.earth.EarthLbrDataReader;
import com.mattwelsh.astronomy.time.JulianDate;

/**
 * This class computes the heliocentric longitude, latitude, and radius vector for the planet Earth
 * with respect to equinox J2000 using VSOP87 Series Version B. This series should have an accuracy
 * of ±1 arc sec over the span 2000 BC to 6000 AD.
 *
 * <p>In these series t = (JD - 2451545.0) / 365250.0
 *
 * <p>Ref: Planetary Theories in Rectangular and Spherical Variables VSOP87 Solutions Pierre
 * Bretagnon, Gerard Francou Journal of Astronomy & Astrophysics vol. 202, p309-p315 1988
 *
 * @author Matt Welsh (mitya.welsh@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class EarthComputer extends PlanetaryComputer {

  /**
   * Initializes a computer using the passed JulianDate.
   *
   * @param jd The JulianDate to use to initialize this object.
   */
  public EarthComputer(JulianDate jd) {
    super(jd);
  }

  /**
   * Intitalizes the data reader for this class.
   */
  @Override
  protected void initializeDataReader() {
    this.dataReader = new EarthLbrDataReader(this.t);
  }
}
