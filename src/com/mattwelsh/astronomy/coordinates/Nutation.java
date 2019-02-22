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

/**
 * This class encapsulates the nutation of longitude and obliquity into a pair.
 *
 * @author Matt Welsh (mitya.welsh@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class Nutation {
  private double nutationInLongitude;
  private double nutationInObliquity;
  private double trueObliquityOfEcliptic;

  /**
   * Create a nutation object with zero for both the nutation of the longitude and obliquity set to
   * zero.
   */
  public Nutation() {
    this(0.0,0.0, 0.0);
  }

  /**
   * Create an instance of Nutation with the passed nutation in longitude and obliquity.
   *
   * @param nutationInLongitude
   * @param nutationInObliquity
   */
  Nutation(double nutationInLongitude, double nutationInObliquity, double trueObliquityOfEcliptic) {
    this.nutationInLongitude = nutationInLongitude;
    this.nutationInObliquity = nutationInObliquity;
    this.trueObliquityOfEcliptic = trueObliquityOfEcliptic;
  }

  /**
   * Sets the nutation in longitude to the passed value (expressed in seconds).
   *
   * @param nutationInLongitude The new value of the nutation in longitude.
   */
  public void setNutationInLongitude(double nutationInLongitude) {
    this.nutationInLongitude = nutationInLongitude;
  }

  /**
   * Sets the nutation in obliquity to the passed value (expressed in seconds).
   *
   * @param nutationInObliquity The new value of the nutation in obliquity.
   */
  public void setNutationInObliquity(double nutationInObliquity) {
    this.nutationInObliquity = nutationInObliquity;
  }

  /**
   * Sets the true obliquity of the ecliptic to the passed value (expressed in seconds).
   *
   * @param trueObliquityOfEcliptic the true obliquity of the ecliptic.
   */
  public void setTrueObliquityOfEcliptic(double trueObliquityOfEcliptic) {
    this.trueObliquityOfEcliptic = trueObliquityOfEcliptic;
  }

  /**
   * Returns the nutation in longitude for the passed julian date (expressed in seconds).
   *
   * @return The nutation in longitude for the passed julian date.
   */
  public double getNutationInLongitude() {
    return nutationInLongitude;
  }

  /**
   * Returns the nutation in obliquity for the passed julian date (expressed in seconds).
   *
   * @return The nutation in longitude for the passed julian date.
   */
  public double getNutationInObliquity() {
    return nutationInObliquity;
  }

  /**
   * Returns the true obliquity of the ecliptic (expressed in seconds).
   *
   * @return
   */
  public double getTrueObliquityOfEcliptic() {
    return this.trueObliquityOfEcliptic;
  }
}
