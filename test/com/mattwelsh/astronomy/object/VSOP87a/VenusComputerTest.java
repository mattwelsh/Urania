/*
 *  Copyright (C) 2019-2025 by Matt Welsh
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

public class VenusComputerTest {

  @Test
  public void TestRectangularCoords() {

    JulianDate jd = new JulianDate(2000, 1, 1, 12, 0, 0);
    VenusComputer comp = new VenusComputer(jd);
    Assert.assertEquals(comp.getRectX(), -0.7183022797, 0.0000000001);
    Assert.assertEquals(comp.getRectY(), -0.0326546017, 0.0000000001);
    Assert.assertEquals(comp.getRectZ(), 0.0410142975, 0.0000000001);

    jd = new JulianDate(1899, 12, 31, 12, 0, 0);
    comp = new VenusComputer(jd);
    Assert.assertEquals(comp.getRectX(), 0.6971428331, 0.0000000001);
    Assert.assertEquals(comp.getRectY(), -0.2033631151, 0.0000000001);
    Assert.assertEquals(comp.getRectZ(), -0.0430201136, 0.0000000001);

    jd = new JulianDate(1799, 12, 30, 12, 0, 0);
    comp = new VenusComputer(jd);
    Assert.assertEquals(comp.getRectX(), -0.5983535208, 0.0000000001);
    Assert.assertEquals(comp.getRectY(), 0.3958502156, 0.0000000001);
    Assert.assertEquals(comp.getRectZ(), 0.0398238141, 0.0000000001);
  }
}