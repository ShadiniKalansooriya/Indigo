package com.example.indigoapp.views;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.indigoapp.R;

public class Denims_display extends AppCompatActivity {

    Button addToCartBtn, removeCartBtn, wishListBtn;
    ImageView productImage;
    ElegantNumberButton numberBtn;
    TextView productPrice, productName;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denims_display);

        addToCartBtn = (Button) findViewById(R.id.update_btn);
        wishListBtn = (Button) findViewById(R.id.imageButton2);
        removeCartBtn = (Button) findViewById(R.id.remove_cart_btn);
        numberBtn = (ElegantNumberButton) findViewById(R.id.number_btn);
        productImage = (ImageView) findViewById(R.id.product_image);
        productPrice = (TextView) findViewById(R.id.product_price);
        productName = (TextView) findViewById(R.id.product_name);


    }
   /*     addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert_cart_details();
            }
        });
        initialize_details();*/
    }
/*
    private void insert_cart_details() {
        int total=Integer.parseInt(productPrice.getText().toString())*Integer.parseInt(numberBtn.getNumber());

        Cart cart=new Cart(productName.getText().toString(),productPrice.getText().toString(),
                String.valueOf(total),Prevelent.currentUser.getId(),Prevelent.current_user_products.getBitmap(),numberBtn.getNumber().toString(),Prevelent.current_user_products.getProduct_id());
        // Toast.makeText(ProductDetailActivity.this,Prevelent.currentUser.getId(),Toast.LENGTH_SHORT).show();

        boolean isInserted=db.User_insert_cart_details(cart);
        boolean isAdd=db.insert_user_notification_details(Prevelent.currentUser.getId());

        if(isInserted && isAdd){
            Toast.makeText(Denims_display.this,"sucessfully inserted",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(Denims_display.this,AppHomeActivity.class);
            startActivity(intent);

        }
        else{
            Toast.makeText(Denims_display.this,"Error cannot insert!!",Toast.LENGTH_SHORT).show();
        }

    }

    private void initialize_details() {

        try {
            productImage.setImageBitmap(Prevelent.current_user_products.getBitmap());
            productPrice.setText(Prevelent.current_user_products.getProduct_price());
            productName.setText(Prevelent.current_user_products.getProduct_name());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }



    }*/
