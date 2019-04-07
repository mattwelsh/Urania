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

public class UranusComputerTest {

  @Test
  public void TestRectangularCoords() {

    JulianDate jd = new JulianDate(2000, 1, 1, 12, 0, 0);
    UranusComputer comp = new UranusComputer(jd);
    Assert.assertEquals(comp.getRectX(), 14.4318934159, 0.0000000001);
    Assert.assertEquals(comp.getRectY(), -13.7343162527, 0.0000000001);
    Assert.assertEquals(comp.getRectZ(), -0.2381421963, 0.0000000001);

    jd = new JulianDate(1899, 12, 31, 12, 0, 0);
    comp = new UranusComputer(jd);
    Assert.assertEquals(comp.getRectX(), -6.4810833337, 0.0000000001);
    Assert.assertEquals(comp.getRectY(), -17.8526893406, 0.0000000001);
    Assert.assertEquals(comp.getRectZ(), 0.0177935238, 0.0000000001);

    jd = new JulianDate(1799, 12, 30, 12, 0, 0);
    comp = new UranusComputer(jd);
    Assert.assertEquals(comp.getRectX(), -18.2708335178, 0.0000000001);
    Assert.assertEquals(comp.getRectY(), 0.9877655715, 0.0000000001);
    Assert.assertEquals(comp.getRectZ(), 0.2420344280, 0.0000000001);
  }
}