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
 * This class is a subclass of AddressV4 with an additional field (prefix) and additional methods
 * to securely manipulate this new field. This class add additional restrictions on user input.
 */
public class NetmaskV4 extends AddressV4 {


    //############################################################################################//
    // =========================================[ FIELDS ] ====================================== //
    //############################################################################################//

    private int prefix; //netmask prefix


    //############################################################################################//
    // ======================================[ CONSTRUCTORS ] =================================== //
    //############################################################################################//

    public NetmaskV4 () {
        super();
        prefix = 0;
    }

    public NetmaskV4 (int prefix) {
        super();
        this.prefix = prefix;
    }


    //############################################################################################//
    // ======================================[ GETORS/SETORS ] ================================== //
    //############################################################################################//

    /**
     * Return the netmask prefix.
     * @return the prefix value.
     */
    public int getPrefix() {
        return prefix;
    }

    /**
     * Set the netmask prefix if the value is valid.
     * Binary values will be updated, which in turn will update the decimal values of the bytes array.
     * @param prefix is the new value for the netmask prefix.
     * @return true if the prefix is valid. False otherwise.
     */
    public boolean setPrefix(int prefix) {
        if (prefix >= 0 && prefix <= 32) {
            this.prefix = prefix;
            setBinaryFromPrefix();
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Set the value of one byte with a decimal value.
     * This method check if the input is valid beforehand
     * and return whether the operation has been successful or not.
     * Override its superclass because additional checks are preformed.
     * @param field provides the array position of the desired byte to be set.
     * @param decimalValue provides the decimal value for the byte to set.
     * @return true if the input is valid and the operation has been successful. False otherwise.
     */
    @Override
    public boolean setByteByDecimal(int field, int decimalValue) {
        if (!isAValidDecimalValue(decimalValue))                return false;
        if (!wouldBeAValidDecimalNetmask(field, decimalValue))  return false;
        if (!bytes[field].setDecimalValue(decimalValue))        return false;
        setPrefixFromBinary();
        return true;
    }

    /**
     * Set the value of one byte with a binary value.
     * This method check if the input is valid beforehand
     * and return whether the operation has been successful or not.
     * Override its superclass because additional checks are preformed.
     * @param field provides the array position of the desired byte to be set.
     * @param binaryValue provides the binary value for the byte to set.
     * @return true if the input is valid and the operation has been successful. False otherwise.
     */
    @Override
    public boolean setByteByBinary(int field, int[] binaryValue) {
        if (!isAValidBinaryValue(binaryValue))                  return false;
        if (!wouldBeAValidBinaryNetmask(field, binaryValue))    return false;
        if (!bytes[field].setBinaryValue(binaryValue))          return false;
        setPrefixFromBinary();
        return true;
    }


    //############################################################################################//
    // =====================================[ PRIVATE METHODS ] ================================= //
    //############################################################################################//

    /**
     * Check if the given decimal value is a valid candidate for a netmask.
     * The method compares the parameter against a valid number list.
     * @param decimalValue provides the binary value for the byte to set.
     * @return true if the decimal value is valid for a netmask address . False otherwise.
     */
    private boolean isAValidDecimalValue(int decimalValue) {
        boolean isValid = false;
        int[] validValues = new int[] {255, 254, 252, 248, 240, 224, 192, 128, 0};

        for (int value:validValues) {
            if (value == decimalValue) {
                isValid = true;
            }
        }
        return isValid;
    }

    /**
     * Check if the given binary value is a valid candidate for a netmask.
     * The method iterate through bits from left to right, once a 0 is found no 1 should be seen.
     * @param binaryValue provides the binary value for the byte to set.
     * @return true if the binary value is valid for a netmask address . False otherwise.
     */
    private boolean isAValidBinaryValue(int[] binaryValue) {
        boolean isValid = true;
        boolean breakpoint = false;
        int bit = 7;

        while (bit >= 0 && isValid) {
            if (binaryValue[bit] == 0 && !breakpoint) {
                breakpoint = true;
            }
            else if (binaryValue[bit] == 1 && breakpoint) {
                isValid = false;
            }
            --bit;
        }
        return isValid;
    }

    /**
     * Check if the given decimal value for a specific bytes would result in a valid netmask address.
     * @param field provides the array position of the desired byte to be set.
     * @param decimalValue provides the binary value for the byte to set.
     * @return true if the decimal value is valid for a netmask address . False otherwise.
     */
    private boolean wouldBeAValidDecimalNetmask(int field, int decimalValue) {
        switch (field) {
            case 0:
                return decimalValue == 0 || bytes[field+1].getDecimalValue() == 255;
            case 1:
            case 2:
                return (decimalValue == 0 && bytes[field-1].getDecimalValue() == 0) || (decimalValue == 255 && bytes[field+1].getDecimalValue() == 255) || (decimalValue > 0 && decimalValue < 255 && bytes[field-1].getDecimalValue() == 0 && bytes[field+1].getDecimalValue() == 255);
            case 3:
                return decimalValue == 255 || bytes[field-1].getDecimalValue() == 0;
            default: return false;
        }
    }

    private int binaryContent(int[] binaryValue) {
        int content = binaryValue[0];
        for (int bit = 1; bit < binaryValue.length; ++bit) {
            if (binaryValue[bit] != content) {
                return -1;
            }
        }
        return content;
    }

    private boolean wouldBeAValidBinaryNetmask(int field, int[] binaryValue) {
        switch (field) {
            case 0:
                return binaryContent(binaryValue) == 0 || binaryContent(bytes[field+1].getBinaryValue()) == 1;
            case 1:
            case 2:
                return (binaryContent(binaryValue) == 0 && binaryContent(bytes[field-1].getBinaryValue()) == 0) || (binaryContent(binaryValue) == 1 && binaryContent(bytes[field+1].getBinaryValue()) == 1) || (binaryContent(binaryValue) == -1  && binaryContent(bytes[field-1].getBinaryValue()) == 0 && binaryContent(bytes[field+1].getBinaryValue()) == 1);
            case 3:
                return binaryContent(binaryValue) == 1 || binaryContent(bytes[field-1].getBinaryValue()) == 0;
            default: return false;
        }
    }

    private void setBinaryFromPrefix() {
        int buffer = prefix;
        int[] byteBuffer = new int[8];

        for (int field = 3; field >= 0; --field) {
            for (int bit = 7; bit >= 0; --bit) {
                if (buffer > 0) {
                    byteBuffer[bit] = 1;
                    --buffer;
                }
                else {
                    byteBuffer[bit] = 0;
                }
            }
            bytes[field].setBinaryValue(byteBuffer);
        }
    }

    private void setPrefixFromBinary() {
        boolean breakpoint = false;
        int field = 3;
        int bit;
        int prefix = 0;

        while (field >= 0 && !breakpoint) {
            bit = 7;
            while (bit >= 0 && !breakpoint) {
                if (bytes[field].getBinaryValue()[bit] == 1) {
                    ++prefix;
                }
                else {
                    breakpoint = true;
                }
                --bit;
            }
            --field;
        }
        this.prefix = prefix;
    }
}