package com.example.indigoapp.views;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.indigoapp.R;

@SuppressLint("Registered")
public class AdminActivity extends AppCompatActivity {

    Button addProd, editProd,  mngGallery, addVoucher, editVoucher, viewProd, viewVou;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        addProd = findViewById(R.id.add_prod_admin_btn);
        editProd = findViewById(R.id.edit_prod_admin_btn);
        mngGallery = findViewById(R.id.mng_gal_admin_btn);
        addVoucher = findViewById(R.id.add_voucher_admin_btn);
        editVoucher = findViewById(R.id.edit_voucher_admin_btn);
        viewProd = findViewById(R.id.view_prod);
        viewVou = findViewById(R.id.view_vou);
        buttonClickActivity();
    }

    private void buttonClickActivity() {
        addProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAddP = new Intent(getApplicationContext(), AdminAddProducts.class);
                startActivity(intentAddP);

            }
        });

        editProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEdit = new Intent(getApplicationContext(), AdminEditProducts.class);
                startActivity(intentEdit);
            }
        });

        addVoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVou = new Intent(getApplicationContext(), AdminAddVoucher.class);
                startActivity(intentVou);
            }
        });

        editVoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEditVou = new Intent(getApplicationContext(), AdminEditVoucher.class);
                startActivity(intentEditVou);
            }
        });

        viewProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEditVou = new Intent(getApplicationContext(), AdminProductsList.class);
                startActivity(intentEditVou);
            }
        });

        viewVou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEditVou = new Intent(getApplicationContext(), AdminVoucherItemList.class);
                startActivity(intentEditVou);
            }
        });


    }
}
