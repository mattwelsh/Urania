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
 *
 */
package com.mattwelsh.astronomy.object;

import com.mattwelsh.astronomy.coordinates.Declination;
import com.mattwelsh.astronomy.coordinates.Nutation;
import com.mattwelsh.astronomy.coordinates.NutationCalculatorFactory;
import com.mattwelsh.astronomy.coordinates.RaDec;
import com.mattwelsh.astronomy.coordinates.RightAscension;
import com.mattwelsh.astronomy.time.DeltaTCalculator;
import com.mattwelsh.astronomy.time.JulianDate;

/**
 * This class implements the API that lunar circumstance calculators must implement using the
 * method of Jean Meeus in Astronomical Algorithms.
 *
 * @author Matt Welsh (mitya.welsh@gmail.com)
 * @version 1.0
 * @since 1.0
 */
class MeeusCircumstanceComputer implements LunarCircumstanceComputer {

  private JulianDate julianDate;
  private double deltaT;
  private double deltaT2;
  private double deltaT3;
  private double deltaT4;
  private RaDec raDec;
  private double meanLongitude;
  private double meanElongation;
  private double sunsMeanAnomaly;
  private double meanAnomaly;
  private double argumentOfLatitude;
  private double venusTerms;
  private double jupiterTerms;
  private double a3;
  private double e;
  private double sumLongitude;
  private double sumDistance;
  private double sumLatitude;
  private double distance;
  private double equatorialHorizontalParallax;
  private double apparentLongitude;
  private double longitude;
  private double latitude;
  private double meanAscendingNode;
  private double meanPerigee;

  @Override
  public void computeCircumstances(JulianDate jd) {
    this.julianDate = jd;
    deltaT = julianDate.getJulianCenturies(DeltaTCalculator.EPOCH2000);
    deltaT2 = deltaT * deltaT;
    deltaT3 = deltaT * deltaT2;
    deltaT4 = deltaT * deltaT3;
    computeMeanLongitude();
    computeMeanElongation();
    computeSunsMeanAnomaly();
    computeMeanAnomaly();
    computeArgumentOfLatitude();
    computeOtherArguments();
    computePeriodicLongitudeAndDistance();
    computePeriodicLatitude();
    computeCoordinates();
    computeNodeAndPerigee();
  }

  /**
   * Returns the right ascension and declination as a coordinate pair.
   *
   * @return The right ascension and declination as a coordinate pair.
   */
  @Override
  public RaDec getRaDec() {
    return this.raDec;
  }

  /**
   * Return the distance in kilometers between the centers of the earth and moon.
   *
   * @return The distance in kilometers between the centers of the earth and moon.
   */
  @Override
  public double getDistance() { return this.distance; }

  /**
   * Return the mean longitude of the moon.
   *
   * @return The mean longitude of the moon.
   */
  @Override
  public double getMeanLongitude() {
    return this.meanLongitude;
  }

  /**
   * Return the mean elongation of the moon.
   *
   * @return The mean elongation of the moon.
   */
  @Override
  public double getMeanElongation() {
    return this.meanElongation;
  }

  /**
   * Return the mean anomaly of the moon.
   *
   * @return The mean anomaly of the moon.
   */
  @Override
  public double getMeanAnomaly() {
    return this.meanAnomaly;
  }

  /**
   * Return the mean argument of latitude (the distance of the moon from it's ascending node).
   *
   * @return The mean argument of latitude.
   */
  @Override
  public double getArgumentOfLatitude() {
    return this.argumentOfLatitude;
  }

  /**
   * Returns the apparent longitude of the moon.
   *
   * @return The apparent longitude of the moon.
   */
  @Override
  public double getApparentLongitude() {
    return this.apparentLongitude;
  }

  /**
   * Returns the mean ascending node of the moon.
   *
   * @return The mean ascending node of the moon.
   */
  @Override
  public double getMeanAscendingNode() {
    return this.meanAscendingNode;
  }

  /**
   * Returns the mean perigee of the moon.
   *
   * @return The mean perigee of the moon.
   */
  @Override
  public double getMeanPerigee() {
    return this.meanPerigee;
  }

  // -----------------------------------------------------------------------------------------------
  // Protected and private methods
  // -----------------------------------------------------------------------------------------------

  /**
   * Computes the lunar mean longitude referred to the mean equinox of the date including the
   * constant term of the effect of light-time (-0.7 seconds).
   */
  private void computeMeanLongitude() {
    this.meanLongitude =
        218.3164477
            + (481267.88123421 * deltaT)
            - (0.0015786 * deltaT2)
            + ((deltaT3) / 538841.0)
            - ((deltaT4) / 65194000.0);
    this.meanLongitude = reduceToRange(meanLongitude);
  }

