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

package com.mattwelsh.astronomy.utilities;

import org.junit.Assert;
import org.junit.Test;

public class UtilitiesTest {

  @Test
  public void reduceTo2pi() {

    Assert.assertEquals(Utilities.reduceTo2pi(Math.PI), Math.PI, 0.0000000000);
    Assert.assertEquals(Utilities.reduceTo2pi(Math.PI / 2.0), Math.PI/2.0, 0.0000000000);
    Assert.assertEquals(Utilities.reduceTo2pi(3*Math.PI), Math.PI, 0.0000000000);
    Assert.assertEquals(Utilities.reduceTo2pi(4*Math.PI), 0.0, 0.0000000000);
    Assert.assertEquals(Utilities.reduceTo2pi(-1*Math.PI), Math.PI, 0.0000000000);
    Assert.assertEquals(Utilities.reduceTo2pi(-2*Math.PI), 0.0, 0.0000000000);
    Assert.assertEquals(Utilities.reduceTo2pi(-3*Math.PI), Math.PI, 0.0000000000);
    Assert.assertEquals(Utilities.reduceTo2pi(-4*Math.PI), 0.0, 0.0000000000);
    Assert.assertEquals(Utilities.reduceTo2pi(-5*Math.PI), Math.PI, 0.0000000000);
    Assert.assertEquals(Utilities.reduceTo2pi(-6*Math.PI), 0.0, 0.0000000000);

  }

  @Test
  public void reduceToRange360() {
    Assert.assertEquals(Utilities.reduceToRange360(90), 90, 0.0000000000);
    Assert.assertEquals(Utilities.reduceToRange360(180), 180, 0.0000000000);
    Assert.assertEquals(Utilities.reduceToRange360(270), 270, 0.0000000000);
    Assert.assertEquals(Utilities.reduceToRange360(361), 1, 0.0000000000);
    Assert.assertEquals(Utilities.reduceToRange360(450), 90, 0.0000000000);
    Assert.assertEquals(Utilities.reduceToRange360(3600), 0, 0.0000000000);
    Assert.assertEquals(Utilities.reduceToRange360(-90), 270, 0.0000000000);
    Assert.assertEquals(Utilities.reduceToRange360(-180), 180, 0.0000000000);
    Assert.assertEquals(Utilities.reduceToRange360(-3600), 0, 0.0000000000);
  }

  @Test
  public void reduceToRange24() {
    Assert.assertEquals(Utilities.reduceToRange24(0), 0, 0.0000000000);
    Assert.assertEquals(Utilities.reduceToRange24(3), 3, 0.0000000000);
    Assert.assertEquals(Utilities.reduceToRange24(6), 6, 0.0000000000);
    Assert.assertEquals(Utilities.reduceToRange24(9), 9, 0.0000000000);
    Assert.assertEquals(Utilities.reduceToRange24(12), 12, 0.0000000000);
    Assert.assertEquals(Utilities.reduceToRange24(16), 16, 0.0000000000);
    Assert.assertEquals(Utilities.reduceToRange24(19), 19, 0.0000000000);
    Assert.assertEquals(Utilities.reduceToRange24(23), 23, 0.0000000000);
    Assert.assertEquals(Utilities.reduceToRange24(24), 0, 0.0000000000);
    Assert.assertEquals(Utilities.reduceToRange24(27), 3, 0.0000000000);
    Assert.assertEquals(Utilities.reduceToRange24(48), 0, 0.0000000000);
    Assert.assertEquals(Utilities.reduceToRange24(480), 0, 0.0000000000);
    Assert.assertEquals(Utilities.reduceToRange24(-48), 0, 0.0000000000);

  }

  @Test
  public void reduceToRange90() {
    Assert.assertEquals(Utilities.reduceToRange90(0), 0, 0.0000000000);
    Assert.assertEquals(Utilities.reduceToRange90(90), 90, 0.0000000000);
    Assert.assertEquals(Utilities.reduceToRange90(-90), -90, 0.0000000000);
    Assert.assertEquals(Utilities.reduceToRange90(100), 80, 0.0000000000);
    Assert.assertEquals(Utilities.reduceToRange90(-100), -80, 0.0000000000);
  }
}