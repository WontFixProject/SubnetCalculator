package xyz.wontfix.subnetcalculator.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import xyz.wontfix.subnetcalculator.V4.upperLevel.IPV4;
import xyz.wontfix.subnetcalculator.R;


public class MainActivity extends AppCompatActivity  implements EditText.OnFocusChangeListener{

                                                    /*
    ##############################################################################################
    # =====================================[ PRIVATE FIELDS ]=================================== #
    ##############################################################################################
                                                    */
    private EditText[] addressV4DecimalField;
    private EditText[][] addressV4BinaryField;

    private EditText[] netmaskV4DecimalField;
    private EditText[][] netmaskV4BinaryField;

    private EditText netmaskV4Prefix;

    public IPV4 ipv4;

                                                    /*
    ##############################################################################################
    # ================================[ ACTIVITY STATE METHODS ]================================ #
    ##############################################################################################
                                                    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /************************************
         * Objects and arrays instantiating *
         ************************************/
        ipv4 = new IPV4();

        addressV4DecimalField = new EditText[4];
        netmaskV4DecimalField = new EditText[4];

        addressV4BinaryField = new EditText[4][8];
        netmaskV4BinaryField = new EditText[4][8];

        /*******************************************
         *  Bind XML UI elements to java variables *
         *******************************************/
        addressV4DecimalField[0] = (EditText) findViewById(R.id.addressV4_decimal_field0);
        addressV4DecimalField[1] = (EditText) findViewById(R.id.addressV4_decimal_field1);
        addressV4DecimalField[2] = (EditText) findViewById(R.id.addressV4_decimal_field2);
        addressV4DecimalField[3] = (EditText) findViewById(R.id.addressV4_decimal_field3);

        addressV4BinaryField[0][0] = (EditText) findViewById(R.id.addressV4_binary_field00);
        addressV4BinaryField[0][1] = (EditText) findViewById(R.id.addressV4_binary_field01);
        addressV4BinaryField[0][2] = (EditText) findViewById(R.id.addressV4_binary_field02);
        addressV4BinaryField[0][3] = (EditText) findViewById(R.id.addressV4_binary_field03);
        addressV4BinaryField[0][4] = (EditText) findViewById(R.id.addressV4_binary_field04);
        addressV4BinaryField[0][5] = (EditText) findViewById(R.id.addressV4_binary_field05);
        addressV4BinaryField[0][6] = (EditText) findViewById(R.id.addressV4_binary_field06);
        addressV4BinaryField[0][7] = (EditText) findViewById(R.id.addressV4_binary_field07);
        addressV4BinaryField[0][0] = (EditText) findViewById(R.id.addressV4_binary_field00);
        
        addressV4BinaryField[1][0] = (EditText) findViewById(R.id.addressV4_binary_field10);
        addressV4BinaryField[1][1] = (EditText) findViewById(R.id.addressV4_binary_field11);
        addressV4BinaryField[1][2] = (EditText) findViewById(R.id.addressV4_binary_field12);
        addressV4BinaryField[1][3] = (EditText) findViewById(R.id.addressV4_binary_field13);
        addressV4BinaryField[1][4] = (EditText) findViewById(R.id.addressV4_binary_field14);
        addressV4BinaryField[1][5] = (EditText) findViewById(R.id.addressV4_binary_field15);
        addressV4BinaryField[1][6] = (EditText) findViewById(R.id.addressV4_binary_field16);
        addressV4BinaryField[1][7] = (EditText) findViewById(R.id.addressV4_binary_field17);
        
        addressV4BinaryField[2][0] = (EditText) findViewById(R.id.addressV4_binary_field20);
        addressV4BinaryField[2][1] = (EditText) findViewById(R.id.addressV4_binary_field21);
        addressV4BinaryField[2][2] = (EditText) findViewById(R.id.addressV4_binary_field22);
        addressV4BinaryField[2][3] = (EditText) findViewById(R.id.addressV4_binary_field23);
        addressV4BinaryField[2][4] = (EditText) findViewById(R.id.addressV4_binary_field24);
        addressV4BinaryField[2][5] = (EditText) findViewById(R.id.addressV4_binary_field25);
        addressV4BinaryField[2][6] = (EditText) findViewById(R.id.addressV4_binary_field26);
        addressV4BinaryField[2][7] = (EditText) findViewById(R.id.addressV4_binary_field27);
        
