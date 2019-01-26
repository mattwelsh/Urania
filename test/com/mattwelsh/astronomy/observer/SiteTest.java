package com.mattwelsh.astronomy.observer;

import org.junit.Before;
import org.junit.Test;

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