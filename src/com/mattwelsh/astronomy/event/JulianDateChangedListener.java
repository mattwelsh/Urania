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

/**
 * This interface defines the methods that JulianDateChangedListeners must implement.
 *
 * @author Matt Welsh (mitya.welsh@gmail.com)
 * @version 1.1
 * @since 1.0
 */
public interface JulianDateChangedListener {

  /**
   * Called when a change has been made to a JulianDate object.
   *
   * @param evt And event that describes the change to a JulianDate object.
   */
  void julianDateChanged(JulianDateChangedEvent evt);
}
