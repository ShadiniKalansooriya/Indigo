package com.example.indigoapp.views;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.indigoapp.R;

import androidx.appcompat.app.AppCompatActivity;

public class PaymentCard {


    private PaymentCard dbHelper;
    private Notification.MessagingStyle.Message editTextEmail;

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
                    if (nameCard.length() != 0 && cardNo.length() != 0 && cardEp.length() != 0) {
                    nameCard.setText("");
                    cardNo.setText("");
                    cardEp.setText("");
                    Toast.makeText(this, "purchase conformed", Toast.LENGTH_LONG).show();
            }
            }  if (nameCard.getText().toString().isEmpty()) {
                Toast.makeText(Payment.this, "Please put card name", Toast.LENGTH_LONG).show();
            } else if (cardNo.getText().toString().isEmpty()) {
                Toast.makeText(Payment.this, " input the card number", Toast.LENGTH_LONG).show();
            } else {
                cardEp.getText().toString();
            }
                Toast.makeText(Payment.this, "input the card expiry date", Toast.LENGTH_LONG).show();


            nameCard = (EditText) findViewById(R.id.et7);
            cardNo = (EditText) findViewById(R.id.et8);
            cardEp = (EditText) findViewById(R.id.et9);
        }
    }
//
//    private void User_insert_cart_details(){
//
//        EditText nameCard = nameCard.getText().toString().trim();
//        EditText cardNo = cardNo.getText().toString().trim();
//        EditText cardEp = cardEp.getText().toString().trim();
//
//
//
//        dbHelper.User_insert_cart_details(nameCard,cardNo,cardEp);
//    }

}