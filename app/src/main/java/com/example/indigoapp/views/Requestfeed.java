package com.example.indigoapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.indigoapp.R;
import com.example.indigoapp.databases.DbHelper;

public class Requestfeed extends AppCompatActivity {

    EditText Name111 ,Email111,message111,sub400;
    Button fed1;
    DbHelper dbHelper;
    Button buttonsubmit;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requestfeed);

        Button givefeed= findViewById(R.id.button2);
        givefeed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activityIntent = new Intent(getApplicationContext(), editfeed.class);
                startActivity(activityIntent);
            }

        });

        Name111 = findViewById(R.id.Name111);
        Email111=findViewById(R.id.Email111);
        message111 = findViewById(R.id.message111);
        sub400= findViewById(R.id.sub400);
        buttonsubmit=(Button)findViewById(R.id.button_update);

        dbHelper = new DbHelper(this);

        buttonsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addfeed();

                Toast.makeText(getApplicationContext(),"Successfully Submitted!",Toast.LENGTH_LONG).show();



            }
        });



    }


    private void addfeed(){

        String name = Name111.getText().toString().trim();
        String mail = Email111.getText().toString().trim();
        String msg = message111.getText().toString().trim();
        String report = sub400.getText().toString().trim();

        dbHelper.addfeed(name,mail,msg,report);
    }





}
