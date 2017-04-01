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

package xyz.wontfix.subnetcalculator.V6;

import static java.lang.Math.pow;

public class FieldV6 {

    //############################################################################################//
    // =========================================[ FIELDS ] ====================================== //
    //############################################################################################//

    private int[][] binHalfByte;//Binary value of this field (4 * 4 digits)
    private char[] hexHalfByte; //Hexadecimal value of this field (4 digits)


    //############################################################################################//
    // ======================================[ CONSTRUCTORS ] =================================== //
    //############################################################################################//

    /**
     * Blank Constructor
     */
    public FieldV6() {
        binHalfByte = new int[4][4];
        hexHalfByte = new char[4];
    }

    /**
     * Constructor using a hexadecimal value to setup its values.
     * @param hex four digits hexadecimal value used to set this FieldV6.
     */
    public FieldV6(char[] hex) {
        binHalfByte = new int[4][4];
        hexHalfByte = new char[4];
        setFieldFromHex(hex);
    }


    //############################################################################################//
    // ======================================[ GETORS/SETORS ] ================================== //
    //############################################################################################//

    /**
     * Set this FieldV6 values from a four digits hexadecimal value.
     * @param hex four digits hexadecimal value used to set this FieldV6.
     * @return True if the hex parameter is valid and FieldV6 has been setup. False otherwise.
     */
    boolean setFieldFromHex (char[] hex) {
        if (hex.length == 4) {
            int[] buffer0 = hex2bin(hex[0]);
            int[] buffer1 = hex2bin(hex[1]);
            int[] buffer2 = hex2bin(hex[2]);
            int[] buffer3 = hex2bin(hex[3]);

            if (buffer0 == null || buffer1 == null || buffer2 == null || buffer3 == null) {
                return false;
            }
            else {
                System.arraycopy(hex, 0, hexHalfByte, 0, 4);
                System.arraycopy(buffer0, 0, binHalfByte[0], 0, 4);
                System.arraycopy(buffer1, 0, binHalfByte[1], 0, 4);
                System.arraycopy(buffer2, 0, binHalfByte[2], 0, 4);
                System.arraycopy(buffer3, 0, binHalfByte[3], 0, 4);
                return true;
            }

        }
        return false;
    }

    /**
     * @return the four digits hexadecimal values of this FieldV6
     */
    public char[] getHexHalfByteArray() {
        return hexHalfByte;
    }

    /**
     * @return the 16 (4 * 4) digits binary values of this FieldV6
     */
    public int[][] getBinHalfByteArray() {
        return binHalfByte;
    }

    /**
     * Return a specific hexadecimal digit.
     * @param halfByte specifies which hexadecimal digit is requested.
     * @return the specific requested hexadecimal digit.
     */
    public char getHexHalfByte(int halfByte) {
        return hexHalfByte[halfByte];
    }

    /**
     * Return a specific four digits binary array.
     * @param halfByte specifies which four digits binary array is requested.
     * @return the specific requested four digits binary array.
     */
    public int[] getBinHalfByte(int halfByte) {
        return binHalfByte[halfByte];
    }

    /**
     * Return a specific binary digit.
     * @param halfByte specifies from which four digits binary array the requested binary digit is.
     * @param bit specifies which bit in the halfByte four digits binary array is requested.
     * @ the specific requested binary digit.
     */
    public int getBinHalfByteBit(int halfByte, int bit) {
        return binHalfByte[halfByte][bit];
    }


    //############################################################################################//
    // =====================================[ PRIVATE METHODS ] ================================= //
    //############################################################################################//

    /**
     * Return a four digits binary value from an one digit hexadecimal value.
     * @param hex is the one digit hexadecimal value from which the four digit binary value will be computed.
     * @return a four digits binary value matching the hexadecimal value. False if the hexadecimal value is invalid.
     */
    private int[] hex2bin(char hex) {
        switch (hex) {
            case '0': return new int[] {0, 0, 0, 0};
            case '1': return new int[] {0, 0, 0, 1};
            case '2': return new int[] {0, 0, 1, 0};
            case '3': return new int[] {0, 0, 1, 1};
            case '4': return new int[] {0, 1, 0, 0};
            case '5': return new int[] {0, 1, 0, 1};
            case '6': return new int[] {0, 1, 1, 0};
            case '7': return new int[] {0, 1, 1, 1};
            case '8': return new int[] {1, 0, 0, 0};
            case '9': return new int[] {1, 0, 0, 1};
            case 'a': return new int[] {1, 0, 1, 0};
            case 'b': return new int[] {1, 0, 1, 1};
            case 'c': return new int[] {1, 1, 0, 0};
            case 'd': return new int[] {1, 1, 0, 1};
            case 'e': return new int[] {1, 1, 1, 0};
            case 'f': return new int[] {1, 1, 1, 1};
            default: return null;
        }
    }

    /**
     * Return a one digit hexadecimal value from a four digits binary value.
     * @param bin the four digits value from which the one digit hexadecimal value will be computed.
     * @return the one digit hexadecimal value matching the binary value.
     * 'z' if the binary length is invalid, 'x' if the binary content is invalid.
     */
    private char bin2hex(int[] bin) {
        if (bin.length == 4) {
            int dec = (int)((bin[0] * pow(2,3)) + bin[1] * pow(2,2) + bin[2] * pow(2,1) + bin[3] * pow(2,0));
            switch (dec) {
                case 0: return '0';
                case 1: return '1';
                case 2: return '2';
                case 3: return '3';
                case 4: return '4';
                case 5: return '5';
                case 6: return '6';
                case 7: return '7';
                case 8: return '8';
                case 9: return '9';
                case 10: return 'a';
                case 11: return 'b';
                case 12: return 'c';
                case 13: return 'd';
                case 14: return 'e';
                case 15: return 'f';
                default: return 'x';
            }
        }
        else {
            return 'z';
        }
    }
}
