package com.example.indigoapp.Views;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.indigoapp.R;

import androidx.appcompat.app.AppCompatActivity;

public class PaymentCard {


    public abstract class Payment extends AppCompatActivity implements View.OnClickListener {
        EditText nameCard, cardNo, cardEp;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_payment);


            Button btnS1 = findViewById(R.id.btnS1);

            btnS1.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnS1:
                    Toast.makeText(this, "purchase conformed", Toast.LENGTH_LONG).show();
            }
            nameCard = (EditText) findViewById(R.id.et7);
            cardNo = (EditText) findViewById(R.id.et8);
            cardEp = (EditText) findViewById(R.id.et9);
        }
    }
}