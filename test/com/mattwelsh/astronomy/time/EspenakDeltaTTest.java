package com.mattwelsh.astronomy.time;

import static org.junit.Assert.*;

import com.mattwelsh.util.JulianDate;
import org.junit.Test;

public class EspenakDeltaTTest {

  @Test
  public void getDeltaT() {

    DeltaTCalculator calc = DynamicalTime.ESPENAK.getCalculator();

    JulianDate jd1 = new JulianDate(1950, 0, 0, 12, 0, 0);
    calc.getDeltaT(jd1);
    org.junit.Assert.assertEquals(calc.getDeltaT(jd1), 52.577893820524605, 0.01);

    jd1 = new JulianDate(2090, 0, 0, 12, 0, 0);
    calc.getDeltaT(jd1);
    org.junit.Assert.assertEquals(calc.getDeltaT(jd1), 173.830623183974299, 0.01);

    jd1 = new JulianDate(1948, 0, 0, 12, 0, 0);
    calc.getDeltaT(jd1);

  }
}
