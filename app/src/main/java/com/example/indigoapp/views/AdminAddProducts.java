package com.example.indigoapp.views;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.indigoapp.R;
import com.example.indigoapp.databases.DbHelper;

import java.io.ByteArrayOutputStream;

import androidx.appcompat.app.AppCompatActivity;

public class AdminAddProducts extends AppCompatActivity {

    EditText prodName, prodDesc, prodPrice, prodquatity, catName;
    Button add_products;
    DbHelper dbHelperp;
    Spinner mySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_products);

        dbHelperp = new DbHelper(this);

        prodName = (EditText) findViewById(R.id.product_name);
        prodDesc = (EditText) findViewById(R.id.product_id);
        prodPrice = (EditText) findViewById(R.id.product_price);
        prodquatity = (EditText) findViewById(R.id.product_counts);
        //catName = (EditText) findViewById(R.id.category_name);
        mySpinner = (Spinner) findViewById(R.id.spinner);
        add_products = (Button) findViewById(R.id.admin_add_new_product);

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
    }


    private void addProduct(){
        String productName = prodName.getText().toString().trim();
        String productQty = prodquatity.getText().toString().trim();
        String productDesc = prodDesc.getText().toString().trim();
        String productPrice = prodPrice.getText().toString().trim();
        //String categoryName = catName.getText().toString().trim();
        String categoryName = mySpinner.getSelectedItem().toString().trim();

        String type = "ProductList";

        dbHelperp.addProduct(productName,productQty,productDesc,productPrice,categoryName);
        Toast.makeText(getApplicationContext(), "Successfully Added Product Details!", Toast.LENGTH_LONG).show();
    }

    public static byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }


}
