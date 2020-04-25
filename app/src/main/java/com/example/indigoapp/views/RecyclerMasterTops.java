package com.example.indigoapp.views;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.indigoapp.R;
import com.example.indigoapp.adapter.RecyclerViewAdapter;
import com.example.indigoapp.databases.DbHelper;

import java.util.ArrayList;

@SuppressLint("Registered")
public class RecyclerMasterTops extends AppCompatActivity {

    private static final String TAG = "RecyclerViewActivity";
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mImagePrice = new ArrayList<>();

    private DbHelper dbHelperp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_master_tops);

        RecyclerView recyclerView = findViewById(R.id.recycler_view_tops);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        dbHelperp = new DbHelper(this);
        //ArrayList data = dbHelperp.Retrive_admin_product_details();
        ArrayList data = dbHelperp.Retrive_selected_product_details("Tops");

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,data);
        recyclerView.setAdapter(adapter);

        Log.d(TAG, "onCreate: started");
        //initImageBitmaps();
        //initRecyclerView();
    }

    private void initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: started");
        mImageUrls.add("");
        mNames.add("Top 1");
        mImagePrice.add("Rs.2500");
        mImageUrls.add("");
        mNames.add("Top 2");
        mImagePrice.add("Rs.3200");
        mImageUrls.add("");
        mNames.add("Top 3");
        mImagePrice.add("Rs.3500");
        mImageUrls.add("");
        mNames.add("Top 4");
        mImagePrice.add("Rs.1400");
        mImageUrls.add("");
        mNames.add("Top 5");
        mImagePrice.add("Rs.3500");
        mImageUrls.add("");
        mNames.add("Top 6");
        mImagePrice.add("Rs.3600");
    }

//    private void initRecyclerView() {
//        Log.d(TAG, "initRecyclerView: started");
//        RecyclerView recyclerView = findViewById(R.id.recycler_view_tops);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mNames, mImageUrls, mImagePrice, this);
//        recyclerView.setAdapter(adapter);
//
//    }
}
