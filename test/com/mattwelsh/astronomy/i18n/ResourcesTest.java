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
package com.mattwelsh.astronomy.i18n;
import java.util.Locale;
import java.util.ResourceBundle;
import org.junit.Test;
import org.junit.Assert;

/**
 * Unit tests for the resources used in Urania
 *
 * @author Matt Welsh
 * @version 1.0
 * @since 1.0
 */
public class ResourcesTest {


  /**
   * Tests the Russian language resources
   *
   * @throws Exception
   */
  @Test
  public void testRussianResources() throws Exception {

    Locale locale = new Locale("ru", "RU");
    ResourceBundle bundle = ResourceBundle.getBundle("com.mattwelsh.astronomy.i18n.Urania", locale);

    Assert.assertEquals(bundle.getString("sun"), "Солнце");
  }

  /**
   * Tests the English language resources
   *
   * @throws Exception
   */
  @Test
  public void testEnglishResources() throws Exception {
    Locale locale = new Locale("en", "US");
    ResourceBundle bundle = ResourceBundle.getBundle("com.mattwelsh.astronomy.i18n.Urania", locale);
    Assert.assertEquals(bundle.getString("sun"), "Sun");
  }

}
