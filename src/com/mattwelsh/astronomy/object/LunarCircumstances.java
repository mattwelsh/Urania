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

package com.mattwelsh.astronomy.object;

/**
 * Use the method of Jean Meeus in Astronomical Algorithms. This is the default method in the first
 * version of the library, but one that will use the method of Michelle Chapront-Touze & Jean
 * Chapront in Lunar Tables and Programs from 4000 B.C. to A.D. 8000 will be added.
 */
public enum LunarCircumstances {

  /**
   * Use the default method in this case the method of Jean Meeus in Astronomical Algorithms.
   */
  DEFAULT {
    public LunarCircumstanceComputer getCalculator() { return new MeeusCircumstanceComputer();}
  },

  /**
   * Use the method of Jean Meeus in Astronomical Algorithms. This is the default method in the
   * first version of the library.
   */
  MEEUS {
    public LunarCircumstanceComputer getCalculator() { return new MeeusCircumstanceComputer();}
  },;

  /**
   * Returns an instance of a LunarCircumstanceComputer that can be used to compute the lunar
   * circumstances for a particular date, using one of methods above.
   *
   * @return An instance of a LunarCircumstanceComputer
   */
  abstract LunarCircumstanceComputer getCalculator();

}

