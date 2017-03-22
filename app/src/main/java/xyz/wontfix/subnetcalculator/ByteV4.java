package xyz.wontfix.subnetcalculator;

import static java.lang.Math.pow;

/*******************************************************************
 * This class represents bytes used by IPv4 addresses and netmasks *
 *******************************************************************/

public class ByteV4 {

                                                /*
##############################################################################################
# =========================================[ FIELDS ] ====================================== #
##############################################################################################
                                                */
    private int decimalValue;
    private int[] binaryValue;

                                                /*
##############################################################################################
# ======================================[ CONSTRUCTORS ] =================================== #
##############################################################################################
                                                */
    //Constructor (no value, defaulting to zero)
    public ByteV4 () {
        decimalValue = 0;
        this.binaryValue = new int[8];
        setBinaryFromDecimal();
    }

    //Constructor (from decimal value)
    public ByteV4 (int decimalValue) {
        this.decimalValue = decimalValue;
        this.binaryValue = new int[8];
        setBinaryFromDecimal();
    }

                                                /*
##############################################################################################
# ======================================[ GETORS/SETORS ] ================================== #
##############################################################################################
                                                */
    public int getDecimalValue() {
        return decimalValue;
    }

    public int[] getBinaryValue() {
        return binaryValue;
    }

    public boolean setDecimalValue(int decimalValue) {
        if (decimalValue >= 0 && decimalValue <= 255) {
            this.decimalValue = decimalValue;
            setBinaryFromDecimal();
            return true;
        }
        else
            return false;
    }

    public boolean setBinaryValue(int [] binaryValue) {
        if (binaryValue != null && binaryValue.length == 8) {
            System.arraycopy(binaryValue, 0, this.binaryValue, 0, 8);
            setDecimalFromBinary();
            return true;
        }
        else
            return false;
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
    //Compute and set binaryValue from decimalValue
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

    //Compute and set decimalValue from binaryValue
    private void setDecimalFromBinary() {

        int decimalValue = 0;

        for (int bit = 7; bit >= 0; --bit) {
            if (binaryValue[bit] == 1)
                decimalValue += (int) pow(2,bit);
        }
        this.decimalValue = decimalValue;
    }
}
