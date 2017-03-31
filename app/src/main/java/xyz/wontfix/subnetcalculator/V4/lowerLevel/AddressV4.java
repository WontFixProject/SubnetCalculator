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

package xyz.wontfix.subnetcalculator.V4.lowerLevel;

/*
 * This class represents IPv4 addresses. It has four bytes and a number of methods
 * setting and getting these bytes while checking the integrity and consistency of
 * data inputs.
 */
public class AddressV4 {


    //############################################################################################//
    // =========================================[ FIELDS ] ====================================== //
    //############################################################################################//

    ByteV4[] bytes;


    //############################################################################################//
    // ======================================[ CONSTRUCTORS ] =================================== //
    //############################################################################################//

    public AddressV4 () {
        bytes = new ByteV4[4];      //IPV4 addresses have four bytes
        bytes[0] = new ByteV4();    //Right byte
        bytes[1] = new ByteV4();    //Middle-right byte
        bytes[2] = new ByteV4();    //Middle-left byte
        bytes[3] = new ByteV4();    //Left byte
    }

    public AddressV4 (AddressV4 addressV4) {
        bytes = new ByteV4[4];
        bytes[0] = new ByteV4(addressV4.getByte(0).getDecimalValue());
        bytes[1] = new ByteV4(addressV4.getByte(1).getDecimalValue());
        bytes[2] = new ByteV4(addressV4.getByte(2).getDecimalValue());
        bytes[3] = new ByteV4(addressV4.getByte(3).getDecimalValue());
    }


    //############################################################################################//
    // ======================================[ GETORS/SETORS ] ================================== //
    //############################################################################################//

    /**
     * Return one of the four ByteV4
     * @param field provides the array position of the desired byte to be returned.
     * @return the requested byte.
     */
    public ByteV4 getByte(int field) {
        return bytes[field];
    }

    /**
     * Set the value of one byte with a decimal value.
     * This method check if the input is valid beforehand
     * and return whether the operation has been successful or not.
     * @param field provides the array position of the desired byte to be set.
     * @param decimalValue provides the decimal value for the byte to set.
     * @return true if the input is valid and the operation has been successful. False otherwise.
     */
    public boolean setByteByDecimal(int field, int decimalValue) {
        return (isAValidDecimalValue(decimalValue) && bytes[field].setDecimalValue(decimalValue));
    }

    /**
     * Set the value of one byte with a binary value.
     * This method check if the input is valid beforehand
     * and return whether the operation has been successful or not.
     * @param field provides the array position of the desired byte to be set.
     * @param binaryValue provides the binary value for the byte to set.
     * @return true if the input is valid and the operation has been successful. False otherwise.
     */
    public boolean setByteByBinary(int field, int[] binaryValue) {
        return (isAValidBinaryValue(binaryValue) && bytes[field].setBinaryValue(binaryValue));
    }


    //############################################################################################//
    // =====================================[ PRIVATE METHODS ] ================================= //
    //############################################################################################//

    /**
     * Check if a decimal value is a suitable candidate for a IPV4 address byte.
     * Value must be equal or greater than 0 and equal or lower than 255.
     * @param decimalValue decimal value to be checked.
     * @return true if the given decimal value is valid.
     */
    private boolean isAValidDecimalValue(int decimalValue) {
        return (decimalValue >= 0 && decimalValue <= 255);
    }

    /**
     * Check if a binary value is a suitable candidate for a IPV4 address byte.
     * Value must not be a null array and have a length of exactly 8.
     * @param binaryValue decimal value to be checked.
     * @return true if the given binary value (array) is valid.
     */
    private boolean isAValidBinaryValue(int[] binaryValue) {
        return (binaryValue != null && binaryValue.length == 8);
    }
}