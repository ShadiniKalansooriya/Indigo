package com.example.indigoapp.views;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.indigoapp.R;
import com.example.indigoapp.databases.DbHelper;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class AdminAddProducts extends AppCompatActivity {

    EditText prodName, prodDesc, prodPrice, prodquatity, catName;
    Button add_products,btnChoose;
    ImageView imageView;
    DbHelper dbHelperp;
    Spinner mySpinner;

    final int REQUEST_CODE_GALLERY = 999;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_products);

        dbHelperp = new DbHelper(this);

        prodName = findViewById(R.id.product_name);
        prodDesc = findViewById(R.id.product_id);
        prodPrice = findViewById(R.id.product_price);
        prodquatity = findViewById(R.id.product_counts);
        //catName = (EditText) findViewById(R.id.category_name);
        btnChoose = findViewById(R.id.chooseProImage);
        imageView = findViewById(R.id.productImage);
        mySpinner = findViewById(R.id.spinner);
        add_products = findViewById(R.id.admin_add_new_product);


        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(AdminAddProducts.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.category));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        buttonClickActivity();

    }

    private void buttonClickActivity() {
        add_products.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addProduct();
                Intent AddProdIntent = new Intent(AdminAddProducts.this, AdminProductsList.class);
                startActivity(AddProdIntent);
                //Toast.makeText(getApplicationContext(), "Successfully Added Product Details!", Toast.LENGTH_LONG).show();

            }
        });

        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(
                        AdminAddProducts.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY
                );
            }
        });
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

        if(requestCode == REQUEST_CODE_GALLERY){
            if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_GALLERY);
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

        Context context;

        if(requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();

            String   x = getRealPathFromURI(getApplicationContext(),uri);

            File file = new File(x);
//            File file = new File(uri.getPath());
            long size = file.length();

            Log.i("size=", size + "");
            if(size > 1048576) { // 1MB
                Toast.makeText(this, "Image must less than 1MB.", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);

                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(bitmap);


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
            String[] proj = { MediaStore.Images.Media.DATA };
            cursor = context.getContentResolver().query(contentUri,  proj, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }


    private void addProduct(){
        String productName = prodName.getText().toString().trim();
        String productQty = prodquatity.getText().toString().trim();
        String productDesc = prodDesc.getText().toString().trim();
        String productPrice = prodPrice.getText().toString().trim();
        String categoryName = mySpinner.getSelectedItem().toString().trim();
        byte[] imView = imageViewToByte(imageView);

        String type = "ProductList";

        dbHelperp.addProduct(productName,productQty,productDesc,productPrice, imView, categoryName);
        Toast.makeText(getApplicationContext(), "Successfully Added Product Details!", Toast.LENGTH_LONG).show();
    }

}
