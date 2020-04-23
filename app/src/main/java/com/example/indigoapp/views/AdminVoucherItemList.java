package com.example.indigoapp.views;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.indigoapp.R;
import com.example.indigoapp.adapter.VoucherItemListAdapter;
import com.example.indigoapp.databases.DbHelper;

import java.util.ArrayList;

public class AdminVoucherItemList extends AppCompatActivity {

    private RecyclerView recyler;
    private DbHelper dbHelperp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_voucher_item_list);

        recyler = findViewById(R.id.recycler_voucher_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyler.setLayoutManager(layoutManager);

        dbHelperp = new DbHelper(this);
        ArrayList data = dbHelperp.Retrive_admin_voucher_details();

        VoucherItemListAdapter mAdapter = new VoucherItemListAdapter(this,data);
        recyler.setAdapter(mAdapter);
    }
}
