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

import static java.lang.Math.pow;

/*
 * This class represents a IPv4 range.
 * It has one starting and one ending AddressV4 as well as an address quantity.
 */
public class RangeV4 {

    //############################################################################################//
    // =========================================[ FIELDS ] ====================================== //
    //############################################################################################//

    private AddressV4 firstAddress; //First address of this range.
    private AddressV4 lastAddress;  //Last address of this range.
    private int addressQuantity;    //Address quantity of this range.


    //############################################################################################//
    // ======================================[ CONSTRUCTORS ] =================================== //
    //############################################################################################//

    /**
     * Blank constructor
     */
    public RangeV4() {
        firstAddress = new AddressV4();
        lastAddress = new AddressV4();
        addressQuantity = 0;
    }

    /**
     * Constructor using an ipv4 to set the range.
     * @param ipv4 is from
     */
    public RangeV4(IPV4 ipv4) {
        firstAddress = new AddressV4(computeFirstAddress(ipv4));
        lastAddress = new AddressV4(computeLastAddress(ipv4));
        addressQuantity = computeAddressQuantity(ipv4.netmask.getPrefix());
    }


    //############################################################################################//
    // ======================================[ GETORS/SETORS ] ================================== //
    //############################################################################################//

    /**
     * @return the first address of this range.
     */
    AddressV4 getFirstAddress() {
        return firstAddress;
    }

    /**
     * @return the last address of this range.
     */
    AddressV4 getLastAddress() {
        return lastAddress;
    }

    /**
     * @return address quantity of this range.
     */
    public int getAddressQuantity() {
        return addressQuantity;
    }

    /**
     * Set this range from a given IPV4.
     * @param ipv4 is the IP from which the range will be computed.
     */
    public void setRangeFromIPV4(IPV4 ipv4) {
        firstAddress = computeFirstAddress(ipv4);
        lastAddress = computeLastAddress(ipv4);
        addressQuantity = computeAddressQuantity(ipv4.netmask.getPrefix());
    }


    //############################################################################################//
    // =====================================[ PRIVATE METHODS ] ================================= //
    //############################################################################################//

    /**
     * Compute the first address of this range.
     * Copy all bits from the IPV4 address where bits from the IPV4 netmask are equal to 1
     * Fill other bits with 0's.
     * @param ipv4 is the IP from which the range will be computed.
     * @return an AddressV4 representing the first address of this range.
     */
    private AddressV4 computeFirstAddress(IPV4 ipv4) {
        AddressV4 addressV4 = new AddressV4();
        int[] byteBuffer = new int[8];

        for (int field = 3; field >= 0; --field) {
            for (int bit = 7; bit >= 0; --bit) {
                if (ipv4.netmask.getByte(field).getBinaryValue()[bit] == 1) {
                    byteBuffer[bit] = ipv4.address.getByte(field).getBinaryValue()[bit];
                }
                else {
                    byteBuffer[bit] = 0;
                }
            }
            addressV4.setByteByBinary(field, byteBuffer);
        }
        return addressV4;
    }

    /**
     * Compute the last address of this range.
     * Copy all bits from the IPV4 address where bits from the IPV4 netmask are equal to 1
     * Fill other bits with 1's
     * @param ipv4 is the IP from which the range will be computed.
     * @return an AddressV4 representing the last address of this range.
     */
    private AddressV4 computeLastAddress(IPV4 ipv4) {
        AddressV4 addressV4 = new AddressV4();
        int[] byteBuffer = new int[8];

        for (int field = 3; field >= 0; --field) {
            for (int bit = 7; bit >= 0; --bit) {
                if (ipv4.netmask.getByte(field).getBinaryValue()[bit] == 1) {
                    byteBuffer[bit] = ipv4.address.getByte(field).getBinaryValue()[bit];
                }
                else {
                    byteBuffer[bit] = 1;
                }
            }
            addressV4.setByteByBinary(field, byteBuffer);
        }
        return addressV4;
    }

    /**
     * Compute the quantity of addresses in this range (using a netmask prefix)
     * @param netmaskPrefix the netmask of an IPV4 in the range.
     * @return the number of addresses in this range.
     */
    private int computeAddressQuantity(int netmaskPrefix) {
        if (netmaskPrefix >=0 && netmaskPrefix <= 32) {
            return (int)pow(2,32 - netmaskPrefix);
        }
        else {
            return -1;
        }
    }
}
