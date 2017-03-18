package xyz.wontfix.subnetcalculator;

import static java.lang.Math.pow;

/*******************************************************************
 * This class represents bytes used by IPv4 addresses and netmasks *
 *******************************************************************/

public class ByteV4 {
    private int decimalValue;
    private String hexadecimalValue;
    private boolean[] binaryValue;

    //Constructor (from decimal value)
    public ByteV4 (int decimalValue) {
        this.decimalValue = decimalValue;
        this.binaryValue = new boolean[8];
        setBinaryFromDecimal();
        setHexadecimalFromBinary();
    }

    //Compute and set binary value from decimal value
    private void setBinaryFromDecimal() {
        int buffer = decimalValue;
        int power = 7;
        while (buffer != 0 && power >= 0) {
            if (buffer > pow(2,power)) {
                buffer =- (int)pow(2,power);
                binaryValue[power] = true;
            }
            else {
                binaryValue[power] = true;
            }
            --power;
        }
    }

    //Compute and set Hexadecimal value from binary value
    private void setHexadecimalFromBinary() {
        //TODO
    }
}
