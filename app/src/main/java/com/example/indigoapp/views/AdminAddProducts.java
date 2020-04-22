package com.example.indigoapp.views;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.indigoapp.R;
import com.example.indigoapp.databases.DbHelper;

public class AdminAddProducts extends AppCompatActivity {

    EditText prodName, prodDesc, prodPrice, prodquatity, catName, prodImageURL;
    Button add_products;
    DbHelper dbHelperp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_products);

        dbHelperp = new DbHelper(this);

        prodName = (EditText) findViewById(R.id.product_name);
        prodDesc = (EditText) findViewById(R.id.product_id);
        prodPrice = (EditText) findViewById(R.id.product_price);
        prodquatity = (EditText) findViewById(R.id.product_counts);
        catName = (EditText) findViewById(R.id.category_name);
        prodImageURL = (EditText) findViewById(R.id.product_img_url);
        add_products = (Button) findViewById(R.id.add_prod_admin_btn);

        //buttonClickActivity();

    }

   /* private void buttonClickActivity() {
        add_products.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addProduct();
                Intent AddProdIntent = new Intent(AdminAddProducts.this, AdminProductsList.class);
                startActivity(AddProdIntent);
                Toast.makeText(getApplicationContext(), "Successfully Added Product Details!", Toast.LENGTH_LONG).show();

            }
        });
    }


    private void addProduct(){
        String productName = prodName.getText().toString().trim();
        String productQty = prodquatity.getText().toString().trim();
        String productDesc = prodDesc.getText().toString().trim();
        String productPrice = prodPrice.getText().toString().trim();
        String categoryName = catName.getText().toString().trim();
        String prodUrl = prodImageURL.getText().toString().trim();
        String type = "ProductList";

        dbHelperp.addProduct(productName,productQty,productDesc,productPrice,prodUrl,categoryName);
    }*/

}
