package com.example.indigoapp.views;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.indigoapp.R;
import com.example.indigoapp.databases.DbHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


public class RegisterDetailsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DbHelper dbHelper;
    //Variables
    BottomNavigationView bottomNavigationView;
    //variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    androidx.appcompat.widget.Toolbar toolbar;
    RadioGroup radioGroupgender;
    RadioButton radioButtonGirl;
    RadioButton radioButtonGuy;
    RadioButton radioButton;
    Spinner mySpinner;
    final int REQUEST_CODE_GALLERY = 999;


    TextView TextViewdate;
    TextView TextViewdateSelect;

    EditText editTextName, editTextEmail, editTextPassword, editTextConfPassword, editTextmobile, editTextAddress;
    Button buttonSignUp;
    TextView textViewSignIn;
    ImageView imageViewPropic;


    Calendar c;
    //DatePickerDialog dpd;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.nav_b_home:
                    Intent intenthome =new Intent(RegisterDetailsActivity.this,HomePage.class);
                    startActivity(intenthome);
                    break;

                case R.id.nav_b_shoppingbag:
                    Intent intent = new Intent(RegisterDetailsActivity.this, MainActivity.class);
                    startActivity(intent);
                    break;

                case R.id.nav_b_wishlist:
                    Intent intent1 = new Intent(RegisterDetailsActivity.this, MainActivity.class);
                    startActivity(intent1);
                    break;

                case R.id.nav_b_gallery:
                    Intent intent2 = new Intent(RegisterDetailsActivity.this, GalleryView.class);
                    startActivity(intent2);
                    break;

                case R.id.nav_b_category:
                    Intent intent3 = new Intent(RegisterDetailsActivity.this, ProductsDisplay.class);
                    startActivity(intent3);

            }

            return true;

        }

    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_register);

        dbHelper = new DbHelper(this);
        /*=============Hooks================== */
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        /*===================Hooks======================*/
        drawerLayout = findViewById(R.id.drawer_Layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle("New Member ?");
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


        textViewSignIn = findViewById(R.id.textViewSignIn);
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfPassword = findViewById(R.id.editTextConfPassword);
        editTextmobile = findViewById(R.id.editTextMobile);
        editTextAddress = findViewById(R.id.editTextAddress);
        buttonSignUp = findViewById(R.id.buttonsignup);
        radioGroupgender = findViewById(R.id.gender);
        mySpinner = (Spinner) findViewById(R.id.spinner);
        imageViewPropic = findViewById(R.id.imageViewprofilepic);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(RegisterDetailsActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.user));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);


        imageViewPropic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(
                        RegisterDetailsActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY
                );
            }
        });


        textViewSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(RegisterDetailsActivity.this, Login.class);
                startActivity(loginIntent);
            }
        });


        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get selected radio button from radioGroup
                int selectedID = radioGroupgender.getCheckedRadioButtonId();

                //find the radio button by returned id
                radioButton = (RadioButton) findViewById(selectedID);

