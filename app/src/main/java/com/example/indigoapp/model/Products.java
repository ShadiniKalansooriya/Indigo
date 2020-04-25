package com.example.indigoapp.model;

public class Products {

    private String product_id;
    private String product_name;
    private String product_desc;
    private String product_price;
    //private Bitmap bitmap;
    private String count;
    private String catName;

    public Products(String product_id, String product_name, String product_desc, String product_price, String count, String catName) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.count = count;
        this.product_desc = product_desc;
        this.product_price = product_price;
        //this.bitmap = bitmap;
        this.catName = catName;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_desc() {
        return product_desc;
    }

    public void setProduct_desc(String product_desc) {
        this.product_desc = product_desc;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

//    public Bitmap getBitmap() {
//
//        return bitmap;
//    }
//
//    public void setBitmap(Bitmap bitmap) {
//
//        this.bitmap = bitmap;
//    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
