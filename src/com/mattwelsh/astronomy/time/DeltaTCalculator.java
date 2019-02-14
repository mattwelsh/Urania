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
package com.mattwelsh.astronomy.time;

/**
 * This interface defines the API that DeltaTCalculators must implement. There can be many
 * implementations, varying from simply looking the value up in a table, to approximating the value
 * using one of the many algorithms available. This design is to make the system flexible when new
 * methods are defined.
 *
 * @author Matt Welsh (mitya.welsh@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public interface DeltaTCalculator {

  JulianDate EPOCH2000 = new JulianDate(2000, 1, 1, 12, 0, 0);
  JulianDate EPOCH1000 = new JulianDate(1000, 1, 1, 12, 0, 0);
  JulianDate EPOCH1600 = new JulianDate(1600, 1, 1, 12, 0, 0);
  JulianDate EPOCH1700 = new JulianDate(1700, 1, 1, 12, 0, 0);
  JulianDate EPOCH1800 = new JulianDate(1800, 1, 1, 12, 0, 0);
  JulianDate EPOCH1860 = new JulianDate(1860, 1, 1, 12, 0, 0);
  JulianDate EPOCH1900 = new JulianDate(1900, 1, 1, 12, 0, 0);
  JulianDate EPOCH1920 = new JulianDate(1920, 1, 1, 12, 0, 0);
  JulianDate EPOCH1950 = new JulianDate(1950, 1, 1, 12, 0, 0);
  JulianDate EPOCH1975 = new JulianDate(1975, 1, 1, 12, 0, 0);
  JulianDate EPOCH1820 = new JulianDate(1820, 1, 1, 12, 0, 0);

  /**
   * Return an approximation of the delta in seconds between Dynamical Time (TD) and Universal Time
   * (UT) using the expression deltaT = TD - UT.
   *
   * <p>This value can only be deduced only by observation, and therefore for future dates it is
   * approximated by different methods. Some of the uncertainty can reach as much as 7200 seconds
   * (two hours) for 4000 B.C.
   *
   *
   * @param julianDate @return Return an approximation of the delta in seconds between Dynamical Time (TD) and
   *     Universal Time * (UT)
   */
  double getDeltaT(JulianDate julianDate);
}
