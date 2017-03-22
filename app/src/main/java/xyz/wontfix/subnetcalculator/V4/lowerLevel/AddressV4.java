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