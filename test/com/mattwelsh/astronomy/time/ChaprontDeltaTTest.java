package com.mattwelsh.astronomy.time;

import static org.junit.Assert.*;

import com.mattwelsh.util.JulianDate;
import org.junit.Test;

public class ChaprontDeltaTTest {

  @Test
  public void getDeltaT() {

    DeltaTCalculator calc = DynamicalTime.CHAPRONT.getCalculator();

    JulianDate jd1 = new JulianDate(1600, 0, 0, 12, 0, 0);
    org.junit.Assert.assertEquals(calc.getDeltaT(jd1), 80.0, 0.0);

    jd1 = new JulianDate(1760, 0, 0, 12, 0, 0);
    org.junit.Assert.assertEquals(calc.getDeltaT(jd1), 8.0, 0.0);

    jd1 = new JulianDate(1730, 0, 0, 12, 0, 0);
    org.junit.Assert.assertEquals(calc.getDeltaT(jd1), 1.0, 0.0);

    jd1 = new JulianDate(1805, 0, 0, 12, 0, 0);
    org.junit.Assert.assertEquals(calc.getDeltaT(jd1), 8.0, 0.0);

    jd1 = new JulianDate(1859, 0, 0, 12, 0, 0);
    org.junit.Assert.assertEquals(calc.getDeltaT(jd1), 6.0, 0.0);

    jd1 = new JulianDate(1909, 0, 0, 12, 0, 0);
    org.junit.Assert.assertEquals(calc.getDeltaT(jd1), 9.0, 0.0);

    jd1 = new JulianDate(1939, 0, 0, 12, 0, 0);
    org.junit.Assert.assertEquals(calc.getDeltaT(jd1), 24.0, 0.0);

    jd1 = new JulianDate(1958, 0, 0, 12, 0, 0);
    org.junit.Assert.assertEquals(calc.getDeltaT(jd1), 32.0, 0.0);

    jd1 = new JulianDate(1966, 0, 0, 12, 0, 0);
    org.junit.Assert.assertEquals(calc.getDeltaT(jd1), 37, 0.0);

    jd1 = new JulianDate(1973, 0, 0, 12, 0, 0);
    org.junit.Assert.assertEquals(calc.getDeltaT(jd1), 43, 0.0);

    jd1 = new JulianDate(1982, 0, 0, 12, 0, 0);
    org.junit.Assert.assertEquals(calc.getDeltaT(jd1), 52, 0.0);

    jd1 = new JulianDate(1990, 0, 0, 12, 0, 0);
    org.junit.Assert.assertEquals(calc.getDeltaT(jd1), 57, 0.0);

    jd1 = new JulianDate(1991, 0, 0, 12, 0, 0);
    org.junit.Assert.assertEquals(calc.getDeltaT(jd1), 57.5, 0.9);

  }
}