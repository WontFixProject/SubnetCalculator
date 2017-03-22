package xyz.wontfix.subnetcalculator;
import static java.lang.Math.pow;
/**
 * Created by eneviere on 3/18/2017.
 */

public class NetmaskV4 {

                                                /*
##############################################################################################
# =========================================[ FIELDS ] ====================================== #
##############################################################################################
                                                */
    public ByteV4[] fields;
    private int affix;

                                                /*
##############################################################################################
# ======================================[ CONSTRUCTORS ] =================================== #
##############################################################################################
                                                */
    public NetmaskV4 () {
        fields = new ByteV4[4];
        fields[0] = new ByteV4();
        fields[1] = new ByteV4();
        fields[2] = new ByteV4();
        fields[3] = new ByteV4();
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
            setDecimalFromBinary();
            return true;
        }
        else return false;
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
    //NEED TO BE CHECKED
    private int computeAffixFromBinaryUnsecure() {
        boolean breakpoint = false;
        int affix = 0;
        int field = 3;
        int bit = 7;

        while (field >= 0 && !breakpoint) {
            while (bit >= 0 && !breakpoint) {
                if (fields[field].binaryValue[bit] == 1)
                    ++affix;
                else
                    breakpoint = true;
                --bit;
            }
            --field;
        }
        return affix;
    }

    //NEED TO BE CHECKED
    private int computeAffixFromBinarySecure() {
        boolean isValid = true;
        boolean breakpoint = false;
        int affix = 0;
        int field = 3;
        int bit = 7;

        while (field >= 0 && isValid) {
            while (bit >= 0 && isValid) {
                if (fields[field].binaryValue[bit] == 0 && !breakpoint)
                    breakpoint = true;
                if (fields[field].binaryValue[bit] == 1) {
                    if (breakpoint)
                        isValid = false;
                    else
                        ++affix;
                }
                --bit;
            }
            --field;
        }
        if (isValid)
            return affix;
        else
            return -1;
    }

    //NEED TO BE CHECKED
    private boolean isAValidBinaryNetmask() {

        boolean isValid = true;
        boolean breakpoint = false;
        int field = 3;
        int bit = 7;

        while (field >= 0 && isValid) {
            while (bit >= 0 && isValid) {
                if (fields[field].binaryValue[bit] == 0 && !breakpoint)
                    breakpoint = true;
                if (fields[field].binaryValue[bit] == 1 && breakpoint)
                    isValid = false;
                --bit;
            }
            --field;
        }
        return isValid;
    }

    //NEED TO BE CHECKED
    private boolean isAValidDecimalNetmask() {

        boolean isValid = true;
        boolean validValueFound;
        int field = 3;
        int index;
        int[] validValues = new int[] {255, 254, 252, 248, 240, 224, 192, 128, 0};

        while (field >= 0 && isValid) {
            validValueFound = false;
            index = 0;

            while (index < validValues.length && !validValueFound) {
                if (fields[field].decimalValue == validValues[index])
                    validValueFound = true;
            }
            if (!validValueFound)
                isValid = false;
            else
                --field;
        }
        return isValid;
    }

    //NEED TO BE CHECKED
    private void setBinaryFromAffix() {

        int buffer = affix;

        for (int field = 3; field >= 0; --field) {
            for (int bit = 7; bit >= 0; --bit) {
                if (buffer > 0) {
                    fields[field].binaryValue[bit] = 1;
                    --buffer;
                }
                else
                    fields[field].binaryValue[bit] = 0;
            }
        }
    }

    //NEED TO BE CHECKED
    private void setDecimalFromBinary() {

        for (int field = 3; field >= 0; --field) {
            fields[field].decimalValue = 0;
            for (int bit = 7; bit >= 0; --bit) {
                if (fields[field].binaryValue[bit] == 1)
                    fields[field].decimalValue += (int) pow(2,bit);
            }
        }
    }
}