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
 * between Dynamical Time(TD) and Universal Time(UT) for the time period A.D. 1950 - A.D. 2100 using
 * the method described by Espenak (1987, 1989).
 *
 * <p>deltaT(seconds) = 67.0 + 61.0t + 64.3t^2,
 *
 * <p>where t is time in JulianCenturies elapsed from epoch 2000.0 JC = (JD - 2451545.0) / 36525
 */
public class EspenakDeltaT implements DeltaTCalculator {

  /**
   * Return an approximation of the delta in seconds between Dynamical Time(TD) and Universal
   * Time(UT) using the method described by Espenak (1987, 1989).
   *
   * @param julianDate @return Return an approximation of the delta in seconds between Dynamical
   *     Time (TD) and Universal Time * (UT)
   */
  @Override
  public double getDeltaT(JulianDate julianDate) {
    double t = julianDate.getJulianCenturies(DeltaTCalculator.EPOCH2000);
    if ((julianDate.getYear() >= 1950) && (julianDate.getYear()) < 2100) {
      return 67.0 + (61.0 * t) + (64.3 * t * t);
    }
    else {
      return (DynamicalTime.DEFAULT.getCalculator().getDeltaT(julianDate));
    }
  }
}