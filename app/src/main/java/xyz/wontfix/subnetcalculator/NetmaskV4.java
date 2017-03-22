package xyz.wontfix.subnetcalculator;

/**
 * Created by eneviere on 3/18/2017.
 */

public class NetmaskV4 {
    public ByteV4[] fields;
    public int suffix;

    public NetmaskV4 () {
        fields = new ByteV4[4];
        fields[0] = new ByteV4();
        fields[1] = new ByteV4();
        fields[2] = new ByteV4();
        fields[3] = new ByteV4();
    }

    public boolean isAValidBinaryNetmask() {

        boolean isValid = true;
        boolean breakpoint = false;
        int field = 3;
        int bit = 7;

        while (field >= 0 && isValid) {
            while (bit >= 0 && isValid) {
                if (fields[field].binaryValue[bit] == 0 && !breakpoint) {
                        breakpoint = true;
                }
                if (fields[field].binaryValue[bit] == 1 && breakpoint) {
                        isValid = false;
                }
                --bit;
            }
            --field;
        }
        return isValid;
    }
}