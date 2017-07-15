package com.mattwelsh.util;

import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
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

    }

    @Test
    public void getDays() throws Exception {

    }

    @Test
    public void getYears() throws Exception {

    }

    @Test
    public void getDecades() throws Exception {

    }

    @Test
    public void getCenturies() throws Exception {

    }

    @Test
    public void getMonths() throws Exception {

    }

}

/*

    private static void testTimeSpan() {

        TimeSpan span2 = new TimeSpan(new GregorianCalendar(2001, 5, 1), new GregorianCalendar(2001, 5, 18));

        //System.out.println(span2.getCenturies());
        assert (span2.getCenturies() == 0);
        //System.out.println(span2.getDecades());
        assert (span2.getDecades() == 0);
        //System.out.println(span2.getYears());
        assert (span2.getYears() == 0);
        //System.out.println(span2.getMonths());
        assert (span2.getMonths() == 0);
        //System.out.println(span2.getWeeks());
        assert (span2.getWeeks() == 2);
        //System.out.println(span2.getDays());
        assert (span2.getDays() == 18310);
        System.out.println("//----------------------------------//");
        System.out.println("End TimeSpan Test 1");
        System.out.println("//----------------------------------// \n\n");

        span2 = new TimeSpan(new GregorianCalendar(1964, 5, 1), new GregorianCalendar(2014, 6, 18));
        //System.out.println(span2.getCenturies());
        assert (span2.getCenturies() == 0);
        //System.out.println(span2.getDecades());
        assert (span2.getDecades() == 5);
        //System.out.println(span2.getYears());
        assert (span2.getYears() == 50);
        //System.out.println(span2.getMonths());
        assert (span2.getMonths() == 601);
        //System.out.println(span2.getDays());
        assert (span2.getDays() == 18310);

        System.out.println("//----------------------------------//");
        System.out.println("End TimeSpan Test 2");
        System.out.println("//----------------------------------// \n\n");

        span2 = new TimeSpan(new GregorianCalendar(2014, 1, 1), new GregorianCalendar(2014, 12, 31));
        //System.out.println(span2.getCenturies());
        assert (span2.getCenturies() == 0);
        //System.out.println(span2.getDecades());
        assert (span2.getDecades() == 0);
        //System.out.println(span2.getYears());
        assert (span2.getYears() == 0);
        //System.out.println(span2.getMonths());
        assert (span2.getMonths() == 11);
        //System.out.println(span2.getDays());
        assert (span2.getDays() == 364);

        System.out.println("//----------------------------------//");
        System.out.println("End TimeSpan Test 3");
        System.out.println("//----------------------------------// \n\n\n\n\n\n\n");

        span2 = new TimeSpan(new GregorianCalendar(2017, 5, 16), 2.25278757866539);
        //span2 = new TimeSpan(new GregorianCalendar(), 2.0);

        GregorianCalendar greg = span2.getEndDateGregorian();

        assert greg != null;

        System.out.println("Computed Date: " + greg.get(Calendar.MONTH) + "/" + greg.get(Calendar.DAY_OF_MONTH) + "/" +
                greg.get(Calendar.YEAR) + " at " + greg.get(Calendar.HOUR_OF_DAY) + ":" +
                greg.get(Calendar.MINUTE) + ":" + greg.get(Calendar.SECOND) + "." +
                greg.get(Calendar.MILLISECOND));

    }


 */