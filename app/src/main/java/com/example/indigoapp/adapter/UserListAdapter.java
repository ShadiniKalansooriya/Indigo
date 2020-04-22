//package com.example.indigoapp.adapter;
//
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.example.indigoapp.R;
//import com.example.indigoapp.model.User;
//
//import java.util.ArrayList;
//
//public class UserListAdapter extends BaseAdapter {
//    private Context context;
//    private  int layout;
//    private ArrayList<User> UserList;
//
//    @Override
//    public int getCount() {
//        return UserList.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return UserList.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    private class ViewHolder{
//        ImageView imageView;
//        TextView txtName, txtPrice;
//    }
//
//    @Override
//    public View getView(int position, View view, ViewGroup parent) {
//
//        View row = view;
//        ViewHolder holder = new ViewHolder();
//
//        if(row == null) {
//            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            row = inflater.inflate(layout, null);
//
//            holder.imageView = (ImageView) row.findViewById(R.id.imageViewpropic);
//            row.setTag(holder);
//        }
//            else {
//                holder = (ViewHolder) row.getTag();
//            }
//
//            User user = UserList.get(position);
//
//        byte[] proImage = user.getPropic();
//        Bitmap bitmap = BitmapFactory.decodeByteArray(proImage, 0, proImage.length);
//        holder.imageView.setImageBitmap(bitmap);
//
//
//        return row;
//    }
//}