  private void computeMeanElongation() {
    this.meanElongation =
        297.8501921
            + (445267.1114034 * deltaT)
            - (0.0018819 * deltaT2)
            + (deltaT3 / 545868.0)
            - (deltaT4 / 113065000.0);
    this.meanElongation = reduceToRange(meanElongation);
  }

  private void computeSunsMeanAnomaly() {
    sunsMeanAnomaly =
        357.5291092 + (35999.0502909 * deltaT) - (0.0001536 * deltaT2) + (deltaT3 / 24490000.0);
    this.sunsMeanAnomaly = reduceToRange(sunsMeanAnomaly);
  }

  private void computeMeanAnomaly() {
    meanAnomaly =
        134.9633964
            + (477198.8675055 * deltaT)
            + (0.0087414 * deltaT2)
            + (deltaT3 / 69699.0)
            - (deltaT4 / 14712000.0);
    this.meanAnomaly = reduceToRange(meanAnomaly);
  }

  private void computeArgumentOfLatitude() {
    argumentOfLatitude =
        93.2720950
            + (483202.0175233 * deltaT)
            - (0.0036539 * deltaT2)
            - (deltaT3 / 3526000.0 + (deltaT4 / 863310000.0));
    this.argumentOfLatitude = reduceToRange(argumentOfLatitude);
  }

  private void computeOtherArguments() {
    venusTerms = 119.75 + (131.849 * deltaT);
    this.venusTerms = reduceToRange(venusTerms);
    jupiterTerms = 53.09 + (479264.29 * deltaT);
    this.jupiterTerms = reduceToRange(jupiterTerms);
    a3 = 313.45 + (481266.484 * deltaT);
    this.a3 = reduceToRange(a3);
    e = 1.0 - (0.002516 * deltaT) - (0.0000074 * deltaT2);
  }

  protected double reduceToRange(double decimalDegrees) {
    if (decimalDegrees > 360.0) {
      decimalDegrees = decimalDegrees - 360.0 * ((long) (decimalDegrees / 360.0));
    }

    if (decimalDegrees < 0.0) {
      decimalDegrees = decimalDegrees + 360.0 * ((long) Math.abs(decimalDegrees / 360.0) + 1);
    }
    return decimalDegrees;
  }

