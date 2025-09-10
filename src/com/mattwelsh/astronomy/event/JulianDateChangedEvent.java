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
package com.mattwelsh.astronomy.event;

import java.util.EventObject;

/**
 * This class represents a change to a JulianDate instance.
 *
 * @author Matt Welsh (mitya.welsh@gmail.com)
 * @version 1.1
 * @since 1.0
 */
public class JulianDateChangedEvent extends EventObject {

  double oldJulianDate;
  double newJulianDate;

  /**
   * Create an instance of a JulianDateChangedEvent.
   *
   * @param source The JulianDate that changed
   * @param oldJulianDate The old value of the JulianDate that changed.
   * @param newJulianDate The new value of the JulianDate that changed.
   */
  public JulianDateChangedEvent(Object source, double oldJulianDate, double newJulianDate) {
    super(source);
  }

  /**
   * Return the value of the JulianDate before the change occurred.
   *
   * @return The value of the JulianDate before the change occurred.
   */
  public double getOldJulianDate() {
    return this.oldJulianDate;
  }

  /**
   * Return the value of the JulianDate after the change occurred.
   *
   * @return The value of the JulianDate after the change occurred.
   */
  public double getNewJulianDate() {
    return this.newJulianDate;
  }
}
