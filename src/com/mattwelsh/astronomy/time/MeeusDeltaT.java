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

import java.util.Calendar;
import com.mattwelsh.util.JulianDate;

/**
 * An implementation of DeltaTCalculator that calculates an approximation of the delta in seconds
 * between Dynamical Time(TD) and Universal Time(UT) using the method described by J. Meeus (1998).
 */
class MeeusDeltaT implements DeltaTCalculator {

  private int dataTableOffset = 1620;
  private double[] methodThreeData = {
        121.00, 116.50, 112.00, 107.50, 103.00, 99.00, 95.00, 91.50, 88.00, 85.00, 82.00, 79.50,
        77.00, 74.50, 72.00, 70.00, 68.00, 65.50, 63.00, 61.50, 60.00, 58.00, 56.00, 54.50, 53.00,
        52.00, 51.00, 49.50, 48.00, 47.00, 46.00, 45.00, 44.00, 43.00, 42.00, 41.00, 40.00, 39.00,
        38.00, 36.50, 35.00, 34.00, 33.00, 32.00, 31.00, 30.00, 29.00, 27.50, 26.00, 25.00, 24.00,
        23.00, 22.00, 21.00, 20.00, 19.00, 18.00, 17.00, 16.00, 15.00, 14.00, 13.00, 12.00, 11.50,
        11.00, 10.50, 10.00, 9.50, 9.00, 8.50, 8.00, 7.50, 7.00, 7.00, 7.00, 7.00, 7.00, 7.00, 7.00,
        7.00, 7.00, 7.00, 7.00, 7.50, 8.00, 8.00, 8.00, 8.50, 9.00, 9.00, 9.00, 9.00, 9.00, 9.00,
        9.00, 9.00, 9.00, 9.50, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00,
        10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.50, 11.00, 11.00, 11.00, 11.00, 11.00, 11.00,
        11.00, 11.50, 12.00, 12.00, 12.00, 12.00, 12.00, 12.00, 12.00, 12.00, 12.00, 12.50, 13.00,
        13.00, 13.00, 13.00, 13.00, 13.50, 14.00, 14.00, 14.00, 14.00, 14.00, 14.00, 14.00, 14.50,
        15.00, 15.00, 15.00, 15.00, 15.00, 15.00, 15.00, 15.00, 15.00, 15.50, 16.00, 16.00, 16.00,
        16.00, 16.00, 16.00, 16.00, 16.00, 16.00, 16.00, 16.00, 16.00, 16.00, 16.00, 16.00, 15.50,
        15.00, 15.00, 15.00, 14.50, 14.00, 13.50, 13.00, 13.05, 13.10, 12.80, 12.50, 12.35, 12.20,
        12.10, 12.00, 12.00, 12.00, 12.00, 12.00, 12.00, 12.00, 12.00, 12.00, 12.00, 12.00, 11.95,
        11.90, 11.75, 11.60, 11.30, 11.00, 10.60, 10.20, 9.70, 9.20, 8.70, 8.20, 7.65, 7.10, 6.65,
        6.20, 5.90, 5.60, 5.50, 5.40, 5.35, 5.30, 5.35, 5.40, 5.50, 5.60, 5.75, 5.90, 6.05, 6.20,
        6.35, 6.50, 6.65, 6.80, 6.95, 7.10, 7.20, 7.30, 7.40, 7.50, 7.55, 7.60, 7.65, 7.70, 7.50,
        7.30, 6.75, 6.20, 5.70, 5.20, 3.95, 2.70, 2.05, 1.40, 0.10, -1.20, -2.00, -2.80, -3.30,
        -3.80, -4.30, -4.80, -5.15, -5.50, -5.40, -5.30, -5.45, -5.60, -5.65, -5.70, -5.80, -5.90,
        -5.95, -6.00, -6.15, -6.30, -6.40, -6.50, -6.35, -6.20, -5.45, -4.70, -3.75, -2.80, -1.45,
        -0.10, 1.25, 2.60, 3.95, 5.30, 6.50, 7.70, 9.05, 10.40, 11.85, 13.30, 14.65, 16.00, 17.10,
        18.20, 19.20, 20.20, 20.65, 21.10, 21.75, 22.40, 22.95, 23.50, 23.65, 23.80, 24.05, 24.30,
        24.15, 24.00, 23.95, 23.90, 23.90, 23.90, 23.80, 23.70, 23.85, 24.00, 24.15, 24.30, 24.80,
        25.30, 25.75, 26.20, 26.75, 27.30, 27.75, 28.20, 28.65, 29.10, 29.55, 30.00, 30.35, 30.70,
        31.05, 31.40, 31.80, 32.20, 32.65, 33.10, 33.55, 34.00, 34.50, 35.00, 35.75, 36.50, 37.40,
        38.30, 39.25, 40.20, 41.20, 42.20, 43.35, 44.50, 45.50, 46.50, 47.50, 48.50, 49.50, 50.50,
        51.35, 52.20, 53.00, 53.80, 54.35, 54.90, 55.35, 55.80, 56.35, 56.90, 57.60, 58.30, 59.15,
        60.00, 60.80, 61.60, 62.30, 63.00, 63.40, 63.80, 64.05, 64.30, 64.45, 64.60, 64.70, 64.80,
        65.15, 65.50, 65.80, 66.10
      };

