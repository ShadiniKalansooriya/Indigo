package com.example.indigoapp.adapter;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.indigoapp.R;
import com.example.indigoapp.model.Products;

import java.util.ArrayList;


public class ProductsItemListAdapter extends RecyclerView.Adapter<ProductsItemListAdapter.MyViewHolder> {
    private ArrayList<Products> list;
    private Context context;

    public ProductsItemListAdapter(Context context, ArrayList<Products> list) {
        this.context = context;
        this.list = list;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        LinearLayout layout;
        TextView name, available, category, price;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.admin_view_product_names);
            available = itemView.findViewById(R.id.admin_current_product_count);
            category = itemView.findViewById(R.id.admin_current_product_category);
            price = itemView.findViewById(R.id.admin_current_product_price);
            image = itemView.findViewById(R.id.admin_view_product_Images);

            layout = itemView.findViewById(R.id.layoutProductItems);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        final View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_admin_products_list, viewGroup, false);

        return new MyViewHolder(itemView);

    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Products data = list.get(position);

        holder.name.setText(data.getProduct_name());
        holder.available.setText(data.getCount());
        holder.category.setText(data.getCatName());
        holder.price.setText(data.getProduct_price());

        byte[] productImage = data.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(productImage, 0, productImage.length);
        holder.image.setImageBitmap(bitmap);

    }
    @Override
    public int getItemCount() {
        return list.size();
    }
}