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
import org.junit.Test;

/**
 * Unit tests for Declination object using example dates from Jean Meeus
 *
 * @author Matt Welsh
 * @version 1.0
 * @since 1.0
 */
public class DeclinationTest {

  private Declination coord1 = new Declination(0.0);
  private Declination coord2 = new Declination(12.31528);
  private Declination coord3 = new Declination(45.0);
  private Declination coord4 = new Declination(90.0);
  private Declination coord5 = new Declination(135.0);
  private Declination coord6 = new Declination(157.9103);
  private Declination coord7 = new Declination(180.0);
  private Declination coord8 = new Declination(225.0);
  private Declination coord9 = new Declination(241.23917);
  private Declination coord10 = new Declination(270.0);
  private Declination coord11 = new Declination(281.6754);
  private Declination coord12 = new Declination(315.0);
  private Declination coord13 = new Declination(359.99991);
  private Declination coord14 = new Declination(2205.0);
  private Declination coord15 = new Declination(-517.9103);

  @Test
  public void getDecimalDegrees() {
    org.junit.Assert.assertEquals(coord1.getDecimalDegrees(), 0, 0.001);
    org.junit.Assert.assertEquals(coord2.getDecimalDegrees(), 12.31528, 0.001);
    org.junit.Assert.assertEquals(coord3.getDecimalDegrees(), 45, 0.001);
    org.junit.Assert.assertEquals(coord4.getDecimalDegrees(), 90, 0.001);
    org.junit.Assert.assertEquals(coord5.getDecimalDegrees(), 45, 0.001);
    org.junit.Assert.assertEquals(coord6.getDecimalDegrees(), 22.0897, 0.001);
    org.junit.Assert.assertEquals(coord7.getDecimalDegrees(), 0, 0.001);
    org.junit.Assert.assertEquals(coord8.getDecimalDegrees(), -45, 0.001);
    org.junit.Assert.assertEquals(coord9.getDecimalDegrees(), -61.23917, 0.001);
    org.junit.Assert.assertEquals(coord10.getDecimalDegrees(), -90, 0.001);
    org.junit.Assert.assertEquals(coord11.getDecimalDegrees(), -78.3246, 0.001);
    org.junit.Assert.assertEquals(coord12.getDecimalDegrees(), -45, 0.001);
    org.junit.Assert.assertEquals(coord13.getDecimalDegrees(), 0, 0.001);
    org.junit.Assert.assertEquals(coord14.getDecimalDegrees(), 45, 0.001);
    org.junit.Assert.assertEquals(coord15.getDecimalDegrees(), -22.0897, 0.001);
  }


  @Test
  public void getIntegerDegrees() {
    org.junit.Assert.assertEquals(coord1.getIntegerDegrees(), 0, 0);
    org.junit.Assert.assertEquals(coord2.getIntegerDegrees(), 12, 0);
    org.junit.Assert.assertEquals(coord3.getIntegerDegrees(), 45, 0);
    org.junit.Assert.assertEquals(coord4.getIntegerDegrees(), 90, 0);
    org.junit.Assert.assertEquals(coord5.getIntegerDegrees(), 45, 0);
    org.junit.Assert.assertEquals(coord6.getIntegerDegrees(), 22, 0);
    org.junit.Assert.assertEquals(coord7.getIntegerDegrees(), 0, 0);
    org.junit.Assert.assertEquals(coord8.getIntegerDegrees(), -45, 0);
    org.junit.Assert.assertEquals(coord9.getIntegerDegrees(), -61, 0);
    org.junit.Assert.assertEquals(coord10.getIntegerDegrees(), -90, 0);
    org.junit.Assert.assertEquals(coord11.getIntegerDegrees(), -78, 0);
    org.junit.Assert.assertEquals(coord12.getIntegerDegrees(), -45, 0);
    org.junit.Assert.assertEquals(coord13.getIntegerDegrees(), 0, 0);
    org.junit.Assert.assertEquals(coord14.getIntegerDegrees(), 45, 0);
    org.junit.Assert.assertEquals(coord15.getIntegerDegrees(), -22, 0);
  }

