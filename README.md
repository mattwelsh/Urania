# Urania
### Introduction
#### History and References
This library is a new Java port of a similar library I wrote in C and C++. In creating and updating it, I drew from a number 
of sources as well as a few newer ones. For folks who are familiar with computational astronomy, the list should include recognizable 
titles:

    Astronomical Formulae for Calculators by Jean Meeus
    Astronomical Algorithms by Jean Meeus
    Lunar Tables and Programs by Chapront-Touze & Chapront
    Planetary Programs and Tables from -4000 to +2800 by Bretagnon & Simon
#### Name
In Greek mythology Urania was the muse of astronomy, and dressed in a cloak embroidered with stars. She is usually represented 
with a small celestial globe to which she points with a little staff. She was said to be able to foretell the future by the 
arrangement of the stars.

### Design Principles
There are a few underlying goals behind the library, besides obviously trying to follow well-known best practices for writing code. 
Those for Urania included:

Rely on as few underlying libraries as possible, the rationale being that minimizing dependencies will result in
fewer breakages.
    
Strive for 100% test code coverage. Currently the tests cover more than 94% of the lines, and while testing can 
always be improved, it's not a bad start.
    
Separate the data calculation code from the objects they are computed for. As an example, the Moon object 
doesn't do any calculations directly, but rather delegates that task to lunar circumstance computers, which
in turn can use different methods to achieve different levels of accuracy. This design also allows new 
calculators to be added as new lunar theories emerge.
    
Objects in the system are loosly coupled and events and event listeners are used to message changed states 
in the system. For example, the JulianDate class is immutable, but the MutableJulianDate subclass can take 
listeners that are notified when the MutableJulianDate changes. Classes that use a MutableJulianDate can 
register a listener on the date, and can recalculate their data.

### License
This library is covered by the GNU Lesser General Public License.
This library is free software; you can redistribute it and/or modify it under the terms of the
GNU Lesser General Public License as published by the Free Software Foundation; either version
2.1 of the License, or any later version.

This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
See the GNU General Public License for more details. You should have received a copy of the GNU
Lesser General Public License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA

If you find errors in the code, I would be grateful if you send them to me at <a href="mailto:mitya.welsh@gmail.com">mitya.welsh@gmail.com</a>   
