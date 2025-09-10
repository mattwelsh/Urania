/*
 * Copyright (C) 2019-2025 by Matt Welsh
 * This library is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details. You should have received a copy of the GNU
 * Lesser General Public License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
 */
package com.mattwelsh.astronomy.object;

import com.mattwelsh.astronomy.coordinates.RaDec;
import com.mattwelsh.astronomy.time.JulianDate;

/**
 * This interface defines the API that lunar circumstance calculators must implement.
 *
 * <p>It defines methods for calculating the RaDec for a specific instant of time.</p>
 *
 * <p>The reason it exists is to allow the Moon object to declare a method for the calculations that
 * should be used. This approach allows the user of the library to decide whether a lower precision
 * but more computationally inexpensive method will suit their needs, or if they want to use a high
 * precision method.</p>
 *
 * <p>This also allows all of the code for a particular method to be outside the Moon object
 * itself.</p>
 *
 * <p>Finally, this approach makes the library flexible as new lunar theories are published. All
 * that would be required to add a new theory would be to create a circumstance calculator and add
 * an enum to the AstronomicalObject interface.</p>
 *
 * @author Matt Welsh (mitya.welsh@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public interface LunarCircumstanceComputer {

  /**
   * Compute the lunar circumstances for the passes julian date.
   *
   * @param jd The JulianDate to compute circumstances for.
   * @return The right ascension and declination as a coordinate pair.
   */
  void computeCircumstances(JulianDate jd);

  /**
   * Returns the right ascension and declination as a coordinate pair.
   *
   * @return The right ascension and declination as a coordinate pair.
   */
  RaDec getRaDec();

  /**
   * Return the distance in kilometers between the centers of the earth and moon.
   *
   * @return The distance in kilometers between the centers of the earth and moon.
   */
  double getDistance();

  /**
   * Return the mean longitude of the moon.
   *
   * @return The mean longitude of the moon.
   */
  double getMeanLongitude();

  /**
   * Return the mean elongation of the moon.
   *
   * @return The mean elongation of the moon.
   */
  double getMeanElongation();

  /**
   * Return the mean anomaly of the moon.
   *
   * @return The mean anomaly of the moon.
   */
  double getMeanAnomaly();

  /**
   * Return the mean argument of latitude (the distance of the moon from it's ascending node).
   *
   * @return The mean argument of latitude.
   */
  double getArgumentOfLatitude();

  /**
   * Returns the apparent longitude of the moon.
   *
   * @return The apparent longitude of the moon.
   */
  double getApparentLongitude();

  /**
   * Returns the mean ascending node of the moon.
   *
   * @return The mean ascending node of the moon.
   */
  double getMeanAscendingNode();

  /**
   * Returns the mean perigee of the moon.
   *
   * @return The mean perigee of the moon.
   */
  double getMeanPerigee();

  /**
   * Returns the true ascending node of the moon.
   *
   * @return The true ascending node of the moon.
   */
   double getTrueAscendingNode();

  }
