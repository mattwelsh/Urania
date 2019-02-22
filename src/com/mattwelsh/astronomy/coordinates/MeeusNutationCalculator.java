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

import com.mattwelsh.astronomy.time.DeltaTCalculator;
import com.mattwelsh.astronomy.time.JulianDate;
import com.mattwelsh.astronomy.time.MutableJulianDate;
import com.mattwelsh.astronomy.utilities.Utilities;

/**
 * This class implements a NutationCalculator that uses the method of Jean Meeus in Astronomical
 * Algorithms.
 *
 * <p>NutationCalculatorFactory is a periodic oscillation of the rotational axis of the earth. It's split into two
 * components, one parallel to the ecliptic called the nutation in longitude, and one perpendicular
 * to the ecliptic, called the nutation in obliquity.</p>
 *
 * <p>The quantities are needed to calculate the apparent position of an astronomical object, and
 * for the apparent sidereal time.</p>
 *
 * @author Matt Welsh (mitya.welsh@gmail.com)
 * @version 1.0
 * @since 1.0
 */
class MeeusNutationCalculator implements NutationCalculator {

  private JulianDate julianDate;
  private Nutation nutation = new Nutation();
  private double meanElongationOfMoon;
  private double meanAnomalyOfSun;
  private double meanAnomalyOfMoon;
  private double moonArgumentOfLatitude;
  private double longitudeOfAscendingNode;

  MeeusNutationCalculator(JulianDate jd) {
    this.julianDate = jd;
    calculateNutation();
    if(jd instanceof MutableJulianDate) {
      MutableJulianDate mjd = (MutableJulianDate)jd;
      mjd.addDateChangedListener(evt -> calculateNutation());
    }
  }

  @Override
  public Nutation getNutation() {
    return this.nutation;
  }

  // -----------------------------------------------------------------------------------------------
  // Protected, package local, & and private methods
  // -----------------------------------------------------------------------------------------------

  private void calculateNutation() {
    this.nutation.setNutationInLongitude(0.0);
    this.nutation.setNutationInObliquity(0.0);
    calculateAngles();
    calculatePeriodicTerms();
  }

  private void calculateAngles() {
    double t = julianDate.getJulianCenturies(DeltaTCalculator.EPOCH2000);
    meanElongationOfMoon = 297.85036 + (445267.111480 * t) - (0.0019142 * t * t) +
        ((t * t * t)/189474.0);
    meanElongationOfMoon = Utilities.reduceToRange360(meanElongationOfMoon);

    meanAnomalyOfSun = 357.52772 + (35999.050340 * t) - (0.0001603 * t * t) -
        ((t * t * t) / 300000.0);
    meanAnomalyOfSun = Utilities.reduceToRange360(meanAnomalyOfSun);

    meanAnomalyOfMoon = 134.96298 + (477198.867398 * t) + (0.0086972 * t * t) +
        ((t * t * t) / 56250.0);
    meanAnomalyOfMoon = Utilities.reduceToRange360(meanAnomalyOfMoon);

    moonArgumentOfLatitude = 93.27191 + (483202.017538 * t) - (0.0036825 * t * t) +
        ((t * t * t) / 327270.0);
    moonArgumentOfLatitude = Utilities.reduceToRange360(moonArgumentOfLatitude);

    longitudeOfAscendingNode = 125.04452 - (1934.136261 * t) + (0.0020708 * t * t) +
        ((t * t * t) / 450000.0);
    longitudeOfAscendingNode = Utilities.reduceToRange360(longitudeOfAscendingNode);
  }

