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

package com.mattwelsh.astronomy.object;

import com.mattwelsh.astronomy.coordinates.RaDec;
import com.mattwelsh.astronomy.time.JulianDate;
import org.junit.Test;
import org.junit.Assert;

public class MoonTest {

  @Test
  public void getObjectName() {
    Moon moon = new Moon(new JulianDate());
    Assert.assertEquals(moon.getObjectName(), "Moon");
  }

  @Test
  public void calculateCircumstances() {
    Moon moon = new Moon(new JulianDate(2448724.5));
    RaDec raDec = moon.getRaDec();
    Assert.assertEquals(raDec.getRightAscension().getDecimalHours(), 8.979231333333333, 0.000001);
    Assert.assertEquals(raDec.getRightAscension().getHour(), 8);
    Assert.assertEquals(raDec.getRightAscension().getMinutes(), 58);
    Assert.assertEquals(raDec.getRightAscension().getSeconds(), 45.1, 0.5);
    Assert.assertEquals(raDec.getRightAscension().getDecimalDegrees(), 134.688470, 0.000005);

    Assert.assertEquals(raDec.getDeclination().getDecimalDegrees(), 13.768368, 0.000005);
    Assert.assertEquals(raDec.getDeclination().getIntegerDegrees(), 13);
    Assert.assertEquals(raDec.getDeclination().getMinutes(), 46);
    Assert.assertEquals(raDec.getDeclination().getSeconds(), 6, 0.5);
    Assert.assertEquals(moon.getDistance(), 368405.6, 10.0);

    Assert.assertEquals(moon.getComputer().getMeanLongitude(), 134.290182, 0.000001);
    Assert.assertEquals(moon.getComputer().getMeanElongation(), 113.842304, 0.000001);
    Assert.assertEquals(moon.getComputer().getMeanAnomaly(), 5.150833, 0.000001);
    Assert.assertEquals(moon.getComputer().getArgumentOfLatitude(), 219.889721, 0.000001);
    Assert.assertEquals(moon.getComputer().getApparentLongitude(), 133.167265, 0.000001);
  }
}