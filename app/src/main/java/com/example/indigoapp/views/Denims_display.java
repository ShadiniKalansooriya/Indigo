package com.example.indigoapp.views;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.indigoapp.R;

public class Denims_display extends AppCompatActivity {

    Button addToCartBtn, removeCartBtn, wishListBtn;
    //private ImageView productImage;
    // private ElegantNumberButton numberBtn;
    // private TextView productPrice, productDescription, productName;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denims_display);

        addToCartBtn = (Button) findViewById(R.id.add_to_cart_btn);
        wishListBtn = (Button) findViewById(R.id.imageButton2);
        removeCartBtn = (Button) findViewById(R.id.remove_cart_btn);

        //   addToCartBtn = (Button) findViewById(R.id.add_to_cart_btn);
        //  numberBtn  = (ElegantNumberButton) findViewById(R.id.number_btn);
        //  productImage = (ImageView) findViewById(R.id.product_image);
        //  productPrice = (TextView) findViewById(R.id.product_price);
        //  productDescription = (TextView) findViewById(R.id.product_description);
        // productName = (TextView) findViewById(R.id.product_name);



    }




    }
