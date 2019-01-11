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

import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.Test;

/**
 * Unit tests for Julian Date object using example dates from Jean Meeus
 *
 * @author Matt Welsh
 * @version 1.0
 * @since 1.0
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

    jdn2 = new JulianDate(1992, 10, 13, 0, 0, 0);
    org.junit.Assert.assertEquals(jdn2.getJulianDayNumber(), 2448908.5, 0);

    jdn2 = new JulianDate(new GregorianCalendar(2000, Calendar.FEBRUARY, 1, 12, 0, 0));
    org.junit.Assert.assertEquals(jdn2.getJulianDayNumber(), 2451545.0, 0);

    jdn2 = new JulianDate(1992, 10, 13, 0, 0, 0);
    org.junit.Assert.assertEquals(jdn2.getJulianDayNumber(), 2448908.5, 0);

    JulianDate epoch = new JulianDate(2000, 1, 1, 12, 0, 0);
    org.junit.Assert.assertEquals(epoch.getJulianDayNumber(), 2451545.0, 0);
  }

  @Test
  public void getJulianCenturies() throws Exception {
    JulianDate epoch = new JulianDate(2000, 1, 1, 12, 0, 0);
    org.junit.Assert.assertEquals(epoch.getJulianDayNumber(), 2451545.0, 0);

    JulianDate jdn2 = new JulianDate(333, 2, 6, 6, 0, 0);
    org.junit.Assert.assertEquals(jdn2.getJulianCenturies(epoch), -16.669, 0.001);
  }
}
