package com.example.indigoapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.indigoapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProductsDisplay extends AppCompatActivity {

    Button topBtn, denimBtn, dressBtn, pantBtn, savingBtn, voucherBtn;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_display);

        topBtn = (Button) findViewById(R.id.topbtn);
        denimBtn = (Button) findViewById(R.id.denimbtn);
        dressBtn = (Button) findViewById(R.id.dressbtn);
        pantBtn = (Button) findViewById(R.id.pantbtn);
        savingBtn = (Button) findViewById(R.id.savingbtn);
        voucherBtn = (Button) findViewById(R.id.voucherbtn);

        buttonClickActivity();

    }

    private void buttonClickActivity() {
        topBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RecyclerMasterTops.class);
                startActivity(intent);

            }
        });

        denimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDenim = new Intent(getApplicationContext(), RecyclerMasterActivity.class);
                startActivity(intentDenim);
            }
        });

        dressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDress = new Intent(getApplicationContext(), RecyclerMasterDresses.class);
                startActivity(intentDress);
            }
        });

        pantBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPant = new Intent(getApplicationContext(), RecyclerMasterPants.class);
                startActivity(intentPant);
            }
        });

        voucherBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVoucher = new Intent(getApplicationContext(), RecyclerMasterVoucher.class);
                startActivity(intentVoucher);
            }
        });


    }

}
