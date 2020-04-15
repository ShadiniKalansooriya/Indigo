package com.example.indigoapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "test.sliit.recyclerview.RecyclerViewAdapter";
    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImageDesc = new ArrayList<>();
    private ArrayList<String> mImagePrice = new ArrayList<>();
    private ArrayList<String> mImage = new ArrayList<>();
    private Context mContext;
    public RecyclerViewAdapter(ArrayList<String> mImageNames, ArrayList<String> mImage, ArrayList<String> mImageDesc, ArrayList<String> mImagePrice, Context mContext)
    {
        this.mImageNames = mImageNames;
        this.mImage = mImage;
        this.mImageDesc = mImageDesc;
        this.mImagePrice = mImagePrice;
        this.mContext = mContext;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_denims_display,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    @SuppressLint("LongLogTag")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");
        Glide.with(mContext).asBitmap().load(mImage.get(position)).into(holder.image);
        holder.productName.setText(mImageNames.get(position));
        holder.productDescription.setText(mImageDesc.get(position));
        holder.productPrice.setText(mImagePrice.get(position));
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on"+mImageNames.get(position));

                Toast.makeText(mContext,mImageNames.get(position),Toast.LENGTH_SHORT).show();

            }
        });
    }
    @Override
    public int getItemCount() {
        return mImageNames.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView productName;
        TextView productPrice;
        TextView productDescription;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.product_image);
            productName = itemView.findViewById(R.id.product_name);
            productPrice = itemView.findViewById(R.id.product_price);
            productDescription = itemView.findViewById(R.id.product_description);
            parentLayout = itemView.findViewById(R.id.recycler_view);
        }
    }
}