  private void calculatePeriodicTerms() {
    double[][] periodicData = {
        { 0,  0,  0,  0,  1, -171996,  -174.2,  92025,  8.9},
        {-2,  0,  0,  2,  2,  -13187,    -1.6,   5736, -3.1},
        { 0,  0,  0,  2,  2,   -2274,    -0.2,    977, -0.5},
        { 0,  0,  0,  0,  2,    2062,     0.2,   -895,  0.5},
        { 0,  1,  0,  0,  0,    1426,    -3.4,     54, -0.1},
        { 0,  0,  1,  0,  0,     712,     0.1,     -7,    0},
        {-2,  1,  0,  2,  2,    -517,     1.2,    224, -0.6},
        { 0,  0,  0,  2,  1,    -386,    -0.4,    200,    0},
        { 0,  0,  1,  2,  2,    -301,       0,    129, -0.1},
        {-2, -1,  0,  2,  2,     217,    -0.5,    -95,  0.3},
        {-2,  0,  1,  0,  0,    -158,       0,      0,    0},
        {-2,  0,  0,  2,  1,     129,     0.1,    -70,    0},
        { 0,  0, -1,  2,  2,     123,       0,    -53,    0},
        { 2,  0,  0,  0,  0,      63,       0,      0,    0},
        { 0,  0,  1,  0,  1,      63,     0.1,    -33,    0},
        { 2,  0, -1,  2,  2,     -59,       0,     26,    0},
        { 0,  0, -1,  0,  1,     -58,    -0.1,     32,    0},
        { 0,  0,  1,  2,  1,     -51,       0,     27,    0},
        {-2,  0,  2,  0,  0,      48,       0,      0,    0},
        { 0,  0, -2,  2,  1,      46,       0,    -24,    0},
        { 2,  0,  0,  2,  2,     -38,       0,     16,    0},
        { 0,  0,  2,  2,  2,     -31,       0,     13,    0},
        { 0,  0,  2,  0,  0,      29,       0,      0,    0},
        {-2,  0,  1,  2,  2,      29,       0,    -12,    0},
        { 0,  0,  0,  2,  0,      26,       0,      0,    0},
        {-2,  0,  0,  2,  0,     -22,       0,      0,    0},
        { 0,  0, -1,  2,  1,      21,       0,    -10,    0},
        { 0,  2,  0,  0,  0,      17,    -0.1,      0,    0},
        { 2,  0, -1,  0,  1,      16,       0,     -8,    0},
        {-2,  2,  0,  2,  2,     -16,     0.1,      7,    0},
        { 0,  1,  0,  0,  1,     -15,       0,      9,    0},
        {-2,  0,  1,  0,  1,     -13,       0,      7,    0},
        { 0, -1,  0,  0,  1,     -12,       0,      6,    0},
        { 0,  0,  2, -2,  0,      11,       0,      0,    0},
        { 2,  0, -1,  2,  1,     -10,       0,      5,    0},
        { 2,  0,  1,  2,  2,      -8,       0,      3,    0},
        { 0,  1,  0,  2,  2,       7,       0,     -3,    0},
        {-2,  1,  1,  0,  0,      -7,       0,      0,    0},
        { 0, -1,  0,  2,  2,      -7,       0,      3,    0},
        { 2,  0,  0,  2,  1,      -7,       0,      3,    0},
        { 2,  0,  1,  0,  0,       6,       0,      0,    0},
        {-2,  0,  2,  2,  2,       6,       0,     -3,    0},
        {-2,  0,  1,  2,  1,       6,       0,     -3,    0},
        { 2,  0, -2,  0,  1,      -6,       0,      3,    0},
        { 2,  0,  0,  0,  1,      -6,       0,      3,    0},
        { 0, -1,  1,  0,  0,       5,       0,      0,    0},
        {-2, -1,  0,  2,  1,      -5,       0,      3,    0},
        {-2,  0,  0,  0,  1,      -5,       0,      3,    0},
        { 0,  0,  2,  2,  1,      -5,       0,      3,    0},
        {-2,  0,  2,  0,  1,       4,       0,      0,    0},
        {-2,  1,  0,  2,  1,       4,       0,      0,    0},
        { 0,  0,  1, -2,  0,       4,       0,      0,    0},
        {-1,  0,  1,  0,  0,      -4,       0,      0,    0},
        {-2,  1,  0,  0,  0,      -4,       0,      0,    0},
        { 1,  0,  0,  0,  0,      -4,       0,      0,    0},
        { 0,  0,  1,  2,  0,       3,       0,      0,    0},
        { 0,  0, -2,  2,  2,      -3,       0,      0,    0},
        {-1, -1,  1,  0,  0,      -3,       0,      0,    0},
        { 0,  1,  1,  0,  0,      -3,       0,      0,    0},
        { 0, -1,  1,  2,  2,      -3,       0,      0,    0},
        { 2, -1, -1,  2,  2,      -3,       0,      0,    0},
        { 0,  0,  3,  2,  2,      -3,       0,      0,    0},
        { 2, -1,  0,  2,  2,      -3,       0,      0,    0}
    };
    double t = julianDate.getJulianCenturies(DeltaTCalculator.EPOCH2000);

    for (int i = 0; i < periodicData.length; i++) {
      double argument = (periodicData[i][0] * meanElongationOfMoon) +
          (periodicData[i][1] * meanAnomalyOfSun) + (periodicData[i][2] * meanAnomalyOfMoon) +
          (periodicData[i][3] * moonArgumentOfLatitude) +
          (periodicData[i][4] * longitudeOfAscendingNode);
      argument = Math.toRadians(argument);
      double coefficientSine = periodicData[i][5] + (periodicData[i][6] * t);
      double coefficientCosine = periodicData[i][7] + (periodicData[i][8] * t);
      this.nutation.setNutationInLongitude(this.nutation.getNutationInLongitude() +
          (coefficientSine * Math.sin(argument)));
      this.nutation.setNutationInObliquity(this.nutation.getNutationInObliquity() +
          (coefficientCosine * Math.cos(argument)));
    }

    this.nutation.setNutationInLongitude(this.nutation.getNutationInLongitude() / 10000.0);
    this.nutation.setNutationInObliquity(this.nutation.getNutationInObliquity() / 10000.0);
    calculateTrueObliquityOfEcliptic(this.nutation.getNutationInObliquity());
  }

  private void calculateTrueObliquityOfEcliptic(double nutationOfObliquity) {
    double u = julianDate.getJulianCenturies(DeltaTCalculator.EPOCH2000) / 100;

    double deltaSeconds = (4680.93 * u)
        - (1.55 * u * u)
        + (1999.25 * u * u * u)
        - (51.38 * u * u * u * u)
        - (249.67 * u * u * u * u * u)
        - (39.05 * u * u * u * u * u * u)
        + (7.12 * u * u * u * u * u * u * u)
        + (27.87 * u * u * u * u * u * u * u * u)
        + (5.79 * u * u * u * u * u * u * u * u * u)
        + (2.45 * u * u * u * u * u * u * u * u * u * u);

    double meanObliquity = 23.0 + (26.0/60.0) + (21.448 / 3600.0) - (deltaSeconds / 3600.0);
    this.nutation.setTrueObliquityOfEcliptic(meanObliquity + (nutationOfObliquity / 3600));
  }
}