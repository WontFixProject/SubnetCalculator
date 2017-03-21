package xyz.wontfix.subnetcalculator;

/**
 * Created by eneviere on 3/18/2017.
 */

public class IPV4 {
    public AddressV4 address;
    public NetmaskV4 netmask;

    public IPV4 () {
        address = new AddressV4();
        netmask = new NetmaskV4();
    }
}
