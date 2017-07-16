package com.mattwelsh.util;

import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests the Time Span Class
 * Created by Matt on 7/15/17.
 */
public class TimeSpanTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

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
        Assert.assertEquals(span2.getLength(), 1.0, 0.0);

        span2 = new TimeSpan(new GregorianCalendar(2011, 2, 14), new GregorianCalendar(2012, 2, 14));
        Assert.assertEquals(span2.getLength(), 365.0, 0.0);

    }

    @Test
    public void getWeeks() throws Exception {
        TimeSpan span2 = new TimeSpan(new GregorianCalendar(2014, 1, 1), 7.0);
        Assert.assertEquals(span2.getLength(), 7.0, 0.0);

        span2 = new TimeSpan(new GregorianCalendar(2014, 1, 1), new GregorianCalendar(2014, 1, 7));
        Assert.assertEquals(span2.getLength(), 6.0, 0.0);

    }

    @Test
    public void getDays() throws Exception {
        TimeSpan span2 = new TimeSpan(new GregorianCalendar(2014, 1, 1), 1.5);
        Assert.assertEquals(span2.getDays(), 1, 0);

        span2 = new TimeSpan(new GregorianCalendar(2011, 2, 14), new GregorianCalendar(2012, 2, 14));
        Assert.assertEquals(span2.getDays(), 365.0, 0);

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
        TimeSpan span2 = new TimeSpan(new GregorianCalendar(1957, 5, 18), new GregorianCalendar(2007, 5, 19));
        Assert.assertEquals(span2.getDecades(), 5, 0);
    }

    @Test
    public void getCenturies() throws Exception {
        TimeSpan span2 = new TimeSpan(new GregorianCalendar(1857, 5, 18), new GregorianCalendar(2057, 5, 19));
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
