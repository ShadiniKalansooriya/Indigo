package com.example.indigoapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.indigoapp.R;
import com.example.indigoapp.adapter.RecyclerViewAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerMasterActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Variables

    BottomNavigationView bottomNavigationView;
    //variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    androidx.appcompat.widget.Toolbar toolbar;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.nav_b_home:
                    break;

                case R.id.nav_b_shoppingbag:
                    Intent intent = new Intent(RecyclerMasterActivity.this, MainActivity.class);
                    startActivity(intent);
                    break;

                case R.id.nav_b_wishlist:
                    Intent intent1 = new Intent(RecyclerMasterActivity.this, Wishlist.class);
                    startActivity(intent1);
                    break;

                case R.id.nav_b_gallery:
                    Intent intent2 = new Intent(RecyclerMasterActivity.this, Gallery.class);
                    startActivity(intent2);
                    break;

                case R.id.nav_b_category:
                    Intent intent3 = new Intent(RecyclerMasterActivity.this, ProductsDisplay.class);
                    startActivity(intent3);

            }

            return true;

        }

    };

    private static final String TAG = "RecyclerViewActivity";
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mImagePrice = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_master);

        /*=============Hooks================== */
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        /*===================Hooks======================*/
        drawerLayout = findViewById(R.id.drawer_Layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle("DENIMS");
        /*===========ToolBar ========= */

        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

//        navigationView.setCheckedItem(R.id.nav_);

        //bottom navigationview listener
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        //Hide or show items
        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nav_Login).setVisible(false);

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

    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.nav_home:
                break;

            case R.id.nav_shoppingBag:
                Intent intent =new Intent(RecyclerMasterActivity.this,MainActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_WishList:
                Intent intent1 = new Intent(RecyclerMasterActivity.this, Wishlist.class);
                startActivity(intent1);
                break;
            case R.id.nav_MyAccount:
                Intent intent6 =new Intent(RecyclerMasterActivity.this, MyAccount.class);
                startActivity(intent6);
                break;

            case R.id.nav_Promotions:
                Intent intent7 = new Intent(RecyclerMasterActivity.this, MainActivity.class);
                startActivity(intent7);
                break;
            case R.id.nav_Gallery:
                Intent intent2 =new Intent(RecyclerMasterActivity.this, Gallery.class);
                startActivity(intent2);
                break;

            case R.id.nav_about:
                Intent intent3 = new Intent(RecyclerMasterActivity.this, MainActivity.class);
                startActivity(intent3);
                break;
            case R.id.nav_contactUs:
                Intent intent4 =new Intent(RecyclerMasterActivity.this,MainActivity.class);
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
