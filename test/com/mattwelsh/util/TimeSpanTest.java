/*
 * Copyright (C) 2017-2019 by Matt Welsh
 * This library is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or any later version.
 *
 * This library is distributed in the
 * hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details. You should have received a copy of the GNU Lesser General Public License along
 * with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street,
 * Fifth Floor, Boston, MA 02110-1301 USA
 */

package com.mattwelsh.util;

import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for Time Span Class
 *
 * @author Matt Welsh
 * @version 1.0
 * @since 1.0
 */
public class TimeSpanTest {

  @Before
  public void setUp() throws Exception {}

  @After
  public void tearDown() throws Exception {}

  @Test
  public void getStartDateGregorian() throws Exception {
    GregorianCalendar cal1 = new GregorianCalendar(2001, 5, 1);
    TimeSpan span2 = new TimeSpan(cal1, new GregorianCalendar(2001, 5, 18));
    Assert.assertEquals(span2.getStartDateGregorian(), cal1);

    cal1 = new GregorianCalendar(1964, 5, 1);
    span2 = new TimeSpan(cal1, new GregorianCalendar(2014, 6, 18));
    Assert.assertEquals(span2.getStartDateGregorian(), cal1);

    cal1 = new GregorianCalendar(2014, 1, 1);
    span2 = new TimeSpan(cal1, new GregorianCalendar(2014, 6, 18));
    Assert.assertEquals(span2.getStartDateGregorian(), cal1);

    cal1 = new GregorianCalendar();
    span2 = new TimeSpan(cal1, new GregorianCalendar(2014, 6, 18));
    Assert.assertEquals(span2.getStartDateGregorian(), cal1);
  }

  @Test
  public void getEndDateGregorian() throws Exception {
    GregorianCalendar cal1 = new GregorianCalendar(2001, 5, 1);
    TimeSpan span2 = new TimeSpan(new GregorianCalendar(2001, 5, 18), cal1);
    Assert.assertEquals(span2.getEndDateGregorian(), cal1);

    cal1 = new GregorianCalendar(1964, 5, 1);
    span2 = new TimeSpan(new GregorianCalendar(2014, 6, 18), cal1);
    Assert.assertEquals(span2.getEndDateGregorian(), cal1);

    cal1 = new GregorianCalendar(2014, 6, 18);
    span2 = new TimeSpan(new GregorianCalendar(2014, 1, 1), new GregorianCalendar(2014, 6, 18));
    Assert.assertEquals(span2.getEndDateGregorian(), cal1);

    cal1 = new GregorianCalendar(2014, 1, 2);
    span2 = new TimeSpan(new GregorianCalendar(2014, 1, 1), 1.0);
    Assert.assertEquals(span2.getEndDateGregorian(), cal1);
  }

  @Test
  public void getLength() throws Exception {

    TimeSpan span2 = new TimeSpan(new GregorianCalendar(2014, 1, 1), 1.0);
    Assert.assertEquals(span2.getLength(), 1, 0);

    span2 = new TimeSpan(new GregorianCalendar(2011, 2, 14), new GregorianCalendar(2012, 2, 14));
    Assert.assertEquals(span2.getLength(), 365.0, 0.0);
  }

  @Test
  public void getWeeks() throws Exception {

    TimeSpan span = new TimeSpan(new GregorianCalendar(2014, 1, 1), new GregorianCalendar(2015, 1, 1));
    Assert.assertEquals(span.getWeeks(), 52, 0);

    span = new TimeSpan(new GregorianCalendar(2014, 1, 1), new GregorianCalendar(2017, 1, 1));
    Assert.assertEquals(span.getWeeks(), 156, 0);

  }

  @Test
  public void getDays() throws Exception {
    TimeSpan span2 = new TimeSpan(new GregorianCalendar(2014, 1, 1), 1.5);
    Assert.assertEquals(span2.getDays(), 1, 0);

    span2 = new TimeSpan(new GregorianCalendar(2011, 2, 14), new GregorianCalendar(2012, 2, 14));
    Assert.assertEquals(span2.getDays(), 365, 0);
  }

  @Test
  public void getYears() throws Exception {
    TimeSpan span2 = new TimeSpan(new GregorianCalendar(2014, 1, 1), 378.5);
    Assert.assertEquals(span2.getYears(), 1, 0);

    span2 = new TimeSpan(new GregorianCalendar(2011, 2, 14), new GregorianCalendar(2017, 3, 14));
    Assert.assertEquals(span2.getYears(), 6, 0);
  }

  @Test
  public void getDecades() throws Exception {
    TimeSpan span2 =
        new TimeSpan(new GregorianCalendar(1957, 5, 18), new GregorianCalendar(2007, 5, 19));
    Assert.assertEquals(span2.getDecades(), 5, 0);
  }

  @Test
  public void getCenturies() throws Exception {
    TimeSpan span2 =
        new TimeSpan(new GregorianCalendar(1857, 5, 18), new GregorianCalendar(2057, 5, 19));
    Assert.assertEquals(span2.getCenturies(), 2, 0);
  }

  @Test
  public void getMonths() throws Exception {
    TimeSpan span2 = new TimeSpan(new GregorianCalendar(2014, 1, 1), 378.5);
    Assert.assertEquals(span2.getMonths(), 12, 0);

    span2 = new TimeSpan(new GregorianCalendar(1957, 2, 14), new GregorianCalendar(2057, 2, 15));
    Assert.assertEquals(span2.getMonths(), 1200, 0);
  }
}
