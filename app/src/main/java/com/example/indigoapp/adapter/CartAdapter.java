package com.example.indigoapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.indigoapp.R;
import com.example.indigoapp.model.Cart;

import java.util.ArrayList;

public abstract class CartAdapter extends RecyclerView.Adapter {

    private Context contexts;
    private ArrayList<Cart> myitems;
    private static CartAdapter.ClickListener clickListener;

    public CartAdapter(Context contexts, ArrayList<Cart> myitems) {
        this.contexts = contexts;
        this.myitems = myitems;
    }


    @NonNull
    @Override
    public CartViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(contexts);
        View view=inflater.inflate(R.layout.activity_price_conform,null);

        return  new CartAdapter.CartViewAdapter(view);
    }



    @Override
    public int getItemCount() {
        return myitems.size();
    }

    class CartViewAdapter extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        ImageView ProductImage;
//                user_delete_button;
        TextView ProductName;
        TextView ProductCount;
        TextView productPrice;
        Button Update;


        public CartViewAdapter(@NonNull View itemView) {
            super(itemView);


            ProductName = itemView.findViewById(R.id.product_name);
            productPrice = itemView.findViewById(R.id.product_price);
            ProductCount = itemView.findViewById(R.id.number_btn);
            ProductImage = itemView.findViewById(R.id.product_image);
            Update = itemView.findViewById(R.id.update_btn);


        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(getAdapterPosition(), view);
        }

        @Override
        public boolean onLongClick(View view) {
            clickListener.onItemLongClick(getAdapterPosition(), view);
            return false;

        }
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        CartAdapter.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(int position, View v);

        void onItemLongClick(int position, View v);
    }
}
