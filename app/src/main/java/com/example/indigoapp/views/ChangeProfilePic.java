package com.example.indigoapp.views;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.indigoapp.R;
import com.example.indigoapp.databases.DbHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class ChangeProfilePic extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Variables

    Button buttonChange, buttonSelect;
    DbHelper dbHelper;

    BottomNavigationView bottomNavigationView;
    //variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    androidx.appcompat.widget.Toolbar toolbar;
    ImageView imageViewEditPic;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.nav_b_home:
                    break;

                case R.id.nav_b_shoppingbag:
                    Intent intent = new Intent(ChangeProfilePic.this, MainActivity.class);
                    startActivity(intent);
                    break;

                case R.id.nav_b_wishlist:
                    Intent intent1 = new Intent(ChangeProfilePic.this, Wishlist.class);
                    startActivity(intent1);
                    break;

                case R.id.nav_b_gallery:
                    Intent intent2 = new Intent(ChangeProfilePic.this, Gallery.class);
                    startActivity(intent2);
                    break;

                case R.id.nav_b_category:
                    Intent intent3 = new Intent(ChangeProfilePic.this, ProductsDisplay.class);
                    startActivity(intent3);

            }

            return true;

        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_profile_pic);

        buttonChange = findViewById(R.id.buttonChange);
        buttonSelect = findViewById(R.id.buttonSelect);

        /*=============Hooks================== */
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        /*===================Hooks======================*/
        drawerLayout = findViewById(R.id.drawer_Layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        dbHelper = new DbHelper(this);

        imageViewEditPic = findViewById(R.id.imageViewEditPic);
        toolbar.setTitle("Change Password");
        /*===========ToolBar ========= */

        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);


        //bottom navigationview listener
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);


        //Hide or show items
        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nav_Login).setVisible(false);


        buttonSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // request photo library
                ActivityCompat.requestPermissions(
                        ChangeProfilePic.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        888
                );
            }
        });

        buttonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                dbHelper.changeProPic(imageViewToByte(imageViewEditPic));

                try {
                    dbHelper.changeProPic(
                            imageViewToByte(imageViewEditPic)
                    );
                    Toast.makeText(getApplicationContext(), "Update successfully!!!",Toast.LENGTH_SHORT).show();
                }
                catch (Exception error) {
                    Log.e("Update error", error.getMessage());
                }

                }

        });


//        dbHelper.changepwd(editTextNewPw.getText().toString().trim());
//        Toast.makeText(getApplicationContext(),"Password Updated",Toast.LENGTH_LONG).show();

    }

    public static byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == 888){
            if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 888);
            }
            else {
                Toast.makeText(getApplicationContext(), "You don't have permission to access file location!", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == 888 && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageViewEditPic.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
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
                Intent intent =new Intent(ChangeProfilePic.this,MainActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_WishList:
                Intent intent1 = new Intent(ChangeProfilePic.this, Wishlist.class);
                startActivity(intent1);
                break;
            case R.id.nav_MyAccount:
                Intent intent6 =new Intent(ChangeProfilePic.this, MyAccount.class);
                startActivity(intent6);
                break;

            case R.id.nav_Promotions:
                Intent intent7 = new Intent(ChangeProfilePic.this, MainActivity.class);
                startActivity(intent7);
                break;
            case R.id.nav_Gallery:
                Intent intent2 =new Intent(ChangeProfilePic.this, Gallery.class);
                startActivity(intent2);
                break;

            case R.id.nav_about:
                Intent intent3 = new Intent(ChangeProfilePic.this, MainActivity.class);
                startActivity(intent3);
                break;
            case R.id.nav_contactUs:
                Intent intent4 =new Intent(ChangeProfilePic.this,MainActivity.class);
                startActivity(intent4);
                break;

            case R.id.nav_Feedback:
                Intent intent5 = new Intent(ChangeProfilePic.this, Feedback.class);
                startActivity(intent5);
                break;

            case R.id.nav_Logout:
                dbHelper.changeuser();
                Intent intent8 = new Intent(ChangeProfilePic.this,Login.class);
                startActivity((intent8));
                Toast.makeText(getApplicationContext(),"Successfully Logged Out",Toast.LENGTH_LONG).show();

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