  private void computePeriodicLongitudeAndDistance() {
    double[][] lunarLongitudeDistance = {
      {0, 0, 1, 0, 6288774, -20905335},
      {2, 0, -1, 0, 1274027, -3699111},
      {2, 0, 0, 0, 658314, -2955968},
      {0, 0, 2, 0, 213618, -569925},
      {0, 1, 0, 0, -185116, 48888},
      {0, 0, 0, 2, -114332, -3149},
      {2, 0, -2, 0, 58793, 246158},
      {2, -1, -1, 0, 57066, -152138},
      {2, 0, 1, 0, 53322, -170733},
      {2, -1, 0, 0, 45758, -204586},
      {0, 1, -1, 0, -40923, -129620},
      {1, 0, 0, 0, -34720, 108743},
      {0, 1, 1, 0, -30383, 104755},
      {2, 0, 0, -2, 15327, 10321},
      {0, 0, 1, 2, -12528, 0},
      {0, 0, 1, -2, 10980, 79661},
      {4, 0, -1, 0, 10675, -34782},
      {0, 0, 3, 0, 10034, -23210},
      {4, 0, -2, 0, 8548, -21636},
      {2, 1, -1, 0, -7888, 24208},
      {2, 1, 0, 0, -6766, 30824},
      {1, 0, -1, 0, -5163, -8379},
      {1, 1, 0, 0, 4987, -16675},
      {2, -1, 1, 0, 4036, -12831},
      {2, 0, 2, 0, 3994, -10445},
      {4, 0, 0, 0, 3861, -11650},
      {2, 0, -3, 0, 3665, 14403},
      {0, 1, -2, 0, -2689, -7003},
      {2, 0, -1, 2, -2602, 0},
      {2, -1, -2, 0, 2390, 10056},
      {1, 0, 1, 0, -2348, 6322},
      {2, -2, 0, 0, 2236, -9884},
      {0, 1, 2, 0, -2120, 5751},
      {0, 2, 0, 0, -2069, 0},
      {2, -2, -1, 0, 2048, -4950},
      {2, 0, 1, -2, -1773, 4130},
      {2, 0, 0, 2, -1595, 0},
      {4, -1, -1, 0, 1215, -3958},
      {0, 0, 2, 2, -1110, 0},
      {3, 0, -1, 0, -892, 3258},
      {2, 1, 1, 0, -810, 2616},
      {4, -1, -2, 0, 759, -1897},
      {0, 2, -1, 0, -713, -2117},
      {2, 2, -1, 0, -700, 2354},
      {2, 1, -2, 0, 691, 0},
      {2, -1, 0, -2, 596, 0},
      {4, 0, 1, 0, 549, -1423},
      {0, 0, 4, 0, 537, -1117},
      {4, -1, 0, 0, 520, -1571},
      {1, 0, -2, 0, -487, -1739},
      {2, 1, 0, -2, -399, 0},
      {0, 0, 2, -2, -381, -4421},
      {1, 1, 1, 0, 351, 0},
      {3, 0, -2, 0, -340, 0},
      {4, 0, -3, 0, 330, 0},
      {2, -1, 2, 0, 327, 0},
      {0, 2, 1, 0, -323, 1165},
      {1, 1, -1, 0, 299, 0},
      {2, 0, 3, 0, 294, 0},
      {2, 0, -1, -2, 0, 8752}
    };

    for (int i = 0; i < lunarLongitudeDistance.length; i++) {

      double argument =
          lunarLongitudeDistance[i][0] * meanElongation
              + lunarLongitudeDistance[i][1] * sunsMeanAnomaly
              + lunarLongitudeDistance[i][2] * meanAnomaly
              + lunarLongitudeDistance[i][3] * argumentOfLatitude;
      argument = Math.toRadians(argument);

      double coefficientLongitude = lunarLongitudeDistance[i][4];
      double coefficientDistance = lunarLongitudeDistance[i][5];

      if ((lunarLongitudeDistance[i][1] == 1) || (lunarLongitudeDistance[i][1] == -1)) {
        coefficientLongitude *= e;
        coefficientDistance *= e;
      }

      if ((lunarLongitudeDistance[i][1] == 2) || (lunarLongitudeDistance[i][1] == -2)) {
        coefficientLongitude = coefficientLongitude * e * e;
        coefficientDistance = coefficientDistance * e * e;
      }

      sumLongitude = sumLongitude + (coefficientLongitude * Math.sin(argument));
      sumDistance = sumDistance + (coefficientDistance * Math.cos(argument));
    }

    sumLongitude = sumLongitude + (3958.0 * Math.sin(Math.toRadians(venusTerms)));
    sumLongitude =
        sumLongitude + (1962.0 * Math.sin(Math.toRadians(meanLongitude - argumentOfLatitude)));
    sumLongitude = sumLongitude + (318.0 * Math.sin(Math.toRadians(jupiterTerms)));

  }

