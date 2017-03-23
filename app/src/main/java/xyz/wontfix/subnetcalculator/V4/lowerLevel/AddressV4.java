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

public class AddressV4 {

                                                /*
##############################################################################################
# =========================================[ FIELDS ] ====================================== #
##############################################################################################
                                               */
    ByteV4[] bytes;

                                                /*
##############################################################################################
# ======================================[ CONSTRUCTORS ] =================================== #
##############################################################################################
                                                */
    public AddressV4 () {
        bytes = new ByteV4[4];
        bytes[0] = new ByteV4();
        bytes[1] = new ByteV4();
        bytes[2] = new ByteV4();
        bytes[3] = new ByteV4();
    }

    /*
##############################################################################################
# ======================================[ GETORS/SETORS ] ================================== #
##############################################################################################
    */

    public ByteV4 getByte(int index) {
        return bytes[index];
    }

    public boolean setByteByDecimal(int field, int decimalValue) {
        return (isAValidDecimalValue(decimalValue) && bytes[field].setDecimalValue(decimalValue));
    }

    public boolean setByteByBinary(int field, int[] binaryValue) {
        return (isAValidBinaryValue(binaryValue) && bytes[field].setBinaryValue(binaryValue));
    }

                                                /*
##############################################################################################
# ======================================[ PUBLIC METHODS ] ================================= #
##############################################################################################
                                                */


                                                /*
##############################################################################################
# =====================================[ PRIVATE METHODS ] ================================= #
##############################################################################################
                                                */

    private boolean isAValidDecimalValue(int decimalValue) {
        return (decimalValue >= 0 && decimalValue <= 255);
    }

    private boolean isAValidBinaryValue(int[] binaryValue) {
        return (binaryValue != null && binaryValue.length == 8);
    }
}