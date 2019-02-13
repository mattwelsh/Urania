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
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
 */
package com.mattwelsh.astronomy.coordinates;

/**
 * This class encapsulates a Right Ascension and Declination into the commonly used coordinate pair.
 *
 * @author Matt Welsh (mitya.welsh@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class RaDec {
  private RightAscension rightAscension;
  private Declination declination;

  /**
   * Construct a coordinate pair for the passed right ascension and declination.
   *
   * @param rightAscension The right ascension coordinate.
   * @param declination The declination coordinate.
   */
  public RaDec(RightAscension rightAscension, Declination declination) {
    this.rightAscension = rightAscension;
    this.declination = declination;
  }

  /**
   * Returns the right ascension coordinate.
   * @return The right ascension coordinate.
   */
  public RightAscension getRightAscension() {
    return this.rightAscension;
  }

  /**
   * Returns the declination coordinate.
   * @return The declination coordinate.
   */
  public Declination getDeclination() {
    return declination;
  }
}
