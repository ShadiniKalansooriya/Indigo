package com.example.indigoapp.model;

import android.graphics.Bitmap;

public class Cart {

    private String id;
    private String name;
    private String price;
    private String count;


    public Cart(String name,  String price,String product_id) {

        this.name = name;
        this.price = price;
        this.count=count;
//            this.product_id=product_id;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//           public String getProduct_id() {
////            return product_id;
//    }



    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
