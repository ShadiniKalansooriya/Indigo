package com.example.indigoapp.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.indigoapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;
import com.google.android.material.navigation.NavigationView;

public class MyAccount extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Variables

    BottomNavigationView navigationView;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.nav_b_home:
                    break;

                case R.id.nav_b_shoppingbag:
                    Intent intent = new Intent(MyAccount.this, MainActivity.class);
                    startActivity(intent);
                    break;

                case R.id.nav_b_wishlist:
                    Intent intent1 = new Intent(MyAccount.this, Wishlist.class);
                    startActivity(intent1);
                    break;

                case R.id.nav_b_gallery:
                    Intent intent2 = new Intent(MyAccount.this, GalleryView.class);
                    startActivity(intent2);
                    break;

                case R.id.nav_b_category:
                    Intent intent3 = new Intent(MyAccount.this, ProductsDisplay.class);
                    startActivity(intent3);

            }

        return true;

        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_myaccount);

        /*=============Hooks================== */
        navigationView = findViewById(R.id.bottom_navigation);

        //bottom navigationview listener
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        BottomNavigationViewHelper.disableShiftMode(navigationView);


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_b_home:
                break;

            case R.id.nav_b_shoppingbag:
                Intent intent = new Intent(MyAccount.this, MainActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_b_wishlist:
                Intent intent1 = new Intent(MyAccount.this, Wishlist.class);
                startActivity(intent1);
                break;

            case R.id.nav_b_gallery:
                Intent intent2 = new Intent(MyAccount.this, GalleryView.class);
                startActivity(intent2);
                break;

            case R.id.nav_b_category:
                Intent intent3 = new Intent(MyAccount.this, ProductsDisplay.class);
                startActivity(intent3);

        }
        return true;
    }
}
