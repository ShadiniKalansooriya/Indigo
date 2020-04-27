package com.example.indigoapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.indigoapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import static com.example.indigoapp.views.Gallery.dbHelper;

public class ProductsDisplay extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

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
                    Intent intenthome =new Intent(ProductsDisplay.this,HomePage.class);
                    startActivity(intenthome);
                    break;

                case R.id.nav_b_shoppingbag:
                    Intent intent = new Intent(ProductsDisplay.this, MainActivity.class);
                    startActivity(intent);
                    break;

                case R.id.nav_b_wishlist:
                    Intent intent1 = new Intent(ProductsDisplay.this, Wishlist.class);
                    startActivity(intent1);
                    break;

                case R.id.nav_b_gallery:
                    Intent intent2 = new Intent(ProductsDisplay.this, Gallery.class);
                    startActivity(intent2);
                    break;

                case R.id.nav_b_category:
                    Intent intent3 = new Intent(ProductsDisplay.this, ProductsDisplay.class);
                    startActivity(intent3);

            }

            return true;

        }

    };

    Button topBtn, denimBtn, dressBtn, pantBtn, voucherBtn;
//    BottomNavigationView bottomNavigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_display);


        /*=============Hooks================== */
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        /*===================Hooks======================*/
        drawerLayout = findViewById(R.id.drawer_Layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle("CATEGORIES");
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



        topBtn = (Button) findViewById(R.id.topbtn);
        denimBtn = (Button) findViewById(R.id.denimbtn);
        dressBtn = (Button) findViewById(R.id.dressbtn);
        pantBtn = (Button) findViewById(R.id.pantbtn);
        //savingBtn = (Button) findViewById(R.id.savingbtn);
        voucherBtn = (Button) findViewById(R.id.voucherbtn);

        buttonClickActivity();

    }



    private void buttonClickActivity() {
        topBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RecyclerMasterTops.class);
                startActivity(intent);
            }
        });

        denimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDenim = new Intent(getApplicationContext(), RecyclerMasterActivity.class);
                startActivity(intentDenim);
            }
        });

        dressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDress = new Intent(getApplicationContext(), RecyclerMasterDresses.class);
                startActivity(intentDress);
            }
        });

        pantBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPants = new Intent(getApplicationContext(), RecyclerMasterPants.class);
                startActivity(intentPants);
            }
        });

        voucherBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVoucher = new Intent(getApplicationContext(), RecyclerMasterVoucher.class);
                startActivity(intentVoucher);
            }
        });


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
                Intent intenthome =new Intent(ProductsDisplay.this,HomePage.class);
                startActivity(intenthome);
                break;

            case R.id.nav_shoppingBag:
                Intent intent =new Intent(ProductsDisplay.this,MainActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_WishList:
                Intent intent1 = new Intent(ProductsDisplay.this, Wishlist.class);
                startActivity(intent1);
                break;
            case R.id.nav_MyAccount:
                Intent intent6 =new Intent(ProductsDisplay.this, MyAccount.class);
                startActivity(intent6);
                break;

            case R.id.nav_Promotions:
                Intent intent7 = new Intent(ProductsDisplay.this, MainActivity.class);
                startActivity(intent7);
                break;
            case R.id.nav_Gallery:
                Intent intent2 =new Intent(ProductsDisplay.this, Gallery.class);
                startActivity(intent2);
                break;

            case R.id.nav_about:
                Intent intent3 = new Intent(ProductsDisplay.this, MainActivity.class);
                startActivity(intent3);
                break;
            case R.id.nav_contactUs:
                Intent intent4 =new Intent(ProductsDisplay.this,MainActivity.class);
                startActivity(intent4);
                break;

            case R.id.nav_Feedback:
                Intent intent5 = new Intent(ProductsDisplay.this, Feedback.class);
                startActivity(intent5);
                break;
            case R.id.nav_Logout:
                dbHelper.changeuser();
                Intent intent8 = new Intent(ProductsDisplay.this,Login.class);
                startActivity((intent8));
                Toast.makeText(getApplicationContext(),"Successfully Logged Out",Toast.LENGTH_LONG).show();

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


}
//intent.putExtra("CategoryType", "Denims");