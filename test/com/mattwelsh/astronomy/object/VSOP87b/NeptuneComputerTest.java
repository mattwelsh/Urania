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

public class NeptuneComputerTest {
  @Test
  public void TestLBRCoords() {

    JulianDate jd = new JulianDate(2000, 1, 1, 12, 0, 0);
    NeptuneComputer comp = new NeptuneComputer(jd);
    Assert.assertEquals(comp.getHeliocentricLongitude(), 5.3045629284, 0.0000000001);
    Assert.assertEquals(comp.getHeliocentricLatitude(), 0.0042236790, 0.0000000001);
    Assert.assertEquals(comp.getRadiusVector(), 30.1205329332, 0.0000000001);

    jd = new JulianDate(1899, 12, 31, 12, 0, 0);
    comp = new NeptuneComputer(jd);
    Assert.assertEquals(comp.getHeliocentricLongitude(), 1.5199957208, 0.0000000001);
    Assert.assertEquals(comp.getHeliocentricLatitude(), -0.0217331273, 0.0000000001);
    Assert.assertEquals(comp.getRadiusVector(), 29.8710344515, 0.0000000001);

    jd = new JulianDate(1799, 12, 30, 12, 0, 0);
    comp = new NeptuneComputer(jd);
    Assert.assertEquals(comp.getHeliocentricLongitude(), 3.9778043127, 0.0000000001);
    Assert.assertEquals(comp.getHeliocentricLatitude(), 0.0307068993, 0.0000000001);
    Assert.assertEquals(comp.getRadiusVector(), 30.3209191027, 0.0000000001);
  }
}