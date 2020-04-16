package com.example.indigoapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.indigoapp.R;
import com.example.indigoapp.databases.DbHelper;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {



        DbHelper dbHelper;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash_screen);

            dbHelper = new DbHelper(this);

//        Toast.makeText(getApplicationContext(),type,Toast.LENGTH_LONG).show();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    String type  = dbHelper.gettype();
                    Intent launchIntent = new Intent();
                    if(type.equals("RegisteredUser")){
                        launchIntent.setClass(getApplicationContext(), MainActivity.class);
                        startActivity(launchIntent);
                    }


                    finish();
                }
            }, 4750);




        }

}
