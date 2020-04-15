package com.example.indigoapp;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class RecyclerMainActivity extends AppCompatActivity {

    private static final String TAG = "RecyclerViewActivity";
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mImageDesc = new ArrayList<>();
    private ArrayList<String> mImagePrice = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        Log.d(TAG, "onCreate: started");
        initImageBitmaps();
    }
    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: started");
        mImageUrls.add("https://5.imimg.com/data5/CW/YG/MY-46057090/ladies-ripped-jeans-500x500.jpg");
        mNames.add("Denim1");
        mImageDesc.add("desc1");
        mImagePrice.add("1000");
        mImageUrls.add("https://s3.ap-south-1.amazonaws.com/www.kellyfelder.com/gallery/6582a7fe61fe2dcdf4a2fccd67171de6956c0e43.jpg");
        mNames.add("Denim1");
        mImageDesc.add("desc1");
        mImagePrice.add("1000");
        mImageUrls.add("https://cdni.onedayonly.co.za/catalog/product/i/m/img_1311_3_4_1_2_1.jpg");
        mNames.add(" Denim1");
        mImageDesc.add("desc1");
        mImagePrice.add("1000");
        mImageUrls.add("https://img.bidorbuy.co.za/image/upload/v1521352999/user_images/992/366992/180318080301_9.jpg");
        mNames.add("Denim1");
        mImageDesc.add("desc1");
        mImagePrice.add("1000");
        mImageUrls.add("https://www.fashionbug.lk/wp-content/uploads/2020/03/080301802443-C2-1_Ladies-Denim_Fashion-Bug_Sri-Lanka-300x382.jpg");
        mNames.add("Denim1");
        mImageDesc.add("desc1");
        mImagePrice.add("1000");
        mImageUrls.add("https://pantaloons.imgix.net/img/app/product/4/479180-3472152.jpg");
        mNames.add("Denim1");
        mImageDesc.add("desc1");
        mImagePrice.add("1000");


    }
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: started");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mNames,mImageUrls,mImageDesc, mImagePrice, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


}

