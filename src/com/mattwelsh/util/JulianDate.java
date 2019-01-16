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
package com.mattwelsh.util;

import java.util.*;
import java.time.LocalDateTime;

/**
 * This class represents a Julian Day Number, the number assigned to a solar day in the Julian day
 * count starting from noon Greenwich Mean Time, with Julian day number 0 assigned to the day
 * starting at noon on January 1, 4713 BC on the Julian calendar (November 24, 4714 BC, in the
 * Gregorian calendar).
 *
 * @author Matt Welsh (mitya.welsh@gmail.com)
 * @version 1.1
 * @since 1.0
 */
public class JulianDate {

  private double julianDayNumber;
  private int year;
  private int month;
  private int dayOfMonth;
  private int hour;
  private int minute;
  private int second;

  /** Create an instance of JulianDate for the current system time. */
  public JulianDate() {
    LocalDateTime dateTime = LocalDateTime.now();
    this.year = dateTime.getYear();
    this.month = dateTime.getMonthValue();
    this.dayOfMonth = dateTime.getDayOfMonth();
    this.hour = dateTime.getHour();
    this.minute = dateTime.getMinute();
    this.second = dateTime.getSecond();
    computeJulianDayNumber();
  }

  /**
   * Create an instance of JulianDate set to the date and time specified.
   *
   * @param year The year
   * @param month The month
   * @param dayOfMonth The day
   * @param hour The hour
   * @param minute The minute
   * @param second The second
   */
  public JulianDate(int year, int month, int dayOfMonth, int hour, int minute, int second) {
    this.year = year;
    this.month = month;
    this.dayOfMonth = dayOfMonth;
    this.hour = hour;
    this.minute = minute;
    this.second = second;
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

  /**
   * Return the number of julian centuries since the passed epoch for the date represented in this
   * object.
   *
   * @return The Julian Day Number for the date represented in this object.
   */
  public double getJulianCenturies(JulianDate epoch) {
    return (getJulianDayNumber() - epoch.getJulianDayNumber() ) / 36525.0;
  }

  /**
   * Return the value of the year used to create this object.
   *
   * @return The value of the year used to create this object.
   */
  public int getYear() {
    return this.year;
  }

  /**
   * Return the value of the month used to create this object.
   *
   * @return The value of the month used to create this object.
   */
  public int getMonth() {
    return this.month;
  }

  /**
   * Return the value of the day of the month used to create this object.
   *
   * @return The value of the day of the month used to create this object.
   */
  public int getDayOfMonth() {
    return this.dayOfMonth;
  }

  /**
   * Return the value of the hour used to create this object.
   *
   * @return The value of the hour used to create this object.
   */
  public int getHour() {
    return this.hour;
  }

  /**
   * Return the value of the minute used to create this object.
   *
   * @return The value of the minute used to create this object.
   */
  public int getMinute() {
    return this.minute;
  }

  /**
   * Return the value of the second used to create this object.
   *
   * @return The value of the second used to create this object.
   */
  public int getSecond() {
    return this.second;
  }

  // -----------------------------------------------------------------------------------------------
  // Protected and private methods
  // -----------------------------------------------------------------------------------------------

  private void computeJulianDayNumber() {
    int B;
    double C;
    int y;
    int m;

    int A = this.year / 100;
    if (isBeforeCutover(this.year, this.month, this.dayOfMonth)) {
      B = 0;
    } else {
      B = 2 - A + (A / 4);
    }

    double D =
        ((double) this.hour) / 24.0
            + ((double) this.minute) / 1440.0
            + ((double) this.second) / 86400.0;

     if (this.year < 0) {
       C = -.75;
     } else {
       C = 0;
     }


    if (this.month > 2) {
      y = this.year;
      m = this.month;
    } else {
      y = this.year - 1;
      m = this.month + 12;
    }

    julianDayNumber =
        (int) ((365.25 * y) + C)
            + (int) (30.6001 * (m + 1))
            + this.dayOfMonth
            + D
            + 1720994.5
            + B;
  }

  /**
   * Compute if the passed day is after the Gregorian calendar cut over date of Oct. 1, 1582.
   *
   * @param year The year to check.
   * @param month The month to check.
   * @param dayOfMonth The day to check.
   * @returnTrue If the date falls before Oct. 1, 1582, false otherwise.
   */
  private boolean isBeforeCutover(int year, int month, int dayOfMonth) {

    if(year < 1582) {
      return true;
    }
    if(year > 1582) {
      return false;
    }

    if (month < 10) {
      return true;
    }

    if(month > 10) {
      return false;
    }
    //if it makes it this far it means the year is exactly 1582, the month is October and the
    // day is at least 1, so
    return false;
  }
}
