package com.example.indigoapp.views;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.indigoapp.R;

import androidx.appcompat.app.AppCompatActivity;

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



//        addToCartBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                insert_cart_details();
//            }
//        });
//        initialize_details();
//    }
//}
//
//private void addToCart(){
//
//        int total=Integer.parseInt(productPrice.getText().toString())*Integer.parseInt(numberBtn.getNumber());
//        String productName = prodName.getText().toString().trim();
//        String productQty = prodquatity.getText().toString().trim();
//        String productDesc = prodDesc.getText().toString().trim();
//        String productPrice = prodPrice.getText().toString().trim();
//        String categoryName = catName.getText().toString().trim();
//        String prodUrl = prodImageURL.getText().toString().trim();
//        String type = "ProductList";
//
//        dbHelperp.addProduct(productName,productQty,productDesc,productPrice,prodUrl,categoryName);
//        Toast.makeText(getApplicationContext(), "Successfully Added Product Details!", Toast.LENGTH_LONG).show();
//        }
//
//    private void insert_cart_details(){
//        int total=Integer.parseInt(productPrice.getText().toString())*Integer.parseInt(numberBtn.getNumber());
//
//
//        boolean isInserted=db.User_insert_cart_details(cart);
//
//
//        if(isInserted&&isAdd){
//        Toast.makeText(Denims_display.this,"sucessfully inserted",Toast.LENGTH_SHORT).show();
//
//        }
//        else{
//        Toast.makeText(Denims_display.this,"Error cannot insert!!",Toast.LENGTH_SHORT).show();
//        }
//
//        }
//    private void initialize_details() {
//
//        try {
//            productImage.setImageBitmap(Prevelent.current_user_products.getBitmap());
//            productPrice.setText(Prevelent.current_user_products.getProduct_price());
//            productName.setText(Prevelent.current_user_products.getProduct_name());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }



