package com.mattwelsh.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for Julian Date object using example dates from Jean Meeus
 *
 * @version 1.0.0
 * Created by Matt on 7/15/17.
 */
public class JulianDateTest {
    @Test
    public void getJulianDayNumber() throws Exception {

        JulianDate jdn2 = new JulianDate(2000, 1, 1, 12, 0, 0);
        org.junit.Assert.assertEquals(jdn2.getJulianDayNumber(), 2451545.0, 0);

        jdn2 = new JulianDate(1999, 1, 1, 0, 0, 0);
        org.junit.Assert.assertEquals(jdn2.getJulianDayNumber(), 2451179.5, 0);

        jdn2 = new JulianDate(1987, 1, 27, 0, 0, 0);
        org.junit.Assert.assertEquals(jdn2.getJulianDayNumber(), 2446822.5, 0);

        jdn2 = new JulianDate(1987, 6, 19, 12, 0, 0);
        org.junit.Assert.assertEquals(jdn2.getJulianDayNumber(), 2446966.0, 0);

        jdn2 = new JulianDate(1988, 1, 27, 0, 0, 0);
        org.junit.Assert.assertEquals(jdn2.getJulianDayNumber(), 2447187.5, 0);

        jdn2 = new JulianDate(1600, 1, 1, 0, 0, 0);
        org.junit.Assert.assertEquals(jdn2.getJulianDayNumber(), 2305447.5, 0);

        jdn2 = new JulianDate(1600, 12, 31, 0, 0, 0);
        org.junit.Assert.assertEquals(jdn2.getJulianDayNumber(), 2305812.5, 0);

        jdn2 = new JulianDate(837, 4, 10, 7, 36, 12);
        org.junit.Assert.assertEquals(jdn2.getJulianDayNumber(), 2026871.8168055555, 0);

    }

}
