package com.example.indigoapp.views;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.indigoapp.R;
import com.example.indigoapp.adapter.ProductsItemListAdapter;
import com.example.indigoapp.databases.DbHelper;

import java.util.ArrayList;

public class AdminProductsList extends AppCompatActivity {

    private RecyclerView recyler;
    private DbHelper dbHelperp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_products_item_list);

        recyler = findViewById(R.id.recycler_item_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyler.setLayoutManager(layoutManager);

        dbHelperp = new DbHelper(this);
        ArrayList data = dbHelperp.Retrive_admin_product_details();
        //ArrayList data = dbHelperp.Retrive_selected_product_details("Denims");

        ProductsItemListAdapter mAdapter = new ProductsItemListAdapter(this,data);
        recyler.setAdapter(mAdapter);
    }
}
