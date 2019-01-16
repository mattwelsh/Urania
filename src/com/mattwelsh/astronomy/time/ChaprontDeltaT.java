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


  private int dataTable1Offset = 1600;
  private double[] dataTable1 = {
      80.0, 78.0, 75.0, 73.0, 70.0, 68.0, 65.0, 52.0, 43.0, 36.0, 30.0, 26.0, 20.0,
      16.0, 10.0, 6.0, 1.0, -2.0, -3.0, -4.0, -3.0, -3.0, -2.0, -1.0, 0.0, 1.0, 1.0, 3.0, 3.0, 5.0, 5.0, 6.0, 8.0,
      9.0, 9.0, 11.0, 11.0
  };

  private int dataTable2Offset = 1781;
  private double[] dataTable2 = {
      11.0, 11.0, 11.0, 11.0, 12.0, 12.0, 12.0, 12.0, 12.0, 12.0, 12.0, 11.0, 11.0, 11.0, 11.0,
      10.0, 10.0, 10.0, 9.0, 9.0, 9.0, 9.0, 8.0, 8.0, 8.0, 8.0, 8.0, 8.0, 8.0, 8.0, 9.0, 9.0, 9.0,
      9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 8.0, 8.0, 8.0, 7.0, 7.0, 6.0, 6.0, 6.0, 5.0, 5.0, 4.0, 4.0,
      3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 4.0, 4.0, 4.0, 4.0, 4.0, 5.0, 5.0, 5.0, 5.0,
      5.0, 5.0, 6.0, 6.0, 6.0, 6.0, 6.0, 6.0, 6.0, 6.0, 6.0, 5.0, 5.0, 4.0, 4.0, 3.0, 1.0, 0.0, 0.0,
      -1.0, -2.0, -3.0, -4.0, -4.0, -5.0, -6.0, -6.0, -6.0, -6.0, -6.0, -6.0, -6.0, -6.0, -7.0,
      -7.0, -7.0, -7.0, -6.0, -7.0, -7.0, -7.0, -7.0, -7.0, -7.0, -7.0, -6.0, -5.0, -4.0, -3.0,
      -2.0, -1.0, 1.0, 2.0, 3.0, 5.0, 6.0, 7.0, 9.0, 10.0, 11.0, 13.0, 14.0, 16.0, 17.0, 18.0, 19.0,
      20.0, 21.0, 21.0, 22.0, 22.0, 23.0, 23.0, 23.0, 24.0, 24.0, 24.0, 24.0, 24.0, 24.0, 24.0,
      24.0, 24.0, 24.0, 24.0, 24.0, 24.0, 24.0, 24.0, 25.0, 25.0, 26.0, 26.0, 27.0, 27.0, 28.0,
      28.0, 29.0, 29.0, 30.0, 30.0, 30.0, 31.0, 31.0, 31.0, 32.0, 32.0, 33.0, 33.0, 34.0, 34.0,
      34.0, 35.0, 36.0, 37.0, 37.0, 38.0, 39.0, 40.0, 41.0, 42.0, 43.0, 44.0, 45.0, 46.0, 48.0,
      49.0, 50.0, 51.0, 51.0, 52.0, 53.0, 54.0, 54.0, 55.0, 55.0, 56.0, 56.0, 57.0
  };

  /**
   * Return an approximation of the delta in seconds between Dynamical Time(TD) and Universal
   * Time(UT) using the method described by Chapront-Touze & Chapront (1991) in Lunar Tables and
   * Programs From 4000B.C. to A.D. 8000.
   *
   *
   * @param julianDate The date to calculate delta T for.
   * @return Return an approximation of the delta in seconds between Dynamical Time (TD) and
   *     Universal Time (UT)
   */
  public double getDeltaT(JulianDate julianDate) {

    if( (julianDate.getYear()  < 1781) && (julianDate.getYear()  > 1599) ) {
      return methodOne(julianDate);
    }
    else if ( (julianDate.getYear() < 1991)  && (julianDate.getYear()  > 1780) ) {
      return methodTwo(julianDate);
    }
    else {
      return (DynamicalTime.DEFAULT.getCalculator().getDeltaT(julianDate));
    }
  }

  private double methodOne(JulianDate julianDate) {
    return dataTable1[(julianDate.getYear() - dataTable1Offset) / 5];
  }

  private double methodTwo(JulianDate julianDate) {
   return dataTable2[julianDate.getYear() - dataTable2Offset];
  }
}

