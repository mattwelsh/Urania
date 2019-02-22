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
import java.time.LocalDateTime;
import org.junit.Test;
import org.junit.Assert;

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
    Assert.assertEquals(jdn2.getJulianDayNumber(), 2451545.0, 0);

    jdn2 = new JulianDate(1999, 1, 1, 0, 0, 0);
    Assert.assertEquals(jdn2.getJulianDayNumber(), 2451179.5, 0);

    jdn2 = new JulianDate(1987, 1, 27, 0, 0, 0);
    Assert.assertEquals(jdn2.getJulianDayNumber(), 2446822.5, 0);

    jdn2 = new JulianDate(1987, 6, 19, 12, 0, 0);
    Assert.assertEquals(jdn2.getJulianDayNumber(), 2446966.0, 0);

    jdn2 = new JulianDate(1988, 1, 27, 0, 0, 0);
    Assert.assertEquals(jdn2.getJulianDayNumber(), 2447187.5, 0);

    jdn2 = new JulianDate(1600, 1, 1, 0, 0, 0);
    Assert.assertEquals(jdn2.getJulianDayNumber(), 2305447.5, 0);

    jdn2 = new JulianDate(1600, 12, 31, 0, 0, 0);
    Assert.assertEquals(jdn2.getJulianDayNumber(), 2305812.5, 0);

    jdn2 = new JulianDate(837, 4, 10, 7, 36, 12);
    Assert.assertEquals(jdn2.getJulianDayNumber(), 2026871.8168055555, 0);

    jdn2 = new JulianDate(1992, 10, 13, 0, 0, 0);
    Assert.assertEquals(jdn2.getJulianDayNumber(), 2448908.5, 0);

    jdn2 = new JulianDate(1992, 10, 13, 0, 0, 0);
    Assert.assertEquals(jdn2.getJulianDayNumber(), 2448908.5, 0);

    jdn2 = new JulianDate(-122, 1, 1, 0, 0, 0);
    Assert.assertEquals(jdn2.getJulianDayNumber(), 1676497.5, 0);

    JulianDate epoch = new JulianDate(2000, 1, 1, 12, 0, 0);
    Assert.assertEquals(epoch.getJulianDayNumber(), 2451545.0, 0);
  }

  @Test
  public void getJulianCenturies() throws Exception {
    JulianDate epoch = new JulianDate(2000, 1, 1, 12, 0, 0);
    Assert.assertEquals(epoch.getJulianDayNumber(), 2451545.0, 0);

    JulianDate jdn2 = new JulianDate(333, 2, 6, 6, 0, 0);
    Assert.assertEquals(jdn2.getJulianCenturies(epoch), -16.669, 0.001);
  }

  @Test
  public void getFields() throws Exception {

    JulianDate jdn2 = new JulianDate(2000, 1,
        1, 12, 0, 0);
    Assert.assertEquals(jdn2.getYear(), 2000, 0);
    Assert.assertEquals(jdn2.getMonth(), 1, 0);
    Assert.assertEquals(jdn2.getDayOfMonth(), 1, 0);
    Assert.assertEquals(jdn2.getHour(), 12, 0);
    Assert.assertEquals(jdn2.getMinute(), 0, 0);
    Assert.assertEquals(jdn2.getSecond(), 0, 0);


    //If the date falls before Oct. 1, 1582, false otherwise.
    jdn2 = new JulianDate(1582, 10,
        1, 0, 0, 0);
    Assert.assertEquals(jdn2.getYear(), 1582, 0);
    Assert.assertEquals(jdn2.getMonth(), 10, 0);
    Assert.assertEquals(jdn2.getDayOfMonth(), 1, 0);
    Assert.assertEquals(jdn2.getHour(), 0, 0);
    Assert.assertEquals(jdn2.getMinute(), 0, 0);
    Assert.assertEquals(jdn2.getSecond(), 0, 0);

    jdn2 = new JulianDate(1582, 11,
        15, 0, 0, 0);
    Assert.assertEquals(jdn2.getYear(), 1582, 0);
    Assert.assertEquals(jdn2.getMonth(), 11, 0);
    Assert.assertEquals(jdn2.getDayOfMonth(), 15, 0);
    Assert.assertEquals(jdn2.getHour(), 0, 0);
    Assert.assertEquals(jdn2.getMinute(), 0, 0);
    Assert.assertEquals(jdn2.getSecond(), 0, 0);

    jdn2 = new JulianDate(1582, 6,
        15, 0, 0, 0);
    Assert.assertEquals(jdn2.getYear(), 1582, 0);
    Assert.assertEquals(jdn2.getMonth(), 6, 0);
    Assert.assertEquals(jdn2.getDayOfMonth(), 15, 0);
    Assert.assertEquals(jdn2.getHour(), 0, 0);
    Assert.assertEquals(jdn2.getMinute(), 0, 0);
    Assert.assertEquals(jdn2.getSecond(), 0, 0);

    LocalDateTime dateTime = LocalDateTime.now();
    jdn2 = new JulianDate();
    Assert.assertEquals(jdn2.getYear(), dateTime.getYear(), 0);
    Assert.assertEquals(jdn2.getMonth(), dateTime.getMonthValue(), 0);
    Assert.assertEquals(jdn2.getDayOfMonth(), dateTime.getDayOfMonth(), 0);
    Assert.assertEquals(jdn2.getHour(), dateTime.getHour(), 0);
    Assert.assertEquals(jdn2.getMinute(), dateTime.getMinute(), 0);

    jdn2 = new JulianDate(2026871.8168055555);
    Assert.assertEquals(jdn2.getMonth(), 4, 0);
    Assert.assertEquals(jdn2.getDayOfMonth(), 10, 0);
    Assert.assertEquals(jdn2.getYear(), 837, 0);
    Assert.assertEquals(jdn2.getHour(), 7, 0);
    Assert.assertEquals(jdn2.getMinute(), 36, 0);
    Assert.assertEquals(jdn2.getSecond(), 12, 1);

    jdn2 = new JulianDate(4500.392100368987923);
    JulianDate jdn3 = new JulianDate(jdn2.getYear(), jdn2.getMonth(), jdn2.getDayOfMonth(),
        jdn2.getHour(), jdn2.getMinute(), jdn2.getSecond());

    Assert.assertEquals(jdn3.getYear(), jdn2.getYear(), 0);
    Assert.assertEquals(jdn3.getMonth(), jdn2.getMonth(), 0);
    Assert.assertEquals(jdn3.getDayOfMonth(), jdn2.getDayOfMonth(), 0);
    Assert.assertEquals(jdn3.getHour(), jdn2.getHour(), 0);
    Assert.assertEquals(jdn3.getMinute(), jdn2.getMinute(), 0);
    Assert.assertEquals(jdn3.getSecond(), jdn2.getSecond(), 0);

    jdn2 = new JulianDate(10000.9812657123);
    jdn3 = new JulianDate(jdn2.getYear(), jdn2.getMonth(), jdn2.getDayOfMonth(),
        jdn2.getHour(), jdn2.getMinute(), jdn2.getSecond());

    Assert.assertEquals(jdn3.getYear(), jdn2.getYear(), 0);
    Assert.assertEquals(jdn3.getMonth(), jdn2.getMonth(), 0);
    Assert.assertEquals(jdn3.getDayOfMonth(), jdn2.getDayOfMonth(), 0);
    Assert.assertEquals(jdn3.getHour(), jdn2.getHour(), 0);
    Assert.assertEquals(jdn3.getMinute(), jdn2.getMinute(), 0);
    Assert.assertEquals(jdn3.getSecond(), jdn2.getSecond(), 0);

    jdn2 = new JulianDate(20000.02875612);
    jdn3 = new JulianDate(jdn2.getYear(), jdn2.getMonth(), jdn2.getDayOfMonth(),
        jdn2.getHour(), jdn2.getMinute(), jdn2.getSecond());

    Assert.assertEquals(jdn3.getYear(), jdn2.getYear(), 0);
    Assert.assertEquals(jdn3.getMonth(), jdn2.getMonth(), 0);
    Assert.assertEquals(jdn3.getDayOfMonth(), jdn2.getDayOfMonth(), 0);
    Assert.assertEquals(jdn3.getHour(), jdn2.getHour(), 0);
    Assert.assertEquals(jdn3.getMinute(), jdn2.getMinute(), 0);
    Assert.assertEquals(jdn3.getSecond(), jdn2.getSecond(), 0);

    jdn2 = new JulianDate(30000.569998);
    jdn3 = new JulianDate(jdn2.getYear(), jdn2.getMonth(), jdn2.getDayOfMonth(),
        jdn2.getHour(), jdn2.getMinute(), jdn2.getSecond());

    Assert.assertEquals(jdn3.getYear(), jdn2.getYear(), 0);
    Assert.assertEquals(jdn3.getMonth(), jdn2.getMonth(), 0);
    Assert.assertEquals(jdn3.getDayOfMonth(), jdn2.getDayOfMonth(), 0);
    Assert.assertEquals(jdn3.getHour(), jdn2.getHour(), 0);
    Assert.assertEquals(jdn3.getMinute(), jdn2.getMinute(), 0);
    Assert.assertEquals(jdn3.getSecond(), jdn2.getSecond(), 0);

    jdn2 = new JulianDate(2299177.98567234);
    jdn3 = new JulianDate(jdn2.getYear(), jdn2.getMonth(), jdn2.getDayOfMonth(),
        jdn2.getHour(), jdn2.getMinute(), jdn2.getSecond());

    Assert.assertEquals(jdn3.getYear(), jdn2.getYear(), 0);
    Assert.assertEquals(jdn3.getMonth(), jdn2.getMonth(), 0);
    Assert.assertEquals(jdn3.getDayOfMonth(), jdn2.getDayOfMonth(), 0);
    Assert.assertEquals(jdn3.getHour(), jdn2.getHour(), 0);
    Assert.assertEquals(jdn3.getMinute(), jdn2.getMinute(), 0);
    Assert.assertEquals(jdn3.getSecond(), jdn2.getSecond(), 0);

  }
}
