package xyz.wontfix.subnetcalculator;

/**
 * Created by eneviere on 3/18/2017.
 */

public class NetmaskV4 {
    public ByteV4[] fields;

    public NetmaskV4 () {
        fields = new ByteV4[4];
        fields[0] = new ByteV4();
        fields[1] = new ByteV4();
        fields[2] = new ByteV4();
        fields[3] = new ByteV4();
    }
}