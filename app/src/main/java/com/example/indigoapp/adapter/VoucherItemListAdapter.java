package com.example.indigoapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.indigoapp.R;

import com.example.indigoapp.model.Vouchers;

import java.util.ArrayList;

public class VoucherItemListAdapter extends RecyclerView.Adapter<VoucherItemListAdapter.MyViewHolder>{

    private ArrayList<Vouchers> list;
    private Context context;

    public VoucherItemListAdapter(Context context, ArrayList<Vouchers> list) {
        this.context = context;
        this.list = list;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        LinearLayout layout;
        TextView available, price;

        public MyViewHolder(View itemView) {
            super(itemView);

            available = itemView.findViewById(R.id.admin_current_voucher_count);
            price = itemView.findViewById(R.id.admin_current_voucher_price);

            layout = itemView.findViewById(R.id.layoutVoucherItems);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        final View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_admin_voucher_list, viewGroup, false);

        return new MyViewHolder(itemView);

    }




    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Vouchers data = list.get(position);

        holder.available.setText(data.getVoucher_count());
        holder.price.setText(data.getVoucher_price());


    }





        /*holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show();

                if(holder.selected.isChecked()){
                    //Toast.makeText(context, "Unchecked", Toast.LENGTH_SHORT).show();
                    holder.selected.setChecked(false);
                    data.setChkStatus(false);
                }else{
                    //Toast.makeText(context, "Checked", Toast.LENGTH_SHORT).show();
                    holder.selected.setChecked(true);
                    data.setChkStatus(true);
                }
            }
        });*/


    @Override
    public int getItemCount() {
        return list.size();
    }
}