/*
 * This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package xyz.wontfix.subnetcalculator.UI;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import xyz.wontfix.subnetcalculator.V4.upperLevel.IPV4;
import xyz.wontfix.subnetcalculator.R;
import xyz.wontfix.subnetcalculator.V4.upperLevel.RangeV4;


public class MainActivity extends AppCompatActivity  implements EditText.OnFocusChangeListener{


    //#############################################################################################
    // =====================================[ PRIVATE FIELDS ]=================================== #
    //#############################################################################################

    private EditText[] addressV4DecimalField;
    private EditText[][] addressV4BinaryField;
    private EditText[] netmaskV4DecimalField;
    private EditText[][] netmaskV4BinaryField;
    private EditText netmaskV4Prefix;
    private TextView[] firstAddressV4DecimalField;
    private TextView[][] firstAddressV4BinaryField;
    private TextView[] lastAddressV4DecimalField;
    private TextView[][] lastAddressV4BinaryField;
    private TextView rangeAddressQuantity;

    public IPV4 ipv4;
    public RangeV4 rangev4;


    //#############################################################################################
    // ================================[ ACTIVITY STATE METHODS ]================================ #
    //#############################################################################################

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         * Objects and arrays instantiating
         */
        ipv4 = new IPV4();
        rangev4 = new RangeV4(ipv4);

        addressV4DecimalField = new EditText[4];
        netmaskV4DecimalField = new EditText[4];

        addressV4BinaryField = new EditText[4][8];
        netmaskV4BinaryField = new EditText[4][8];
        
        firstAddressV4DecimalField  = new TextView[4];
        lastAddressV4DecimalField   = new TextView[4];

        firstAddressV4BinaryField  = new TextView[4][8];
        lastAddressV4BinaryField   = new TextView[4][8];
        
        /*
         * Bind XML UI elements to java variables *
         */
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

        firstAddressV4DecimalField[0] = (TextView) findViewById(R.id.first_addressV4_decimal_field0);
        firstAddressV4DecimalField[1] = (TextView) findViewById(R.id.first_addressV4_decimal_field1);
        firstAddressV4DecimalField[2] = (TextView) findViewById(R.id.first_addressV4_decimal_field2);
        firstAddressV4DecimalField[3] = (TextView) findViewById(R.id.first_addressV4_decimal_field3);

        firstAddressV4BinaryField[0][0] = (TextView) findViewById(R.id.first_addressV4_binary_field00);
        firstAddressV4BinaryField[0][1] = (TextView) findViewById(R.id.first_addressV4_binary_field01);
        firstAddressV4BinaryField[0][2] = (TextView) findViewById(R.id.first_addressV4_binary_field02);
        firstAddressV4BinaryField[0][3] = (TextView) findViewById(R.id.first_addressV4_binary_field03);
        firstAddressV4BinaryField[0][4] = (TextView) findViewById(R.id.first_addressV4_binary_field04);
        firstAddressV4BinaryField[0][5] = (TextView) findViewById(R.id.first_addressV4_binary_field05);
        firstAddressV4BinaryField[0][6] = (TextView) findViewById(R.id.first_addressV4_binary_field06);
        firstAddressV4BinaryField[0][7] = (TextView) findViewById(R.id.first_addressV4_binary_field07);
        firstAddressV4BinaryField[0][0] = (TextView) findViewById(R.id.first_addressV4_binary_field00);

        firstAddressV4BinaryField[1][0] = (TextView) findViewById(R.id.first_addressV4_binary_field10);
        firstAddressV4BinaryField[1][1] = (TextView) findViewById(R.id.first_addressV4_binary_field11);
        firstAddressV4BinaryField[1][2] = (TextView) findViewById(R.id.first_addressV4_binary_field12);
        firstAddressV4BinaryField[1][3] = (TextView) findViewById(R.id.first_addressV4_binary_field13);
        firstAddressV4BinaryField[1][4] = (TextView) findViewById(R.id.first_addressV4_binary_field14);
        firstAddressV4BinaryField[1][5] = (TextView) findViewById(R.id.first_addressV4_binary_field15);
        firstAddressV4BinaryField[1][6] = (TextView) findViewById(R.id.first_addressV4_binary_field16);
        firstAddressV4BinaryField[1][7] = (TextView) findViewById(R.id.first_addressV4_binary_field17);

        firstAddressV4BinaryField[2][0] = (TextView) findViewById(R.id.first_addressV4_binary_field20);
        firstAddressV4BinaryField[2][1] = (TextView) findViewById(R.id.first_addressV4_binary_field21);
        firstAddressV4BinaryField[2][2] = (TextView) findViewById(R.id.first_addressV4_binary_field22);
        firstAddressV4BinaryField[2][3] = (TextView) findViewById(R.id.first_addressV4_binary_field23);
        firstAddressV4BinaryField[2][4] = (TextView) findViewById(R.id.first_addressV4_binary_field24);
        firstAddressV4BinaryField[2][5] = (TextView) findViewById(R.id.first_addressV4_binary_field25);
        firstAddressV4BinaryField[2][6] = (TextView) findViewById(R.id.first_addressV4_binary_field26);
        firstAddressV4BinaryField[2][7] = (TextView) findViewById(R.id.first_addressV4_binary_field27);

        firstAddressV4BinaryField[3][0] = (TextView) findViewById(R.id.first_addressV4_binary_field30);
        firstAddressV4BinaryField[3][1] = (TextView) findViewById(R.id.first_addressV4_binary_field31);
        firstAddressV4BinaryField[3][2] = (TextView) findViewById(R.id.first_addressV4_binary_field32);
        firstAddressV4BinaryField[3][3] = (TextView) findViewById(R.id.first_addressV4_binary_field33);
        firstAddressV4BinaryField[3][4] = (TextView) findViewById(R.id.first_addressV4_binary_field34);
        firstAddressV4BinaryField[3][5] = (TextView) findViewById(R.id.first_addressV4_binary_field35);
        firstAddressV4BinaryField[3][6] = (TextView) findViewById(R.id.first_addressV4_binary_field36);
        firstAddressV4BinaryField[3][7] = (TextView) findViewById(R.id.first_addressV4_binary_field37);

        lastAddressV4DecimalField[0] = (TextView) findViewById(R.id.last_addressV4_decimal_field0);
        lastAddressV4DecimalField[1] = (TextView) findViewById(R.id.last_addressV4_decimal_field1);
        lastAddressV4DecimalField[2] = (TextView) findViewById(R.id.last_addressV4_decimal_field2);
        lastAddressV4DecimalField[3] = (TextView) findViewById(R.id.last_addressV4_decimal_field3);

        lastAddressV4BinaryField[0][0] = (TextView) findViewById(R.id.last_addressV4_binary_field00);
        lastAddressV4BinaryField[0][1] = (TextView) findViewById(R.id.last_addressV4_binary_field01);
        lastAddressV4BinaryField[0][2] = (TextView) findViewById(R.id.last_addressV4_binary_field02);
        lastAddressV4BinaryField[0][3] = (TextView) findViewById(R.id.last_addressV4_binary_field03);
        lastAddressV4BinaryField[0][4] = (TextView) findViewById(R.id.last_addressV4_binary_field04);
        lastAddressV4BinaryField[0][5] = (TextView) findViewById(R.id.last_addressV4_binary_field05);
        lastAddressV4BinaryField[0][6] = (TextView) findViewById(R.id.last_addressV4_binary_field06);
        lastAddressV4BinaryField[0][7] = (TextView) findViewById(R.id.last_addressV4_binary_field07);
        lastAddressV4BinaryField[0][0] = (TextView) findViewById(R.id.last_addressV4_binary_field00);

        lastAddressV4BinaryField[1][0] = (TextView) findViewById(R.id.last_addressV4_binary_field10);
        lastAddressV4BinaryField[1][1] = (TextView) findViewById(R.id.last_addressV4_binary_field11);
        lastAddressV4BinaryField[1][2] = (TextView) findViewById(R.id.last_addressV4_binary_field12);
        lastAddressV4BinaryField[1][3] = (TextView) findViewById(R.id.last_addressV4_binary_field13);
        lastAddressV4BinaryField[1][4] = (TextView) findViewById(R.id.last_addressV4_binary_field14);
        lastAddressV4BinaryField[1][5] = (TextView) findViewById(R.id.last_addressV4_binary_field15);
        lastAddressV4BinaryField[1][6] = (TextView) findViewById(R.id.last_addressV4_binary_field16);
        lastAddressV4BinaryField[1][7] = (TextView) findViewById(R.id.last_addressV4_binary_field17);

        lastAddressV4BinaryField[2][0] = (TextView) findViewById(R.id.last_addressV4_binary_field20);
        lastAddressV4BinaryField[2][1] = (TextView) findViewById(R.id.last_addressV4_binary_field21);
        lastAddressV4BinaryField[2][2] = (TextView) findViewById(R.id.last_addressV4_binary_field22);
        lastAddressV4BinaryField[2][3] = (TextView) findViewById(R.id.last_addressV4_binary_field23);
        lastAddressV4BinaryField[2][4] = (TextView) findViewById(R.id.last_addressV4_binary_field24);
        lastAddressV4BinaryField[2][5] = (TextView) findViewById(R.id.last_addressV4_binary_field25);
        lastAddressV4BinaryField[2][6] = (TextView) findViewById(R.id.last_addressV4_binary_field26);
        lastAddressV4BinaryField[2][7] = (TextView) findViewById(R.id.last_addressV4_binary_field27);

        lastAddressV4BinaryField[3][0] = (TextView) findViewById(R.id.last_addressV4_binary_field30);
        lastAddressV4BinaryField[3][1] = (TextView) findViewById(R.id.last_addressV4_binary_field31);
        lastAddressV4BinaryField[3][2] = (TextView) findViewById(R.id.last_addressV4_binary_field32);
        lastAddressV4BinaryField[3][3] = (TextView) findViewById(R.id.last_addressV4_binary_field33);
        lastAddressV4BinaryField[3][4] = (TextView) findViewById(R.id.last_addressV4_binary_field34);
        lastAddressV4BinaryField[3][5] = (TextView) findViewById(R.id.last_addressV4_binary_field35);
        lastAddressV4BinaryField[3][6] = (TextView) findViewById(R.id.last_addressV4_binary_field36);
        lastAddressV4BinaryField[3][7] = (TextView) findViewById(R.id.last_addressV4_binary_field37);

        rangeAddressQuantity = (TextView) findViewById(R.id.range_address_quantity);

        /*
         * Set event listeners for UI element
         */
        addressV4DecimalField[0].setOnFocusChangeListener(this); //TODO: Switch to a better event listener (on value change?)
        addressV4DecimalField[1].setOnFocusChangeListener(this); //TODO: Switch to a better event listener (on value change?)
        addressV4DecimalField[2].setOnFocusChangeListener(this); //TODO: Switch to a better event listener (on value change?)
        addressV4DecimalField[3].setOnFocusChangeListener(this); //TODO: Switch to a better event listener (on value change?)

        netmaskV4DecimalField[0].setOnFocusChangeListener(this); //TODO: Switch to a better event listener (on value change?)
        netmaskV4DecimalField[1].setOnFocusChangeListener(this); //TODO: Switch to a better event listener (on value change?)
        netmaskV4DecimalField[2].setOnFocusChangeListener(this); //TODO: Switch to a better event listener (on value change?)
        netmaskV4DecimalField[3].setOnFocusChangeListener(this); //TODO: Switch to a better event listener (on value change?)

        netmaskV4Prefix.setOnFocusChangeListener(this); //TODO: Switch to a better event listener (on value change?)

        /*
         * Force binary UI refresh
         */
        onFocusChange(addressV4DecimalField[0], false);
        onFocusChange(addressV4DecimalField[1], false);
        onFocusChange(addressV4DecimalField[2], false);
        onFocusChange(addressV4DecimalField[3], false);

        onFocusChange(netmaskV4DecimalField[0], false);
        onFocusChange(netmaskV4DecimalField[1], false);
        onFocusChange(netmaskV4DecimalField[2], false);
        onFocusChange(netmaskV4DecimalField[3], false);
    }


    //############################################################################################//
    // =====================================[ PRIVATE METHODS ] ================================= //
    //############################################################################################//

    /**
     * Update range values and display.
     */
    private void updateRange() {
        rangev4.setRangeFromIPV4(ipv4);
        for (int field = 0; field < 4; ++field) {
            firstAddressV4DecimalField[field].setText(Integer.toString(rangev4.getFirstAddress().getByte(field).getDecimalValue()));
            lastAddressV4DecimalField[field].setText(Integer.toString(rangev4.getLastAddress().getByte(field).getDecimalValue()));
            for (int bit = 0; bit < 8; ++bit) {
                firstAddressV4BinaryField[field][bit].setText(Integer.toString(rangev4.getFirstAddress().getByte(field).getBinaryValue()[bit]));
                lastAddressV4BinaryField[field][bit].setText(Integer.toString(rangev4.getLastAddress().getByte(field).getBinaryValue()[bit]));
            }
        }
        rangeAddressQuantity.setText(Integer.toString(rangev4.getAddressQuantity()));
    }

    /**
     * Colorize all binary values to highlight the netmask effect.
     */
    private void colorizeBinaries() {
        int firstColorCount = ipv4.netmask.getPrefix();

        for (int field = 3; field >= 0; --field) {
            for (int bit = 7; bit >= 0; --bit) {
                if (firstColorCount > 0) {
                    --firstColorCount;
                    addressV4BinaryField[field][bit].setTextColor(Color.RED);
                    netmaskV4BinaryField[field][bit].setTextColor(Color.RED);
                    firstAddressV4BinaryField[field][bit].setTextColor(Color.RED);
                    lastAddressV4BinaryField[field][bit].setTextColor(Color.RED);
                }
                else {
                    addressV4BinaryField[field][bit].setTextColor(Color.BLUE);
                    netmaskV4BinaryField[field][bit].setTextColor(Color.BLUE);
                    firstAddressV4BinaryField[field][bit].setTextColor(Color.BLUE);
                    lastAddressV4BinaryField[field][bit].setTextColor(Color.BLUE);
                }
            }
        }
    }

    //############################################################################################//
    // ======================================[ UI LISTENERS ] =================================== //
    //############################################################################################//

    @Override
    public void onFocusChange(View v, boolean hasFocus) {

        int field = -1;
        int type = -1;

        if (!hasFocus) {
            if (v == addressV4DecimalField[0])  {type = 0; field = 0;}  //Address field 0
            if (v == addressV4DecimalField[1])  {type = 0; field = 1;}  //Address field 1
            if (v == addressV4DecimalField[2])  {type = 0; field = 2;}  //Address field 2
            if (v == addressV4DecimalField[3])  {type = 0; field = 3;}  //Address field 3
            if (v == netmaskV4DecimalField[0])  {type = 1; field = 0;}  //Netmask field 0
            if (v == netmaskV4DecimalField[1])  {type = 1; field = 1;}  //Netmask field 1
            if (v == netmaskV4DecimalField[2])  {type = 1; field = 2;}  //Netmask field 2
            if (v == netmaskV4DecimalField[3])  {type = 1; field = 3;}  //Netmask field 3
            if (v == netmaskV4Prefix)           {type = 2;}             //Netmask prefix

            switch (type) {
                //An address field has been changed
                case 0:
                    if (ipv4.address.setByteByDecimal(field, Integer.valueOf(addressV4DecimalField[field].getText().toString()))) {
                        for (int bit = 0; bit < 8; ++bit) {
                            addressV4BinaryField[field][bit].setText(Integer.toString(ipv4.address.getByte(field).getBinaryValue()[bit]));
                        }
                        updateRange();
                        colorizeBinaries();
                    }
                    else {
                        addressV4DecimalField[field].setText(Integer.toString(ipv4.address.getByte(field).getDecimalValue()));
                    }
                    break;
                //An netmask field has been changed
                case 1:
                    if (ipv4.netmask.setByteByDecimal(field, Integer.valueOf(netmaskV4DecimalField[field].getText().toString()))) {
                        for (int bit = 0; bit < 8; ++bit) {
                            netmaskV4BinaryField[field][bit].setText(Integer.toString(ipv4.netmask.getByte(field).getBinaryValue()[bit]));
                        }
                        netmaskV4Prefix.setText(Integer.toString(ipv4.netmask.getPrefix()));
                        updateRange();
                        colorizeBinaries();
                    }
                    else
                        netmaskV4DecimalField[field].setText(Integer.toString(ipv4.netmask.getByte(field).getDecimalValue()));
                    break;
                //The netmask prefix has been changed
                case 2:
                    try {
                        if (ipv4.netmask.setPrefix(Integer.valueOf(netmaskV4Prefix.getText().toString()))) {
                            for (int localField = 0; localField < 4; ++localField) {
                                for (int bit = 0; bit < 8; ++bit) {
                                    netmaskV4BinaryField[localField][bit].setText(Integer.toString(ipv4.netmask.getByte(localField).getBinaryValue()[bit]));
                                }
                                netmaskV4DecimalField[localField].setText(Integer.toString(ipv4.netmask.getByte(localField).getDecimalValue()));
                            }
                            updateRange();
                            colorizeBinaries();

                        }
                        else {
                            netmaskV4Prefix.setText(Integer.toString(ipv4.netmask.getPrefix()));
                        }
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        }
    }
}
