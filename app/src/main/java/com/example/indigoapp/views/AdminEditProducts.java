package com.example.indigoapp.views;

import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.indigoapp.R;
import com.example.indigoapp.adapter.ProductsItemListAdapter;
import com.example.indigoapp.databases.DbHelper;
import com.example.indigoapp.model.Products;

import java.util.ArrayList;

//import dmax.dialog.SpotsDialog;

public class AdminEditProducts extends AppCompatActivity {

    private AlertDialog dialog;
    private static final int REQUEST_CODE_GALLERY = 2;
    private boolean ExceptionFound = false;
    private byte[] photo = null;
    private EditText admin_product_name, admin_product_des, admin_product_price, admin_product_counts, admin_category_name, admin_product_img_url, admin_search_pro;
    private Button delete_new_product_button, admin_update_button, admin_search_button;
    private DbHelper db;
    //private TextView admin_category_edit_heading;
    private RecyclerView recyclerView;
    private ProductsItemListAdapter itemsAdapter;
    private ArrayList<Products> admin_items;

    private Bitmap bp = null;

    private String itemID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_edit_products);

        db = new DbHelper(this);
        db.Retrive_admin_product_details();

        admin_product_name = (EditText) findViewById(R.id.edit_product_name);
        admin_product_des = (EditText) findViewById(R.id.edit_product_description);
        admin_product_price = (EditText) findViewById(R.id.edit_product_price);
        admin_update_button = (Button) findViewById(R.id.admin_update_current_product);
        admin_product_counts = (EditText) findViewById(R.id.edit_product_count);
        delete_new_product_button = (Button) findViewById(R.id.admin_edit_product_delete);
        admin_category_name = (EditText) findViewById(R.id.edit_category_name);
        //admin_product_img_url = (EditText) findViewById(R.id.edit_product_img_url);
        admin_search_pro = (EditText) findViewById(R.id.admin_search_product);
        //dialog = new SpotsDialog(this,"Updating..");

        admin_search_button = (Button) findViewById(R.id.product_search_btn);

        //Search a Product item
        admin_search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = admin_search_pro.getText().toString();
                if (!TextUtils.isEmpty(item)) {
                    ArrayList<Products> prodItem = db.Retrive_admin_search_product_details(item);
                    if (prodItem.size() > 0) {
                        itemID = prodItem.get(0).getProduct_id();
                        admin_product_name.setText(prodItem.get(0).getProduct_name());
                        admin_product_des.setText(prodItem.get(0).getProduct_desc());
                        admin_product_price.setText(prodItem.get(0).getProduct_price());
                        admin_product_counts.setText(prodItem.get(0).getCount());
                        admin_category_name.setText(prodItem.get(0).getCatName());
                    } else {
                        Toast.makeText(AdminEditProducts.this, "Item not found", Toast.LENGTH_SHORT).show();
                    }
                    //admin_search_pro.setText("");
                } else {
                    admin_search_pro.setError("Enter valid product name");
                }

            }
        });

        //Update a product item
        admin_update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = admin_search_pro.getText().toString();
                if (!TextUtils.isEmpty(item)) {
                    String productName = admin_product_name.getText().toString().trim();
                    String productQty = admin_product_counts.getText().toString().trim();
                    String productDesc = admin_product_des.getText().toString().trim();
                    String productPrice = admin_product_price.getText().toString().trim();
                    String categoryName = admin_category_name.getText().toString().trim();
                    //String prodUrl = prodImageURL.getText().toString().trim();

                    db.Admin_update_product_info(itemID, productName, productDesc, productPrice, null, productQty, categoryName);
                    //Admin_update_product_info(String id,String name,String des,String price,byte[]image,String count, String cname){

                    Toast.makeText(AdminEditProducts.this, "One item updated", Toast.LENGTH_SHORT).show();
                } else {
                    admin_search_pro.setError("Enter valid product name");
                }
            }
        });


        //Delete a Product item
        delete_new_product_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //delete_admin_product();
                db.Admin_delete_current_product(itemID);
                Toast.makeText(AdminEditProducts.this, "One record deleted", Toast.LENGTH_SHORT).show();
                clear();
            }
        });
    }


    //Clear Product item fields
    private void clear() {
        admin_product_name.setText("");
        admin_product_price.setText("");
        admin_product_des.setText("");
        admin_product_counts.setText("");
        admin_category_name.setText("");
        admin_product_img_url.setText("");
    }

}

