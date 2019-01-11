/*
 * Copyright (C) 2019 by Matt Welsh
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

import static org.junit.Assert.*;

import org.junit.Test;

public class RightAscensionTest {

  @Test
  public void setHour() {
    RightAscension coord1 = new RightAscension(0.0);
    org.junit.Assert.assertEquals(coord1.getHour(), 0);
    coord1.setHour(3);
    org.junit.Assert.assertEquals(coord1.getHour(), 3);
    org.junit.Assert.assertEquals(coord1.getDecimalDegrees(), 45.0, 0.0);

    coord1.setDecimalDegrees(225.0);
    org.junit.Assert.assertEquals(coord1.getHour(), 15);
    org.junit.Assert.assertEquals(coord1.getDecimalDegrees(), 225.0, 0.0);

    coord1.setDecimalDegrees(540.0);
    org.junit.Assert.assertEquals(coord1.getHour(), 12);
    org.junit.Assert.assertEquals(coord1.getDecimalDegrees(), 180.0, 0.0);

    coord1.setDecimalDegrees(-180.0);
    org.junit.Assert.assertEquals(coord1.getHour(), 12);
    org.junit.Assert.assertEquals(coord1.getDecimalDegrees(), 180.0, 0.0);


  }

  @Test
  public void getHour() {

    RightAscension coord1 = new RightAscension(0.0);
    RightAscension coord3 = new RightAscension(45.0);
    RightAscension coord4 = new RightAscension(90.0);
    RightAscension coord5 = new RightAscension(135.0);
    RightAscension coord7 = new RightAscension(180.0);
    RightAscension coord8 = new RightAscension(225.0);
    RightAscension coord10 = new RightAscension(270.0);
    RightAscension coord12 = new RightAscension(315.0);

    org.junit.Assert.assertEquals(coord1.getHour(), 0);
    org.junit.Assert.assertEquals(coord3.getHour(), 3);
    org.junit.Assert.assertEquals(coord4.getHour(), 6);
    org.junit.Assert.assertEquals(coord5.getHour(), 9);
    org.junit.Assert.assertEquals(coord7.getHour(), 12);
    org.junit.Assert.assertEquals(coord8.getHour(), 15);
    org.junit.Assert.assertEquals(coord10.getHour(), 18);
    org.junit.Assert.assertEquals(coord12.getHour(), 21);
  }
}