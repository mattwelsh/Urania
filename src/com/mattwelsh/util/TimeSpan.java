package com.mattwelsh.util;

import java.util.*;

/**
 * This class represents a span of time between two points in time. It uses the JulianDate class to
 * calculate the span length and holds that representation in days. The order the dates are passed
 * is ignored and there are methods to get the span length in days, weeks, months, years, decades
 * and centuries that ignore fractional parts. For example, the span of time between March 7, 2017
 * at 5:00am and March 7, 2017 at 5:00pm returns '1' for getDays() rather than 1.5 following the
 * convention people most often use when speaking.
 *
 * <p>If you want the exact span length use getLength() which returns the exact span length as a
 * double.
 *
 * @author Matt Welsh July 11, 2017
 * @version 1.0.0
 */
public class TimeSpan {

  private GregorianCalendar startDateGregorian;
  private GregorianCalendar endDateGregorian;
  private JulianDate startDateJulian;
  private JulianDate endDateJulian;
  private double length;
  private boolean forward;

  /**
   * Create a TimeSpan object representing the length of time between startDateGregorian and
   * endDateGregorian. The order the arguments are passed is irrelevant to the computed length.
   *
   *
   * @param startDateGregorian The starting date or the time span.
   * @param endDateGregorian The ending date of the time span.
   */
  public TimeSpan(GregorianCalendar startDateGregorian, GregorianCalendar endDateGregorian) {

    this.startDateGregorian = startDateGregorian;
    this.endDateGregorian = endDateGregorian;
    startDateJulian = new JulianDate(startDateGregorian);
    endDateJulian = new JulianDate(endDateGregorian);

    forward = (startDateJulian.getJulianDayNumber() - endDateJulian.getJulianDayNumber()) >= 0;
    length = Math.abs(startDateJulian.getJulianDayNumber() - endDateJulian.getJulianDayNumber());
  }

  /**
   * Create a TimeSpan with the given start date and length in days. The length may be negative
   * resulting in an end date before the start time.
   *
   * @param startDateGregorian The start of the time span.
   * @param length The length of the time span.
   */
  public TimeSpan(GregorianCalendar startDateGregorian, double length) {

    this.startDateGregorian = startDateGregorian;
    this.endDateGregorian = computeEndDate(length);
    startDateJulian = new JulianDate(startDateGregorian);
    endDateJulian = new JulianDate(endDateGregorian);
    this.length =
        Math.abs(startDateJulian.getJulianDayNumber() - endDateJulian.getJulianDayNumber());
  }

  /**
   * Returns the starting date that was used to construct the span.
   *
   * @return The start date of the time span.
   */
  public GregorianCalendar getStartDateGregorian() {
    return startDateGregorian;
  }

  /**
   * Return the end date used to construct the span.
   *
   * @return The end date used to construct the span.
   */
  public GregorianCalendar getEndDateGregorian() {
    return endDateGregorian;
  }

  /**
   * Return the exact length of the time span in days as a double.
   *
   * @return The exact length of the time span in days as a double.
   */
  public double getLength() {
    return length;
  }

  /**
   * Get the number of weeks in the span ignoring fractional parts.
   *
   * @return The number of weeks in the span ignoring fractional parts.
   */
  public long getWeeks() {
    return (long) getLength() / 7;
  }

  /**
   * Get the number of days in the time span ignoring fractional parts.
   *
   * @return The number of days in the time span ignoring fractional parts.
   */
  public long getDays() {
    return (long) getLength();
  }

  /**
   * Get the number of years in the time span ignoring fractional parts.
   *
   * @return The number of years in the time span ignoring fractional parts.
   */
  public long getYears() {
    return (long) (getLength() / 365.25);
  }

  /**
   * Get the number of decades in the time span ignoring fractional parts.
   *
   * @return The number of decades in the time span ignoring fractional parts.
   */
  public long getDecades() {
    return getYears() / 10;
  }

  /**
   * Get the number of centuries in the time span ignoring fractional parts.
   *
   * @return The number of centuries in the time span ignoring fractional parts.
   */
  public long getCenturies() {
    return getDecades() / 10;
  }

  /**
   * Get the number of months in the time span ignoring fractional parts.
   *
   * @return The number of months in the time span ignoring fractional parts.
   */
  public long getMonths() {

    GregorianCalendar g1;
    GregorianCalendar g2;

    if (forward) {
      g1 = startDateGregorian;
      g2 = endDateGregorian;
    } else {
      g1 = endDateGregorian;
      g2 = startDateGregorian;
    }

    long temp = (long) g1.get(GregorianCalendar.YEAR) - (long) g2.get(GregorianCalendar.YEAR);
    temp = temp * 12;
    temp += g1.get(GregorianCalendar.MONTH) - g2.get(GregorianCalendar.MONTH);
    return temp;
  }

  // ------------------------------------------------------------------------------------------------------------------
  // Private and protected methods
  // ------------------------------------------------------------------------------------------------------------------

  private GregorianCalendar computeEndDate(double length) {
    startDateJulian = new JulianDate(this.startDateGregorian);
    return computeCalendarDate(this.startDateJulian.getJulianDayNumber() + length);
  }

  private GregorianCalendar computeCalendarDate(double julianDate) {
    double startJD = julianDate;
    startJD += 0.5;
    double z = getInteger(startJD);
    double f = getFractional(startJD);
    double a;
    double alpha;

    if (z < 2299161) {
      a = z;
    } else {
      alpha = getInteger((z - 1867216.25) / 36524.25);
      a = z + 1.0 + alpha - getInteger(alpha / 4.0);
    }

    double b = a + 1524;
    double c = getInteger((b - 122.1) / 365.25);
    double d = getInteger(365.25 * c);
    double e = getInteger((b - d) / 30.6001);

    double day = b - d - (long) (30.6001 * e) + f;

    double month;
    if (e < 14) {
      month = e - 1;
    } else {
      month = e - 13;
    }

    double year;
    if (month > 2) {
      year = c - 4716;
    } else {
      year = c - 4715;
    }

    double hours = getFractional(day);
    hours = hours * 24;
    day = getInteger(day);

    double minutes = getFractional(hours);
    minutes = minutes * 60;

    double seconds = getFractional(minutes);
    minutes = getInteger(minutes);
    seconds = seconds * 60;

    double milliseconds = getFractional(seconds);
    seconds = getInteger(seconds);
    milliseconds *= 1000;

    GregorianCalendar greg =
        new GregorianCalendar(
            (int) year, (int) month, (int) day, (int) hours, (int) minutes, (int) seconds);

    greg.set(Calendar.MILLISECOND, (int) milliseconds);
    return greg;
  }

  private double getFractional(double d) {
    return d - getInteger(d);
  }

  private double getInteger(double d) {
    return (double) ((long) d);
  }

  private void printGregorianCalendar(GregorianCalendar greg) {

    System.out.println(
        "Computed Date: "
            + greg.get(Calendar.MONTH)
            + "/"
            + greg.get(Calendar.DAY_OF_MONTH)
            + "/"
            + greg.get(Calendar.YEAR)
            + " at "
            + greg.get(Calendar.HOUR_OF_DAY)
            + ":"
            + greg.get(Calendar.MINUTE)
            + ":"
            + greg.get(Calendar.SECOND)
            + ":"
            + greg.get(Calendar.MILLISECOND));
  }
}