  @Test
  public void getMinutes() {
    org.junit.Assert.assertEquals(coord1.getMinutes(), 0, 0);
    org.junit.Assert.assertEquals(coord2.getMinutes(), 18, 0);
    org.junit.Assert.assertEquals(coord3.getMinutes(), 0, 0);
    org.junit.Assert.assertEquals(coord4.getMinutes(), 0, 0);
    org.junit.Assert.assertEquals(coord5.getMinutes(), 0, 0);
    org.junit.Assert.assertEquals(coord6.getMinutes(), 5, 0);
    org.junit.Assert.assertEquals(coord7.getMinutes(), 0, 0);
    org.junit.Assert.assertEquals(coord8.getMinutes(), 0, 0);
    org.junit.Assert.assertEquals(coord9.getMinutes(), -14, 0);
    org.junit.Assert.assertEquals(coord10.getMinutes(), 0, 0);
    org.junit.Assert.assertEquals(coord11.getMinutes(), -19, 0);
    org.junit.Assert.assertEquals(coord12.getMinutes(), 0, 0);
    org.junit.Assert.assertEquals(coord13.getMinutes(), 0, 0);
    org.junit.Assert.assertEquals(coord14.getMinutes(), 0, 0);
    org.junit.Assert.assertEquals(coord15.getMinutes(), -5, 0);

  }

  @Test
  public void getSeconds() {
    org.junit.Assert.assertEquals(coord1.getSeconds(), 0, 0);
    org.junit.Assert.assertEquals(coord2.getSeconds(), 55.008, 0.001);
    org.junit.Assert.assertEquals(coord3.getSeconds(), 0.0, 0.001);
    org.junit.Assert.assertEquals(coord4.getSeconds(), 0.0, 0.001);
    org.junit.Assert.assertEquals(coord5.getSeconds(), 0.0, 0.001);
    org.junit.Assert.assertEquals(coord6.getSeconds(), 22.92 , 0.001);
    org.junit.Assert.assertEquals(coord7.getSeconds(), 0.0 , 0.001);
    org.junit.Assert.assertEquals(coord8.getSeconds(), 0.0, 0.001);
    org.junit.Assert.assertEquals(coord9.getSeconds(), -21.012, 0.001);
    org.junit.Assert.assertEquals(coord10.getSeconds(), 0.0, 0.001);
    org.junit.Assert.assertEquals(coord11.getSeconds(), -28.56, 0.001);
    org.junit.Assert.assertEquals(coord12.getSeconds(), 0.0, 0.001);
    org.junit.Assert.assertEquals(coord13.getSeconds(), -0.324, 0.001);
    org.junit.Assert.assertEquals(coord14.getSeconds(), 0.0, 0.001);
    org.junit.Assert.assertEquals(coord15.getSeconds(), -22.92 , 0.001);

  }

  @Test
  public void getRadians() {
    org.junit.Assert.assertEquals(coord1.getRadians(), 0.0, 0.001);
    org.junit.Assert.assertEquals(coord2.getRadians(), 0.214942184304, 0.001);
    org.junit.Assert.assertEquals(coord3.getRadians(), 0.785398, 0.001);
    org.junit.Assert.assertEquals(coord4.getRadians(), 1.5708, 0.001);
    org.junit.Assert.assertEquals(coord5.getRadians(), 0.785398, 0.001);
    org.junit.Assert.assertEquals(coord6.getRadians(), 0.3855379958, 0.001);
    org.junit.Assert.assertEquals(coord7.getRadians(), 0.0, 0.001);
    org.junit.Assert.assertEquals(coord8.getRadians(), -0.785398, 0.001);
    org.junit.Assert.assertEquals(coord9.getRadians(), -1.0688251477, 0.001);
    org.junit.Assert.assertEquals(coord10.getRadians(), -1.5708, 0.001);
    org.junit.Assert.assertEquals(coord11.getRadians(), -1.367022155, 0.001);
    org.junit.Assert.assertEquals(coord12.getRadians(), -0.785398, 0.001);
    org.junit.Assert.assertEquals(coord13.getRadians(), -1.57079633e-6, 0.001);
    org.junit.Assert.assertEquals(coord14.getRadians(), 0.785398, 0.001);
    org.junit.Assert.assertEquals(coord15.getRadians(), -0.385537995, 0.001);
  }

  @Test
  public void setDecimalDegrees() {
    Declination coord = new Declination(12.31528);
    org.junit.Assert.assertEquals(coord.getDecimalDegrees(), 12.31528, 0.001);
    org.junit.Assert.assertEquals(coord.getIntegerDegrees(), 12, 0);
    org.junit.Assert.assertEquals(coord.getMinutes(), 18, 0);
    org.junit.Assert.assertEquals(coord.getSeconds(), 55.008, 0.001);
    org.junit.Assert.assertEquals(coord.getRadians(), 0.214942184304, 0.001);

    coord.setDecimalDegrees(-517.9103);
    org.junit.Assert.assertEquals(coord.getDecimalDegrees(), -22.0897, 0.001);
    org.junit.Assert.assertEquals(coord.getIntegerDegrees(), -22, 0);
    org.junit.Assert.assertEquals(coord.getMinutes(), -5, 0);
    org.junit.Assert.assertEquals(coord.getSeconds(), -22.92 , 0.001);
    org.junit.Assert.assertEquals(coord.getRadians(), -0.385537995, 0.001);
  }
}