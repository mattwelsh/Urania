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

public class RaDecTest {

  @Test
  public void getRightAscension() {
    RightAscension ra = new RightAscension(6.5);
    Declination dec = new Declination(43.868);
    RaDec raDec = new RaDec(ra, dec);
    org.junit.Assert.assertEquals(ra, raDec.getRightAscension());
  }

  @Test
  public void getDeclination() {
    RightAscension ra = new RightAscension(6.5);
    Declination dec = new Declination(43.868);
    RaDec raDec = new RaDec(ra, dec);
    org.junit.Assert.assertEquals(dec, raDec.getDeclination());
  }
}