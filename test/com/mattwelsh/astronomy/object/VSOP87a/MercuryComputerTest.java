/*
 *  Copyright (C) 2019 by Matt Welsh
 *  This library is free software; you can redistribute it and/or modify it under the terms of the
 *  GNU Lesser General Public License as published by the Free Software Foundation; either version
 *  2.1 of the License, or any later version.
 *
 *  This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *  See the GNU General Public License for more details. You should have received a copy of the GNU
 *  Lesser General Public License along with this library; if not, write to the Free Software
 *  Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
 */

package com.mattwelsh.astronomy.object.VSOP87a;

import com.mattwelsh.astronomy.time.JulianDate;
import org.junit.Assert;
import org.junit.Test;

public class MercuryComputerTest {

  @Test
  public void TestRectangularCoords() {

    JulianDate jd = new JulianDate(2000, 1, 1, 12, 0, 0);
    MercuryComputer comp = new MercuryComputer(jd);
    Assert.assertEquals(comp.getRectX(), -0.1300934115, 0.0000000001);
    Assert.assertEquals(comp.getRectY(), -0.4472876716, 0.0000000001);
    Assert.assertEquals(comp.getRectZ(), -0.0245983802, 0.0000000001);

    jd = new JulianDate(1899, 12, 31, 12, 0, 0);
    comp = new MercuryComputer(jd);
    Assert.assertEquals(comp.getRectX(), -0.3897246931, 0.0000000001);
    Assert.assertEquals(comp.getRectY(), -0.1502242199, 0.0000000001);
    Assert.assertEquals(comp.getRectZ(), 0.0236199373, 0.0000000001);

    jd = new JulianDate(1799, 12, 30, 12, 0, 0);
    comp = new MercuryComputer(jd);
    Assert.assertEquals(comp.getRectX(), -0.1683565237, 0.0000000001);
    Assert.assertEquals(comp.getRectY(), 0.2735108157, 0.0000000001);
    Assert.assertEquals(comp.getRectZ(), 0.0378103630, 0.0000000001);
  }
}