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

package com.mattwelsh.astronomy.time;

import com.mattwelsh.astronomy.event.JulianDateChangedEvent;
import com.mattwelsh.astronomy.event.JulianDateChangedListener;
import org.junit.Test;
import org.junit.Assert;

/**
 * Unit tests for MutableJulianDateTest object.
 *
 * @author Matt Welsh
 * @version 1.0
 * @since 1.0
 */
public class MutableJulianDateTest {

  private boolean dateChangedEventFired = false;

  @Test
  public void setJulianDayNumber() {

    MutableJulianDate jdn1 =
        new MutableJulianDate(2000, 1, 1, 12, 0, 0);
    Assert.assertEquals(jdn1.getJulianDayNumber(), 2451545.0, 0);

    jdn1.addDateChangedListener(
        evt -> {
          setDateChangedEventFired();
        });

    jdn1.setJulianDate(1999, 1, 1, 0, 0, 0);
    Assert.assertEquals(jdn1.getJulianDayNumber(), 2451179.5, 0);
    Assert.assertTrue(dateChangedEventFired);

    jdn1 = new MutableJulianDate(2451545.0);
    Assert.assertEquals(jdn1.getJulianDayNumber(), 2451545.0, 0);
  }

  @Test
  public void setJulianDate() {
    MutableJulianDate jdn1 =
        new MutableJulianDate(2000, 1, 1, 12, 0, 0);
    Assert.assertEquals(jdn1.getJulianDayNumber(), 2451545.0, 0);
    jdn1.addDateChangedListener(
        evt -> {
          setDateChangedEventFired();
        });
    jdn1.setJulianDayNumber(2451545.0);
    Assert.assertTrue(dateChangedEventFired);
  }

  @Test
  public void addDateChangedListener() {
    MutableJulianDate jdn1 =
        new MutableJulianDate(2000, 1, 1, 12, 0, 0);
    Assert.assertEquals(jdn1.getJulianDayNumber(), 2451545.0, 0);
    jdn1.addDateChangedListener(
        evt -> {
          setDateChangedEventFired();
        });
    Assert.assertEquals(jdn1.listeners.size(), 1, 0);
  }

  @Test
  public void removeDateChangedListener() {
    MutableJulianDate jdn1 =
        new MutableJulianDate(2000, 1, 1, 12, 0, 0);
    Assert.assertEquals(jdn1.getJulianDayNumber(), 2451545.0, 0);
    JulianDateChanged jDC = new JulianDateChanged();
    jdn1.addDateChangedListener(jDC);
    Assert.assertEquals(jdn1.listeners.size(), 1, 0);
    jdn1.removeDateChangedListener(jDC);
    Assert.assertNull(jdn1.listeners);
    // Should gracefully do nothing
    jdn1.removeDateChangedListener(jDC);

  }

  // -----------------------------------------------------------------------------------------------
  // Protected, private and package local methods
  // -----------------------------------------------------------------------------------------------
  private void setDateChangedEventFired() {
    dateChangedEventFired = true;
  }
}

class JulianDateChanged implements JulianDateChangedListener {
  @Override
  public void julianDateChanged(JulianDateChangedEvent evt) {}
}
