package com.example.indigoapp.views;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.indigoapp.R;
import com.example.indigoapp.databases.DbHelper;

import androidx.appcompat.app.AppCompatActivity;

public class Requestfeed extends AppCompatActivity {

    EditText Name111 ,Email111,message111,sub400;
    Button fed1;
    DbHelper dbHelper;
    Button buttonsubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requestfeed);

        Name111 = findViewById(R.id.Name111);
        Email111=findViewById(R.id.Email111);
        message111 = findViewById(R.id.message111);
        sub400= findViewById(R.id.sub400);
    //    buttonsubmit=(Button)findViewById(R.id.fed1);

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
