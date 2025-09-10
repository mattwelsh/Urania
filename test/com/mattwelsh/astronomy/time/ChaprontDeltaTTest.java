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

public class ChaprontDeltaTTest {

  @Test
  public void getDeltaT() {

    DeltaTCalculator calc = DynamicalTime.CHAPRONT.getCalculator();

    JulianDate jd1 = new JulianDate(1600, 0, 0, 12, 0, 0);
    Assert.assertEquals(calc.getDeltaT(jd1), 80.0, 0.0);

    jd1 = new JulianDate(1760, 0, 0, 12, 0, 0);
    Assert.assertEquals(calc.getDeltaT(jd1), 8.0, 0.0);

    jd1 = new JulianDate(1730, 0, 0, 12, 0, 0);
    Assert.assertEquals(calc.getDeltaT(jd1), 1.0, 0.0);

    jd1 = new JulianDate(1805, 0, 0, 12, 0, 0);
    Assert.assertEquals(calc.getDeltaT(jd1), 8.0, 0.0);

    jd1 = new JulianDate(1859, 0, 0, 12, 0, 0);
    Assert.assertEquals(calc.getDeltaT(jd1), 6.0, 0.0);

    jd1 = new JulianDate(1909, 0, 0, 12, 0, 0);
    Assert.assertEquals(calc.getDeltaT(jd1), 9.0, 0.0);

    jd1 = new JulianDate(1939, 0, 0, 12, 0, 0);
    Assert.assertEquals(calc.getDeltaT(jd1), 24.0, 0.0);

    jd1 = new JulianDate(1958, 0, 0, 12, 0, 0);
    Assert.assertEquals(calc.getDeltaT(jd1), 32.0, 0.0);

    jd1 = new JulianDate(1966, 0, 0, 12, 0, 0);
    Assert.assertEquals(calc.getDeltaT(jd1), 37, 0.0);

    jd1 = new JulianDate(1973, 0, 0, 12, 0, 0);
    Assert.assertEquals(calc.getDeltaT(jd1), 43, 0.0);

    jd1 = new JulianDate(1982, 0, 0, 12, 0, 0);
    Assert.assertEquals(calc.getDeltaT(jd1), 52, 0.0);

    jd1 = new JulianDate(1990, 0, 0, 12, 0, 0);
    Assert.assertEquals(calc.getDeltaT(jd1), 57, 0.0);

    jd1 = new JulianDate(1991, 0, 0, 12, 0, 0);
    Assert.assertEquals(calc.getDeltaT(jd1), 57.5, 0.9);

  }
}