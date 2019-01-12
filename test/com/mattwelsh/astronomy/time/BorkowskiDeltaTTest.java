package com.mattwelsh.astronomy.time;

import static org.junit.Assert.*;

import com.mattwelsh.util.JulianDate;
import org.junit.Test;

public class BorkowskiDeltaTTest {

  @Test
  public void getDeltaT() {
    DeltaTCalculator calc = DynamicalTime.BORKOWSKI.getCalculator();

    JulianDate jd1 = new JulianDate(1715, 0, 0, 12, 0, 0);
    JulianDate jd2 = new JulianDate(1000, 0, 0, 12, 0, 0);
    JulianDate jd3 = new JulianDate(1500, 0, 0, 12, 0, 0);
    JulianDate jd4 = new JulianDate(1, 0, 0, 12, 0, 0);

    org.junit.Assert.assertEquals(calc.getDeltaT(jd1), 68.4, 0.1);
    org.junit.Assert.assertEquals(calc.getDeltaT(jd2), 1407.0, 0.9);
    org.junit.Assert.assertEquals(calc.getDeltaT(jd3), 94.8, 0.1);
    org.junit.Assert.assertEquals(calc.getDeltaT(jd4), 9270.6, 12.0);


  }
}