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
package com.mattwelsh.astronomy.object;

import com.mattwelsh.astronomy.coordinates.RaDec;
import com.mattwelsh.astronomy.time.JulianDate;
import com.mattwelsh.astronomy.time.MutableJulianDate;
import java.util.ResourceBundle;

/**
 * This class implements the AstronomicalObject interface and calculates the circumstances of the
 * moon using one of the methods specified by the METHOD enumeration.
 *
 * @author Matt Welsh (mitya.welsh@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class Moon implements AstronomicalObject {

  private JulianDate julianDate;
  private LunarCircumstanceComputer computer;

  /**
   * Create an instance of the Moon object and calculate the circumstances of the moon for that
   * moment in time using the default method.
   *
   * @param julianDate The date to use to compute the circumstances.
   */
  public Moon(JulianDate julianDate) {
    this(julianDate, LunarCircumstances.DEFAULT.getCalculator());
  }

  /**
   * Create an instance of the Moon object and calculate the circumstances of the moon for that
   * moment in time using the passed method.
   *
   * @param julianDate The date to use to compute the circumstances.
   * @param computer The LunarCircumstanceComputer to use to do the calculations.
   */
  public Moon(JulianDate julianDate, LunarCircumstanceComputer computer) {
    this.julianDate = julianDate;
    if (julianDate instanceof MutableJulianDate) {
      ((MutableJulianDate) julianDate).addDateChangedListener(evt -> calculateCircumstances());
    }
    this.computer = computer;
    calculateCircumstances();
  }

  @Override
  public String getObjectName() {
    return ResourceBundle.getBundle("com.mattwelsh.astronomy.i18n.Urania").getString("moon");
  }

  @Override
  public RaDec getRaDec() {
    return this.computer.getRaDec();
  }

  /**
   * Return the distance in kilometers between the centers of the earth and moon.
   *
   * @return The distance in kilometers between the centers of the earth and moon.
   */
  public double getDistance() {
    return this.computer.getDistance();
  }

  /**
   * Return a reference to the circumstance computer used to compute circumstances for this object.
   *
   * @return a reference to the circumstance computer used to compute circumstances for this object.
   */
  public LunarCircumstanceComputer getComputer() {
    return this.computer;
  }

  // -----------------------------------------------------------------------------------------------
  // Protected, package local, & and private methods
  // -----------------------------------------------------------------------------------------------

  protected void calculateCircumstances() {
    this.computer.computeCircumstances(this.julianDate);
  }
}
