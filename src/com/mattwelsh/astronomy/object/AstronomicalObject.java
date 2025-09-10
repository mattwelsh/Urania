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

/**
 * This interface defines the API that astronomical objects library must implement.
 *
 * <p>It defines methods for retrieving the type of the object, the name of the object, and it's
 * location. For some objects, stars for instance, the RaDec never changes (practically speaking),
 * while for other objects (planets, etc.) the RaDec is dependent on the date for which it is
 * computed.
 *
 * <p>Likewise, if the object is close to earth astronomically speaking, the calculation make take
 * into account the observers location to compute things like parallax.
 *
 * @author Matt Welsh (mitya.welsh@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public interface AstronomicalObject {

  /**
   * Return the name of the object.
   *
   * @return The name of the object.
   */
  public String getObjectName();

  /**
   * Returns the right ascension and declination of the object.
   *
   * @return The right ascension and declination.
   */
  public RaDec getRaDec();

  /**
   * Gets the type of an AstronomicalObject.
   *
   * @return One of the enumerated types below.
   */
  public TYPE getType();

  enum TYPE {
    /** Type for the 8 planets from Mercury to Neptune. */
    PLANET,

    /** Type for moons, including the earth's moon. */
    MOON,

    /** Type for all classes of stars. */
    STAR,

    /** Type for all classes of nebulae. */
    NEBULA,

    /** Type for all classes of clusters. */
    CLUSTER,

    /** Type for all man-made orbiting bodies. */
    SATELLITE,

    /**
     * Type for a planetary-mass object that is neither a true planet nor a natural satellite. That
     * is, it is in direct orbit of a star, and is massive enough for its gravity to compress it
     * into a hydrostatically equilibrious shape (usually a spheroid), but has not cleared the
     * neighborhood of other material around its orbit. Pluto for example.
     */
    DWARF_PLANET,

    /**
     * Type for a small solar system body, an object in the Solar System that is neither a planet, a
     * dwarf planet, nor a natural satellite. This encompasses all comets and all minor planets
     * other than those that are dwarf planets. Thus SSSBs are: the comets; the classical asteroids,
     * with the exception of the dwarf planet Ceres; the trojans; and the centaurs and
     * trans-Neptunian objects, with the exception of the dwarf planets Pluto, Haumea, Makemake, and
     * Eris and others that may turn out to be dwarf planets.
     */
    SSSB,

    /** Type for a small solar system body, of type comet. */
    SSSB_COMET,

    /** Type for a small solar system body, of type asteroid. */
    SSSB_ASTEROID,

    /** Type for a small solar system body, of type trojan. */
    SSSB_TROJAN,

    /** Type for a small solar system body, of type centaur. */
    SSSB_CENTAUR,

    /** Type for a small solar system body, of type trans-neptunian. */
    SSSB_TRANS_NEPTUNIAN
  }
}
