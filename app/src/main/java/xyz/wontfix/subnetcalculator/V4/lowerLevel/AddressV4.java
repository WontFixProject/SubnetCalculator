package xyz.wontfix.subnetcalculator.V4.lowerLevel;

/**
 * Created by eneviere on 3/18/2017.
 */

public class AddressV4 {

                                                /*
##############################################################################################
# =========================================[ FIELDS ] ====================================== #
##############################################################################################
                                               */
    protected ByteV4[] bytes;

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
        System.out.println("DEBUG: address override");
        if (!isAValidDecimalValue(decimalValue))
            return false;
        if (!bytes[field].setDecimalValue(decimalValue))
            return false;
        return true;
    }

    public boolean setByteByBinary(int field, int[] binaryValue) {
        if (!isAValidBinaryValue(binaryValue))
            return false;
        if (!bytes[field].setBinaryValue(binaryValue))
            return false;
        return true;
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
        if (decimalValue >= 0 && decimalValue <= 255)
            return true;
        else
            return false;
    }

    private boolean isAValidBinaryValue(int[] binaryValue) {
        if (binaryValue != null && binaryValue.length == 8)
            return true;
        else
            return false;
    }
}