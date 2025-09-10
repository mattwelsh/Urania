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
package com.mattwelsh.astronomy.time;

/**
 * This class implements an enumeration and factory for creating computers for the delta between
 * Universal Time and Dynamical Time. At the moment there are computers available for the method
 * described by J. Meeus (1998), and another described by Chapront-Touze & Chapront (1991) in
 * Lunar Tables and Programs From 4000B.C. to A.D. 8000.
 *
 * @author Matt Welsh (mitya.welsh@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public enum DynamicalTime {

  /**
   * Create a calculator that will use the Espenak & Meeus (2006) method of computation.
   */
  DEFAULT {public DeltaTCalculator getCalculator() { return new EspenakMeeusDeltaT();}},

  /**
   * Create a calculator that will use the Espenak & Meeus (2006) method of computation.
   */
  ESPENAKMEEUS {public DeltaTCalculator getCalculator() { return new EspenakMeeusDeltaT();}},

  /**
   * Create a calculator that will use the Espenak (1987, 1989) method of computation.
   */
  ESPENAK {public DeltaTCalculator getCalculator() { return new EspenakDeltaT();}},

  /**
   * Create a calculator that will use the Meeus (1998) method of computation.
   */
  MEEUS {public DeltaTCalculator getCalculator() { return new MeeusDeltaT();}},

  /**
   * Create a calculator that will use the Chapront-Touze & Chapront (1991) method of computation.
   */
  CHAPRONT {public DeltaTCalculator getCalculator() { return new ChaprontDeltaT();}},

  /**
   * Create a calculator that will use the the method described by Borkowski (1988).
   */
  BORKOWSKI {public DeltaTCalculator getCalculator() { return new BorkowskiDeltaT();}};

  /**
   * Return an instance of DeltaTCalculator that can be used to determine the delta between
   * Universal Time and Dynamical Time.
   *
   * @return A DeltaTCalculator that can be used to determine the delta between Universal Time and
   * Dynamical Time.
   */
  public abstract DeltaTCalculator getCalculator();

  // -----------------------------------------------------------------------------------------------
  // Protected, private, and package local methods
  // -----------------------------------------------------------------------------------------------

  DynamicalTime() {}

}
