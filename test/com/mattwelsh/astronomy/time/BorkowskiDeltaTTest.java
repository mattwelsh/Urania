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


import com.mattwelsh.util.JulianDate;
import org.junit.Test;

public class BorkowskiDeltaTTest {

  @Test
  public void getDeltaT() {
    DeltaTCalculator calc = DynamicalTime.BORKOWSKI.getCalculator();

    JulianDate jd2 = new JulianDate(1000, 0, 0, 12, 0, 0);
    JulianDate jd3 = new JulianDate(1500, 0, 0, 12, 0, 0);
    JulianDate jd4 = new JulianDate(1, 0, 0, 12, 0, 0);

    org.junit.Assert.assertEquals(calc.getDeltaT(jd2), 1407.0, 0.9);
    org.junit.Assert.assertEquals(calc.getDeltaT(jd3), 94.8, 0.1);
    org.junit.Assert.assertEquals(calc.getDeltaT(jd4), 9270.6, 12.0);


  }
}