        addressV4BinaryField[3][0] = (EditText) findViewById(R.id.addressV4_binary_field30);
        addressV4BinaryField[3][1] = (EditText) findViewById(R.id.addressV4_binary_field31);
        addressV4BinaryField[3][2] = (EditText) findViewById(R.id.addressV4_binary_field32);
        addressV4BinaryField[3][3] = (EditText) findViewById(R.id.addressV4_binary_field33);
        addressV4BinaryField[3][4] = (EditText) findViewById(R.id.addressV4_binary_field34);
        addressV4BinaryField[3][5] = (EditText) findViewById(R.id.addressV4_binary_field35);
        addressV4BinaryField[3][6] = (EditText) findViewById(R.id.addressV4_binary_field36);
        addressV4BinaryField[3][7] = (EditText) findViewById(R.id.addressV4_binary_field37);

        netmaskV4DecimalField[0] = (EditText) findViewById(R.id.netmaskV4_decimal_field0);
        netmaskV4DecimalField[1] = (EditText) findViewById(R.id.netmaskV4_decimal_field1);
        netmaskV4DecimalField[2] = (EditText) findViewById(R.id.netmaskV4_decimal_field2);
        netmaskV4DecimalField[3] = (EditText) findViewById(R.id.netmaskV4_decimal_field3);

        netmaskV4BinaryField[0][0] = (EditText) findViewById(R.id.netmaskV4_binary_field00);
        netmaskV4BinaryField[0][1] = (EditText) findViewById(R.id.netmaskV4_binary_field01);
        netmaskV4BinaryField[0][2] = (EditText) findViewById(R.id.netmaskV4_binary_field02);
        netmaskV4BinaryField[0][3] = (EditText) findViewById(R.id.netmaskV4_binary_field03);
        netmaskV4BinaryField[0][4] = (EditText) findViewById(R.id.netmaskV4_binary_field04);
        netmaskV4BinaryField[0][5] = (EditText) findViewById(R.id.netmaskV4_binary_field05);
        netmaskV4BinaryField[0][6] = (EditText) findViewById(R.id.netmaskV4_binary_field06);
        netmaskV4BinaryField[0][7] = (EditText) findViewById(R.id.netmaskV4_binary_field07);
        netmaskV4BinaryField[0][0] = (EditText) findViewById(R.id.netmaskV4_binary_field00);

        netmaskV4BinaryField[1][0] = (EditText) findViewById(R.id.netmaskV4_binary_field10);
        netmaskV4BinaryField[1][1] = (EditText) findViewById(R.id.netmaskV4_binary_field11);
        netmaskV4BinaryField[1][2] = (EditText) findViewById(R.id.netmaskV4_binary_field12);
        netmaskV4BinaryField[1][3] = (EditText) findViewById(R.id.netmaskV4_binary_field13);
        netmaskV4BinaryField[1][4] = (EditText) findViewById(R.id.netmaskV4_binary_field14);
        netmaskV4BinaryField[1][5] = (EditText) findViewById(R.id.netmaskV4_binary_field15);
        netmaskV4BinaryField[1][6] = (EditText) findViewById(R.id.netmaskV4_binary_field16);
        netmaskV4BinaryField[1][7] = (EditText) findViewById(R.id.netmaskV4_binary_field17);

        netmaskV4BinaryField[2][0] = (EditText) findViewById(R.id.netmaskV4_binary_field20);
        netmaskV4BinaryField[2][1] = (EditText) findViewById(R.id.netmaskV4_binary_field21);
        netmaskV4BinaryField[2][2] = (EditText) findViewById(R.id.netmaskV4_binary_field22);
        netmaskV4BinaryField[2][3] = (EditText) findViewById(R.id.netmaskV4_binary_field23);
        netmaskV4BinaryField[2][4] = (EditText) findViewById(R.id.netmaskV4_binary_field24);
        netmaskV4BinaryField[2][5] = (EditText) findViewById(R.id.netmaskV4_binary_field25);
        netmaskV4BinaryField[2][6] = (EditText) findViewById(R.id.netmaskV4_binary_field26);
        netmaskV4BinaryField[2][7] = (EditText) findViewById(R.id.netmaskV4_binary_field27);

        netmaskV4BinaryField[3][0] = (EditText) findViewById(R.id.netmaskV4_binary_field30);
        netmaskV4BinaryField[3][1] = (EditText) findViewById(R.id.netmaskV4_binary_field31);
        netmaskV4BinaryField[3][2] = (EditText) findViewById(R.id.netmaskV4_binary_field32);
        netmaskV4BinaryField[3][3] = (EditText) findViewById(R.id.netmaskV4_binary_field33);
        netmaskV4BinaryField[3][4] = (EditText) findViewById(R.id.netmaskV4_binary_field34);
        netmaskV4BinaryField[3][5] = (EditText) findViewById(R.id.netmaskV4_binary_field35);
        netmaskV4BinaryField[3][6] = (EditText) findViewById(R.id.netmaskV4_binary_field36);
        netmaskV4BinaryField[3][7] = (EditText) findViewById(R.id.netmaskV4_binary_field37);

