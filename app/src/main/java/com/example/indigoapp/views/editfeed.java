package com.example.indigoapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.indigoapp.R;
import com.example.indigoapp.databases.DbHelper;

import java.util.List;

public class editfeed extends AppCompatActivity {

    DbHelper dbHelper;
    private ListView mListView;
    DbHelper mDatabaseHelper;
    EditText Name111 ,Email111,message111,sub400;
    Button fed1;
    Button mButtonUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_editfeed);
        dbHelper = new DbHelper (this);


        Name111 = (EditText) findViewById (R.id.Name111);
        Name111.setText (dbHelper.getname ());
        Email111 = (EditText) findViewById (R.id.Email111);
        Email111.setText (dbHelper.getemail11 ());
        message111 = (EditText) findViewById (R.id.message111);
        message111.setText (dbHelper.getmessage ());
        sub400 = (EditText) findViewById (R.id.sub400);
        sub400.setText (dbHelper.getreport ());
        mButtonUpdate = (Button) findViewById (R.id.button_update);
        mButtonUpdate.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {

            }
        });


    }
}