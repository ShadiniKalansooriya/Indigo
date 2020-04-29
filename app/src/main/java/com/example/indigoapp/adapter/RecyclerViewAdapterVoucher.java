package com.example.indigoapp.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.indigoapp.R;
import com.example.indigoapp.model.Vouchers;

import java.util.ArrayList;

public class RecyclerViewAdapterVoucher extends RecyclerView.Adapter<RecyclerViewAdapterVoucher.MyViewHolder>{

    private ArrayList<Vouchers> list;
    private Context context;public RecyclerViewAdapterVoucher(Context context, ArrayList<Vouchers> list) {
        this.context = context;
        this.list = list;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout layout;
        TextView  name,price;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.product_name);
            price = itemView.findViewById(R.id.product_price);
            image = itemView.findViewById(R.id.product_image);

            layout = itemView.findViewById(R.id.layoutclothesItems);
        }
    }

    @Override
    public RecyclerViewAdapterVoucher.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        final View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_denims_display, viewGroup, false);

        return new RecyclerViewAdapterVoucher.MyViewHolder(itemView);

    }




    @Override
    public void onBindViewHolder(final RecyclerViewAdapterVoucher.MyViewHolder holder, int position) {
        final Vouchers data = list.get(position);

        holder.name.setText("Gift Voucher");
        holder.price.setText(data.getVoucher_price());
        holder.image.setImageDrawable(Drawable.createFromPath("@drawable/voucher.jpg"));

    }




    @Override
    public int getItemCount() {
        return list.size();
    }
}