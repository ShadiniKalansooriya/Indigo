package com.example.indigoapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.indigoapp.R;

public class PayemtTotal extends AppCompatActivity {
    private Button payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payemt_total);

        payment = findViewById(R.id.User_cart_next_button);


        payment = (Button) findViewById(R.id.User_cart_next_button);

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PAYMENT();

            }
        });
    }
    public void PAYMENT(){
        Intent intent = new Intent(this, Payment.class);
        startActivity(intent);
    }


}