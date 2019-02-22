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

/**
 * This class implements an enumeration and factory for creating computers for the nutation of
 * longitude and obliquity. At the moment there are computers available only for the method
 * described by J. Meeus (1998). Another described by Chapront-Touze & Chapront (1991) in Lunar
 * Tables and Programs From 4000 B.C. to A.D. 8000 will be added.
 *
 * @author Matt Welsh (mitya.welsh@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public enum NutationCalculatorFactory {

  /**
   * Create a calculator that will use the Meeus (1998) method of computation.
   */
  DEFAULT {public NutationCalculator getCalculator(JulianDate jd) {
    return new MeeusNutationCalculator(jd);}},

  /**
   * Create a calculator that will use the Meeus (1998) method of computation.
   */
  MEEUS {public NutationCalculator getCalculator(JulianDate jd) {
    return new MeeusNutationCalculator(jd);}},;

  /**
   * Return an instance of DeltaTCalculator that can be used to determine the delta between
   * Universal Time and Dynamical Time.
   *
   * @return A DeltaTCalculator that can be used to determine the delta between Universal Time and
   * Dynamical Time.
   */
  public abstract NutationCalculator getCalculator(JulianDate jd);

  // -----------------------------------------------------------------------------------------------
  // Protected, private, and package local methods
  // -----------------------------------------------------------------------------------------------

  NutationCalculatorFactory() {}


  }
