package com.example.indigoapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.indigoapp.R;
import com.example.indigoapp.model.Products;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private ArrayList<Products> list;
    private Context context;

    public RecyclerViewAdapter(Context context, ArrayList<Products> list) {
        this.context = context;
        this.list = list;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout layout;
        TextView name, price;

        public MyViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.product_name);
            price = itemView.findViewById(R.id.product_price);

            layout = itemView.findViewById(R.id.layoutclothesItems);
        }
    }

    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        final View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_denims_display, viewGroup, false);

        return new RecyclerViewAdapter.MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final RecyclerViewAdapter.MyViewHolder holder, int position) {
        final Products data = list.get(position);

        holder.name.setText(data.getProduct_name());
        holder.price.setText(data.getProduct_price());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}