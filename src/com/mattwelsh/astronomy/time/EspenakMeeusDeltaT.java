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
 * between Dynamical Time(TD) and Universal Time(UT) using the method described by Espenak & Meeus
 * (2006) in the publications:
 * <ul>
 *   <li>F. Espenak & J. Meeus, Five Millennium Canon of Solar Eclipses: –1999 to +3000 (2000 BCE to
 *       3000 CE) (NASA, 2006).
 *   <li>F. Espenak & J. Meeus, Five Millennium Catalog of Solar * Eclipses: –1999 to +3000
 *       (2000 BCE to 3000 CE) (NASA, 2008 [revised 2009]).
 *   <li>F. Espenak & J. Meeus, Five Millennium Canon of Lunar Eclipses: –1999 to +3000 (2000 BCE to
 *       3000 CE) (NASA, 2009).
 *   <li>F. Espenak & J. Meeus, Five Millennium Catalog of Lunar Eclipses: –1999 to +3000 (2000 BCE
 * to 3000 CE) (NASA, 2009)
 * </ul>
 *
 * <p> This implementation is the default for this library, and well behaved DeltaTCalculators will
 * fall through to this implementation when dates fall outside the range of dates that they can
 * meaningfully compute delta T for.
 *
 * <p> See http://www.eclipsewise.com/help/deltatpoly2014.html for more information</p>
 * <p> See https://www.staff.science.uu.nl/~gent0113/deltat/deltat_old.htm for more information</p>
 */
class EspenakMeeusDeltaT implements DeltaTCalculator {

  /**
   * Return an approximation of the delta in seconds between Dynamical Time(TD) and Universal
   * Time(UT) using the method described by Espenak & Meeus * (2006).
   *
   * @param julianDate The date to calculate delta T for.
   * @return Return an approximation of the delta in seconds between Dynamical Time (TD) and
   * Universal Time (UT)
   */
  public double getDeltaT(JulianDate julianDate) {

    if(julianDate.getYear()  < -500){
      return period00(julianDate);
    }
    else if( (julianDate.getYear()  < 500) && (julianDate.getYear()  >= -500) ) {
      return period01(julianDate);
    }
    else if ( (julianDate.getYear()  < 1600) && (julianDate.getYear()  >= 500) ) {
      return period02(julianDate);
    }
    else if ( (julianDate.getYear() < 1700) && (julianDate.getYear() >= 1600) ) {
      return period03(julianDate);

    }
    else if ( (julianDate.getYear()  < 1800) && (julianDate.getYear()  >= 1700) ) {
      return period04(julianDate);

    }
    else if ( (julianDate.getYear()  < 1860)  && (julianDate.getYear()  >= 1800) ) {
      return period05(julianDate);

    }
    else if ( (julianDate.getYear()  < 1900)  && (julianDate.getYear()  >= 1860) ) {
      return period06(julianDate);

    }
    else if ( (julianDate.getYear()  < 1920)  && (julianDate.getYear()  >= 1900) ) {
      return period07(julianDate);

    }
    else if ( (julianDate.getYear()  < 1941)  && (julianDate.getYear()  >= 1920) ) {
      return period08(julianDate);

    }
    else if ( (julianDate.getYear()  < 1961)  && (julianDate.getYear()  >= 1941) ) {
      return period09(julianDate);

    }
    else if ( (julianDate.getYear()  < 1986)  && (julianDate.getYear()  >= 1961) ) {
      return period10(julianDate);

    }
    else if ( (julianDate.getYear()  < 2005)  && (julianDate.getYear()  >= 1986) ) {
      return period11(julianDate);
    }
    else if ( (julianDate.getYear()  < 2050)  && (julianDate.getYear()  >= 2005) ) {
      return period12(julianDate);
    }
    else if ( (julianDate.getYear()  < 2150)  && (julianDate.getYear()  >= 2050) ) {
      return period13(julianDate);
    }
    else {
      return period14(julianDate);
    }
  }

  /**
   * Used to calculate delta T before –500.
   *
   * @param julianDate The date to calculate delta T for.
   * @return delta T
   */
  private double period00(JulianDate julianDate) {
    double t = julianDate.getJulianCenturies(DeltaTCalculator.EPOCH1820);
    return -20 + (32 * t * t);

  }

  /**
   * Used to calculate delta T from –500 to 500.
   *
   * @param julianDate The date to calculate delta T for.
   * @return delta T
   */
  private double period01(JulianDate julianDate) {
    double t = (double)(julianDate.getYear()) / 100.0;
    return 10583.6 - (1014.41 * t) + (33.78311 * t * t) - (5.952053 * t * t * t) -
        (0.1798452 * t * t * t * t) + (0.022174192 * t * t * t * t * t) +
        (0.0090316521 * t * t * t * t * t * t);
  }

  /**
   * Used to calculate delta T from 500 to 1600.
   *
   * @param julianDate The date to calculate delta T for.
   * @return delta T
   */
  private double period02(JulianDate julianDate) {
    double t = julianDate.getJulianCenturies(DeltaTCalculator.EPOCH1000);
    return 1574.2 - (556.01 * t) + (71.23472 * t * t) + (0.319781 * t * t * t) -
        (0.8503463 * t * t * t * t) - (0.005050998 * t * t * t * t * t) +
        (0.0083572073 * t * t * t * t * t * t);
  }

