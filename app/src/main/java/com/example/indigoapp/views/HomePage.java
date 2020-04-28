package com.example.indigoapp.views;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.indigoapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import static com.example.indigoapp.views.Gallery.dbHelper;

public class HomePage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

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
                    Intent intent = new Intent(HomePage.this, MainActivity.class);
                    startActivity(intent);
                    break;

                case R.id.nav_b_wishlist:
                    Intent intent1 = new Intent(HomePage.this, Wishlist.class);
                    startActivity(intent1);
                    break;

                case R.id.nav_b_gallery:
                    Intent intent2 = new Intent(HomePage.this, Gallery.class);
                    startActivity(intent2);
                    break;

                case R.id.nav_b_category:
                    Intent intent3 = new Intent(HomePage.this, ProductsDisplay.class);
                    startActivity(intent3);

            }

            return true;

        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        //this is your video name

        String fileName = "videohome";

        //this is the full video path from raw folder
        String fileplace = "android.resource://"+getPackageName()+"/raw/"+fileName;

        //defining the video view
        VideoView videoView = (VideoView)findViewById(R.id.videoView);
        videoView.setVideoURI(Uri.parse(fileplace));

        //this is if you want the video to repeat
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

//        //this is if you want to show video controls
//        videoView.setMediaController(new MediaController(this));

        videoView.start();


        /*=============Hooks================== */
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        /*===================Hooks======================*/
        drawerLayout = findViewById(R.id.drawer_Layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle("HOME");
        /*===========ToolBar ========= */

        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

         navigationView.setCheckedItem(R.id.nav_home);

        //bottom navigationview listener
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        //Hide or show items
        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nav_Login).setVisible(false);



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
                Intent intenthome =new Intent(HomePage.this,HomePage.class);
                startActivity(intenthome);
                break;

            case R.id.nav_shoppingBag:
                Intent intent =new Intent(HomePage.this,MainActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_WishList:
                Intent intent1 = new Intent(HomePage.this, Wishlist.class);
                startActivity(intent1);
                break;
            case R.id.nav_MyAccount:
                Intent intent6 =new Intent(HomePage.this, MyAccount.class);
                startActivity(intent6);
                break;

            case R.id.nav_Promotions:
                Intent intent7 = new Intent(HomePage.this, MainActivity.class);
                startActivity(intent7);
                break;
            case R.id.nav_Gallery:
                Intent intent2 =new Intent(HomePage.this, Gallery.class);
                startActivity(intent2);
                break;

            case R.id.nav_about:
                Intent intent3 = new Intent(HomePage.this, MainActivity.class);
                startActivity(intent3);
                break;
            case R.id.nav_contactUs:
                Intent intent4 =new Intent(HomePage.this,MainActivity.class);
                startActivity(intent4);
                break;

            case R.id.nav_Feedback:
                Intent intent5 = new Intent(HomePage.this, Feedback.class);
                startActivity(intent5);
                break;

            case R.id.nav_Logout:
                dbHelper.changeuser();
                Intent intent8 = new Intent(HomePage.this,Login.class);
                startActivity((intent8));
                Toast.makeText(getApplicationContext(),"Successfully Logged Out",Toast.LENGTH_LONG).show();

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
