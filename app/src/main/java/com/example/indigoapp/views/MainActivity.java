package com.example.indigoapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.tv.TvContract;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.indigoapp.R;

public class MainActivity extends AppCompatActivity {

    Button btnlogin, btnSignin, btnGuest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnlogin = (Button)findViewById(R.id.btnLogin);
        btnSignin = (Button)findViewById(R.id.btnSignIn);
        btnGuest = (Button)findViewById(R.id.btnGuest);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,Login.class);

                startActivity(intent);
            }
        });

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,Register.class);

                startActivity(intent);
            }
        });


    }
}