  /**
   * Used to calculate delta T from 1600 to 1700.
   *
   * @param julianDate The date to calculate delta T for.
   * @return delta T
   */
  private double period03(JulianDate julianDate) {
    double t = julianDate.getJulianCenturies(DeltaTCalculator.EPOCH1600);
    return 120.0 - (98.08 * t) - (153.2 * t * t) + ((t * t * t)/0.007129);
  }

  /**
   * Used to calculate delta T from 1700 to 1800.
   *
   * @param julianDate The date to calculate delta T for.
   * @return delta T
   */
  private double period04(JulianDate julianDate) {
    double t = julianDate.getJulianCenturies(DeltaTCalculator.EPOCH1700);
    return 8.83 + (16.03 * t) - (59.285 * t * t) + (133.36 * t * t * t) -
        ((t * t * t * t) / 0.01174);
  }

  /**
   * Used to calculate delta T from 1800 to 1860.
   *
   * @param julianDate The date to calculate delta T for.
   * @return delta T
   */
  private double period05(JulianDate julianDate) {
    double t = julianDate.getJulianCenturies(DeltaTCalculator.EPOCH1800);
    return 13.72 - (33.2447 * t) + (68.612 * t * t) + (4111.6 * t * t * t) -
        (37436 * t * t * t * t) + (121272  * t * t * t * t * t) -
        (169900 * t * t * t * t * t * t) + (87500 * t * t * t * t * t * t * t);
  }

  /**
   * Used to calculate delta T from 1860 to 1900.
   *
   * @param julianDate The date to calculate delta T for.
   * @return delta T
   */
  private double period06(JulianDate julianDate) {
    double t = julianDate.getJulianCenturies(DeltaTCalculator.EPOCH1860);
    return 7.62 + (57.37 * t) - (2517.54 *t * t) + (16806.68 * t * t * t) -
        (44736.24 * t * t * t * t) + ((t * t * t * t * t)/0.0000233174);
  }

  /**
   * Used to calculate delta T from 1900 to 1920.
   *
   * @param julianDate The date to calculate delta T for.
   * @return delta T
   */
  private double period07(JulianDate julianDate) {
    double t = julianDate.getJulianCenturies(DeltaTCalculator.EPOCH1900);
    return -2.79 + (149.4119 * t) - (598.939 * t * t) + (6196.6 * t * t * t) -
        (19700.0 * t * t * t * t);
  }

  /**
   * Used to calculate delta T from 1920 to 1941.
   *
   * @param julianDate The date to calculate delta T for.
   * @return delta T
   */
  private double period08(JulianDate julianDate) {
    double t = julianDate.getJulianCenturies(DeltaTCalculator.EPOCH1920);
    return 21.20 + (84.493 * t) - (761.00 * t * t) + (2093.6 * t * t * t);
  }

  /**
   * Used to calculate delta T from 1941 to 1961.
   *
   * @param julianDate The date to calculate delta T for.
   * @return delta T
   */
  private double period09(JulianDate julianDate) {
    double t = julianDate.getJulianCenturies(DeltaTCalculator.EPOCH1950);
    return 29.07 + (40.7 * t) - ((t * t)/0.0233) + ((t * t * t)/0.002547);
  }

  /**
   * Used to calculate delta T from 1961 to 1986.
   *
   * @param julianDate The date to calculate delta T for.
   * @return delta T
   */
  private double period10(JulianDate julianDate) {
    double t = julianDate.getJulianCenturies(DeltaTCalculator.EPOCH1975);
    return 45.45 + (106.7 * t) - ((t * t)/0.026) - ((t * t * t)/0.000718);
  }

  /**
   * Used to calculate delta T from 1986 to 2005.
   *
   * @param julianDate The date to calculate delta T for.
   * @return delta T
   */
  private double period11(JulianDate julianDate) {
    double t = julianDate.getJulianCenturies(DeltaTCalculator.EPOCH2000);
    return 63.86 + (33.45 * t) - (603.74 * t * t) + (1727.5 * t * t * t) +
        (65181.4 * t * t * t * t) + (237359.9 * t * t * t * t * t);
  }

  /**
   * Used to calculate delta T from 2005 to 2050.
   *
   * @param julianDate The date to calculate delta T for.
   * @return delta T
   */
  private double period12(JulianDate julianDate) {
    double t = julianDate.getJulianCenturies(DeltaTCalculator.EPOCH2000);
    return 62.92 + (32.217 * t) + (55.89 * t * t);
  }

  /**
   * Used to calculate delta T from 2050 to 2150.
   *
   * @param julianDate The date to calculate delta T for.
   * @return delta T
   */
  private double period13(JulianDate julianDate) {
    double t = julianDate.getJulianCenturies(DeltaTCalculator.EPOCH1820);
    return -205.72 + (56.28 * t) + (32 * t * t);
  }

  /**
   * Used to calculate delta T after 2150.
   *
   * @param julianDate The date to calculate delta T for.
   * @return delta T
   */
  private double period14(JulianDate julianDate) {
    double t = julianDate.getJulianCenturies(DeltaTCalculator.EPOCH1820);
    return -20 + (32 * t * t);
  }
}
