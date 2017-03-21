package xyz.wontfix.subnetcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity  implements EditText.OnFocusChangeListener{

    private EditText addressV4Field0, addressV4Field1, addressV4Field2, addressV4Field3;
    private EditText addressV4BinaryField00, addressV4BinaryField01,addressV4BinaryField02,addressV4BinaryField03,addressV4BinaryField04,addressV4BinaryField05,addressV4BinaryField06,addressV4BinaryField07;
    private EditText addressV4BinaryField10, addressV4BinaryField11,addressV4BinaryField12,addressV4BinaryField13,addressV4BinaryField14,addressV4BinaryField15,addressV4BinaryField16,addressV4BinaryField17;
    private EditText addressV4BinaryField20, addressV4BinaryField21,addressV4BinaryField22,addressV4BinaryField23,addressV4BinaryField24,addressV4BinaryField25,addressV4BinaryField26,addressV4BinaryField27;
    private EditText addressV4BinaryField30, addressV4BinaryField31,addressV4BinaryField32,addressV4BinaryField33,addressV4BinaryField34,addressV4BinaryField35,addressV4BinaryField36,addressV4BinaryField37;

    private EditText netmaskV4Field0, netmaskV4Field1, netmaskV4Field2, netmaskV4Field3;
    private EditText netmaskV4BinaryField00, netmaskV4BinaryField01,netmaskV4BinaryField02,netmaskV4BinaryField03,netmaskV4BinaryField04,netmaskV4BinaryField05,netmaskV4BinaryField06,netmaskV4BinaryField07;
    private EditText netmaskV4BinaryField10, netmaskV4BinaryField11,netmaskV4BinaryField12,netmaskV4BinaryField13,netmaskV4BinaryField14,netmaskV4BinaryField15,netmaskV4BinaryField16,netmaskV4BinaryField17;
    private EditText netmaskV4BinaryField20, netmaskV4BinaryField21,netmaskV4BinaryField22,netmaskV4BinaryField23,netmaskV4BinaryField24,netmaskV4BinaryField25,netmaskV4BinaryField26,netmaskV4BinaryField27;
    private EditText netmaskV4BinaryField30, netmaskV4BinaryField31,netmaskV4BinaryField32,netmaskV4BinaryField33,netmaskV4BinaryField34,netmaskV4BinaryField35,netmaskV4BinaryField36,netmaskV4BinaryField37;
    
    public IPV4 ipv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ipv4 = new IPV4();

        addressV4Field0 = (EditText) findViewById(R.id.addressV4_field0);
        addressV4Field1 = (EditText) findViewById(R.id.addressV4_field1);
        addressV4Field2 = (EditText) findViewById(R.id.addressV4_field2);
        addressV4Field3 = (EditText) findViewById(R.id.addressV4_field3);

        addressV4BinaryField00 = (EditText) findViewById(R.id.addressV4_binary_field00);
        addressV4BinaryField01 = (EditText) findViewById(R.id.addressV4_binary_field01);
        addressV4BinaryField02 = (EditText) findViewById(R.id.addressV4_binary_field02);
        addressV4BinaryField03 = (EditText) findViewById(R.id.addressV4_binary_field03);
        addressV4BinaryField04 = (EditText) findViewById(R.id.addressV4_binary_field04);
        addressV4BinaryField05 = (EditText) findViewById(R.id.addressV4_binary_field05);
        addressV4BinaryField06 = (EditText) findViewById(R.id.addressV4_binary_field06);
        addressV4BinaryField07 = (EditText) findViewById(R.id.addressV4_binary_field07);
        addressV4BinaryField00 = (EditText) findViewById(R.id.addressV4_binary_field00);
        
        addressV4BinaryField10 = (EditText) findViewById(R.id.addressV4_binary_field10);
        addressV4BinaryField11 = (EditText) findViewById(R.id.addressV4_binary_field11);
        addressV4BinaryField12 = (EditText) findViewById(R.id.addressV4_binary_field12);
        addressV4BinaryField13 = (EditText) findViewById(R.id.addressV4_binary_field13);
        addressV4BinaryField14 = (EditText) findViewById(R.id.addressV4_binary_field14);
        addressV4BinaryField15 = (EditText) findViewById(R.id.addressV4_binary_field15);
        addressV4BinaryField16 = (EditText) findViewById(R.id.addressV4_binary_field16);
        addressV4BinaryField17 = (EditText) findViewById(R.id.addressV4_binary_field17);
        
        addressV4BinaryField20 = (EditText) findViewById(R.id.addressV4_binary_field20);
        addressV4BinaryField21 = (EditText) findViewById(R.id.addressV4_binary_field21);
        addressV4BinaryField22 = (EditText) findViewById(R.id.addressV4_binary_field22);
        addressV4BinaryField23 = (EditText) findViewById(R.id.addressV4_binary_field23);
        addressV4BinaryField24 = (EditText) findViewById(R.id.addressV4_binary_field24);
        addressV4BinaryField25 = (EditText) findViewById(R.id.addressV4_binary_field25);
        addressV4BinaryField26 = (EditText) findViewById(R.id.addressV4_binary_field26);
        addressV4BinaryField27 = (EditText) findViewById(R.id.addressV4_binary_field27);
        
        addressV4BinaryField30 = (EditText) findViewById(R.id.addressV4_binary_field30);
        addressV4BinaryField31 = (EditText) findViewById(R.id.addressV4_binary_field31);
        addressV4BinaryField32 = (EditText) findViewById(R.id.addressV4_binary_field32);
        addressV4BinaryField33 = (EditText) findViewById(R.id.addressV4_binary_field33);
        addressV4BinaryField34 = (EditText) findViewById(R.id.addressV4_binary_field34);
        addressV4BinaryField35 = (EditText) findViewById(R.id.addressV4_binary_field35);
        addressV4BinaryField36 = (EditText) findViewById(R.id.addressV4_binary_field36);
        addressV4BinaryField37 = (EditText) findViewById(R.id.addressV4_binary_field37);

        netmaskV4Field0 = (EditText) findViewById(R.id.netmaskV4_field0);
        netmaskV4Field1 = (EditText) findViewById(R.id.netmaskV4_field1);
        netmaskV4Field2 = (EditText) findViewById(R.id.netmaskV4_field2);
        netmaskV4Field3 = (EditText) findViewById(R.id.netmaskV4_field3);

        netmaskV4BinaryField00 = (EditText) findViewById(R.id.netmaskV4_binary_field00);
        netmaskV4BinaryField01 = (EditText) findViewById(R.id.netmaskV4_binary_field01);
        netmaskV4BinaryField02 = (EditText) findViewById(R.id.netmaskV4_binary_field02);
        netmaskV4BinaryField03 = (EditText) findViewById(R.id.netmaskV4_binary_field03);
        netmaskV4BinaryField04 = (EditText) findViewById(R.id.netmaskV4_binary_field04);
        netmaskV4BinaryField05 = (EditText) findViewById(R.id.netmaskV4_binary_field05);
        netmaskV4BinaryField06 = (EditText) findViewById(R.id.netmaskV4_binary_field06);
        netmaskV4BinaryField07 = (EditText) findViewById(R.id.netmaskV4_binary_field07);
        netmaskV4BinaryField00 = (EditText) findViewById(R.id.netmaskV4_binary_field00);

        netmaskV4BinaryField10 = (EditText) findViewById(R.id.netmaskV4_binary_field10);
        netmaskV4BinaryField11 = (EditText) findViewById(R.id.netmaskV4_binary_field11);
        netmaskV4BinaryField12 = (EditText) findViewById(R.id.netmaskV4_binary_field12);
        netmaskV4BinaryField13 = (EditText) findViewById(R.id.netmaskV4_binary_field13);
        netmaskV4BinaryField14 = (EditText) findViewById(R.id.netmaskV4_binary_field14);
        netmaskV4BinaryField15 = (EditText) findViewById(R.id.netmaskV4_binary_field15);
        netmaskV4BinaryField16 = (EditText) findViewById(R.id.netmaskV4_binary_field16);
        netmaskV4BinaryField17 = (EditText) findViewById(R.id.netmaskV4_binary_field17);

        netmaskV4BinaryField20 = (EditText) findViewById(R.id.netmaskV4_binary_field20);
        netmaskV4BinaryField21 = (EditText) findViewById(R.id.netmaskV4_binary_field21);
        netmaskV4BinaryField22 = (EditText) findViewById(R.id.netmaskV4_binary_field22);
        netmaskV4BinaryField23 = (EditText) findViewById(R.id.netmaskV4_binary_field23);
        netmaskV4BinaryField24 = (EditText) findViewById(R.id.netmaskV4_binary_field24);
        netmaskV4BinaryField25 = (EditText) findViewById(R.id.netmaskV4_binary_field25);
        netmaskV4BinaryField26 = (EditText) findViewById(R.id.netmaskV4_binary_field26);
        netmaskV4BinaryField27 = (EditText) findViewById(R.id.netmaskV4_binary_field27);

        netmaskV4BinaryField30 = (EditText) findViewById(R.id.netmaskV4_binary_field30);
        netmaskV4BinaryField31 = (EditText) findViewById(R.id.netmaskV4_binary_field31);
        netmaskV4BinaryField32 = (EditText) findViewById(R.id.netmaskV4_binary_field32);
        netmaskV4BinaryField33 = (EditText) findViewById(R.id.netmaskV4_binary_field33);
        netmaskV4BinaryField34 = (EditText) findViewById(R.id.netmaskV4_binary_field34);
        netmaskV4BinaryField35 = (EditText) findViewById(R.id.netmaskV4_binary_field35);
        netmaskV4BinaryField36 = (EditText) findViewById(R.id.netmaskV4_binary_field36);
        netmaskV4BinaryField37 = (EditText) findViewById(R.id.netmaskV4_binary_field37);

        addressV4Field0.setOnFocusChangeListener(this);
        addressV4Field1.setOnFocusChangeListener(this);
        addressV4Field2.setOnFocusChangeListener(this);
        addressV4Field3.setOnFocusChangeListener(this);

        netmaskV4Field0.setOnFocusChangeListener(this);
        netmaskV4Field1.setOnFocusChangeListener(this);
        netmaskV4Field2.setOnFocusChangeListener(this);
        netmaskV4Field3.setOnFocusChangeListener(this);

        onFocusChange(addressV4Field0, false);
        onFocusChange(addressV4Field1, false);
        onFocusChange(addressV4Field2, false);
        onFocusChange(addressV4Field3, false);

        onFocusChange(netmaskV4Field0, false);
        onFocusChange(netmaskV4Field1, false);
        onFocusChange(netmaskV4Field2, false);
        onFocusChange(netmaskV4Field3, false);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!hasFocus) {
            if (v == addressV4Field0) {
                try {
                    ipv4.address.fields[0].decimalValue = Integer.valueOf(addressV4Field0.getText().toString());
                    ipv4.address.fields[0].setBinaryFromDecimal();
                    if (ipv4.address.fields[0].binaryValue[0]) {addressV4BinaryField00.setText("1");} else {addressV4BinaryField00.setText("0");}
                    if (ipv4.address.fields[0].binaryValue[1]) {addressV4BinaryField01.setText("1");} else {addressV4BinaryField01.setText("0");}
                    if (ipv4.address.fields[0].binaryValue[2]) {addressV4BinaryField02.setText("1");} else {addressV4BinaryField02.setText("0");}
                    if (ipv4.address.fields[0].binaryValue[3]) {addressV4BinaryField03.setText("1");} else {addressV4BinaryField03.setText("0");}
                    if (ipv4.address.fields[0].binaryValue[4]) {addressV4BinaryField04.setText("1");} else {addressV4BinaryField04.setText("0");}
                    if (ipv4.address.fields[0].binaryValue[5]) {addressV4BinaryField05.setText("1");} else {addressV4BinaryField05.setText("0");}
                    if (ipv4.address.fields[0].binaryValue[6]) {addressV4BinaryField06.setText("1");} else {addressV4BinaryField06.setText("0");}
                    if (ipv4.address.fields[0].binaryValue[7]) {addressV4BinaryField07.setText("1");} else {addressV4BinaryField07.setText("0");}
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (v == addressV4Field1) {
                try {
                    ipv4.address.fields[1].decimalValue = Integer.valueOf(addressV4Field1.getText().toString());
                    ipv4.address.fields[1].setBinaryFromDecimal();
                    if (ipv4.address.fields[1].binaryValue[0]) {addressV4BinaryField10.setText("1");} else {addressV4BinaryField10.setText("0");}
                    if (ipv4.address.fields[1].binaryValue[1]) {addressV4BinaryField11.setText("1");} else {addressV4BinaryField11.setText("0");}
                    if (ipv4.address.fields[1].binaryValue[2]) {addressV4BinaryField12.setText("1");} else {addressV4BinaryField12.setText("0");}
                    if (ipv4.address.fields[1].binaryValue[3]) {addressV4BinaryField13.setText("1");} else {addressV4BinaryField13.setText("0");}
                    if (ipv4.address.fields[1].binaryValue[4]) {addressV4BinaryField14.setText("1");} else {addressV4BinaryField14.setText("0");}
                    if (ipv4.address.fields[1].binaryValue[5]) {addressV4BinaryField15.setText("1");} else {addressV4BinaryField15.setText("0");}
                    if (ipv4.address.fields[1].binaryValue[6]) {addressV4BinaryField16.setText("1");} else {addressV4BinaryField16.setText("0");}
                    if (ipv4.address.fields[1].binaryValue[7]) {addressV4BinaryField17.setText("1");} else {addressV4BinaryField17.setText("0");}
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (v == addressV4Field2) {
                try {
                    ipv4.address.fields[2].decimalValue = Integer.valueOf(addressV4Field2.getText().toString());
                    ipv4.address.fields[2].setBinaryFromDecimal();
                    if (ipv4.address.fields[2].binaryValue[0]) {addressV4BinaryField20.setText("1");} else {addressV4BinaryField20.setText("0");}
                    if (ipv4.address.fields[2].binaryValue[1]) {addressV4BinaryField21.setText("1");} else {addressV4BinaryField21.setText("0");}
                    if (ipv4.address.fields[2].binaryValue[2]) {addressV4BinaryField22.setText("1");} else {addressV4BinaryField22.setText("0");}
                    if (ipv4.address.fields[2].binaryValue[3]) {addressV4BinaryField23.setText("1");} else {addressV4BinaryField23.setText("0");}
                    if (ipv4.address.fields[2].binaryValue[4]) {addressV4BinaryField24.setText("1");} else {addressV4BinaryField24.setText("0");}
                    if (ipv4.address.fields[2].binaryValue[5]) {addressV4BinaryField25.setText("1");} else {addressV4BinaryField25.setText("0");}
                    if (ipv4.address.fields[2].binaryValue[6]) {addressV4BinaryField26.setText("1");} else {addressV4BinaryField26.setText("0");}
                    if (ipv4.address.fields[2].binaryValue[7]) {addressV4BinaryField27.setText("1");} else {addressV4BinaryField27.setText("0");}
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (v == addressV4Field3) {
                try {
                    ipv4.address.fields[3].decimalValue = Integer.valueOf(addressV4Field3.getText().toString());
                    ipv4.address.fields[3].setBinaryFromDecimal();
                    if (ipv4.address.fields[3].binaryValue[0]) {addressV4BinaryField30.setText("1");} else {addressV4BinaryField30.setText("0");}
                    if (ipv4.address.fields[3].binaryValue[1]) {addressV4BinaryField31.setText("1");} else {addressV4BinaryField31.setText("0");}
                    if (ipv4.address.fields[3].binaryValue[2]) {addressV4BinaryField32.setText("1");} else {addressV4BinaryField32.setText("0");}
                    if (ipv4.address.fields[3].binaryValue[3]) {addressV4BinaryField33.setText("1");} else {addressV4BinaryField33.setText("0");}
                    if (ipv4.address.fields[3].binaryValue[4]) {addressV4BinaryField34.setText("1");} else {addressV4BinaryField34.setText("0");}
                    if (ipv4.address.fields[3].binaryValue[5]) {addressV4BinaryField35.setText("1");} else {addressV4BinaryField35.setText("0");}
                    if (ipv4.address.fields[3].binaryValue[6]) {addressV4BinaryField36.setText("1");} else {addressV4BinaryField36.setText("0");}
                    if (ipv4.address.fields[3].binaryValue[7]) {addressV4BinaryField37.setText("1");} else {addressV4BinaryField37.setText("0");}
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (v == netmaskV4Field0) {
                try {
                    ipv4.netmask.fields[0].decimalValue = Integer.valueOf(netmaskV4Field0.getText().toString());
                    ipv4.netmask.fields[0].setBinaryFromDecimal();
                    if (ipv4.netmask.fields[0].binaryValue[0]) {netmaskV4BinaryField00.setText("1");} else {netmaskV4BinaryField00.setText("0");}
                    if (ipv4.netmask.fields[0].binaryValue[1]) {netmaskV4BinaryField01.setText("1");} else {netmaskV4BinaryField01.setText("0");}
                    if (ipv4.netmask.fields[0].binaryValue[2]) {netmaskV4BinaryField02.setText("1");} else {netmaskV4BinaryField02.setText("0");}
                    if (ipv4.netmask.fields[0].binaryValue[3]) {netmaskV4BinaryField03.setText("1");} else {netmaskV4BinaryField03.setText("0");}
                    if (ipv4.netmask.fields[0].binaryValue[4]) {netmaskV4BinaryField04.setText("1");} else {netmaskV4BinaryField04.setText("0");}
                    if (ipv4.netmask.fields[0].binaryValue[5]) {netmaskV4BinaryField05.setText("1");} else {netmaskV4BinaryField05.setText("0");}
                    if (ipv4.netmask.fields[0].binaryValue[6]) {netmaskV4BinaryField06.setText("1");} else {netmaskV4BinaryField06.setText("0");}
                    if (ipv4.netmask.fields[0].binaryValue[7]) {netmaskV4BinaryField07.setText("1");} else {netmaskV4BinaryField07.setText("0");}
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (v == netmaskV4Field1) {
                try {
                    ipv4.netmask.fields[1].decimalValue = Integer.valueOf(netmaskV4Field1.getText().toString());
                    ipv4.netmask.fields[1].setBinaryFromDecimal();
                    if (ipv4.netmask.fields[1].binaryValue[0]) {netmaskV4BinaryField10.setText("1");} else {netmaskV4BinaryField10.setText("0");}
                    if (ipv4.netmask.fields[1].binaryValue[1]) {netmaskV4BinaryField11.setText("1");} else {netmaskV4BinaryField11.setText("0");}
                    if (ipv4.netmask.fields[1].binaryValue[2]) {netmaskV4BinaryField12.setText("1");} else {netmaskV4BinaryField12.setText("0");}
                    if (ipv4.netmask.fields[1].binaryValue[3]) {netmaskV4BinaryField13.setText("1");} else {netmaskV4BinaryField13.setText("0");}
                    if (ipv4.netmask.fields[1].binaryValue[4]) {netmaskV4BinaryField14.setText("1");} else {netmaskV4BinaryField14.setText("0");}
                    if (ipv4.netmask.fields[1].binaryValue[5]) {netmaskV4BinaryField15.setText("1");} else {netmaskV4BinaryField15.setText("0");}
                    if (ipv4.netmask.fields[1].binaryValue[6]) {netmaskV4BinaryField16.setText("1");} else {netmaskV4BinaryField16.setText("0");}
                    if (ipv4.netmask.fields[1].binaryValue[7]) {netmaskV4BinaryField17.setText("1");} else {netmaskV4BinaryField17.setText("0");}
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (v == netmaskV4Field2) {
                try {
                    ipv4.netmask.fields[2].decimalValue = Integer.valueOf(netmaskV4Field2.getText().toString());
                    ipv4.netmask.fields[2].setBinaryFromDecimal();
                    if (ipv4.netmask.fields[2].binaryValue[0]) {netmaskV4BinaryField20.setText("1");} else {netmaskV4BinaryField20.setText("0");}
                    if (ipv4.netmask.fields[2].binaryValue[1]) {netmaskV4BinaryField21.setText("1");} else {netmaskV4BinaryField21.setText("0");}
                    if (ipv4.netmask.fields[2].binaryValue[2]) {netmaskV4BinaryField22.setText("1");} else {netmaskV4BinaryField22.setText("0");}
                    if (ipv4.netmask.fields[2].binaryValue[3]) {netmaskV4BinaryField23.setText("1");} else {netmaskV4BinaryField23.setText("0");}
                    if (ipv4.netmask.fields[2].binaryValue[4]) {netmaskV4BinaryField24.setText("1");} else {netmaskV4BinaryField24.setText("0");}
                    if (ipv4.netmask.fields[2].binaryValue[5]) {netmaskV4BinaryField25.setText("1");} else {netmaskV4BinaryField25.setText("0");}
                    if (ipv4.netmask.fields[2].binaryValue[6]) {netmaskV4BinaryField26.setText("1");} else {netmaskV4BinaryField26.setText("0");}
                    if (ipv4.netmask.fields[2].binaryValue[7]) {netmaskV4BinaryField27.setText("1");} else {netmaskV4BinaryField27.setText("0");}
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (v == netmaskV4Field3) {
                try {
                    ipv4.netmask.fields[3].decimalValue = Integer.valueOf(netmaskV4Field3.getText().toString());
                    ipv4.netmask.fields[3].setBinaryFromDecimal();
                    if (ipv4.netmask.fields[3].binaryValue[0]) {netmaskV4BinaryField30.setText("1");} else {netmaskV4BinaryField30.setText("0");}
                    if (ipv4.netmask.fields[3].binaryValue[1]) {netmaskV4BinaryField31.setText("1");} else {netmaskV4BinaryField31.setText("0");}
                    if (ipv4.netmask.fields[3].binaryValue[2]) {netmaskV4BinaryField32.setText("1");} else {netmaskV4BinaryField32.setText("0");}
                    if (ipv4.netmask.fields[3].binaryValue[3]) {netmaskV4BinaryField33.setText("1");} else {netmaskV4BinaryField33.setText("0");}
                    if (ipv4.netmask.fields[3].binaryValue[4]) {netmaskV4BinaryField34.setText("1");} else {netmaskV4BinaryField34.setText("0");}
                    if (ipv4.netmask.fields[3].binaryValue[5]) {netmaskV4BinaryField35.setText("1");} else {netmaskV4BinaryField35.setText("0");}
                    if (ipv4.netmask.fields[3].binaryValue[6]) {netmaskV4BinaryField36.setText("1");} else {netmaskV4BinaryField36.setText("0");}
                    if (ipv4.netmask.fields[3].binaryValue[7]) {netmaskV4BinaryField37.setText("1");} else {netmaskV4BinaryField37.setText("0");}
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
