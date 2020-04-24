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
import com.example.indigoapp.model.Vouchers;

import java.util.ArrayList;

public class AdminEditVoucher extends AppCompatActivity {

    private AlertDialog dialog;
    private static final int REQUEST_CODE_GALLERY = 2;
    private boolean ExceptionFound = false;
    private byte[] photo = null;
    private EditText vouPrice, vouQty, searchVou;
    private Button vouUpdateBtn, vouDelBtn, vouSearBtn;
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
        setContentView(R.layout.activity_admin_edit_voucher);

        db = new DbHelper(this);
        db.Retrive_admin_product_details();

        vouPrice = (EditText) findViewById(R.id.admin_voucher_price);
        vouQty = (EditText) findViewById(R.id.admin_voucher_qty);
        searchVou = (EditText) findViewById(R.id.admin_search_voucher);
        vouSearBtn = (Button) findViewById(R.id.admin_search_voucher_btn);
        vouUpdateBtn = (Button) findViewById(R.id.admin_update_voucher_btn);
        vouDelBtn = (Button) findViewById(R.id.admin_delete_voucher_btn);


        //Search a voucher item
        vouSearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = searchVou.getText().toString();
                if (!TextUtils.isEmpty(item)) {
                    ArrayList<Vouchers> vouItem = db.Retrive_admin_search_voucher_details(item);
                    if (vouItem.size() > 0) {
                        itemID = vouItem.get(0).getVoucher_id();
                        vouPrice.setText(vouItem.get(0).getVoucher_price());
                        vouQty.setText(vouItem.get(0).getVoucher_count());

                    } else {
                        Toast.makeText(AdminEditVoucher.this, "Item not found", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    searchVou.setError("Enter valid voucher price");
                }

            }
        });

        //Update a voucher item
        vouUpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = searchVou.getText().toString();
                if (!TextUtils.isEmpty(item)) {
                    String productQty = vouQty.getText().toString().trim();
                    String productPrice = vouPrice.getText().toString().trim();
                    //String prodUrl = prodImageURL.getText().toString().trim();

                    db.Admin_update_voucher_info(itemID, productPrice, productQty);
                    //Admin_update_product_info(String id,String name,String des,String price,byte[]image,String count, String cname){

                    Toast.makeText(AdminEditVoucher.this, "One item updated", Toast.LENGTH_SHORT).show();
                } else {
                    searchVou.setError("Enter valid voucher price");
                }
            }
        });


        //Delete a voucher item
        vouDelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //delete_admin_product();
                db.Admin_delete_current_voucher(itemID);
                Toast.makeText(AdminEditVoucher.this, "One record deleted", Toast.LENGTH_SHORT).show();
                clear();
            }
        });
    }


    //Clear voucher item fields
    private void clear() {
        vouPrice.setText("");
        vouQty.setText("");
    }

}
