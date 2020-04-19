package com.example.indigoapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.indigoapp.R;
import com.example.indigoapp.adapter.RecyclerViewAdapter;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class RecyclerMasterActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "RecyclerViewActivity";
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mImagePrice = new ArrayList<>();
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_master);

        Log.d(TAG, "onCreate: started");
        initImageBitmaps();
        initRecyclerView();

    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: started");
        mImageUrls.add("https://hips.hearstapps.com/vader-prod.s3.amazonaws.com/1550771105-01b35aaa-11b1-48c8-971b-7c61b5a853ea.jpg");
        mNames.add("Skinny Jeans");
        mImagePrice.add("Rs.2500");
        mImageUrls.add("https://hips.hearstapps.com/vader-prod.s3.amazonaws.com/1550689928-AGOL-WJ39_V1.jpg");
        mNames.add("Skinny Crop Jeans");
        mImagePrice.add("Rs.3200");
        mImageUrls.add("https://hips.hearstapps.com/vader-prod.s3.amazonaws.com/1550696763-9c30dffd_2d8b.jpg");
        mNames.add("Cigarette Jeans");
        mImagePrice.add("Rs.3500");
        mImageUrls.add("https://hips.hearstapps.com/vader-prod.s3.amazonaws.com/1550688459-original.jpg");
        mNames.add("Straight Jeans");
        mImagePrice.add("Rs.1400");
        mImageUrls.add("https://hips.hearstapps.com/vader-prod.s3.amazonaws.com/1550771034-12107-hepburn-crop-high-rise-wide-leg-belden-001-02-1200x-1550771028.jpg");
        mNames.add("Cropped Wide-Leg Jeans");
        mImagePrice.add("Rs.3500");
        mImageUrls.add("https://bananarepublic.gap.com/webcontent/0017/521/230/cn17521230.jpg");
        mNames.add("Wide-Leg Jeans");
        mImagePrice.add("Rs.3600");


    }
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: started");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mNames,mImageUrls,mImagePrice, this);
        recyclerView.setAdapter(adapter);

    }

    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                Intent intentHome = new Intent(RecyclerMasterActivity.this, MainActivity.class);
                startActivity(intentHome);
                break;

            case R.id.nav_shoppingBag:
                Intent intent = new Intent(RecyclerMasterActivity.this, MainActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_WishList:
                Intent intent1 = new Intent(RecyclerMasterActivity.this, Wishlist.class);
                startActivity(intent1);
                break;
            case R.id.nav_MyAccount:
                Intent intent6 = new Intent(RecyclerMasterActivity.this, MyAccount.class);
                startActivity(intent6);
                break;

            case R.id.nav_Promotions:
                Intent intent7 = new Intent(RecyclerMasterActivity.this, MainActivity.class);
                startActivity(intent7);
                break;
            case R.id.nav_Gallery:
                Intent intent2 = new Intent(RecyclerMasterActivity.this, GalleryView.class);
                startActivity(intent2);
                break;

            case R.id.nav_about:
                Intent intent3 = new Intent(RecyclerMasterActivity.this, MainActivity.class);
                startActivity(intent3);
                break;
            case R.id.nav_contactUs:
                Intent intent4 = new Intent(RecyclerMasterActivity.this, MainActivity.class);
                startActivity(intent4);
                break;

            case R.id.nav_Feedback:
                Intent intent5 = new Intent(RecyclerMasterActivity.this, Feedback.class);
                startActivity(intent5);
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
