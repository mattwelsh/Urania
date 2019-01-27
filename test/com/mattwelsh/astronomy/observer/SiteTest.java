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
package com.mattwelsh.astronomy.observer;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for Site object using examples from Jean Meeus
 *
 * @author Matt Welsh
 * @version 1.0
 * @since 1.0
 */
public class SiteTest {

  private Site siteOne;

  @Before
  public void setUp() throws Exception {
    siteOne = new Site("Palomar", 33.356111, 0.0, 1706.0);
  }

  @Test
  public void getGeographicalLatitude() {
    org.junit.Assert.assertEquals(siteOne.getGeographicalLatitude(), 33.356111, 0.0);
  }

  @Test
  public void getLongitude() {
    org.junit.Assert.assertEquals(siteOne.getLongitude(), 0.0, 0.0);
  }

  @Test
  public void getAltitude() {
    org.junit.Assert.assertEquals(siteOne.getAltitude(), 1706.0, 0.0);
  }

  @Test
  public void getGeocentricLatitude() {
    org.junit.Assert.assertEquals(siteOne.getGeocentricLatitude(), 33.17959610990454, 0.0);
  }

  @Test
  public void getRhoSinPhiPrime() {
    org.junit.Assert.assertEquals(siteOne.getRhoSinPhiPrime(), 0.5468607803375676, 0.0);
  }

  @Test
  public void getRhoCosPhiPrime() {
    org.junit.Assert.assertEquals(siteOne.getRhoCosPhiPrime(), 0.8363392448202929, 0.0);
  }

  @Test
  public void getSiteName() {
    org.junit.Assert.assertEquals(siteOne.getSiteName(), "Palomar");
  }
}