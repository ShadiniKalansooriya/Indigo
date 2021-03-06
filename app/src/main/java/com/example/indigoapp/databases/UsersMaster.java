package com.example.indigoapp.databases;

import android.provider.BaseColumns;

public class UsersMaster {

    public UsersMaster() {
    }

    public static class Users implements BaseColumns {
        public static final String TABLE_USER =  "users";
        //
        //Columns of TABLE_USER
        // public static final String COL_USER_USER_ID = "UserID";
        //public static final String COL_USER_USERNAME = "UserName";
        public static final String COL_USER_NAME = "Name";
        public static final String COL_USER_EMAIL="Email";
        public static final String COL_USER_PASSWORD = "UserPassword";
        public static final String COL_USER_MOBILE="Mobile";
        public static final String COL_USER_ADDRESS = "Address";
        public static final String COL_USER_GENDER="Gender";
        public static final String COL_USER_TYPE = "UserType";
        public static final String COL_USER_PROPIC= "propic";
        public static final String COL_USER_CURRENT = "Current";

    }

//    public static class Gallery implements BaseColumns {
//        public static final String GALLERY =  "gallery";
//
//        public static final String COL_USER_EMAIL="email";
//        public static final String COL_USER_HASHTAG = "hashtag";
//        public static final String COL_USER_IMAGE="image";
//
//
//    }

    public static class Gallery implements BaseColumns{
        public static  String GALLERY ="gallery";
        public static final String COLUMN_GALLERY_ID="id";
        public static final String COLUMN_GALLERY_EMAIL = "email";
        public static final String COLUMN_GALLERY_IMAGE = "image";
        public static final String COLUMN_GALLERY_HASHTAG = "hashtag";
//        public static final String COLUMN_GALLERY_CURRENT = "Current";

    }



    public static class Payment implements BaseColumns {
        public static final String TABLE_NAME = "payment";
        public static final String COL_USER_NAME = "Username";
        public static final String COL_USER_EMAIL = "Email";
        public static final String COLUMN_USER_AMOUNT = "Sub total";
        public static final String COL_USER_ADDRESS = "Address";

    }

    public static class UserCart implements BaseColumns{
        public static final String CART_NAME_USER = "user cart";
        public static final String CART_NAME="cart name";
        public static final String COLUMN_NUMBER="cart number";
        public static final String COLUMN_DATE="cart expiry date";

    }

    public static class PriceConform implements BaseColumns{
        public static final String PRICE_CONFORM_USER = "price conform";
        public static final String COLUMN_NAME_ID="id";
        public static final String COLUMN_NAME_PRODUCT_NAME="name";
        public static final String COLUMN_NAME_PRICE="price";
        public static final String COLUMN_NAME_COUNT="count";

    }

//    public static class Products implements BaseColumns{
//        public static String TABLE_NAME="products";
//        public static final String COLUMN_NAME_ID="id";
//        public static final String COLUMN_NAME_TITLE = "title";
//        public static final String COLUMN_NAME_IMAGE = "image";
//        public static final String COLUMN_NAME_PRICE = "price";
//    }

    public static class ProductsItems implements BaseColumns{
        public static String TABLE_NAME="productitems";
        public static final String COLUMN_NAME_ID="id";
        public static final String COLUMN_NAME_PRODUCT_NAME="name";
        public static final String COLUMN_NAME_COUNT="count";
        public static final String COLUMN_NAME_PRICE="price";
        public static final String COLUMN_NAME_DESCRIPTION="description";
        public static final String COLUMN_NAME_PRODUCTIMAGE="image";
        public static final String COLUMN_NAME_FOREIGNKEY="cid";
        public static final String COLUMN_NAME_CATEGORY_NAME="cname";
    }

    public static class Feedback implements BaseColumns{
        public static final String TABLE_NAME = "feedback";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_EMAIL="email";
        public static final String COLUMN_NAME_MESSAGE="message";
        public static final String COLUMN_NAME_Report="report";
    }

    public static class Vouchers implements BaseColumns{
        public static String TABLE_NAME = "vouchers";
        public static final String COLUMN_NAME_ID="id";
        public static final String COLUMN_NAME_COUNT="count";
        public static final String COLUMN_NAME_PRICE="price";
        public static final String COLUMN_NAME_VOUCHERIMAGE="image";
        public static final String COLUMN_NAME_FOREIGNKEY="vid";
    }
}



