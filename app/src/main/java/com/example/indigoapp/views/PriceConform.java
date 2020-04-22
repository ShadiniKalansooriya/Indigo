package com.example.indigoapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;

import android.widget.TextView;


import com.example.indigoapp.R;

public class PriceConform extends AppCompatActivity {

    Button addToCartBtn;

    TextView productPrice, productName;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payemt_total);

        addToCartBtn = (Button) findViewById(R.id.payment_btn);
        productPrice = (TextView) findViewById(R.id.product_price);
        productName = (TextView) findViewById(R.id.product_name);
    }
}
