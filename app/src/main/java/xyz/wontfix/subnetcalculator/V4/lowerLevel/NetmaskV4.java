package xyz.wontfix.subnetcalculator.V4.lowerLevel;

public class NetmaskV4 extends AddressV4 {

                                                /*
##############################################################################################
# =========================================[ FIELDS ] ====================================== #
##############################################################################################
                                                */
    private int affix;

                                                /*
##############################################################################################
# ======================================[ CONSTRUCTORS ] =================================== #
##############################################################################################
                                                */
    public NetmaskV4 () {
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
    public int getAffix() {
        return this.affix;
    }

    public boolean setAffix(int affix) {
        if (affix >= 0 && affix <= 32) {
            this.affix = affix;
            setBinaryFromAffix();
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

    @Override
    public boolean setByteByDecimal(int field, int decimalValue) {
        if (!isAValidDecimalValue(decimalValue))
            return false;
        if (!wouldBeAValidDecimalNetmask(field, decimalValue))
            return false;
        if (!bytes[field].setDecimalValue(decimalValue))
            return false;
        setAffixFromBinary();
        return true;
    }

    @Override
    public boolean setByteByBinary(int field, int[] binaryValue) {
        if (!isAValidBinaryValue(binaryValue))
            return false;
        if(!wouldBeAValidBinaryNetmask(field, binaryValue))
            return false;
        if (!bytes[field].setBinaryValue(binaryValue))
            return false;
        setAffixFromBinary();
        return true;
    }

                                                /*
##############################################################################################
# =====================================[ PRIVATE METHODS ] ================================= #
##############################################################################################
                                                */
    private boolean isAValidDecimalValue(int decimalValue) {

        boolean isValid = false;
        int[] validValues = new int[] {255, 254, 252, 248, 240, 224, 192, 128, 0};

        for (int value:validValues) {
            if (value == decimalValue)
                isValid = true;
        }
        return isValid;
    }

    private boolean isAValidBinaryValue(int[] binaryValue) {

        boolean isValid = true;
        boolean breakpoint = false;
        int bit = 7;

        while (bit >= 0 && isValid) {
            if (binaryValue[bit] == 0 && !breakpoint)
                breakpoint = true;
            else if (binaryValue[bit] == 1 && breakpoint)
                isValid = false;
            --bit;
        }
        return isValid;
    }

    private boolean wouldBeAValidDecimalNetmask(int field, int decimalValue) {
        return ((field == 0 && decimalValue != 0 && bytes[field+1].getDecimalValue() == 255) || ((field == 1 || field == 2) && decimalValue != 255 && bytes[field-1].getDecimalValue() == 0 || decimalValue != 0 && bytes[field+1].getDecimalValue() == 255) || (field == 3 && decimalValue != 255 && bytes[field-1].getDecimalValue() == 0));
    }

    //LOGIC IS FLAWED - NEED RE-WRITE
    private boolean wouldBeAValidBinaryNetmask(int field, int[] binaryValue) {
        if (field > 0 && binaryValue[0] == 0 && bytes[field-1].getBinaryValue()[7] != 0)
            return false;
        if (field < 3 && binaryValue[7] != 0 && bytes[field+1].getBinaryValue()[0] == 0)
            return false;
        return true;
    }

    private void setBinaryFromAffix() {

        int buffer = affix;
        int[] byteBuffer = new int[8];

        for (int field = 3; field >= 0; --field) {
            for (int bit = 7; bit >= 0; --bit) {
                if (buffer > 0) {
                    byteBuffer[bit] = 1;
                    --buffer;
                }
                else
                    byteBuffer[bit] = 0;
            }
            bytes[field].setBinaryValue(byteBuffer);
        }
    }

    private void setAffixFromBinary() {

        boolean breakpoint = false;
        int field = 3;
        int bit = 7;
        int affix = 0;

        while (field >= 0 && !breakpoint) {
            while (bit >= 0 && !breakpoint) {
                if (bytes[field].getBinaryValue()[bit] == 1)
                    ++affix;
                else
                    breakpoint = true;
                --bit;
            }
            --field;
        }
        this.affix = affix;
    }
}