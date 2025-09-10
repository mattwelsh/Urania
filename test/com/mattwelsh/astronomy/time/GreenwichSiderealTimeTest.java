/*
 * Copyright (C) 2019-2025 by Matt Welsh
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
import org.junit.Test;
import org.junit.Assert;
/**
 * Unit tests for GreenwichSiderealTimeTest
 *
 * @author Matt Welsh
 * @version 1.0
 * @since 1.0
 */
public class GreenwichSiderealTimeTest {

  @Test
  public void testGMST() {
    JulianDate jdn2 = new JulianDate(1987, 4, 10, 19, 21, 0);
    Assert.assertEquals(jdn2.getJulianDayNumber(), 2446896.30625, 0);
    GreenwichSiderealTime greenwichSiderealTime = new GreenwichSiderealTime(jdn2);

    Assert.assertEquals(greenwichSiderealTime.getJulianDate().getJulianDayNumber(),
        2446896.30625, 0.0);
    Assert.assertEquals(greenwichSiderealTime.getMeanSiderealTime(),
        128.7378734, 0.001);
    Assert.assertEquals(greenwichSiderealTime.getMeanSiderealTimeDecimalHours(),
        8.58252489, 0.001);

    jdn2 = new JulianDate(1987, 4, 10, 0, 0, 0);
    Assert.assertEquals(jdn2.getJulianDayNumber(), 2446895.5, 0);
    greenwichSiderealTime = new GreenwichSiderealTime(jdn2);

    Assert.assertEquals(greenwichSiderealTime.getJulianDate().getJulianDayNumber(),
        2446895.5, 0.0);
    Assert.assertEquals(greenwichSiderealTime.getMeanSiderealTimeHour(),
        13, 0.0);
    Assert.assertEquals(greenwichSiderealTime.getMeanSiderealTimeMinute(),
        10, 0.0);
    Assert.assertEquals(greenwichSiderealTime.getMeanSiderealTimeSecond(),
        46, 0.0);

    jdn2 = new JulianDate(1978, 11, 13, 4, 34, 0);
    greenwichSiderealTime = new GreenwichSiderealTime(jdn2);

    Assert.assertEquals(greenwichSiderealTime.getMeanSiderealTimeHour(),
        8, 0.0);
    Assert.assertEquals(greenwichSiderealTime.getMeanSiderealTimeMinute(),
        01, 0.0);
    Assert.assertEquals(greenwichSiderealTime.getMeanSiderealTimeSecond(),
        46, 0.0);
  }
}