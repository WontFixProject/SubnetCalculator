package xyz.wontfix.subnetcalculator;

/**
 * Created by eneviere on 3/18/2017.
 */

public class AddressV4 {
    public ByteV4[] fields;

    public AddressV4 () {
        fields = new ByteV4[4];
        fields[0] = new ByteV4(100);
        fields[1] = new ByteV4(100);
        fields[2] = new ByteV4(100);
        fields[3] = new ByteV4(100);
    }
}
