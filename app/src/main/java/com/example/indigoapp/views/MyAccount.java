package com.example.indigoapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.indigoapp.R;
import com.example.indigoapp.databases.DbHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


public class MyAccount extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Variables

    BottomNavigationView bottomNavigationView;
    //variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    androidx.appcompat.widget.Toolbar toolbar;


    Button btnAccountOverView,buttonChangePW,buttonChangeProPic,buttonWishlist,buttonStoreCredit,buttonNewsletter,buttonLogout;
    ImageView imageViewPropic;
    TextView textViewName;
    String x;
    DbHelper dbHelper;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.nav_b_home:
                    Intent intenthome =new Intent(MyAccount.this,HomePage.class);
                    startActivity(intenthome);
                    break;

                case R.id.nav_b_shoppingbag:
                    Intent intent = new Intent(MyAccount.this, ProductsDetails.class);
                    startActivity(intent);
                    break;

                case R.id.nav_b_wishlist:
                    Intent intent1 = new Intent(MyAccount.this, Wishlist.class);
                    startActivity(intent1);
                    break;

                case R.id.nav_b_gallery:
                    Intent intent2 = new Intent(MyAccount.this, Gallery.class);
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

        dbHelper = new DbHelper(this);

        /*=============Hooks================== */
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        /*===================Hooks======================*/
        drawerLayout = findViewById(R.id.drawer_Layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle("My Account");
        /*===========ToolBar ========= */

        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_MyAccount);

        //bottom navigationview listener
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);


        btnAccountOverView = findViewById(R.id.buttonAccountOverview);
        buttonChangePW = findViewById(R.id.buttonChangePw);
        buttonChangeProPic = findViewById(R.id.buttonChangeProPic);
        textViewName = findViewById(R.id.textViewName);
        imageViewPropic = findViewById(R.id.imageViewpropic);
        imageViewPropic.setImageBitmap(dbHelper.getProPic());


        //Hide or show items
        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nav_Login).setVisible(false);

        x = dbHelper.getUsername();
        textViewName.setText(x);
//        ViewHolder holder = new ViewHolder();


//        byte[] propicImage = User.getPropic();
//        Bitmap bitmap = BitmapFactory.decodeByteArray(propicImage, 0, propicImage.length);
//        imageViewPropic.setImageBitmap(bitmap);


        btnAccountOverView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyAccount.this,AccountOverview.class);
                startActivity(intent);
            }
        });


        buttonChangePW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changePwIntent = new Intent(MyAccount.this, changePassword.class);
                startActivity(changePwIntent);
            }
        });
        buttonChangeProPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changePwIntent = new Intent(MyAccount.this, ChangeProfilePic.class);
                startActivity(changePwIntent);
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

//    private  class ViewHolder{
//        ImageView imageView;
//    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.nav_home:
                Intent intenthome =new Intent(MyAccount.this,HomePage.class);
                startActivity(intenthome);
                break;

            case R.id.nav_shoppingBag:
                Intent intent =new Intent(MyAccount.this,ProductsDetails.class);
                startActivity(intent);
                break;

            case R.id.nav_WishList:
                Intent intent1 = new Intent(MyAccount.this, Wishlist.class);
                startActivity(intent1);
                break;
            case R.id.nav_MyAccount:
                Intent intent6 =new Intent(MyAccount.this, MyAccount.class);
                startActivity(intent6);
                break;

            case R.id.nav_Promotions:
                Intent intent7 = new Intent(MyAccount.this, MainActivity.class);
                startActivity(intent7);
                break;
            case R.id.nav_Gallery:
                Intent intent2 =new Intent(MyAccount.this, GalleryView.class);
                startActivity(intent2);
                break;

            case R.id.nav_about:
                Intent intent3 = new Intent(MyAccount.this, MainActivity.class);
                startActivity(intent3);
                break;
            case R.id.nav_contactUs:
                Intent intent4 =new Intent(MyAccount.this,MainActivity.class);
                startActivity(intent4);
                break;

            case R.id.nav_Feedback:
                Intent intent5 = new Intent(MyAccount.this, Feedback.class);
                startActivity(intent5);
                break;

            case R.id.nav_Logout:
                dbHelper.changeuser();
                Intent intent8 = new Intent(MyAccount.this,Login.class);
                startActivity((intent8));
                Toast.makeText(getApplicationContext(),"Successfully Logged Out",Toast.LENGTH_LONG).show();

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}
