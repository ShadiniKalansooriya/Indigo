package com.example.indigoapp.views;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.indigoapp.R;
import com.example.indigoapp.adapter.RecyclerViewAdapter;

import java.util.ArrayList;

public class RecyclerMasterVoucher extends AppCompatActivity {

    private static final String TAG = "RecyclerViewActivity";
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mImagePrice = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_master_voucher);

        Log.d(TAG, "onCreate: started");
        initImageBitmaps();
        initRecyclerView();
    }

    private void initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: started");
        mImageUrls.add("");
        mNames.add("Gift Voucher");
        mImagePrice.add("Rs.1000");
        mImageUrls.add("");
        mNames.add("Gift Voucher");
        mImagePrice.add("Rs.2000");
        mImageUrls.add("");
        mNames.add("Gift Voucher");
        mImagePrice.add("Rs.5000");
        mImageUrls.add("");
        mNames.add("Gift Voucher");
        mImagePrice.add("Rs.10,000");
    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: started");
        RecyclerView recyclerView = findViewById(R.id.recycler_view_voucher);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mNames, mImageUrls, mImagePrice, this);
        recyclerView.setAdapter(adapter);

    }
}