        netmaskV4Prefix = (EditText) findViewById(R.id.netmaskV4_prefix);

        /***************************************
         *  Set event listeners for UI element *
         ***************************************/
        addressV4DecimalField[0].setOnFocusChangeListener(this);
        addressV4DecimalField[1].setOnFocusChangeListener(this);
        addressV4DecimalField[2].setOnFocusChangeListener(this);
        addressV4DecimalField[3].setOnFocusChangeListener(this);

        netmaskV4DecimalField[0].setOnFocusChangeListener(this);
        netmaskV4DecimalField[1].setOnFocusChangeListener(this);
        netmaskV4DecimalField[2].setOnFocusChangeListener(this);
        netmaskV4DecimalField[3].setOnFocusChangeListener(this);

        netmaskV4Prefix.setOnFocusChangeListener(this);

        /****************************
         *  Force binary UI refresh *
         ****************************/
        onFocusChange(addressV4DecimalField[0], false);
        onFocusChange(addressV4DecimalField[1], false);
        onFocusChange(addressV4DecimalField[2], false);
        onFocusChange(addressV4DecimalField[3], false);

        onFocusChange(netmaskV4DecimalField[0], false);
        onFocusChange(netmaskV4DecimalField[1], false);
        onFocusChange(netmaskV4DecimalField[2], false);
        onFocusChange(netmaskV4DecimalField[3], false);
    }

                                                    /*
    ##############################################################################################
    # ======================================[ UI LISTENERS ] =================================== #
    ##############################################################################################
                                                    */
    @Override
    public void onFocusChange(View v, boolean hasFocus) {

        int field = -1;
        int type = -1;

        if (!hasFocus) {

            //type 0: address update, type 1: netmask update, type 2: netmask prefix update, field: which field to update
            if (v == addressV4DecimalField[0]) {type = 0; field = 0;}
            if (v == addressV4DecimalField[1]) {type = 0; field = 1;}
            if (v == addressV4DecimalField[2]) {type = 0; field = 2;}
            if (v == addressV4DecimalField[3]) {type = 0; field = 3;}
            if (v == netmaskV4DecimalField[0]) {type = 1; field = 0;}
            if (v == netmaskV4DecimalField[1]) {type = 1; field = 1;}
            if (v == netmaskV4DecimalField[2]) {type = 1; field = 2;}
            if (v == netmaskV4DecimalField[3]) {type = 1; field = 3;}
            if (v == netmaskV4Prefix)
                type = 2;

            switch (type) {
                case 0:
                    if (ipv4.address.setByteByDecimal(field, Integer.valueOf(addressV4DecimalField[field].getText().toString())))
                        for (int bit = 0; bit < 8; ++bit)
                            addressV4BinaryField[field][bit].setText(Integer.toString(ipv4.address.getByte(field).getBinaryValue()[bit]));
                    else
                        addressV4DecimalField[field].setText(Integer.toString(ipv4.address.getByte(field).getDecimalValue()));
                    break;
                case 1:
                    if (ipv4.netmask.setByteByDecimal(field, Integer.valueOf(netmaskV4DecimalField[field].getText().toString()))) {
                        for (int bit = 0; bit < 8; ++bit)
                            netmaskV4BinaryField[field][bit].setText(Integer.toString(ipv4.netmask.getByte(field).getBinaryValue()[bit]));
                        netmaskV4Prefix.setText(Integer.toString(ipv4.netmask.getPrefix()));
                    }
                    else
                        netmaskV4DecimalField[field].setText(Integer.toString(ipv4.netmask.getByte(field).getDecimalValue()));
                    break;
                case 2:
                    if (ipv4.netmask.setPrefix(Integer.valueOf(netmaskV4Prefix.getText().toString()))) {
                        for (int bit = 0; bit < 8; ++bit)
                            netmaskV4BinaryField[field][bit].setText(Integer.toString(ipv4.netmask.getByte(field).getBinaryValue()[bit]));
                        netmaskV4DecimalField[field].setText(Integer.toString(ipv4.netmask.getByte(field).getDecimalValue()));
                    }
                    else
                        netmaskV4DecimalField[field].setText(Integer.toString(ipv4.netmask.getByte(field).getDecimalValue()));

            }
        }
    }
}
