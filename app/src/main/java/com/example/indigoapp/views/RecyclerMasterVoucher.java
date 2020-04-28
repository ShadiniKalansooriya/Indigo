package com.example.indigoapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.indigoapp.R;
import com.example.indigoapp.adapter.RecyclerViewAdapterVoucher;
import com.example.indigoapp.databases.DbHelper;
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

import static com.example.indigoapp.views.Gallery.dbHelper;

public class RecyclerMasterVoucher extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

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
                    Intent intenthome =new Intent(RecyclerMasterVoucher.this,HomePage.class);
                    startActivity(intenthome);
                    break;

                case R.id.nav_b_shoppingbag:
                    Intent intent = new Intent(RecyclerMasterVoucher.this, MainActivity.class);
                    startActivity(intent);
                    break;

                case R.id.nav_b_wishlist:
                    Intent intent1 = new Intent(RecyclerMasterVoucher.this, Wishlist.class);
                    startActivity(intent1);
                    break;

                case R.id.nav_b_gallery:
                    Intent intent2 = new Intent(RecyclerMasterVoucher.this, Gallery.class);
                    startActivity(intent2);
                    break;

                case R.id.nav_b_category:
                    Intent intent3 = new Intent(RecyclerMasterVoucher.this, ProductsDisplay.class);
                    startActivity(intent3);

            }

            return true;

        }

    };

    private static final String TAG = "RecyclerViewActivity";
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mImagePrice = new ArrayList<>();

    private DbHelper dbHelperp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_master_voucher);

        RecyclerView recyclerView = findViewById(R.id.recycler_view_voucher);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        dbHelperp = new DbHelper(this);
        ArrayList data = dbHelperp.Retrive_admin_voucher_details();

        RecyclerViewAdapterVoucher adapter = new RecyclerViewAdapterVoucher(this,data);
        recyclerView.setAdapter(adapter);


        /*=============Hooks================== */
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        /*===================Hooks======================*/
        drawerLayout = findViewById(R.id.drawer_Layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle("VOUCHERS");
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
        //initImageBitmaps();
        //initRecyclerView();
    }

    private void initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: started");
        mImageUrls.add("@drawable/thou.png");
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

//    private void initRecyclerView() {
//        Log.d(TAG, "initRecyclerView: started");
//        RecyclerView recyclerView = findViewById(R.id.recycler_view_voucher);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mNames, mImageUrls, mImagePrice, this);
//        recyclerView.setAdapter(adapter);
//
//    }

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
                Intent intenthome =new Intent(RecyclerMasterVoucher.this,HomePage.class);
                startActivity(intenthome);
                break;

            case R.id.nav_shoppingBag:
                Intent intent =new Intent(RecyclerMasterVoucher.this,MainActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_WishList:
                Intent intent1 = new Intent(RecyclerMasterVoucher.this, Wishlist.class);
                startActivity(intent1);
                break;
            case R.id.nav_MyAccount:
                Intent intent6 =new Intent(RecyclerMasterVoucher.this, MyAccount.class);
                startActivity(intent6);
                break;

            case R.id.nav_Promotions:
                Intent intent7 = new Intent(RecyclerMasterVoucher.this, MainActivity.class);
                startActivity(intent7);
                break;
            case R.id.nav_Gallery:
                Intent intent2 =new Intent(RecyclerMasterVoucher.this, Gallery.class);
                startActivity(intent2);
                break;

            case R.id.nav_about:
                Intent intent3 = new Intent(RecyclerMasterVoucher.this, MainActivity.class);
                startActivity(intent3);
                break;
            case R.id.nav_contactUs:
                Intent intent4 =new Intent(RecyclerMasterVoucher.this,MainActivity.class);
                startActivity(intent4);
                break;

            case R.id.nav_Feedback:
                Intent intent5 = new Intent(RecyclerMasterVoucher.this, Feedback.class);
                startActivity(intent5);
                break;

            case R.id.nav_Logout:
                dbHelper.changeuser();
                Intent intent8 = new Intent(RecyclerMasterVoucher.this,Login.class);
                startActivity((intent8));
                Toast.makeText(getApplicationContext(),"Successfully Logged Out",Toast.LENGTH_LONG).show();

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}
