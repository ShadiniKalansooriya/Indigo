package com.example.indigoapp.views;

import android.app.Notification;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.indigoapp.R;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class PaymentCard {


    private PaymentCard dbHelper;
    private Notification.MessagingStyle.Message editTextEmail;
    private Notification.MessagingStyle.Message cardNo;
    private Notification.MessagingStyle.Message nameCard;
    private Notification.MessagingStyle.Message cardEp;

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




    @RequiresApi(api = Build.VERSION_CODES.N)
    public void User_insert_cart_details() {

        String Name = nameCard.getText().toString().trim();
        String Numb = cardNo.getText().toString().trim();
        String Date = cardEp.getText().toString().trim();



        
        dbHelper.User_insert_cart_details(Name, Numb, Date);
    }

    private void User_insert_cart_details(String name, String numb, String date) {
    }


}