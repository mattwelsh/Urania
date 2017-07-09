package com.mattwelsh.test.util;

// import java.util.*;
import com.mattwelsh.util.JulianDate;

public class UtilTest {

    public static void main(String[] args) {


        //final GregorianCalendar dateTime = new GregorianCalendar(1986, 12, 13, 0, 0, 0);


        JulianDate jdn2 = new JulianDate(2000, 1, 1, 12, 0, 0);
        System.out.println(jdn2.getJulianDayNumber());
        assert jdn2.getJulianDayNumber() == 2451545.0;

        JulianDate jdn3 = new JulianDate(1999, 1, 1, 0, 0, 0);
        System.out.println(jdn3.getJulianDayNumber());
        assert jdn3.getJulianDayNumber() == 2451179.5;

        JulianDate jdn4 = new JulianDate(1987, 1, 27, 0, 0, 0);
        System.out.println(jdn4.getJulianDayNumber());
        assert jdn4.getJulianDayNumber() == 2446822.5;

        JulianDate jdn5 = new JulianDate(1987, 6, 19, 12, 0, 0);
        System.out.println(jdn5.getJulianDayNumber());
        assert jdn5.getJulianDayNumber() == 2446966.0;

        JulianDate jdn6 = new JulianDate(1988, 1, 27, 0, 0, 0);
        System.out.println(jdn6.getJulianDayNumber());
        assert jdn6.getJulianDayNumber() == 2447187.5;

        JulianDate jdn8 = new JulianDate(1600, 1, 1, 0, 0, 0);
        System.out.println(jdn8.getJulianDayNumber());
        assert jdn8.getJulianDayNumber() == 2305447.5;

        JulianDate jdn9 = new JulianDate(1600, 12, 31, 0, 0, 0);
        System.out.println(jdn9.getJulianDayNumber());
        assert jdn9.getJulianDayNumber() == 2305812.5;

        JulianDate jdn10 = new JulianDate(837, 4, 10, 7, 36, 12);
        System.out.println(jdn10.getJulianDayNumber());
        assert jdn10.getJulianDayNumber() == 2026871.8168055555;


    }
}
