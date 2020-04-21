package com.example.indigoapp.views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class Login extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Variables
    EditText editTextEmail, editTextPassword;
    Button buttonSignIn;
    TextView textViewSignUp;
    DbHelper dbHelper;
    SharedPreferences pref;


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
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                    break;

                case R.id.nav_b_wishlist:
                    Intent intent1 = new Intent(Login.this, MainActivity.class);
                    startActivity(intent1);
                    break;

                case R.id.nav_b_gallery:
                    Intent intent2 = new Intent(Login.this, GalleryView.class);
                    startActivity(intent2);
                    break;

                case R.id.nav_b_category:
                    Intent intent3 = new Intent(Login.this, ProductsDisplay.class);
                    startActivity(intent3);

            }

            return true;

        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_login);

        /*=============Hooks================== */
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        /*===================Hooks======================*/
        drawerLayout = findViewById(R.id.drawer_Layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle("Already Registered ?");
        /*===========ToolBar ========= */

        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        //navigationView.setCheckedItem(R.id.nav_MyAccount);

        //bottom navigationview listener
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        //Hide or show items
        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nav_Logout).setVisible(false);
        menu.findItem(R.id.nav_MyAccount).setVisible(false);


        dbHelper = new DbHelper(this);
        pref = getSharedPreferences("user_details",MODE_PRIVATE);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextEmail.setText(dbHelper.getEmail());
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextPassword.setText(dbHelper.getpwd());
        buttonSignIn = findViewById(R.id.buttonSignIn);
        textViewSignUp = findViewById(R.id.textViewSignUp);

        textViewSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(Login.this, RegisterDetailsActivity.class);
                startActivity(registerIntent);
            }
        });

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            String input;


            @Override
            public void onClick(View v) {
                if (validateEmailUsername() == true && validatePassword() == true) {
                    String type = checkUser();

                    if (type.equals("RegisteredUser")) {
                        Intent loginIntent = new Intent(Login.this, MyAccount.class);
                        Toast.makeText(Login.this, "Successfully Logged in", Toast.LENGTH_SHORT).show();

                        startActivity(loginIntent);
                    }
                    else
                        Toast.makeText(Login.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();

                }



            }
        });


    }


    private boolean validateEmailUsername() {
        String emailusernameInput = editTextEmail.getText().toString().trim();
        String input;
        if (emailusernameInput.isEmpty()) {
            input =  "Email(Username) cannot be empty";
            Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
            return  false;
        }
        else {
            return true;
        }

    }

    private boolean validatePassword() {
        String passwordInput = editTextPassword.getEditableText().toString().trim();
        String input;

        if (passwordInput.isEmpty()) {
            input =  "Password cannot be empty";
            Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
            return  false;
        }
        else {
            return true;
        }

    }

    private String checkUser() {
        String email = editTextEmail.getText().toString().trim();
        String pwd = editTextPassword.getText().toString().trim();

        SharedPreferences.Editor editor = pref.edit();
        editor.putString("email", email);
        editor.putString("password", pwd);
        editor.commit();
        String type = dbHelper.checkUser(email, pwd);
        return type;
    }

        @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                break;

            case R.id.nav_shoppingBag:
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_WishList:
                Intent intent1 = new Intent(Login.this, Wishlist.class);
                startActivity(intent1);
                break;
            case R.id.nav_MyAccount:
                Intent intent6 = new Intent(Login.this, MyAccount.class);
                startActivity(intent6);
                break;

            case R.id.nav_Promotions:
                Intent intent7 = new Intent(Login.this, MainActivity.class);
                startActivity(intent7);
                break;
            case R.id.nav_Gallery:
                Intent intent2 = new Intent(Login.this, GalleryView.class);
                startActivity(intent2);
                break;

            case R.id.nav_about:
                Intent intent3 = new Intent(Login.this, MainActivity.class);
                startActivity(intent3);
                break;
            case R.id.nav_contactUs:
                Intent intent4 = new Intent(Login.this, MainActivity.class);
                startActivity(intent4);
                break;

            case R.id.nav_Feedback:
                Intent intent5 = new Intent(Login.this, Feedback.class);
                startActivity(intent5);
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}
