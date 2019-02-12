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

import com.mattwelsh.astronomy.event.JulianDateChangedEvent;
import com.mattwelsh.astronomy.event.JulianDateChangedListener;
import java.util.ArrayList;

/**
 * Like it's parent class, this class represents a Julian Day Number, the number assigned to a solar
 * day in the Julian day count starting from noon Greenwich Mean Time, but unlike it's parent
 * instances of this class are mutable, and there is support for adding DateChangedListeners that
 * can be notified when the JulianDat changes. If you don't need mutability, you may want to
 * consider using JulianDate instead.
 *
 * @author Matt Welsh (mitya.welsh@gmail.com)
 * @version 1.1
 * @since 1.0
 */
public class MutableJulianDate extends JulianDate {

  ArrayList<JulianDateChangedListener> listeners;

  /** Create an instance of JulianDate for the current system time. */
  public MutableJulianDate() {
    super();
  }

  /**
   * Create an instance of JulianDate set to the date and time specified.
   *
   * @param year The year
   * @param month The month
   * @param dayOfMonth The day
   * @param hour The hour
   * @param minute The minute
   * @param second The second
   */
  public MutableJulianDate(int year, int month, int dayOfMonth, int hour, int minute, int second) {
    super(year, month, dayOfMonth, hour, minute, second);
  }

  /**
   * Create an instance of JulianDate set to the julianDayNumber specified. This constructor only
   * works for non-negative values.
   *
   * @param julianDayNumber The julianDayNumber to use to create the JulianDate.
   */
  public MutableJulianDate(double julianDayNumber) {
    super(julianDayNumber);
  }

  /**
   * Sets the date represented by this class to the passed Julian Day Number. Registered listeners
   * are then notified of the change in Julian Day Number.
   *
   * @param julianDayNumber The julianDayNumber to use to create the JulianDate.
   */
  public void setJulianDayNumber(double julianDayNumber) {
    double oldVal = this.julianDayNumber;
    this.julianDayNumber = julianDayNumber;
    computeCalendarDate();
    notifyChangeListeners(oldVal, this.julianDayNumber);
  }

  /**
   * Sets the date represented by this class to the Julian Day Number represented by the passed
   * values. Registered listeners are then notified of the change in Julian Day Number.
   *
   * @param year The year
   * @param month The month
   * @param dayOfMonth The day
   * @param hour The hour
   * @param minute The minute
   * @param second The second
   */
  public void setJulianDate(int year, int month, int dayOfMonth, int hour, int minute, int second) {
    double oldVal = this.julianDayNumber;
    this.year = year;
    this.month = month;
    this.dayOfMonth = dayOfMonth;
    this.hour = hour;
    this.minute = minute;
    this.second = second;
    computeJulianDayNumber();
    notifyChangeListeners(oldVal, this.julianDayNumber);
  }

  /**
   * Adds a change listener that is notified when the date represented by this object changes.
   *
   * @param listener The listener that is notified when the date represented by this object changes.
   */
  public void addDateChangedListener (JulianDateChangedListener listener) {
    if (listeners == null) {
      listeners = new ArrayList<JulianDateChangedListener>();
    }
    listeners.add(listener);
  }

  /**
   * Removes a change listener that was notified when the date represented by this object changes.
   *
   * @param listener The listener to remove.
   */
  public void removeDateChangedListener(JulianDateChangedListener listener) {
    if (listeners == null) {
      return;
    }
    listeners.remove(listener);
    if (listeners.size() == 0) {
      listeners = null;
    }
  }

  // -----------------------------------------------------------------------------------------------
  // Protected and private methods
  // -----------------------------------------------------------------------------------------------

  private void notifyChangeListeners(double oldValue, double newValue) {
    if (listeners == null) {
      return;
    }
    JulianDateChangedEvent evt = new JulianDateChangedEvent(this, oldValue, newValue);
    listeners.forEach(n -> n.julianDateChanged(evt));
  }
}
