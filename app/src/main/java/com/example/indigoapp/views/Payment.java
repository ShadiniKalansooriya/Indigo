package com.example.indigoapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.indigoapp.R;
import com.example.indigoapp.databases.DbHelper;

import androidx.appcompat.app.AppCompatActivity;

public class Payment extends  AppCompatActivity implements View.OnClickListener {


    EditText Uname;
    EditText editTextEmail;
    EditText lctn;
    EditText sub;
    EditText address;
    RadioButton paymentM;
    Button btnS, btnS1, btnU;
    EditText et1, et2, et3, et7, et8, et9;

    private RadioGroup rg;
    private RadioButton rb;
    private Button submit, switch1;
    private Button start;
    private TextView text;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private DbHelper dbHelper;
    DbHelper dbHelperp;
    private View editText6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnS = findViewById(R.id.btnS);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        address= findViewById(R.id.et6);


        submit = (Button) findViewById(R.id.btnS);
        Uname = (EditText) findViewById(R.id.et1);
        editTextEmail = (EditText) findViewById(R.id.et2);
        sub = (EditText) findViewById(R.id.et3);
        address = (EditText) findViewById(R.id.et6);
        paymentM = (RadioButton) findViewById(R.id.radioButton1);
        paymentM = (RadioButton) findViewById(R.id.radioButton2);
        buttonClickActivity();


        btnS = (Button) findViewById(R.id.btnS);


        Button btnS = findViewById(R.id.btnS);

        btnS.setOnClickListener((View.OnClickListener) this);


        rg = (RadioGroup) findViewById(R.id.radioGroup4);
    }

    private void buttonClickActivity() {
        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Customer_insert_payment_details();
                Intent AddpurchaseIntent;
                AddpurchaseIntent = new Intent(Payment.this, Payment.class);
                startActivity(AddpurchaseIntent);
                Toast.makeText(getApplicationContext(), "Successfully Added Cart Details!", Toast.LENGTH_LONG).show();

            }
        });


    }

    public void rbclick(View v) {
        int radiobuttonid = rg.getCheckedRadioButtonId();
        rb = (RadioButton) findViewById(radiobuttonid);

        if (rb.getText().equals("Add to card")) {
            startActivity(new Intent(getApplicationContext(), Payment.class));
        }


    }






    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnS:
                if (et1.length() != 0 && et2.length() != 0 && et3.length() != 0) {
                    et1.setText("");
                    et2.setText("");
                    et3.setText("");

                    Toast.makeText(Payment.this, "confirm your payment", Toast.LENGTH_LONG).show();
                } else if (et1.getText().toString().trim().matches(emailPattern)) {
                    Toast.makeText(Payment.this, "Please put valid email", Toast.LENGTH_LONG).show();
                } else if (et1.getText().toString().isEmpty()) {
                    Toast.makeText(Payment.this, " Name is empty", Toast.LENGTH_LONG).show();
                } else if (address.getText().toString().isEmpty()) {
                    Toast.makeText(Payment.this, "Address is empty", Toast.LENGTH_LONG).show();
                } else if (et3.getText().toString().isEmpty()) {
                    Toast.makeText(Payment.this, "Total is empty", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Payment.this, "invalid", Toast.LENGTH_LONG).show();
                }


        }

        }

        private void Customer_insert_payment_details() {

        String Username = Uname.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String Total = sub.getText().toString().trim();
        String Address = address.getText().toString().trim();
            String type = "PaymentList";


        dbHelper.Customer_insert_payment_details(Username,email,Total,Address);
            Toast.makeText(getApplicationContext(), "Successfully Added Payment List!", Toast.LENGTH_LONG).show();


    }


}
