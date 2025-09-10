/*
 *  Copyright (C) 2019-2025 by Matt Welsh
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
package com.mattwelsh.astronomy.application;

import com.mattwelsh.astronomy.coordinates.Nutation;
import com.mattwelsh.astronomy.coordinates.NutationCalculator;
import com.mattwelsh.astronomy.coordinates.NutationCalculatorFactory;
import com.mattwelsh.astronomy.coordinates.RaDec;
import com.mattwelsh.astronomy.object.VSOP87b.EarthComputer;
import com.mattwelsh.astronomy.object.VSOP87b.VenusComputer;
import com.mattwelsh.astronomy.time.JulianDate;
import com.mattwelsh.astronomy.utilities.Utilities;

/**
 * This class implements a demo application that uses the Urania library to compute the position
 * of Venus. It's not as rigorous from a code perspective as the library itself, but rather intended
 * to demonstrate how to use the library.
 *
 * @author Matt Welsh (mitya.welsh@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class TestApplication {

  public static void main(String[] args) {
    TestApplication testApp = new TestApplication();
  }

  public TestApplication() {
    computeVenusRaDec();
  }

  private void computeVenusRaDec() {


    JulianDate jd = new JulianDate(2024, 2, 12, 1, 33, 39);
    System.out.println("JD: " + jd.getJulianDayNumber());

    // Create and instance of a VenusComputer for that date
    VenusComputer venusComp = new VenusComputer(jd);
    System.out.println(
        "Venus Heliocentric Longitude: " + Math.toDegrees(venusComp.getHeliocentricLongitude()));
    System.out.println(
        "Venus Heliocentric Latitude: " + Math.toDegrees(venusComp.getHeliocentricLatitude()));
    System.out.println("Venus Radius Vector: " + venusComp.getRadiusVector());

    // Create and instance of an EarthComputer for December 12, 1992
    EarthComputer earthComputer = new EarthComputer(jd);
    System.out.println("\nEarth Heliocentric Longitude: " + Math
        .toDegrees(earthComputer.getHeliocentricLongitude()));
    System.out.println(
        "Earth Heliocentric Latitude: " + Math.toDegrees(earthComputer.getHeliocentricLatitude()));
    System.out.println("Earth Radius Vector: " + earthComputer.getRadiusVector());

    // Compute the distance between Venus and Earth
    double xV = venusComp.getRadiusVector() * Math.cos(venusComp.getHeliocentricLatitude()) * Math
        .cos(venusComp.getHeliocentricLongitude());
    double xE =
        earthComputer.getRadiusVector() * Math.cos(earthComputer.getHeliocentricLatitude()) * Math
            .cos(earthComputer.getHeliocentricLongitude());
    double x = xV - xE;

    double yV = venusComp.getRadiusVector() * Math.cos(venusComp.getHeliocentricLatitude()) * Math
        .sin(venusComp.getHeliocentricLongitude());
    double yE =
        earthComputer.getRadiusVector() * Math.cos(earthComputer.getHeliocentricLatitude()) * Math
            .sin(earthComputer.getHeliocentricLongitude());
    double y = yV - yE;
    double z = venusComp.getRadiusVector() * Math.sin(venusComp.getHeliocentricLatitude())
        - earthComputer.getRadiusVector() * Math.sin(earthComputer.getHeliocentricLatitude());
    System.out.println("\nX: " + x);
    System.out.println("Y: " + y);
    System.out.println("Z: " + z);
    double delta = Math.sqrt((x * x) + (y * y) + (z * z));
    System.out.println("\nDelta: " + delta);

    // Adjust for light travel time
    double lightTime = 0.0057755183 * delta;
    System.out.println("\nLight Time: " + lightTime);

    // Now adjust the Venus computer for the adjusted date
    JulianDate adjustedDate = new JulianDate(jd.getJulianDayNumber() - lightTime);
    System.out.println("\nAdjustedDate: " + adjustedDate.getJulianDayNumber());
    venusComp = new VenusComputer(adjustedDate);
    System.out.println(
        "Venus Heliocentric Longitude: " + Math.toDegrees(venusComp.getHeliocentricLongitude()));
    System.out.println(
        "Venus Heliocentric Latitude: " + Math.toDegrees(venusComp.getHeliocentricLatitude()));
    System.out.println("Venus Radius Vector: " + venusComp.getRadiusVector());

    // Compute adjusted distance from Venus to Earth accounting for light travel time
    xV = venusComp.getRadiusVector() * Math.cos(venusComp.getHeliocentricLatitude()) * Math
        .cos(venusComp.getHeliocentricLongitude());
    xE = earthComputer.getRadiusVector() * Math.cos(earthComputer.getHeliocentricLatitude()) * Math
        .cos(earthComputer.getHeliocentricLongitude());
    x = xV - xE;

    yV = venusComp.getRadiusVector() * Math.cos(venusComp.getHeliocentricLatitude()) * Math
        .sin(venusComp.getHeliocentricLongitude());
    yE = earthComputer.getRadiusVector() * Math.cos(earthComputer.getHeliocentricLatitude()) * Math
        .sin(earthComputer.getHeliocentricLongitude());
    y = yV - yE;

    z = venusComp.getRadiusVector() * Math.sin(venusComp.getHeliocentricLatitude())
        - earthComputer.getRadiusVector() * Math.sin(earthComputer.getHeliocentricLatitude());
    System.out.println("\nX: " + x);
    System.out.println("Y: " + y);
    System.out.println("Z: " + z);
    delta = Math.sqrt((x * x) + (y * y) + (z * z));
    System.out.println("\nDelta: " + delta);

    lightTime = 0.0057755183 * delta;
    System.out.println("Light Time: " + lightTime);

    // Compute the geocentric coordinates for the adjusted time
    double geocentricLongitude = Math.atan2(y, x);
    geocentricLongitude = Utilities.reduceTo2pi(geocentricLongitude);
    double geocentricLatitude = Math.atan2(z, Math.sqrt((x * x) + (y * y)));
    System.out.println("\nGeocentric Longitude (λ): " + Math.toDegrees(geocentricLongitude));
    System.out.println("Geocentric Latitude (β): " + Math.toDegrees(geocentricLatitude));

    // Compute the nutation, obliquity and anomaly
    NutationCalculator calc = NutationCalculatorFactory.DEFAULT.getCalculator(jd);
    Nutation nutation = calc.getNutation();
    System.out.println("\nTrueObliquityOfEcliptic (ϵ): " + nutation
        .getTrueObliquityOfEcliptic()); // ϵ  True obliquity of ecliptic
    System.out.println("NutationInLongitude (Δψ): " + nutation
        .getNutationInLongitude()); // Δψ Add Nutation in longitude to longitude of objects
    System.out.println("NutationInObliquity (Δϵ): " + nutation
        .getNutationInObliquity()); // Δϵ Nutation in obliquity
    double solarTrueAnomaly = computeSunTrueAnomaly(jd);
    System.out.println("SolarTrueAnomaly: " + solarTrueAnomaly); // Δϵ Nutation in obliquity

    // Compute the orbital eccentricity & longitude of perihelion of earth
    double t = computeT(jd);
    double earthOrbitEccentricity = computeEarthOrbitEccentricity(t);
    double longitudeOfPerihelion = computeLongitudeOfPerihelion(t);
    System.out.println("Earth Orbit Eccentricity (e): " + earthOrbitEccentricity);
    System.out.println("Earth Longitude of Perihelion (π): " + longitudeOfPerihelion);

    // Adjust the geocentric longitude & latitude
    double constAbber = -1 * Utilities.getConstantOfAberration();
    double solarTrueAnomalyRadians = Math.toRadians(solarTrueAnomaly);
    double deltaGeoLongitude = constAbber * Math.cos(solarTrueAnomalyRadians - geocentricLongitude);
    deltaGeoLongitude = deltaGeoLongitude + (earthOrbitEccentricity * constAbber * Math
        .cos(longitudeOfPerihelion - geocentricLongitude));
    deltaGeoLongitude = deltaGeoLongitude / Math.cos(geocentricLatitude);
    deltaGeoLongitude = deltaGeoLongitude / 3600.0;
    System.out.println("Delta GeoLong: " + deltaGeoLongitude);
    double innerTerm = Math.sin(solarTrueAnomalyRadians - geocentricLongitude);
    innerTerm = innerTerm - (earthOrbitEccentricity * Math
        .sin(longitudeOfPerihelion - geocentricLongitude));
    double deltaGeoLatitude = constAbber * Math.sin(geocentricLatitude) * innerTerm;
    deltaGeoLatitude = deltaGeoLatitude / 3600.0;
    System.out.println("Delta GeoLat: " + deltaGeoLatitude);
    geocentricLongitude = Math.toDegrees(geocentricLongitude + deltaGeoLongitude);
    geocentricLatitude = Math.toDegrees(geocentricLatitude + deltaGeoLatitude);
    geocentricLongitude = geocentricLongitude + (nutation.getNutationInLongitude() / 3600);
    System.out.println("Geocentric Longitude: " + geocentricLongitude);
    System.out.println("Geocentric Latitude: " + geocentricLatitude);
    // Compute RA/Dec
    RaDec raDec = Utilities
        .convertEclipticalToEquatorial(geocentricLongitude, geocentricLatitude, nutation
            .getTrueObliquityOfEcliptic());
    System.out.println("R.A. (α): " + raDec.getRightAscension().getDecimalHours());
    System.out.println(
        "R.A. (α):" + raDec.getRightAscension().getHour() + ":" + raDec.getRightAscension()
            .getMinutes() + ":" + raDec.getRightAscension().getSeconds());
    System.out.println("Dec (δ): " + raDec.getDeclination().getDecimalDegrees());
    System.out.println(
        "Dec (δ): " + raDec.getDeclination().getIntegerDegrees() + ":" + Math.abs(raDec.getDeclination()
            .getMinutes()) + ":" + Math.abs(raDec.getDeclination().getSeconds()));
  }

  private double computeSunTrueAnomaly(JulianDate jd) {
    JulianDate epoch = new JulianDate(2000, 1, 1, 12, 0, 0);
    double t = jd.getJulianCenturies(epoch);
    double solarGeometricMeanLongitude = 280.46646 + 36000.76983 * t + 0.0003032 * t * t;
    solarGeometricMeanLongitude = Utilities.reduceToRange360(solarGeometricMeanLongitude);
    double solarMeanAnomaly = 357.52911 + 35999.05029 * t - 0.0001537 * t * t;
    solarMeanAnomaly = Utilities.reduceToRange360(solarMeanAnomaly);
    double solarMeanAnomalyRadians = Math.toRadians(solarMeanAnomaly);
    double sunEquationOfCenter =
        (1.914602 - (0.004817 * t) - (0.000014 * t * t)) * Math.sin(solarMeanAnomalyRadians);
    sunEquationOfCenter =
        sunEquationOfCenter + (0.019993 - 0.000101 * t) * Math.sin(2 * solarMeanAnomalyRadians);
    sunEquationOfCenter = sunEquationOfCenter + 0.000289 * Math.sin(3 * solarMeanAnomalyRadians);
    return solarGeometricMeanLongitude + sunEquationOfCenter;
  }

  private double computeEarthOrbitEccentricity(double t) {
    return 0.016708634 - 0.000042037 * t - 0.0000001267 * t * t;
  }

  private double computeLongitudeOfPerihelion(double t) {
    return 102.93735 + 1.71946 * t + 0.00046 * t * t;
  }

  private double computeT(JulianDate jd) {
    JulianDate epoch = new JulianDate(2000, 1, 1, 12, 0, 0);
    return jd.getJulianCenturies(epoch);
  }

}
