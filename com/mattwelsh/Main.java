package com.mattwelsh;

import java.util.*;
import com.mattwelsh.astronomy.time.JulianDayNumber;

public class Main {

    public static void main(String[] args) {


        //final GregorianCalendar dateTime = new GregorianCalendar(1986, 12, 13, 0, 0, 0);


        JulianDayNumber jdn2 = new JulianDayNumber(2000, 1, 1, 12, 0, 0);
        System.out.println(jdn2.getJulianDayNumber());
        assert jdn2.getJulianDayNumber() == 2451545.0;

        JulianDayNumber jdn3 = new JulianDayNumber(1999, 1, 1, 0, 0, 0);
        System.out.println(jdn3.getJulianDayNumber());
        assert jdn3.getJulianDayNumber() == 2451179.5;

        JulianDayNumber jdn4 = new JulianDayNumber(1987, 1, 27, 0, 0, 0);
        System.out.println(jdn4.getJulianDayNumber());
        assert jdn4.getJulianDayNumber() == 2446822.5;

        JulianDayNumber jdn5 = new JulianDayNumber(1987, 6, 19, 12, 0, 0);
        System.out.println(jdn5.getJulianDayNumber());
        assert jdn5.getJulianDayNumber() == 2446966.0;

        JulianDayNumber jdn6 = new JulianDayNumber(1988, 1, 27, 0, 0, 0);
        System.out.println(jdn6.getJulianDayNumber());
        assert jdn6.getJulianDayNumber() == 2447187.5;

        JulianDayNumber jdn8 = new JulianDayNumber(1600, 1, 1, 0, 0, 0);
        System.out.println(jdn8.getJulianDayNumber());
        assert jdn8.getJulianDayNumber() == 2305447.5;

        JulianDayNumber jdn9 = new JulianDayNumber(1600, 12, 31, 0, 0, 0);
        System.out.println(jdn9.getJulianDayNumber());
        assert jdn9.getJulianDayNumber() == 2305812.5;

        JulianDayNumber jdn10 = new JulianDayNumber(837, 4, 10, 7, 36, 12);
        System.out.println(jdn10.getJulianDayNumber());
        assert jdn10.getJulianDayNumber() == 2026871.8168055555;


    }
}
