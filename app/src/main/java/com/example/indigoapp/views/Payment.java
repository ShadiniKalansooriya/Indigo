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

public abstract class Payment extends  AppCompatActivity implements View.OnClickListener {


    EditText Uname;
    String email;
    EditText lctn;
    EditText subto;
    TextView address;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnS = findViewById(R.id.btnS);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);


        submit = (Button) findViewById(R.id.btnS);
        Uname = (EditText) findViewById(R.id.et1);
        email = String.valueOf((EditText) findViewById(R.id.et2));
        subto = (EditText) findViewById(R.id.et3);
        address = (TextView) findViewById(R.id.address);
        paymentM = (RadioButton) findViewById(R.id.radioButton1);
        paymentM = (RadioButton) findViewById(R.id.radioButton2);


        btnS = (Button) findViewById(R.id.btnS);


        Button btnS = findViewById(R.id.btnS);

        btnS.setOnClickListener((View.OnClickListener) this);


        rg = (RadioGroup) findViewById(R.id.radioGroup4);
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
                } else if (et2.getText().toString().isEmpty()) {
                    Toast.makeText(Payment.this, "Email is empty", Toast.LENGTH_LONG).show();
                } else if (et3.getText().toString().isEmpty()) {
                    Toast.makeText(Payment.this, "Total is empty", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Payment.this, "invalid", Toast.LENGTH_LONG).show();
                }

        }

        private void Customer_insert_payment_details();

        String Username = Uname.getText().toString().trim();
//        String email = String.getText.toString().trim();

        String Total = subto.getText().toString().trim();


        dbHelper.Customer_insert_payment_details(Username, email, Total);


    }


}
