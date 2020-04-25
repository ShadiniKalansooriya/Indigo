package com.example.indigoapp.views;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.indigoapp.R;
import com.example.indigoapp.databases.DbHelper;

public class PaymentCard {


    private PaymentCard dbHelper;
    private Notification.MessagingStyle.Message editTextEmail;
    private Notification.MessagingStyle.Message cardNo;
    private Notification.MessagingStyle.Message nameCard;
    private Notification.MessagingStyle.Message cardEp;


    public class Payment extends AppCompatActivity implements View.OnClickListener {
        private EditText nameCard;
        private EditText cardNo;
        private EditText cardEp;
        private Button Update, Delete, Purchase;
        private DbHelper db;
        DbHelper dbHelperp;

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
            }
            if (nameCard.getText().toString().isEmpty()) {
                Toast.makeText(Payment.this, "Please put card name", Toast.LENGTH_LONG).show();
            } else if (cardNo.getText().toString().isEmpty()) {
                Toast.makeText(Payment.this, " input the card number", Toast.LENGTH_LONG).show();
            } else {
                cardEp.getText().toString();
            }
            Toast.makeText(Payment.this, "input the card expiry date", Toast.LENGTH_LONG).show();


            dbHelperp = new DbHelper(this);
            nameCard = (EditText) findViewById(R.id.et7);
            cardNo = (EditText) findViewById(R.id.et8);
            cardEp = (EditText) findViewById(R.id.et9);
            Update = (Button) findViewById(R.id.Update_cart);
            Delete = (Button) findViewById(R.id.Delete_cart_btn);
            Purchase = (Button) findViewById(R.id.btnS1);
            buttonClickActivity();




            Delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    db.delete_cart_details(cardNo);
                    Toast.makeText(Payment.this, "One record deleted", Toast.LENGTH_SHORT).show();
                    clear();
                }
            });
        }

        private void buttonClickActivity() {
            Update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    User_insert_cart_details();
                    Intent AddPayIntent = new Intent(Payment.this, PaymentCard.class);
                      startActivity(AddPayIntent);
                        Toast.makeText(getApplicationContext(), "Successfully Added Cart Details!", Toast.LENGTH_LONG).show();

                }
            });
        }

        private void User_insert_cart_details() {

            String Name = nameCard.getText().toString().trim();
        String Numb = cardNo.getText().toString().trim();
        String Date = cardEp.getText().toString().trim();
        String type = "CartList";




        dbHelperp.User_insert_cart_details(Name, Numb, Date);
        Toast.makeText(new Payment(), "Successfully Added Cart List!", Toast.LENGTH_LONG).show();
        }

        private void clear() {
            nameCard.setText("");
            cardNo.setText("");
            cardEp.setText("");

        }




    }


}