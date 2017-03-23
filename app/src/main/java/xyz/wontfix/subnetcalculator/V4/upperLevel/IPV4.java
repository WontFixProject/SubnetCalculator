/*
 * This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package xyz.wontfix.subnetcalculator.V4.upperLevel;

import xyz.wontfix.subnetcalculator.V4.lowerLevel.AddressV4;
import xyz.wontfix.subnetcalculator.V4.lowerLevel.NetmaskV4;

public class IPV4 {
    public AddressV4 address;
    public NetmaskV4 netmask;

    public IPV4 () {
        address = new AddressV4();
        netmask = new NetmaskV4();
    }
}
