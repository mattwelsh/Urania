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

package com.mattwelsh.astronomy.object.VSOP87b;


import com.mattwelsh.astronomy.time.JulianDate;
import org.junit.Assert;
import org.junit.Test;

public class MarsComputerTest {
  @Test
  public void TestLBRCoords() {

    JulianDate jd = new JulianDate(2000, 1, 1, 12, 0, 0);
    MarsComputer comp = new MarsComputer(jd);
    Assert.assertEquals(comp.getHeliocentricLongitude(), 6.2735389872, 0.0000000001);
    Assert.assertEquals(comp.getHeliocentricLatitude(), -0.0247779824, 0.0000000001);
    Assert.assertEquals(comp.getRadiusVector(), 1.3912076937, 0.0000000001);

    jd = new JulianDate(1899, 12, 31, 12, 0, 0);
    comp = new MarsComputer(jd);
    Assert.assertEquals(comp.getHeliocentricLongitude(), 5.0185792656, 0.0000000001);
    Assert.assertEquals(comp.getHeliocentricLatitude(), -0.0274073500, 0.0000000001);
    Assert.assertEquals(comp.getRadiusVector(), 1.4218777718, 0.0000000001);

    jd = new JulianDate(1799, 12, 30, 12, 0, 0);
    comp = new MarsComputer(jd);
    Assert.assertEquals(comp.getHeliocentricLongitude(), 3.9199284825, 0.0000000001);
    Assert.assertEquals(comp.getHeliocentricLatitude(), 0.0031513365, 0.0000000001);
    Assert.assertEquals(comp.getRadiusVector(), 1.5615140022, 0.0000000001);

  }
}