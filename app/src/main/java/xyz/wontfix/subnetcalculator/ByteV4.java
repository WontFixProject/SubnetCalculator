package xyz.wontfix.subnetcalculator;

import static java.lang.Math.pow;

/*******************************************************************
 * This class represents bytes used by IPv4 addresses and netmasks *
 *******************************************************************/

public class ByteV4 {
    public int decimalValue;
    public String hexadecimalValue;
    public int[] binaryValue;

    //Constructor (no value, defaulting to zero)
    public ByteV4 () {
        decimalValue = 0;
        this.binaryValue = new int[8];
        setBinaryFromDecimal();
        setHexadecimalFromBinary();
    }

    //Constructor (from decimal value)
    public ByteV4 (int decimalValue) {
        this.decimalValue = decimalValue;
        this.binaryValue = new int[8];
        setBinaryFromDecimal();
        setHexadecimalFromBinary();
    }

    //Compute and set binary value from decimal value
    public void setBinaryFromDecimal() {
        int buffer = decimalValue;
        int power = 7;

        for (int i=0; i<8; ++i) {
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
            power = power - 1;
        }
    }

    //Compute and set Hexadecimal value from binary value
    private void setHexadecimalFromBinary() {
        //TODO
    }
}
