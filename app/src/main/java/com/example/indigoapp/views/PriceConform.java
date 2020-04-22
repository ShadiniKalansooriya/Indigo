package com.example.indigoapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;

import android.widget.TextView;


import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.indigoapp.R;

public class PriceConform extends AppCompatActivity {

    Button UPDATE;
    ElegantNumberButton numberBtn;

    TextView productPrice, productName;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payemt_total);

        UPDATE = (Button) findViewById(R.id.update_btn);
        productPrice = (TextView) findViewById(R.id.product_price);
        numberBtn = (ElegantNumberButton) findViewById(R.id.number_btn);
        productName = (TextView) findViewById(R.id.product_name);
    }
}
