package com.mattwelsh.test.util;

import com.mattwelsh.util.JulianDate;
import com.mattwelsh.util.TimeSpan;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class UtilTest {

    public static void main(String[] args) {

        testJulianDayNumbers();
        testTimeSpan();
    }

    private static void testJulianDayNumbers() {

        JulianDate jdn2 = new JulianDate(2000, 1, 1, 12, 0, 0);
        //System.out.println(jdn2.getJulianDayNumber());
        assert jdn2.getJulianDayNumber() == 2451545.0;

        JulianDate jdn3 = new JulianDate(1999, 1, 1, 0, 0, 0);
        //System.out.println(jdn3.getJulianDayNumber());
        assert jdn3.getJulianDayNumber() == 2451179.5;

        JulianDate jdn4 = new JulianDate(1987, 1, 27, 0, 0, 0);
        //System.out.println(jdn4.getJulianDayNumber());
        assert jdn4.getJulianDayNumber() == 2446822.5;

        JulianDate jdn5 = new JulianDate(1987, 6, 19, 12, 0, 0);
        //System.out.println(jdn5.getJulianDayNumber());
        assert jdn5.getJulianDayNumber() == 2446966.0;

        JulianDate jdn6 = new JulianDate(1988, 1, 27, 0, 0, 0);
        //System.out.println(jdn6.getJulianDayNumber());
        assert jdn6.getJulianDayNumber() == 2447187.5;

        JulianDate jdn8 = new JulianDate(1600, 1, 1, 0, 0, 0);
        //System.out.println(jdn8.getJulianDayNumber());
        assert jdn8.getJulianDayNumber() == 2305447.5;

        JulianDate jdn9 = new JulianDate(1600, 12, 31, 0, 0, 0);
        //System.out.println(jdn9.getJulianDayNumber());
        assert jdn9.getJulianDayNumber() == 2305812.5;

        JulianDate jdn10 = new JulianDate(837, 4, 10, 7, 36, 12);
        //System.out.println(jdn10.getJulianDayNumber());
        assert jdn10.getJulianDayNumber() == 2026871.8168055555;

        System.out.println("//----------------------------------//");
        System.out.println("End JulianDate Test");
        System.out.println("//----------------------------------// \n\n");

    }

    private static void testTimeSpan() {

        TimeSpan span2 = new TimeSpan(new GregorianCalendar(2001, 5, 1), new GregorianCalendar(2001, 5, 18));

        //System.out.println(span2.getCenturies());
        assert (span2.getCenturies() == 0);
        //System.out.println(span2.getDecades());
        assert (span2.getDecades() == 0);
        //System.out.println(span2.getYears());
        assert (span2.getYears() == 0);
        //System.out.println(span2.getMonths());
        assert (span2.getMonths() == 0);
        //System.out.println(span2.getWeeks());
        assert (span2.getWeeks() == 2);
        //System.out.println(span2.getDays());
        assert (span2.getDays() == 18310);
        System.out.println("//----------------------------------//");
        System.out.println("End TimeSpan Test 1");
        System.out.println("//----------------------------------// \n\n");

        span2 = new TimeSpan(new GregorianCalendar(1964, 5, 1), new GregorianCalendar(2014, 6, 18));
        //System.out.println(span2.getCenturies());
        assert (span2.getCenturies() == 0);
        //System.out.println(span2.getDecades());
        assert (span2.getDecades() == 5);
        //System.out.println(span2.getYears());
        assert (span2.getYears() == 50);
        //System.out.println(span2.getMonths());
        assert (span2.getMonths() == 601);
        //System.out.println(span2.getDays());
        assert (span2.getDays() == 18310);

        System.out.println("//----------------------------------//");
        System.out.println("End TimeSpan Test 2");
        System.out.println("//----------------------------------// \n\n");

        span2 = new TimeSpan(new GregorianCalendar(2014, 1, 1), new GregorianCalendar(2014, 12, 31));
        //System.out.println(span2.getCenturies());
        assert (span2.getCenturies() == 0);
        //System.out.println(span2.getDecades());
        assert (span2.getDecades() == 0);
        //System.out.println(span2.getYears());
        assert (span2.getYears() == 0);
        //System.out.println(span2.getMonths());
        assert (span2.getMonths() == 11);
        //System.out.println(span2.getDays());
        assert (span2.getDays() == 364);

        System.out.println("//----------------------------------//");
        System.out.println("End TimeSpan Test 3");
        System.out.println("//----------------------------------// \n\n\n\n\n\n\n");

        span2 = new TimeSpan(new GregorianCalendar(2017, 5, 16), 2.25278757866539);
        //span2 = new TimeSpan(new GregorianCalendar(), 2.0);

        GregorianCalendar greg = span2.getEndDateGregorian();

        assert greg != null;

        System.out.println("Computed Date: " + greg.get(Calendar.MONTH) + "/" + greg.get(Calendar.DAY_OF_MONTH) + "/" +
                greg.get(Calendar.YEAR) + " at " + greg.get(Calendar.HOUR_OF_DAY) + ":" +
                greg.get(Calendar.MINUTE) + ":" + greg.get(Calendar.SECOND) + "." +
                greg.get(Calendar.MILLISECOND));

    }

}
