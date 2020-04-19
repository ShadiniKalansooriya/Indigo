package com.example.indigoapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.indigoapp.R;
import com.example.indigoapp.databases.DbHelper;

public class Requestfeed extends AppCompatActivity {

    EditText Name111 ,Email111,message111,sub400;
    Button fed1;
    DbHelper dbHelper=new DbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requestfeed);

        Name111 = findViewById(R.id.Name111);
        Email111=findViewById(R.id.Email111);
        message111 = findViewById(R.id.message111);
        sub400= findViewById(R.id.sub400);

        fed1=findViewById(R.id.fed1);
        fed1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nameIsfull() == true && Emailfull() == true && messfull() == true && reportfull() == true) {
                    addfeed();
                    Intent RegisterIntent = new Intent(Requestfeed.this, Feedback.class);
                    startActivity(RegisterIntent);
                    Toast.makeText(getApplicationContext(), "Successfully Registered!", Toast.LENGTH_LONG).show();
                }

            }

        });

        }



        private void addfeed(){

            String name = Name111.getText().toString().trim();
            String email = Email111.getText().toString().trim();
            String message = message111 .getText().toString().trim();
            String report= sub400.getText().toString().trim();



            dbHelper.addfeed(name,email,message,report);
        }



        private boolean nameIsfull(){
            String vname = Name111.getText().toString().trim();

            if (vname.isEmpty()){
                Toast.makeText(getApplicationContext(),"Name Field Cannot be Empty",Toast.LENGTH_LONG).show();
                return false;
            }else {
                return true;
            }

        }

        private boolean Emailfull(){
            String vaddress = Email111.getText().toString().trim();

            if (vaddress.isEmpty()){
                Toast.makeText(getApplicationContext(),"Address Field Cannot be Empty",Toast.LENGTH_LONG).show();
                return false;
            }else {
                return true;
            }

        }

        private boolean messfull(){
            String vmobile = message111.getText().toString().trim();

            if (vmobile.isEmpty()){
                Toast.makeText(getApplicationContext(),"Field Cannot be Empty",Toast.LENGTH_LONG).show();
                return false;
            }else {
                return true;
            }

        }

        private boolean reportfull(){
            String vdiag = sub400.getText().toString().trim();

            if (vdiag.isEmpty()){
                Toast.makeText(getApplicationContext(),"Diagnosis Field Cannot be Empty",Toast.LENGTH_LONG).show();
                return false;
            }else {
                return true;
            }

        }









    }