  /**
   * Return an approximation of the delta in seconds between Dynamical Time(TD) and Universal
   * Time(UT) using the method described by J. Meeus (1998):
   *
   * <p>For years before A.D. 948 (method 1): deltaT = 2177 + 497*t + 44.1*t*t</p>
   *
   * <p>From A.D. 948 - A.D. 1600 (method 2): deltaT = 102 + 102*t + 25.3*t*t</p>
   *
   * <p>For years from A.D. 1620 - A.D. 2000 (method 3): Tabular lookup</p>
   *
   * <p>From A.D. 2000 - A.D. 2100 (method 4): deltaT = 102 + 102*t + 25.3*t*t + 0.37 * (year -
   * 2100)</p>
   *
   * <p>For years after A.D. 2010 (method 2): deltaT = 102 + 102*t + 25.3*t*t</p>
   *
   * <p>For dates after A.D. 2000 this delta calculator starts getting rapidly inaccurate. </p>
   *
   * @param julianDate The date to calculate delta T for.
   * @return Return an approximation of the delta in seconds between Dynamical Time (TD) and
   *     Universal Time * (UT)
   */
  public double getDeltaT(JulianDate julianDate) {

    System.out.print("Year: " + julianDate.getGregorianCalendar().get(Calendar.YEAR));

    if (julianDate.getGregorianCalendar().get(Calendar.YEAR) < 948) {
      return methodOne(julianDate);
    } else if ((julianDate.getGregorianCalendar().get(Calendar.YEAR) >= 948)
        && (julianDate.getGregorianCalendar().get(Calendar.YEAR) < 1620)) {
      return methodTwo(julianDate);
    } else if ((julianDate.getGregorianCalendar().get(Calendar.YEAR) >= 1620)
        && (julianDate.getGregorianCalendar().get(Calendar.YEAR) < 2000)) {
      return methodThree(julianDate);
    } else if ((julianDate.getGregorianCalendar().get(Calendar.YEAR) >= 2000)
        && (julianDate.getGregorianCalendar().get(Calendar.YEAR) < 2100)) {
      return methodFour(julianDate);
    } else {
      return methodTwo(julianDate);
    }
  }

  // -----------------------------------------------------------------------------------------------
  // Protected and private methods
  // -----------------------------------------------------------------------------------------------

  private double methodOne(JulianDate julianDate) {
    System.out.println(" Starting Meeus Method One");
    double t = julianDate.getJulianCenturies(DeltaTCalculator.EPOCH2000);
    System.out.println("Julian Centuries: " + t);
    return (2177.0 + 497.0 * t + 44.1 * t * t);
  }

  private double methodTwo(JulianDate julianDate) {
    System.out.println(" Starting Meeus Method Two");
    double t = julianDate.getJulianCenturies(DeltaTCalculator.EPOCH2000);
    System.out.println("Julian Centuries: " + t);
    return (102.0 + 102.0 * t + 25.3 * t * t);
  }

  private double methodThree(JulianDate julianDate) {
    System.out.println(" Starting Meeus Method Three");
    return methodThreeData[julianDate.getGregorianCalendar().get(Calendar.YEAR) - dataTableOffset];
  }

  private double methodFour(JulianDate julianDate) {

    double t = julianDate.getJulianCenturies(DeltaTCalculator.EPOCH2000);

    return (102.0 + 102.0 * t + 25.3 * t * t + 0.37 *
        (julianDate.getGregorianCalendar().get(Calendar.YEAR) - 2100));
  }
}
