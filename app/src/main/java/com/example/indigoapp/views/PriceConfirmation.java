package com.example.indigoapp.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;

import com.example.indigoapp.R;

public class PriceConfirmation extends AppCompatActivity {

    Button payment_btn;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_confirmation;

        payment_btn = (Button) findViewById(R.id.payment_btn);

    }
}