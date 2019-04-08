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
    //System.out.println("\nRadians: " + Utilities.reduceTo2pi(2*Math.PI));

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
  public void reduceToRange360() {}

  @Test
  public void reduceToRange24() {}

  @Test
  public void reduceToRange90() {}
}