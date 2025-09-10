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
package com.mattwelsh.astronomy.coordinates;

import org.junit.Test;
import org.junit.Assert;

public class RightAscensionTest {

  @Test
  public void generalInitializations() {
    RightAscension coord1 = new RightAscension(134.6884685486162);
    Assert.assertEquals(coord1.getHour(),8);
    Assert.assertEquals(coord1.getMinutes(),58);
    Assert.assertEquals(coord1.getSeconds(),45.2, 0.9);
    Assert.assertEquals(coord1.getDecimalDegrees(), 134.6884685486162, 0.0);
    Assert.assertEquals(coord1.getDecimalHours(), 8.979231236574413, 0.0);

    coord1 = new RightAscension(138.73250);
    Assert.assertEquals(coord1.getHour(),9);
    Assert.assertEquals(coord1.getMinutes(),14);
    Assert.assertEquals(coord1.getSeconds(),55.7, 0.9);
    Assert.assertEquals(coord1.getDecimalDegrees(), 138.73250, 0.0);
    Assert.assertEquals(coord1.getDecimalHours(), 9.248833333333333, 0.0001);

    coord1 = new RightAscension(232.93231);
    Assert.assertEquals(coord1.getHour(),15);
    Assert.assertEquals(coord1.getMinutes(),31);
    Assert.assertEquals(coord1.getSeconds(),43.8, 0.9);
    Assert.assertEquals(coord1.getDecimalDegrees(), 232.93231, 0.0);
    Assert.assertEquals(coord1.getDecimalHours(), 15.528820666666667, 0.0001);

    coord1 = new RightAscension(198.378178);
    Assert.assertEquals(coord1.getHour(),13);
    Assert.assertEquals(coord1.getMinutes(),13);
    Assert.assertEquals(coord1.getSeconds(),30.7, 0.9);
    Assert.assertEquals(coord1.getDecimalDegrees(), 198.378178, 0.0);
    Assert.assertEquals(coord1.getDecimalHours(), 13.225211866666667, 0.0001);

    coord1 = new RightAscension(158.558965);
    Assert.assertEquals(coord1.getHour(),10);
    Assert.assertEquals(coord1.getMinutes(),34);
    Assert.assertEquals(coord1.getSeconds(),14.2, 0.9);
    Assert.assertEquals(coord1.getDecimalDegrees(), 158.558965, 0.0);
    Assert.assertEquals(coord1.getDecimalHours(), 10.570597666666667, 0.0001);

    RightAscension coord12 = new RightAscension(675.0);
    Assert.assertEquals(coord12.getHour(), 21);

  }

  @Test
  public void setDecimalDegrees() {
    RightAscension coord1 = new RightAscension(134.6884685486162);
    Assert.assertEquals(coord1.getHour(),8);
    Assert.assertEquals(coord1.getMinutes(),58);
    Assert.assertEquals(coord1.getSeconds(),45.2, 0.9);
    Assert.assertEquals(coord1.getDecimalDegrees(), 134.6884685486162, 0.0);
    Assert.assertEquals(coord1.getDecimalHours(), 8.979231236574413, 0.0);

    coord1.setDecimalDegrees(138.73250);
    Assert.assertEquals(coord1.getHour(),9);
    Assert.assertEquals(coord1.getMinutes(),14);
    Assert.assertEquals(coord1.getSeconds(),55.7, 0.9);
    Assert.assertEquals(coord1.getDecimalDegrees(), 138.73250, 0.0);
    Assert.assertEquals(coord1.getDecimalHours(), 9.248833333333333, 0.0001);

    coord1.setDecimalDegrees(158.558965);
    Assert.assertEquals(coord1.getHour(),10);
    Assert.assertEquals(coord1.getMinutes(),34);
    Assert.assertEquals(coord1.getSeconds(),14.2, 0.9);
    Assert.assertEquals(coord1.getDecimalDegrees(), 158.558965, 0.0);
    Assert.assertEquals(coord1.getDecimalHours(), 10.570597666666667, 0.0001);
  }

  @Test
  public void setDecimalHours() {
    RightAscension coord1 = new RightAscension(134.6884685486162);
    Assert.assertEquals(coord1.getHour(),8);
    Assert.assertEquals(coord1.getMinutes(),58);
    Assert.assertEquals(coord1.getSeconds(),45.2, 0.9);
    Assert.assertEquals(coord1.getDecimalDegrees(), 134.6884685486162, 0.0);
    Assert.assertEquals(coord1.getDecimalHours(), 8.979231236574413, 0.0);

    coord1.setDecimalHours(9.248833333333333);
    Assert.assertEquals(coord1.getHour(),9);
    Assert.assertEquals(coord1.getMinutes(),14);
    Assert.assertEquals(coord1.getSeconds(),55.7, 0.9);
    Assert.assertEquals(coord1.getDecimalDegrees(), 138.73250, 0.001);
    Assert.assertEquals(coord1.getDecimalHours(), 9.248833333333333, 0.0001);

    coord1.setDecimalHours(10.570597666666667);
    Assert.assertEquals(coord1.getHour(),10);
    Assert.assertEquals(coord1.getMinutes(),34);
    Assert.assertEquals(coord1.getSeconds(),14.2, 0.9);
    Assert.assertEquals(coord1.getDecimalDegrees(), 158.558965, 0.001);
    Assert.assertEquals(coord1.getDecimalHours(), 10.570597666666667, 0.0001);
  }
}