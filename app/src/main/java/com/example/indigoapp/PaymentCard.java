package com.example.indigoapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class PaymentCard {


    public abstract class Payment extends  AppCompatActivity implements View.OnClickListener {
        EditText nameCard, cardNo, cardEp;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_payment);


            Button btnS1 = findViewById(R.id.btnS1);

            btnS1.setOnClickListener(this);

        }
    }
}
