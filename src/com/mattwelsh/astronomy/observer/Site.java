/*
 * Copyright (C) 2019 by Matt Welsh
 * This library is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details. You should have received a copy of the GNU
 * Lesser General Public License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 U.S.A.
 */
package com.mattwelsh.astronomy.observer;

/**
 * This class represents an observational site on the surface of the earth. The geocentric latitude
 * is calculated from the geographical latitude which is in turn used in the calculation of
 * diurnal parallaxes, eclipses, and occultations.
 *
 * @author Matt Welsh (mitya.welsh@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class Site {

  private String siteName;
  private double geographicalLatitude;
  private double longitude;
  private double altitude;
  private double geocentricLatitude;
  private double rhoSinPhiPrime;
  private double rhoCosPhiPrime;

  /**
   * Create an instance of an observing site with the specified name, latitude, longitude and
   * altitude.
   *
   * @param siteName The name of the site.
   * @param geographicalLatitude The geographical latitude of the site.
   * @param longitude The geographical longitude of the site.
   * @param altitude The altitude of the site in meters.
   */
  public Site(String siteName, double geographicalLatitude, double longitude, double altitude) {
    this.siteName = siteName;
    this.geographicalLatitude = geographicalLatitude;
    this.longitude = longitude;
    this.altitude = altitude;
    computeFields();
  }

  /**
   * Get the site name.
   *
   * @return The display name of the observing site.
   */
  public String getSiteName() {
    return this.siteName;
  }

  /**
   * Return the geographical latitude of the observing site.
   *
   * @return The geographical latitude of the observing site.
   */
  public double getGeographicalLatitude() {
    return this.geographicalLatitude;
  }

  /**
   * Return the geographical longitude of the observing site.
   * @return The geographical longitude of the observing site.
   */
  public double getLongitude() {
    return this.longitude;
  }

  /**
   * Return the altitude of the observing site in meters.
   *
   * @return The altitude of the observing site in meters.
   */
  public double getAltitude() {
    return this.altitude;
  }

  /**
   * Return the geocentric latitude of the observing site.
   *
   * @return The geocentric latitude of the observing site.
   */
  public double getGeocentricLatitude() {
    return this.geocentricLatitude;
  }

  /**
   * Return the value of Rho Sin Prime for this site, used in calculating diurnal parallaxes,
   * eclipses, and occultations.
   *
   * @return The value of Rho Sin Prime for this site.
   */
  public double getRhoSinPhiPrime() {
    return this.rhoSinPhiPrime;
  }

  /**
   * Return the value of Rho Cos Prime for this site, used in calculating diurnal parallaxes,
   * eclipses, and occultations.
   *
   * @return The value of Rho Cos Prime for this site.
   */
  public double getRhoCosPhiPrime() {
    return this.rhoCosPhiPrime;
  }

  // -----------------------------------------------------------------------------------------------
  // Protected and private methods
  // -----------------------------------------------------------------------------------------------

  private void computeFields() {

    double polarRadius = 6356.755;
    double equatorialRadius = 6378.14;
    double polarOverEquatorial = polarRadius / equatorialRadius;

    if((this.geographicalLatitude == 0.0) ||
        (this.geographicalLatitude == 90.0) ||
        (this.geographicalLatitude == -90.0)) {
      this.geocentricLatitude = this.geographicalLatitude;
    } else {
      this.geocentricLatitude =
          Math.toDegrees(Math.atan(
              polarOverEquatorial
                  * polarOverEquatorial
                  * Math.tan(Math.toRadians(this.geographicalLatitude))));
    }
    System.out.println(this.geocentricLatitude);

    double u = Math.atan(polarOverEquatorial *
        Math.tan(Math.toRadians(this.geographicalLatitude)));

    this.rhoSinPhiPrime = (polarOverEquatorial * Math.sin(u)) + ((this.altitude / 6378140) *
        Math.sin(Math.toRadians(this.geographicalLatitude)));

    this.rhoCosPhiPrime = Math.cos(u) + ((this.altitude /6378140) *
        Math.cos(Math.toRadians(this.geographicalLatitude)));
  }
}
