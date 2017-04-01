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

import static java.lang.Math.pow;

/*
 * This class represents bytes (fields) used by IPv4 addresses and netmasks.
 */
public class ByteV4 {


    //#############################################################################################
    // =========================================[ FIELDS ] ====================================== #
    //#############################################################################################

    private int decimalValue;   //decimal value of this field/byte
    private int[] binaryValue;  //binary value of this field/byte


    //#############################################################################################
    // ======================================[ CONSTRUCTORS ] =================================== #
    //#############################################################################################

    //Constructor (no value, defaulting to zero)
    ByteV4 () {
        decimalValue = 0;
        this.binaryValue = new int[8];
        setBinaryFromDecimal();
    }

    //Constructor (from decimal value)
    ByteV4 (int decimalValue) {
        this.decimalValue = decimalValue;
        this.binaryValue = new int[8];
        setBinaryFromDecimal();
    }


    //#############################################################################################
    // ======================================[ GETORS/SETORS ] ================================== #
    //#############################################################################################

    /**
     * Return the decimal value of this field/byte.
     * @return the decimal value.
     */
    public int getDecimalValue() {
        return decimalValue;
    }

    /**
     * Return the binary value of this field/byte.
     * @return the binary value.
     */
    public int[] getBinaryValue() {
        return binaryValue;
    }

    /**
     * Set the decimal value of this field/byte. Then set the binary value from the decimal value.
     * @return true if the decimal value is valid and has been set. False otherwise.
     */
    boolean setDecimalValue(int decimalValue) {
        if (decimalValue >= 0 && decimalValue <= 255) {
            this.decimalValue = decimalValue;
            setBinaryFromDecimal();
            return true;
        }
        else
            return false;
    }

    /**
     * Set the binary value of this field/byte. Then set the decimal value from the binary value.
     * @return true if the binary value is valid and has been set. False otherwise.
     */
    boolean setBinaryValue(int [] binaryValue) {
        if (binaryValue != null && binaryValue.length == 8) {
            System.arraycopy(binaryValue, 0, this.binaryValue, 0, 8);
            setDecimalFromBinary();
            return true;
        }
        else
            return false;
    }


    //#############################################################################################
    // =====================================[ PRIVATE METHODS ] ================================= #
    //#############################################################################################

    /**
     * Compute and set the binary value from the decimal value.
     */
    private void setBinaryFromDecimal() {
        int buffer = decimalValue;
        int power = 7;

        for (int i = 0; i < 8; ++i) {
            binaryValue[i] = 0;
        }
        while (buffer > 0 && power >= 0) {
            if (buffer >= pow(2,power)) {
                buffer -= (int)pow(2,power);
                binaryValue[power] = 1;
            }
            else {
                binaryValue[power] = 0;
            }
            --power;
        }
    }

    /**
     * Compute and set the decimal value from the binary value.
     */
    private void setDecimalFromBinary() {

        int decimalValue = 0;

        for (int bit = 7; bit >= 0; --bit) {
            if (binaryValue[bit] == 1)
                decimalValue += (int) pow(2,bit);
        }
        this.decimalValue = decimalValue;
    }
}
