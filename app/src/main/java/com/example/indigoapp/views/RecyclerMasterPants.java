package com.example.indigoapp.views;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.indigoapp.R;
import com.example.indigoapp.adapter.RecyclerViewAdapter;

import java.util.ArrayList;

@SuppressLint("Registered")
public class RecyclerMasterPants extends AppCompatActivity {

    private static final String TAG = "RecyclerViewActivity";
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mImagePrice = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_master_pants);

        Log.d(TAG, "onCreate: started");
        initImageBitmaps();
        initRecyclerView();
    }

    private void initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: started");
        mImageUrls.add("");
        mNames.add("Pant 1");
        mImagePrice.add("Rs.2500");
        mImageUrls.add("");
        mNames.add("Pant 2");
        mImagePrice.add("Rs.3200");
        mImageUrls.add("");
        mNames.add("Pant 3");
        mImagePrice.add("Rs.3500");
        mImageUrls.add("");
        mNames.add("Pant 4");
        mImagePrice.add("Rs.1400");
        mImageUrls.add("");
        mNames.add("Pant 5");
        mImagePrice.add("Rs.3500");
        mImageUrls.add("");
        mNames.add("Pant 6");
        mImagePrice.add("Rs.3600");
    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: started");
        RecyclerView recyclerView = findViewById(R.id.recycler_view_pants);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mNames, mImageUrls, mImagePrice, this);
        recyclerView.setAdapter(adapter);

    }
}
