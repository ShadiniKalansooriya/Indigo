package com.example.indigoapp.model;

public class Cart {

    private String id;
    private String name;
    private String price;
    //private byte[] image;
    private String count;
    public  String email;



    public Cart(String name,  String price,String product_id) {

        this.name = name;
        this.price = price;
        //this.image = image;
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

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

//    public byte[] getImage() {
//        return image;
//    }
//
//    public void setImage(byte[] image) {
//        this.image = image;
//    }
}
