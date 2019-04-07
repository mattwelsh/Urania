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

import com.mattwelsh.astronomy.coordinates.Declination;
import com.mattwelsh.astronomy.coordinates.RightAscension;
import com.mattwelsh.astronomy.coordinates.SimpleCoordinate;
import com.mattwelsh.astronomy.time.JulianDate;
import com.mattwelsh.astronomy.utilities.Utilities;
import org.junit.Assert;
import org.junit.Test;

public class JupiterComputerTest {

  @Test
  public void TestRectangularCoords() {

    JulianDate jd = new JulianDate(2000, 1, 1, 12, 0, 0);
    JupiterComputer comp = new JupiterComputer(jd);
    Assert.assertEquals(comp.getRectX(), 4.0011740268, 0.0000000001);
    Assert.assertEquals(comp.getRectY(), 2.9385810077, 0.0000000001);
    Assert.assertEquals(comp.getRectZ(), -0.1017837501, 0.0000000001);

    jd = new JulianDate(1899, 12, 31, 12, 0, 0);
    comp = new JupiterComputer(jd);
    Assert.assertEquals(comp.getRectX(), -3.0191224350, 0.0000000001);
    Assert.assertEquals(comp.getRectY(), -4.4582563705, 0.0000000001);
    Assert.assertEquals(comp.getRectZ(), 0.0858641900, 0.0000000001);

    jd = new JulianDate(1799, 12, 30, 12, 0, 0);
    comp = new JupiterComputer(jd);
    Assert.assertEquals(comp.getRectX(), -0.0180390004, 0.0000000001);
    Assert.assertEquals(comp.getRectY(), 5.1317748839, 0.0000000001);
    Assert.assertEquals(comp.getRectZ(), -0.0200448490, 0.0000000001);

  }
}