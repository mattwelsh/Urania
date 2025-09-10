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
 * Unit tests for MeeusDeltaTTest object using example dates from Jean Meeus.
 *
 * @author Matt Welsh
 * @version 1.0
 * @since 1.0
 */
public class MeeusDeltaTTest {

  @Test
  public void getDeltaT() throws Exception {

    DeltaTCalculator calc = DynamicalTime.MEEUS.getCalculator();

    JulianDate jd1 = new JulianDate(333, 2, 6, 6, 0, 0);
    JulianDate jd2 = new JulianDate(1000, 5, 18, 0, 0, 0);
    JulianDate jd3 = new JulianDate(1628, 1, 1, 12, 0, 0);
    JulianDate jd4 = new JulianDate(1840, 1, 11, 12, 0, 0);
    JulianDate jd5 = new JulianDate(1900, 1, 11, 12, 0, 0);
    JulianDate jd6 = new JulianDate(1999, 1, 11, 12, 0, 0);
    JulianDate jd7 = new JulianDate(2007, 1, 1, 12, 0, 0);

    Assert.assertEquals(calc.getDeltaT(jd1), 6146.0, 0.9);
    Assert.assertEquals(calc.getDeltaT(jd2), 1610.0, 0.9);
    Assert.assertEquals(calc.getDeltaT(jd3), 88.0, 0.9);
    Assert.assertEquals(calc.getDeltaT(jd4), 5.4, 0.5);
    Assert.assertEquals(calc.getDeltaT(jd5), -2.8, 0.5);
    Assert.assertEquals(calc.getDeltaT(jd6), 63.4, 0.5);
    Assert.assertEquals(calc.getDeltaT(jd7), 63.4, 12.0);
  }

}