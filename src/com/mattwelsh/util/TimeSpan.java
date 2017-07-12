package com.mattwelsh.util;

import java.util.GregorianCalendar;

/**
 * This class represents a span of time between two points in time. It uses the JulianDate class to calculate the span
 * length and holds that representation in days. The order the dates are passed is ignored and there are methods to
 * get the span length in days, weeks, months, years, decades and centuries that ignore fractional parts. For example,
 * the span of time between March 7, 2017 at 5:00am and March 7, 2017 at 5:00pm returns '1' for getDays() rather than
 * 1.5 following the convention people most often use when speaking.
 *
 * If you want the exact span length use getLength() which returns the exact span length as a double.
 *
 * @author Matt Welsh July 11, 2017
 */

public class TimeSpan {

    private GregorianCalendar startDate;
    private GregorianCalendar endDate;
    private int years;
    private int months;
    private int days;
    private int hours;
    private int minutes;
    private float seconds;
    private double length;
    private boolean forward;


    /**
     * Create a TimeSpan object representing the length of time between startDate and endDate. The order the arguments
     * are passed is irrelevant to the computed length.
     *
     * @param startDate The starting date or the time span.
     * @param endDate The ending date of the time span.
     */
    public TimeSpan(GregorianCalendar startDate, GregorianCalendar endDate) {

        this.startDate = startDate;
        this.endDate = endDate;
        JulianDate start = new JulianDate(startDate);
        JulianDate end = new JulianDate(endDate);

        forward = (start.getJulianDayNumber() - end.getJulianDayNumber()) >= 0;
        length = Math.abs(start.getJulianDayNumber() - end.getJulianDayNumber());
    }

    /**
     * Returns the starting date that was used to construct the span.
     *
     * @return The start date of the time span.
     */
    public GregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Return the end date used to construct the span.
     *
     * @return The end date used to construct the span.
     */
    public GregorianCalendar endStartDate() {
        return endDate;
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
        return (long)(getLength() /365.25);
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
        return getDecades()/10;
    }

    /**
     * Get the number of months in the time span ignoring fractional parts.
     *
     * @return The number of months in the time span ignoring fractional parts.
     */
    public long getMonths() {

        GregorianCalendar g1;
        GregorianCalendar g2;

        if(forward) {
            g1 = startDate;
            g2 = endDate;
        }
        else {
            g1 = endDate;
            g2 = startDate;
        }

        long temp = (long) g1.get(GregorianCalendar.YEAR) - (long) g2.get(GregorianCalendar.YEAR);
        temp = temp * 12;
        temp += g1.get(GregorianCalendar.MONTH) - g2.get(GregorianCalendar.MONTH);
        return temp;
    }

}
