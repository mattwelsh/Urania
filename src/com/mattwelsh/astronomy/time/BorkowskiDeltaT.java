/*
 * Copyright (C) 2019 by Matt Welsh
 * This library is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details. You should have received a copy of the GNU
 * Lesser General Public License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
 */
package com.mattwelsh.astronomy.time;
import com.mattwelsh.util.JulianDate;

/**
 * An implementation of DeltaTCalculator that calculates an approximation of the delta in seconds
 * between Dynamical Time(TD) and Universal Time(UT) for the time period 2000 B.C. - A.D. 1700
 * using the method described by Borkowski.
 *
 * deltaT(seconds) = 35.0 (t + 3.75)^2 +40,
 *
 * where t is time in JulianCenturies elapsed from epoch 2000.0 JC = (JD - 2451545.0) / 36525
 *
 * See (http://articles.adsabs.harvard.edu/cgi-bin/nph-iarticle_query?letter=L&classic=YES&bibcode=1988A%26A...205L...8B&page=&type=SCREEN_VIEW&data_type=PDF_HIGH&send=GET&filetype=.pdf).
 */
public class BorkowskiDeltaT implements DeltaTCalculator {

  /**
   * Return an approximation of the delta in seconds between Dynamical Time(TD) and Universal
   * Time(UT) using the method described by Borkowski (1988).
   *
   *
   * @param julianDate @return Return an approximation of the delta in seconds between Dynamical Time (TD) and
   *     Universal Time * (UT)
   */
  @Override
  public double getDeltaT(JulianDate julianDate) {
    double t = julianDate.getJulianCenturies(DeltaTCalculator.EPOCH2000);
    if ((julianDate.getYear() >= -2000) && (julianDate.getYear()) < 1700) {
      double result = (t + 3.75) * (t + 3.75);
      return (35 * result + 40);
    }
    else {
      return (DynamicalTime.DEFAULT.getCalculator().getDeltaT(julianDate));
    }
  }
}