  private void computePeriodicLatitude() {
    double[][] lunarLatitude = {
      {0, 0, 0, 1, 5128122},
      {0, 0, 1, 1, 280602},
      {0, 0, 1, -1, 277693},
      {2, 0, 0, -1, 173237},
      {2, 0, -1, 1, 55413},
      {2, 0, -1, -1, 46271},
      {2, 0, 0, 1, 32573},
      {0, 0, 2, 1, 17198},
      {2, 0, 1, -1, 9266},
      {0, 0, 2, -1, 8822},
      {2, -1, 0, -1, 8216},
      {2, 0, -2, -1, 4324},
      {2, 0, 1, 1, 4200},
      {2, 1, 0, -1, -3359},
      {2, -1, -1, 1, 2463},
      {2, -1, 0, 1, 2211},
      {2, -1, -1, -1, 2065},
      {0, 1, -1, -1, -1870},
      {4, 0, -1, -1, 1828},
      {0, 1, 0, 1, -1794},
      {0, 0, 0, 3, -1749},
      {0, 1, -1, 1, -1565},
      {1, 0, 0, 1, -1491},
      {0, 1, 1, 1, -1475},
      {0, 1, 1, -1, -1410},
      {0, 1, 0, -1, -1344},
      {1, 0, 0, -1, -1335},
      {0, 0, 3, 1, 1107},
      {4, 0, 0, -1, 1021},
      {4, 0, -1, 1, 833},
      {0, 0, 1, -3, 777},
      {4, 0, -2, 1, 671},
      {2, 0, 0, -3, 607},
      {2, 0, 2, -1, 596},
      {2, -1, 1, -1, 491},
      {2, 0, -2, 1, -451},
      {0, 0, 3, -1, 439},
      {2, 0, 2, 1, 422},
      {2, 0, -3, -1, 421},
      {2, 1, -1, 1, -366},
      {2, 1, 0, 1, -351},
      {4, 0, 0, 1, 331},
      {2, -1, 1, 1, 315},
      {2, -2, 0, -1, 302},
      {0, 0, 1, 3, -283},
      {2, 1, 1, -1, -229},
      {1, 1, 0, -1, 223},
      {1, 1, 0, 1, 223},
      {0, 1, -2, -1, -220},
      {2, 1, -1, -1, -220},
      {1, 0, 1, 1, -185},
      {2, -1, -2, -1, 181},
      {0, 1, 2, 1, -177},
      {4, 0, -2, -1, 176},
      {4, -1, -1, -1, 166},
      {1, 0, 1, -1, -164},
      {4, 0, 1, -1, 132},
      {1, 0, -1, -1, -119},
      {4, -1, 0, -1, 115},
      {2, -2, 0, 1, 107}
    };

    for (int i = 0; i < lunarLatitude.length; i++) {

      double argument =
          lunarLatitude[i][0] * meanElongation
              + lunarLatitude[i][1] * sunsMeanAnomaly
              + lunarLatitude[i][2] * meanAnomaly
              + lunarLatitude[i][3] * argumentOfLatitude;
      argument = Math.toRadians(argument);

      double coefficient = lunarLatitude[i][4];

      if ((lunarLatitude[i][1] == 1) || (lunarLatitude[i][1] == -1)) {
        coefficient *= e;
      }

      if ((lunarLatitude[i][1] == 2) || (lunarLatitude[i][1] == -2)) {
        coefficient = coefficient * e * e;
      }

      sumLatitude = sumLatitude + (coefficient * Math.sin(argument));
    }
    sumLatitude = sumLatitude + (-2235 * Math.sin(Math.toRadians(meanLongitude)));
    sumLatitude = sumLatitude + (382 * Math.sin(Math.toRadians(a3)));
    sumLatitude = sumLatitude + (175 * Math.sin(Math.toRadians(venusTerms - argumentOfLatitude)));
    sumLatitude = sumLatitude + (175 * Math.sin(Math.toRadians(venusTerms + argumentOfLatitude)));
    sumLatitude = sumLatitude + (127 * Math.sin(Math.toRadians(meanLongitude - meanAnomaly)));
    sumLatitude = sumLatitude + (-115 * Math.sin(Math.toRadians(meanLongitude + meanAnomaly)));
  }

  private void computeCoordinates() {
    longitude = this.meanLongitude + this.sumLongitude / 1000000.0;
    latitude = this.sumLatitude / 1000000.0;
    distance = 385000.56 + this.sumDistance / 1000;
    equatorialHorizontalParallax = Math.toDegrees(Math.asin(6378.14 / distance));
    Nutation nutation = NutationCalculatorFactory.MEEUS.getCalculator(this.julianDate).getNutation();

    apparentLongitude = longitude + (nutation.getNutationInLongitude() / 3600);
    double numerator = Math.sin(Math.toRadians(apparentLongitude)) * Math.cos(Math.toRadians(nutation.getTrueObliquityOfEcliptic()));
    numerator -= (Math.tan(Math.toRadians(latitude)) * Math.sin(Math.toRadians(nutation.getTrueObliquityOfEcliptic())));

    double denominator = Math.cos(Math.toRadians(apparentLongitude));

    double ra = Math.toDegrees(Math.atan2(numerator, denominator));

    RightAscension rightAscension = new RightAscension(ra);

    double dec = (Math.sin(Math.toRadians(latitude)) *
        Math.cos(Math.toRadians(nutation.getTrueObliquityOfEcliptic()))) +
        (Math.cos(Math.toRadians(latitude)) *
        Math.sin(Math.toRadians(nutation.getTrueObliquityOfEcliptic())) *
        Math.sin(Math.toRadians(apparentLongitude)));

    dec = Math.toDegrees(Math.asin(dec));
    Declination declination = new Declination(dec);

    raDec = new RaDec(rightAscension, declination);
  }

  private void computeNodeAndPerigee() {
    meanAscendingNode = 125.0445479 - (1934.1362891 * deltaT) + (0.0020754 * deltaT2) +
        (deltaT3 / 467441) - (deltaT4 / 60616000);
    meanAscendingNode = reduceToRange(meanAscendingNode);
    meanPerigee = 83.3532465 + (4069.0137287 * deltaT) - (0.0103200 * deltaT2) -
        (deltaT3 / 80053.0) + (deltaT4 / 18999000.0);
    meanPerigee = reduceToRange(meanPerigee);

  }
}

