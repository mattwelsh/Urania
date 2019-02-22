/*
 *  Copyright (C) 2019 by Matt Welsh
 *  This library is free software; you can redistribute it and/or modify it under the terms of the
 *  GNU Lesser General Public License as published by the Free Software Foundation; either version
 *  2.1 of the License, or any later version.
 *
 *  This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *  See the GNU General Public License for more details. You should have received a copy of the GNU
 *  Lesser General Public License along with this library; if not, write to the Free Software
 *  Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
 */

package com.mattwelsh.astronomy.coordinates;

import com.mattwelsh.astronomy.time.JulianDate;
import org.junit.Test;
import org.junit.Assert;

public class MeeusNutationCalculatorTest {

  @Test
  public void testNutation() {
    NutationCalculator meeus =
        NutationCalculatorFactory.MEEUS.getCalculator(new JulianDate(1987, 4,
            10, 0, 0, 0));

    Assert.assertEquals(meeus.getNutation().getNutationInLongitude(), -3.78, 0.01);
    Assert.assertEquals(meeus.getNutation().getNutationInObliquity(), 9.443, 0.001);
    Assert.assertEquals(meeus.getNutation().getTrueObliquityOfEcliptic(), 23.44357, 0.00001);
  }


}