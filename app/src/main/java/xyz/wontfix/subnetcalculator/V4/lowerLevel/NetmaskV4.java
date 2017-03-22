package xyz.wontfix.subnetcalculator.V4.lowerLevel;

public class NetmaskV4 extends AddressV4 {

                                                /*
##############################################################################################
# =========================================[ FIELDS ] ====================================== #
##############################################################################################
                                                */
    private int prefix;

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
    public int getPrefix() {
        return this.prefix;
    }

    public boolean setPrefix(int prefix) {
        if (prefix >= 0 && prefix <= 32) {
            this.prefix = prefix;
            setBinaryFromPrefix();
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
        setPrefixFromBinary();
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
        setPrefixFromBinary();
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
        for (int bit = 1; bit < binaryValue.length; ++bit)
            if (binaryValue[bit] != content)
                return -1;
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
                else
                    byteBuffer[bit] = 0;
            }
            bytes[field].setBinaryValue(byteBuffer);
        }
    }

    private void setPrefixFromBinary() {

        boolean breakpoint = false;
        int field = 3;
        int bit = 7;
        int prefix = 0;

        while (field >= 0 && !breakpoint) {
            while (bit >= 0 && !breakpoint) {
                if (bytes[field].getBinaryValue()[bit] == 1)
                    ++prefix;
                else
                    breakpoint = true;
                --bit;
            }
            --field;
        }
        this.prefix = prefix;
    }
}