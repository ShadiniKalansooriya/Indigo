package com.example.indigoapp.views;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.indigoapp.R;
import com.example.indigoapp.databases.DbHelper;

public class Denims_display extends AppCompatActivity {

    Button addToCartBtn, removeCartBtn, wishListBtn;
    ImageView productImage;
    ElegantNumberButton numberBtn;
    TextView productPrice, productName;
    DbHelper dbHelperp;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denims_display);

        dbHelperp = new DbHelper(this);


        numberBtn = (ElegantNumberButton) findViewById(R.id.number_btn);
        productImage = (ImageView) findViewById(R.id.product_image);
        productPrice = (TextView) findViewById(R.id.product_price);
        productName = (TextView) findViewById(R.id.product_name);
        addToCartBtn = (Button) findViewById(R.id.update_btn);
        removeCartBtn = (Button) findViewById(R.id.remove_cart_btn);
        wishListBtn = (Button) findViewById(R.id.imageButton2);

    }
}

//        addToCartBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                insert_cart_details();
//            }
//        });
//        initialize_details();
//    }


//    private void insert_cart_details() {
//        int total=Integer.(productPrice.getText().toString())*Integer.(numberBtn.getNumber().toString());
//
//        Cart cart=new Cart(productName.getText().toString(),productPrice.getText().toString(),
//                String.valueOf(total),numberBtn.getNumber().toString());
//
//        boolean isInserted=dbHelperp.User_insert_cart_details(cart);
//
//        if(isInserted){
//            Toast.makeText(Denims_display.this,"Sucessfully inserted",Toast.LENGTH_SHORT).show();
//
//        }
//        else{
//            Toast.makeText(Denims_display.this,"Error cannot insert!!",Toast.LENGTH_SHORT).show();
//        }
//
//    }
//
//    private void initialize_details() {
//
//            //product_image.setImageBitmap(Prevelent.current_user_products.getBitmap());
//            String proPrice = productPrice.getText().toString().trim();
//            String proName = productName.getText().toString().trim();
//
//
//            dbHelperp.initialize_details(proPrice,proName);
//            Toast.makeText(getApplicationContext(), "Successfully Added Product Details!", Toast.LENGTH_LONG).show();
//
//        }
//
//    }

