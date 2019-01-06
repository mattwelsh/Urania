/*
 * Copyright (C) 2017-2019 by Matt Welsh
 * This library is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or any later version.
 *
 * This library is distributed in the
 * hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details. You should have received a copy of the GNU Lesser General Public License along
 * with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street,
 * Fifth Floor, Boston, MA 02110-1301 USA
 */

package com.mattwelsh.util;

import java.util.*;

/**
 * This class represents a Julian Day Number, the number assigned to a solar day in the Julian day
 * count starting from noon Greenwich Mean Time, with Julian day number 0 assigned to the day
 * starting at noon on January 1, 4713 BC on the Julian calendar (November 24, 4714 BC, in the
 * Gregorian calendar). Due to the way GregorianCalendar works, this class only works for dates
 * after Jan 1, 1AD.
 *
 * @author Matt Welsh (mitya.welsh@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class JulianDate {

  private static GregorianCalendar CALENDAR_CUTOVER = new GregorianCalendar(1582, 10, 15);
  private GregorianCalendar gregorianCalendar;
  private double julianDayNumber;

  /** Create an instance of JulianDate for the current system time. */
  public JulianDate() {
    this(new GregorianCalendar());
  }

  /**
   * Create an instance of JulianDate set to the date and time specified. All parameters must
   * conform to the rules for creating a GregorianCalendar.
   *
   * @param year The year
   * @param month The month
   * @param day The day
   * @param hour The hour
   * @param minutes The minutes
   * @param seconds The hour
   */
  public JulianDate(int year, int month, int day, int hour, int minutes, int seconds) {
    this(new GregorianCalendar(year, month, day, hour, minutes, seconds));
  }

  /**
   * Create an instance of JulianDate set to the time specified in the passed calendar object.
   *
   * @param calendar The calendar to use specifying the date and time for the computed JD
   */
  public JulianDate(GregorianCalendar calendar) {
    this.gregorianCalendar = calendar;
    computeJulianDayNumber();
  }

  /**
   * Return the Julian Day Number for the date represented in this object.
   *
   * @return The Julian Day Number for the date represented in this object.
   */
  public double getJulianDayNumber() {
    return julianDayNumber;
  }

  // -----------------------------------------------------------------------------------------------
  // Protected and private methods
  // -----------------------------------------------------------------------------------------------

  private void computeJulianDayNumber() {
    int B;
    double C;
    int y;
    int m;

    int A = gregorianCalendar.get(GregorianCalendar.YEAR) / 100;
    if (gregorianCalendar.before(CALENDAR_CUTOVER)) {
      B = 0;
    } else {
      B = 2 - A + (A / 4);
    }

    double D =
        ((double) gregorianCalendar.get(GregorianCalendar.HOUR_OF_DAY)) / 24.0
            + ((double) gregorianCalendar.get(GregorianCalendar.MINUTE)) / 1440.0
            + ((double) gregorianCalendar.get(GregorianCalendar.SECOND)) / 86400.0;

    // Due to the way GregorianCalendar works, this class only works for dates after Jan 1, 1AD
    // so the following block of code isn't needed. It's left here only so that anyone comparing the
    // code to Meeus's book won't be confused about why it's missing.

    // if (gregorianCalendar.get(GregorianCalendar.YEAR) < 0) {
    //  C = -.75;
    // } else {
    //  C = 0;
    //    }
    C = 0.0;

    if (gregorianCalendar.get(GregorianCalendar.MONTH) > 2) {

      y = gregorianCalendar.get(GregorianCalendar.YEAR);
      m = gregorianCalendar.get(GregorianCalendar.MONTH);
    } else {
      y = gregorianCalendar.get(GregorianCalendar.YEAR) - 1;
      m = gregorianCalendar.get(GregorianCalendar.MONTH) + 12;
    }

    julianDayNumber =
        (int) ((365.25 * y) + C)
            + (int) (30.6001 * (m + 1))
            + gregorianCalendar.get(GregorianCalendar.DAY_OF_MONTH)
            + D
            + 1720994.5
            + B;
  }
}
