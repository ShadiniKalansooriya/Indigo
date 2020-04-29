package com.example.indigoapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.indigoapp.R;
import com.example.indigoapp.databases.DbHelper;

public class PriceConform extends AppCompatActivity {
    private DbHelper db;
    DbHelper dbHelperp;
    private TextView product_id;
    private TextView name;
    private TextView product_price;
    private Button number_btn;

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
        buttonClickActivity();
    }

    private void buttonClickActivity() {
        UPDATE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User_insert_price_details();
                Intent AddPriceIntent = new Intent(PriceConform.this, PriceConform.class);
                startActivity(AddPriceIntent);
                Toast.makeText(getApplicationContext(), "Successfully Added Price conform Details!", Toast.LENGTH_LONG).show();

            }
        });
    }
    private void User_insert_price_details() {

//        String id = nameCard.getText().toString().trim();
        String name = productName.getText().toString().trim();
        String price = productPrice.getText().toString().trim();
//        String count = numberBtn.getText().toString().trim();
        String type = "PaymentConformList";




//        dbHelperp.User_insert_price_details(name, price);
        Toast.makeText(new Payment(), "Successfully Added Cart List!", Toast.LENGTH_LONG).show();
    }

}



