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
 * between Dynamical Time(TD) and Universal Time(UT) using the method described by Chapront-Touze &
 * Chapront (1991) in Lunar Tables and Programs From 4000B.C. to A.D. 8000.
 */
class ChaprontDeltaT implements DeltaTCalculator {

  /**
   * Return an approximation of the delta in seconds between Dynamical Time(TD) and Universal
   * Time(UT) using the method described by Chapront-Touze & Chapront (1991) in Lunar Tables and
   * Programs From 4000B.C. to A.D. 8000. Currently a placeholder.
   *
   *
   * @param julianDate The date to calculate delta T for.
   * @return Return an approximation of the delta in seconds between Dynamical Time (TD) and
   *     Universal Time * (UT)
   */
  public double getDeltaT(JulianDate julianDate) {
    return 0;
  }
}
