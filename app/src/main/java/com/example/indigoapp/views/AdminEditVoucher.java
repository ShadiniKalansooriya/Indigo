package com.example.indigoapp.views;

import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.indigoapp.R;
import com.example.indigoapp.adapter.ProductsAdapter;
import com.example.indigoapp.databases.DbHelper;
import com.example.indigoapp.model.Products;

import java.util.ArrayList;

public class AdminEditVoucher extends AppCompatActivity {

    private AlertDialog dialog;
    private static final int REQUEST_CODE_GALLERY=2;
    private boolean ExceptionFound=false;
    private byte[] photo=null;
    private EditText vouPrice, vouQty, searchVou;
    private Button vouUpdateBtn,vouDelBtn, vouSearBtn;
    private DbHelper db;
    //private TextView admin_category_edit_heading;
    private RecyclerView recyclerView;
    private ProductsAdapter itemsAdapter;
    private ArrayList<Products> admin_items;
    private Bitmap bp=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_edit_voucher);

        vouPrice = (EditText) findViewById(R.id.admin_voucher_price);
        vouQty = (EditText) findViewById(R.id.admin_voucher_qty);
        searchVou = (EditText) findViewById(R.id.admin_search_voucher);
        vouSearBtn = (Button) findViewById(R.id.admin_search_voucher_btn);
        vouUpdateBtn = (Button) findViewById(R.id.admin_update_voucher_btn);
        vouDelBtn = (Button) findViewById(R.id.admin_delete_voucher_btn);


        vouUpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AdminEditVoucher.this,"Product!",Toast.LENGTH_SHORT).show();
                //Update_Admin_voucher_Details();
            }
        });

        db=new DbHelper(this);

        vouDelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //delete_admin_voucher();

            }
        });

        //initializeComponents();

    }

    /*private void initializeComponents(){
        vouPrice.setText(Vouchers.getVoucher_price());
        vouQty.setText(Vouchers.getVoucher_count());

    }


    private void delete_admin_voucher(){


        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Add new Vouchers").setMessage("Are you sure want to delete this Item?").setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                boolean isDeleted=db.//Admin_delete_current_product(Vouchers.getVoucher_id());
                if(isDeleted){
                    Toast.makeText(AdminEditVoucher.this,"Voucher deleted Sucessfully!!",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(AdminEditVoucher.this,AdminEditVoucher.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(AdminEditVoucher.this,"Error Occur Cannot Delete",Toast.LENGTH_SHORT).show();
                }
            }

        }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AdminEditVoucher.this, "Delete Cancel..", Toast.LENGTH_SHORT).show();
            }
        }).setCancelable(false).show();



    }

    private void Update_Admin_voucher_Details() {


        if (vouPrice.getText().toString().isEmpty()) {
            Toast.makeText(AdminEditVoucher.this, "Please Enter product Name..", Toast.LENGTH_SHORT).show();
        } else{
            if (vouQty.getText().toString().isEmpty()) {
                Toast.makeText(AdminEditVoucher.this, "Please Enter voucher quantity..", Toast.LENGTH_SHORT).show();
            }  else {


            }
        }
    }*/
}