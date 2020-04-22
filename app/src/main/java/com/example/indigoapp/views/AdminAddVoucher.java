package com.example.indigoapp.views;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

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
    }
}
