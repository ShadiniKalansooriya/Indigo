package com.example.indigoapp.databases;

import android.provider.BaseColumns;

public class UsersMaster {

    public UsersMaster() {
    }

    public static class Users implements BaseColumns {
        public static final String TABLE_USER = "users";
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
        public static final String COL_USER_CURRENT = "Current";

    }

    public static class Payment implements BaseColumns {
        public static String TABLE_NAME;
        public static final String COL_USER_NAME = "Name";
        public static final String COL_USER_EMAIL = "Email";
        public static final String COL_USER_ADDRESS = "Address";
        public static final String COLUMN_USER_AMOUNT = "Sub total";
    }
}