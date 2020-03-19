package com.example.indigoapp.Views;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.indigoapp.R;

import java.util.Calendar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterDetailsActivity extends AppCompatActivity {
    TextView TextViewdate;
    TextView TextViewdateSelect;

    Calendar c;
    DatePickerDialog dpd;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_register);

        TextViewdate = (TextView)findViewById(R.id.textViewdate);
        TextViewdateSelect = (TextView)findViewById(R.id.textViewDOB);

        TextViewdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);


                dpd = new DatePickerDialog(RegisterDetailsActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        TextViewdateSelect.setText(dayOfMonth + "/"+(month+1)+"/"+year);

                    }
                },day,month,year);
                dpd.show();
            }
        });


    }
}
