package com.example.indigoapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class changePassword extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

        //Variables
        EditText editTextCurrPw, editTextNewPw,editTextconfPw;
        Button buttonChange;
        DbHelper dbHelper;

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
            Intent intenthome =new Intent(changePassword.this,HomePage.class);
            startActivity(intenthome);
        break;

        case R.id.nav_b_shoppingbag:
        Intent intent = new Intent(changePassword.this, MainActivity.class);
        startActivity(intent);
        break;

        case R.id.nav_b_wishlist:
        Intent intent1 = new Intent(changePassword.this, Wishlist.class);
        startActivity(intent1);
        break;

        case R.id.nav_b_gallery:
        Intent intent2 = new Intent(changePassword.this, Gallery.class);
        startActivity(intent2);
        break;

        case R.id.nav_b_category:
        Intent intent3 = new Intent(changePassword.this, ProductsDisplay.class);
        startActivity(intent3);

        }

        return true;

        }

        };



@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

    /*=============Hooks================== */
    bottomNavigationView = findViewById(R.id.bottom_navigation);
    /*===================Hooks======================*/
    drawerLayout = findViewById(R.id.drawer_Layout);
    navigationView = findViewById(R.id.nav_view);
    toolbar = findViewById(R.id.toolbar);

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

    dbHelper = new DbHelper(this);
    editTextCurrPw = findViewById(R.id.editTextcurrentPW);
    editTextNewPw = findViewById(R.id.editTextNewPW);
    editTextconfPw = findViewById(R.id.editTextConfPW);

    buttonChange = findViewById(R.id.buttonChangePw);
    buttonChange.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            validateNewPassword();
            validateConfirmPassword();

            if (validatepassword() == true){
                if (validateNewPassword() == true && validateConfirmPassword() == true){
                    dbHelper.changepwd(editTextNewPw.getText().toString().trim());
                    Toast.makeText(getApplicationContext(),"Password Updated",Toast.LENGTH_LONG).show();
                }
            }

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

    private boolean validatepassword(){

        String passwordInput = editTextCurrPw.getText().toString().trim();
        String input;

        if (passwordInput.isEmpty()) {
            input =  "Current Password cannot be empty";
            Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (passwordInput.equals(dbHelper.getpwd())){
            return true;
        }
        else {
            Toast.makeText(this, "Your Current Password is Incorrect", Toast.LENGTH_SHORT).show();
            return false;
        }




    }



    private boolean validateNewPassword() {
        String passwordInput = editTextNewPw.getText().toString().trim();
        String input;
        int len = passwordInput.length();
        if (passwordInput.isEmpty()) {
            input =  "New Password cannot be empty";
            Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (passwordInput.length() <=8){
            input =  "New Password must be atleast 8 characters";
            Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
            return false;
        }
        else {
            return true;
        }




    }


    private boolean validateConfirmPassword() {
        String i = editTextconfPw.getText().toString().trim();
        String passwordInput = editTextNewPw.getText().toString().trim();
        String input;

        if (i.isEmpty()) {
            input =  "You did not confirm your password";
            Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (i.equals(passwordInput) ){
            return true;
        }
        else {
            input =  "Confirm Password does not match";
            Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
            return false;
        }


    }




    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.nav_home:
                Intent intenthome =new Intent(changePassword.this,HomePage.class);
                startActivity(intenthome);
                break;

            case R.id.nav_shoppingBag:
                Intent intent =new Intent(changePassword.this,MainActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_WishList:
                Intent intent1 = new Intent(changePassword.this, Wishlist.class);
                startActivity(intent1);
                break;
            case R.id.nav_MyAccount:
                Intent intent6 =new Intent(changePassword.this, MyAccount.class);
                startActivity(intent6);
                break;

            case R.id.nav_Promotions:
                Intent intent7 = new Intent(changePassword.this, MainActivity.class);
                startActivity(intent7);
                break;
            case R.id.nav_Gallery:
                Intent intent2 =new Intent(changePassword.this, Gallery.class);
                startActivity(intent2);
                break;

            case R.id.nav_about:
                Intent intent3 = new Intent(changePassword.this, MainActivity.class);
                startActivity(intent3);
                break;
            case R.id.nav_contactUs:
                Intent intent4 =new Intent(changePassword.this,MainActivity.class);
                startActivity(intent4);
                break;

            case R.id.nav_Feedback:
                Intent intent5 = new Intent(changePassword.this, Feedback.class);
                startActivity(intent5);
                break;

            case R.id.nav_Logout:
                dbHelper.changeuser();
                Intent intent8 = new Intent(changePassword.this,Login.class);
                startActivity((intent8));
                Toast.makeText(getApplicationContext(),"Successfully Logged Out",Toast.LENGTH_LONG).show();

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
