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
 * The unit test values used here were computed from the formulae at:
 *
 * <p>See http://www.eclipsewise.com/help/deltatpoly2014.html for more information</p>
 *
 * and were evaluated in Maple 2017 or hand checked at
 *
 * <p>https://www.staff.science.uu.nl/~gent0113/deltat/deltat_calculator.htm</p>
 *
 */
public class EspenakMeeusDeltaTTest {

  @Test
  public void getDeltaT() {

    DeltaTCalculator calc = DynamicalTime.ESPENAKMEEUS.getCalculator();

    JulianDate jd1 = new JulianDate(-600, 1, 1, 12, 0, 0);
    Assert.assertEquals(calc.getDeltaT(jd1), 18720.48, 4.0);

    jd1 = new JulianDate(250, 1, 1, 12, 0, 0);
    Assert.assertEquals(calc.getDeltaT(jd1), 8163.063848, 4.0);

    jd1 = new JulianDate(700, 1, 1, 12, 0, 0);
    Assert.assertEquals(calc.getDeltaT(jd1), 3813.150140, 4.0);

    jd1 = new JulianDate(1650, 1, 1, 12, 0, 0);
    Assert.assertEquals(calc.getDeltaT(jd1), 50.19401599, 1.0);

    jd1 = new JulianDate(1750, 1, 1, 12, 0, 0);
    Assert.assertEquals(calc.getDeltaT(jd1), 13.37007027, 1.0);

    jd1 = new JulianDate(1850, 1, 1, 12, 0, 0);
    Assert.assertEquals(calc.getDeltaT(jd1), 7.1069000, 1.0);

    jd1 = new JulianDate(1875, 1, 1, 12, 0, 0);
    Assert.assertEquals(calc.getDeltaT(jd1), -3.087638362, 1.0);

    jd1 = new JulianDate(1910, 1, 1, 12, 0, 0);
    Assert.assertEquals(calc.getDeltaT(jd1), 10.3884000, 1.0);

    jd1 = new JulianDate(1930, 1, 1, 12, 0, 0);
    Assert.assertEquals(calc.getDeltaT(jd1), 24.1329000, 1.0);

    jd1 = new JulianDate(1957, 1, 1, 12, 0, 0);
    Assert.assertEquals(calc.getDeltaT(jd1), 31.84336781, 1.0);

    jd1 = new JulianDate(1964, 1, 1, 12, 0, 0);
    Assert.assertEquals(calc.getDeltaT(jd1), 35.10137583, 1.0);

    jd1 = new JulianDate(1997, 1, 1, 12, 0, 0);
    Assert.assertEquals(calc.getDeltaT(jd1), 62.31352058, 1.0);

    jd1 = new JulianDate(2019, 1, 1, 12, 0, 0);
    Assert.assertEquals(calc.getDeltaT(jd1), 69.1416080, 4.0);

    jd1 = new JulianDate(2060, 1, 1, 12, 0, 0);
    Assert.assertEquals(calc.getDeltaT(jd1), 113.0, 1.0);

    jd1 = new JulianDate(2200, 1, 1, 12, 0, 0);
    Assert.assertEquals(calc.getDeltaT(jd1), 442.08, 1.0);


  }
}