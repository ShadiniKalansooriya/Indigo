package com.example.indigoapp.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.indigoapp.R;
import com.example.indigoapp.model.Gallery;

import java.util.ArrayList;

public class GalleryLIstAdapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<Gallery> galleryList;

    public GalleryLIstAdapter(Context context, int layout, ArrayList<Gallery> galleryList) {
        this.context = context;
        this.layout = layout;
        this.galleryList = galleryList;
    }

    @Override
    public int getCount() {
        return galleryList.size();
    }

    @Override
    public Object getItem(int position) {
        return galleryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView txtEmail, txtHashtag;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtEmail = (TextView) row.findViewById(R.id.textViewEmail);
            holder.txtHashtag = (TextView) row.findViewById(R.id.textViewHashtag);
            holder.imageView = (ImageView) row.findViewById(R.id.imageViewimg);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        Gallery food = galleryList.get(position);

        holder.txtEmail.setText(food.getEmail());
        holder.txtHashtag.setText(food.getHashtag());

        byte[] Image = food.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(Image, 0, Image.length);
        holder.imageView.setImageBitmap(bitmap);

        return row;
    }
}
