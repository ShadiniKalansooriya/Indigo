package com.example.indigoapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.indigoapp.R;
import com.example.indigoapp.databases.DbHelper;

public class AdminAddVoucher extends AppCompatActivity {

    EditText vouQty, vouPrice;
    Button add_voucher;
    DbHelper dbHelperp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_voucher);

        dbHelperp = new DbHelper(this);

        vouQty = (EditText) findViewById(R.id.voucher_qty);
        vouPrice = (EditText) findViewById(R.id.voucher_price);
        add_voucher = (Button) findViewById(R.id.admin_add_voucher_btn);

        buttonClickActivity();

    }

    private void buttonClickActivity() {
        add_voucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                add_voucher();
                Intent AddVouIntent = new Intent(AdminAddVoucher.this, AdminVoucherItemList.class);
                startActivity(AddVouIntent);
                //Toast.makeText(getApplicationContext(), "Successfully Added Product Details!", Toast.LENGTH_LONG).show();

            }
        });
    }

    private void add_voucher(){

        String voucherPrice = vouPrice.getText().toString().trim();
        String voucherQty = vouQty.getText().toString().trim();
        String type = "VoucherList";

        dbHelperp.addVoucher(voucherPrice,voucherQty);
        Toast.makeText(getApplicationContext(), "Successfully Added Voucher Details!", Toast.LENGTH_LONG).show();
    }

}