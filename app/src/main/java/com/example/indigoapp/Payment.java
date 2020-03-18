package com.example.indigoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public abstract class Payment extends  AppCompatActivity implements View.OnClickListener{


    EditText Uname, email, lctn, subto;
    RadioButton paymentM;
    Button btnS,btnS1,btnU;
    EditText et1, et2, et3,et7,et8,et9;

    private RadioGroup rg;
    private RadioButton rb;
    private Button submit,switch1;
    private Button start;
    private TextView text;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";




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
        email = (EditText) findViewById(R.id.et2);
        subto = (EditText) findViewById(R.id.et3);
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



    }


}
