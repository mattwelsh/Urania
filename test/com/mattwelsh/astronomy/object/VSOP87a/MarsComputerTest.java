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

public class MarsComputerTest {

  @Test
  public void TestRectangularCoords() {

    JulianDate jd = new JulianDate(2000, 1, 1, 12, 0, 0);
    MarsComputer comp = new MarsComputer(jd);
    Assert.assertEquals(comp.getRectX(), 1.3907159264, 0.0000000001);
    Assert.assertEquals(comp.getRectY(), -0.0134157043, 0.0000000001);
    Assert.assertEquals(comp.getRectZ(), -0.0344677967, 0.0000000001);

    jd = new JulianDate(1899, 12, 31, 12, 0, 0);
    comp = new MarsComputer(jd);
    Assert.assertEquals(comp.getRectX(), 0.4284332474, 0.0000000001);
    Assert.assertEquals(comp.getRectY(), -1.3552354250, 0.0000000001);
    Assert.assertEquals(comp.getRectZ(), -0.0389650205, 0.0000000001);

    jd = new JulianDate(1799, 12, 30, 12, 0, 0);
    comp = new MarsComputer(jd);
    Assert.assertEquals(comp.getRectX(), -1.1119219621, 0.0000000001);
    Assert.assertEquals(comp.getRectY(), -1.0963263014, 0.0000000001);
    Assert.assertEquals(comp.getRectZ(), 0.0049208507, 0.0000000001);
  }
}