//             Toast.makeText(RegisterDetailsActivity.this,
//                     radioButton.getText(), Toast.LENGTH_SHORT).show();


                if (validateUsername() == true && validateEmail() == true && validatePassword() == true && validateMobile() == true && validateConfirmPassword() == true) {
                    try {


                        addUser();
                        Intent RegisterIntent = new Intent(RegisterDetailsActivity.this, Login.class);

                        startActivity(RegisterIntent);

                        Toast.makeText(getApplicationContext(), "Successfully Registered!", Toast.LENGTH_LONG).show();
                        imageViewPropic.setImageResource(R.mipmap.ic_launcher);
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "PROFILE PICTURE REQUIRED", Toast.LENGTH_LONG).show();

                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void addUser() {

        String uname = editTextName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String gender = radioButton.getText().toString().trim();
        String pwd = editTextPassword.getText().toString().trim();
        String mob = editTextmobile.getText().toString().trim();
        String address = editTextAddress.getText().toString().trim();
        String type = mySpinner.getSelectedItem().toString().trim();
        byte[] propic = imageViewToByte(imageViewPropic);


        dbHelper.addUser(uname, email, pwd, mob, address, gender, type, propic);
    }

    public static byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == REQUEST_CODE_GALLERY) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_GALLERY);
            } else {
                Toast.makeText(getApplicationContext(), "You don't have permission to access file location!", Toast.LENGTH_SHORT).show();
            }
            return;
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Context context;

        if (requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();

            String x = getRealPathFromURI(getApplicationContext(), uri);

            File file = new File(x);
//            File file = new File(uri.getPath());
            long size = file.length();

            Log.i("size=", size + "");
            if (size > 1048576) { // 1MB
                Toast.makeText(this, "Image must less than 1MB.", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);

                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageViewPropic.setImageBitmap(bitmap);


            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(this, "Image must less than 1MB.", Toast.LENGTH_SHORT).show();

            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    public String getRealPathFromURI(Context context, Uri contentUri) {
        Cursor cursor = null;
        try {
            String[] proj = {MediaStore.Images.Media.DATA};
            cursor = context.getContentResolver().query(contentUri, proj, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private Boolean validateUsername() {
        String usernameInput = editTextName.getText().toString().trim();
        String input;
        if (usernameInput.isEmpty()) {
            input = "Username cannot be empty";
            Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }

    }

    private Boolean validateEmail() {
        String emailInput = editTextEmail.getText().toString().trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String input;

        if (emailInput.isEmpty()) {
            input = "Email cannot be empty";
            Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
            return false;
        } else if (!emailInput.matches(emailPattern)) {

            Toast toast = Toast.makeText(getApplicationContext(), "invalid email address", Toast.LENGTH_SHORT);
            View view = toast.getView();
            view.setBackgroundColor(Color.rgb(69, 61, 85));
            TextView text = view.findViewById(android.R.id.message);
            text.setTextColor(Color.WHITE);

            toast.setGravity(Gravity.LEFT | Gravity.TOP, 250, 170);
            toast.show();
            return false;
        } else {

            return true;
        }



    }


    private boolean validatePassword() {
        String passwordInput = editTextPassword.getText().toString().trim();
        String input;
        int len = passwordInput.length();
        if (passwordInput.isEmpty()) {
            input = "Password cannot be empty";
            Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
            return false;
        } else if (passwordInput.length() <= 8) {
            input = "Password must be atleast 8 characters";
            Toast.makeText(this, input, Toast.LENGTH_SHORT).show();

            return false;

        } else {
            return true;
        }


    }

    private boolean validateConfirmPassword() {
        String i = editTextConfPassword.getText().toString().trim();
        String passwordInput = editTextPassword.getText().toString().trim();
        String input;

        if (i.isEmpty()) {
            input = "You did not confirm your password";
            Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
            return false;
        } else if (i.equals(passwordInput)) {
            return true;
        } else {
            input = "Password does not match";
            Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
            return false;
        }


    }

    private boolean validateMobile() {
        String mobileInput = editTextmobile.getEditableText().toString().trim();
        String input;
        int len = mobileInput.length();
        if (mobileInput.isEmpty()) {
            input = "Mobile cannot be empty";
            Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
            return false;
        } else if (mobileInput.length() != 10) {
            input = "Enter a valid mobile number ";
            Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                Intent intenthome =new Intent(RegisterDetailsActivity.this,HomePage.class);
                startActivity(intenthome);
                break;

            case R.id.nav_shoppingBag:
                Intent intent = new Intent(RegisterDetailsActivity.this, MainActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_WishList:
                Intent intent1 = new Intent(RegisterDetailsActivity.this, MainActivity.class);
                startActivity(intent1);
                break;
            case R.id.nav_MyAccount:
                Intent intent6 = new Intent(RegisterDetailsActivity.this, MyAccount.class);
                startActivity(intent6);
                break;

            case R.id.nav_Promotions:
                Intent intent7 = new Intent(RegisterDetailsActivity.this, MainActivity.class);
                startActivity(intent7);
                break;
            case R.id.nav_Gallery:
                Intent intent2 = new Intent(RegisterDetailsActivity.this, GalleryView.class);
                startActivity(intent2);
                break;

            case R.id.nav_about:
                Intent intent3 = new Intent(RegisterDetailsActivity.this, MainActivity.class);
                startActivity(intent3);
                break;
            case R.id.nav_contactUs:
                Intent intent4 = new Intent(RegisterDetailsActivity.this, MainActivity.class);
                startActivity(intent4);
                break;

            case R.id.nav_Feedback:
                Intent intent5 = new Intent(RegisterDetailsActivity.this, Feedback.class);
                startActivity(intent5);
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
