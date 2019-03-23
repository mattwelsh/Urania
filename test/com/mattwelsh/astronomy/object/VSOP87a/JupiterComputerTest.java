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

package com.mattwelsh.astronomy.object.VSOP87a;

import com.mattwelsh.astronomy.time.JulianDate;
import org.junit.Test;

public class JupiterComputerTest {

  @Test
  public void TestRectangularCoords() {
    //JulianDate jd = new JulianDate(2448724.5);
    JulianDate jd = new JulianDate(2448972.5);
    JupiterComputer comp = new JupiterComputer(jd);
    //Assert.assertEquals(comp.getRectX(), -5.1759773275205045, 0.00000000000000001);
    //Assert.assertEquals(comp.getRectY(), 1.5738696075877108, 0.00000000000000001);
    //Assert.assertEquals(comp.getRectZ(), 0.10940416381524534, 0.00000000000000001);
    double[] eclipticCoords = new double[] {comp.getRectX(),comp.getRectY(),comp.getRectZ()};
    double[] FK5Coords = meanEclipticJ2000ToEquatorialFK5(eclipticCoords);

    for (int i = 0; i < FK5Coords.length; i++) {
      System.out.println("\nPosition: " + FK5Coords[i]);
    }
  }

  /**
   * Transform J2000 mean ecliptic coordinates into equatorial.
   * Specific to this theory (class) to compare positions with DE200.
   *
   * @param position Ecliptic coordinates (x, y, z) or (x, y, z, vx, vy, vz)
   *        refered to mean ecliptic and dynamical equinox of J2000.
   * @return Equatorial FK5 coordinates.
   */
  private static double[] meanEclipticJ2000ToEquatorialFK5(double position[])
  {
    double RotM[][] = new double[4][4];
    double out_pos[] = new double[3];
    double out_vel[] = new double[3];

    RotM[1][1] = 1.000000000000;
    RotM[1][2] = 0.000000440360;
    RotM[1][3] = -0.000000190919;
    RotM[2][1] = -0.000000479966;
    RotM[2][2] = 0.917482137087;
    RotM[2][3] = -0.397776982902;
    RotM[3][1] = 0.000000000000;
    RotM[3][2] = 0.397776982902;
    RotM[3][3] = 0.917482137087;

    // Apply rotation
    out_pos[0] = RotM[1][1] * position[0] + RotM[1][2] * position[1] + RotM[1][3] * position[2]; // x
    out_pos[1] = RotM[2][1] * position[0] + RotM[2][2] * position[1] + RotM[2][3] * position[2]; // y
    out_pos[2] = RotM[3][1] * position[0] + RotM[3][2] * position[1] + RotM[3][3] * position[2]; // z
    if (position.length > 3)
    {
      out_vel[0] = RotM[1][1] * position[3] + RotM[1][2] * position[4] + RotM[1][3] * position[5]; // vx
      out_vel[1] = RotM[2][1] * position[3] + RotM[2][2] * position[4] + RotM[2][3] * position[5]; // vy
      out_vel[2] = RotM[3][1] * position[3] + RotM[3][2] * position[4] + RotM[3][3] * position[5]; // vz

      return new double[]
          { out_pos[0], out_pos[1], out_pos[2], out_vel[0], out_vel[1], out_vel[2] };
    }

    return out_pos;
  }


}