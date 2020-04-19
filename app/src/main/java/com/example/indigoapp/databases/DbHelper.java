package com.example.indigoapp.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.ByteArrayOutputStream;

import static com.example.indigoapp.databases.UsersMaster.Users.TABLE_USER;

public class DbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "indigo.db";
    private static final String TAG = "DBHelper";


    public static final int SYNC_STATUS_OK = 1;
    public static final int SYNC_STATUS_FAIL = 0;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, 4);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + UsersMaster.Users.TABLE_USER + " (" +
                        UsersMaster.Users._ID + " INTEGER PRIMARY KEY," +
                        UsersMaster.Users.COL_USER_NAME + " TEXT," +
                        UsersMaster.Users.COL_USER_EMAIL + " TEXT," +
                        UsersMaster.Users.COL_USER_PASSWORD + " TEXT," +
                        UsersMaster.Users.COL_USER_MOBILE + " TEXT," +
                        UsersMaster.Users.COL_USER_ADDRESS + " TEXT," +
                        UsersMaster.Users.COL_USER_GENDER + " TEXT," +
                        UsersMaster.Users.COL_USER_TYPE + " TEXT," +
                        UsersMaster.Users.COL_USER_CURRENT + " TEXT)";


        String PAYMENT_DETAILS_ENTRIES = "CREATE TABLE " + UsersMaster.Payment.TABLE_NAME + "(" +
                UsersMaster.Payment.COL_USER_NAME + " TEXT," +
                UsersMaster.Payment.COL_USER_EMAIL + " TEXT," +
                UsersMaster.Payment.COLUMN_USER_AMOUNT + " TEXT," +
                UsersMaster.Payment.COL_USER_ADDRESS + " TEXT," +

                " FOREIGN KEY (" + UsersMaster.Payment.COL_USER_NAME + ") REFERENCES " + UsersMaster.Payment.TABLE_NAME +
                " ON DELETE CASCADE ON UPDATE CASCADE, )";


        String CUSTOMER_CART_CREATES_ENTRIES = "CREATE TABLE " + UsersMaster.UserCart.CART_NAME_USER + "(" +
                UsersMaster.UserCart.CART_NAME +" TEXT,"+
                UsersMaster.UserCart.COLUMN_NUMBER +" TEXT,"+
                UsersMaster.UserCart.COLUMN_DATE +" TEXT,"+

                " FOREIGN KEY (" + UsersMaster.UserCart.COLUMN_NUMBER + ") REFERENCES " + UsersMaster.UserCart.CART_NAME_USER +
                " ON DELETE CASCADE ON UPDATE CASCADE, )";



        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
        sqLiteDatabase.execSQL(PAYMENT_DETAILS_ENTRIES);
        sqLiteDatabase.execSQL(CUSTOMER_CART_CREATES_ENTRIES);

        String SQL_CREATE_FEED_ENTRIES =
                "CREATE TABLE " +   UsersMaster.Feedback.TABLE_NAME + " ("+
                        "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                        UsersMaster.Feedback.COLUMN_NAME_NAME + " TEXT,"+
                        UsersMaster.Feedback.COLUMN_NAME_EMAIL + " TEXT," +
                        UsersMaster.Feedback.COLUMN_NAME_Report + " TEXT," +
                        UsersMaster.Feedback.COLUMN_NAME_MESSAGE + " TEXT)";

        sqLiteDatabase.execSQL(SQL_CREATE_FEED_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + UsersMaster.Payment.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+UsersMaster.UserCart.CART_NAME_USER);

        onCreate(db);

    }

    public void addUser(String userName, String email, String password, String mobile, String address, String gender, String type) {

        SQLiteDatabase db = getWritableDatabase();


        ContentValues values = new ContentValues();

        values.put(UsersMaster.Users.COL_USER_NAME, userName);
        values.put(UsersMaster.Users.COL_USER_EMAIL, email);
        values.put(UsersMaster.Users.COL_USER_PASSWORD, password);
        values.put(UsersMaster.Users.COL_USER_MOBILE, mobile);
        values.put(UsersMaster.Users.COL_USER_ADDRESS, address);
        values.put(UsersMaster.Users.COL_USER_GENDER, gender);
        values.put(UsersMaster.Users.COL_USER_TYPE, type);
        values.put(UsersMaster.Users.COL_USER_CURRENT, "FALSE");

        long newRowId = db.insert(UsersMaster.Users.TABLE_USER, null, values);


    }

    public void Customer_insert_payment_details(payments pay) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(UsersMaster.Payment.COL_USER_NAME, pay.getUsername());
        values.put(UsersMaster.Payment.COL_USER_EMAIL, pay.getemail());
        values.put(UsersMaster.Payment.COLUMN_USER_AMOUNT, pay.getTotal());

        long newRowId = db.insert(UsersMaster.Payment.TABLE_NAME, null, values);

    }

    public void User_insert_cart_details(Cart cart){
        SQLiteDatabase db=getWritableDatabase();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        ContentValues values=new ContentValues();
        values.put( UsersMaster.UserCart.CART_NAME,cart.Name());
//        values.put(UsersMaster.UserCart.COLUMN_NUMBER,cart.Numb);
//        values.put(UsersMaster.UserCart.COLUMN_DATE,cart.Date);
        long newRowId =db.insert(UsersMaster.UserCart.CART_NAME_USER,null,values);

    }




    public String checkUser(String email, String password) {
        SQLiteDatabase db = getReadableDatabase();


        Cursor cursor = db.rawQuery("SELECT * from users where Email = ? and UserPassword = ?", new String[]{email, password});

        if (cursor.moveToFirst()) {
            SQLiteDatabase db1 = getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(UsersMaster.Users.COL_USER_CURRENT, "TRUE");
            String selection = UsersMaster.Users.COL_USER_EMAIL + " LIKE ?";
            String[] selectionArgs = {email};
            db1.update(UsersMaster.Users.TABLE_USER, values, selection, selectionArgs);
            String type = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Users.COL_USER_TYPE));
            return type;
        }
        cursor.close();
        return "";


    }

    public String getUsername() {


        String[] projection = {
                UsersMaster.Users.COL_USER_NAME
        };
        SQLiteDatabase db = getWritableDatabase();


        String selection = UsersMaster.Users.COL_USER_CURRENT + " LIKE ?";
        String[] selectionArgs = {"TRUE"};


        Cursor cursor = db.query(UsersMaster.Users.TABLE_USER,
                projection,
                selection,
                selectionArgs,
                null, null, null);
        String currentUsername;

        if (cursor.moveToFirst()) {
            do {
                currentUsername = cursor.getString(cursor.getColumnIndex(UsersMaster.Users.COL_USER_NAME));
            } while (cursor.moveToNext());
        } else {
            currentUsername = "123";
        }
        cursor.close();
        return currentUsername;
    }


    public String getEmail() {


        String[] projection = {
                UsersMaster.Users.COL_USER_EMAIL
        };
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(UsersMaster.Users.TABLE_USER,
                projection,
                UsersMaster.Users.COL_USER_CURRENT + " LIKE ? ",
                new String[]{"TRUE"},
                null, null, null);
//        cursor.moveToFirst();
        String currentUsername;

        if (cursor.moveToFirst()) {
            do {
                currentUsername = cursor.getString(cursor.getColumnIndex(UsersMaster.Users.COL_USER_EMAIL));
            } while (cursor.moveToNext());
        } else {
            currentUsername = "123";

        }
        cursor.close();
        return currentUsername;
    }

    public String getMobile() {


        String[] projection = {
                UsersMaster.Users.COL_USER_MOBILE
        };
        SQLiteDatabase db = getWritableDatabase();


        String selection = UsersMaster.Users.COL_USER_CURRENT + " LIKE ?";
        String[] selectionArgs = {"TRUE"};


        Cursor cursor = db.query(UsersMaster.Users.TABLE_USER,
                projection,
                selection,
                selectionArgs,
                null, null, null);
        String currentUsername;

        if (cursor.moveToFirst()) {
            do {
                currentUsername = cursor.getString(cursor.getColumnIndex(UsersMaster.Users.COL_USER_MOBILE));
            } while (cursor.moveToNext());
        } else {
            currentUsername = "123";
        }
        cursor.close();
        return currentUsername;
    }


    public String getAddress() {


        String[] projection = {
                UsersMaster.Users.COL_USER_ADDRESS
        };
        SQLiteDatabase db = getWritableDatabase();


        String selection = UsersMaster.Users.COL_USER_CURRENT + " LIKE ?";
        String[] selectionArgs = {"TRUE"};


        Cursor cursor = db.query(UsersMaster.Users.TABLE_USER,
                projection,
                selection,
                selectionArgs,
                null, null, null);
        String currentUsername;

        if (cursor.moveToFirst()) {
            do {
                currentUsername = cursor.getString(cursor.getColumnIndex(UsersMaster.Users.COL_USER_ADDRESS));
            } while (cursor.moveToNext());
        } else {
            currentUsername = "123";
        }
        cursor.close();
        return currentUsername;
    }

    public String getGender() {


        String[] projection = {
                UsersMaster.Users.COL_USER_GENDER
        };
        SQLiteDatabase db = getWritableDatabase();


        String selection = UsersMaster.Users.COL_USER_CURRENT + " LIKE ?";
        String[] selectionArgs = {"TRUE"};


        Cursor cursor = db.query(UsersMaster.Users.TABLE_USER,
                projection,
                selection,
                selectionArgs,
                null, null, null);
        String currentUsername;

        if (cursor.moveToFirst()) {
            do {
                currentUsername = cursor.getString(cursor.getColumnIndex(UsersMaster.Users.COL_USER_GENDER));
            } while (cursor.moveToNext());
        } else {
            currentUsername = "123";
        }
        cursor.close();
        return currentUsername;
    }


    public void changeinfo(String Name, String Email, String Mobile, String Address) {
        SQLiteDatabase db = getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(UsersMaster.Users.COL_USER_NAME, Name);
        values.put(UsersMaster.Users.COL_USER_EMAIL, Email);
        values.put(UsersMaster.Users.COL_USER_MOBILE, Mobile);
        values.put(UsersMaster.Users.COL_USER_ADDRESS, Address);


        String selection = UsersMaster.Users.COL_USER_CURRENT + " LIKE ?";
        String[] selectionArgs = {"TRUE"};
        db.update(UsersMaster.Users.TABLE_USER, values, selection, selectionArgs);


    }


    public void changepwd(String pwd) {
        SQLiteDatabase db = getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(UsersMaster.Users.COL_USER_PASSWORD, pwd);


        String selection = UsersMaster.Users.COL_USER_CURRENT + " LIKE ?";
        String[] selectionArgs = {"TRUE"};
        db.update(UsersMaster.Users.TABLE_USER, values, selection, selectionArgs);


    }


    public void changeuser() {
        SQLiteDatabase db = getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(UsersMaster.Users.COL_USER_CURRENT, "FALSE");


        String selection = UsersMaster.Users.COL_USER_CURRENT + " LIKE ?";
        String[] selectionArgs = {"TRUE"};
        db.update(UsersMaster.Users.TABLE_USER, values, selection, selectionArgs);


    }

    public String getpwd() {


        String[] projection = {
                UsersMaster.Users.COL_USER_PASSWORD
        };
        SQLiteDatabase db = getWritableDatabase();


        String selection = UsersMaster.Users.COL_USER_CURRENT + " LIKE ?";
        String[] selectionArgs = {"TRUE"};


        Cursor cursor = db.query(UsersMaster.Users.TABLE_USER,
                projection,
                selection,
                selectionArgs,
                null, null, null);
        String currentUsername;

        if (cursor.moveToFirst()) {
            do {
                currentUsername = cursor.getString(cursor.getColumnIndex(UsersMaster.Users.COL_USER_PASSWORD));
            } while (cursor.moveToNext());
        } else {
            currentUsername = "123";
        }
        cursor.close();
        return currentUsername;
    }


    public String gettype() {


        String[] projection = {
                UsersMaster.Users.COL_USER_TYPE
        };
        SQLiteDatabase db = getWritableDatabase();


        String selection = UsersMaster.Users.COL_USER_CURRENT + " LIKE ?";
        String[] selectionArgs = {"TRUE"};


        Cursor cursor = db.query(UsersMaster.Users.TABLE_USER,
                projection,
                selection,
                selectionArgs,
                null, null, null);
        String currentUsername;

        if (cursor.moveToFirst()) {
            do {
                currentUsername = cursor.getString(cursor.getColumnIndex(UsersMaster.Users.COL_USER_TYPE));
            } while (cursor.moveToNext());
        } else {
            currentUsername = "";
        }
        cursor.close();
        return currentUsername;
    }


    public void deleteAccount() {
        SQLiteDatabase db = getReadableDatabase();


        String selection = UsersMaster.Users.COL_USER_CURRENT + " LIKE ?";
        String[] selectionArgs = {"TRUE"};
        db.delete(UsersMaster.Users.TABLE_USER, selection, selectionArgs);


    }

    private class payments {

        public String getUsername() {
            String[] projection = {
                    UsersMaster.Payment.COL_USER_NAME
            };
            SQLiteDatabase db = getWritableDatabase();


            String selection = UsersMaster.Users.COL_USER_CURRENT + " LIKE ?";
            String[] selectionArgs = {"TRUE"};


            Cursor cursor = db.query(UsersMaster.Users.TABLE_USER,
                    projection,
                    selection,
                    selectionArgs,
                    null, null, null);
            String currentUsername;

            if (cursor.moveToFirst()) {
                do {
                    currentUsername = cursor.getString(cursor.getColumnIndex(UsersMaster.Payment.COL_USER_NAME));
                } while (cursor.moveToNext());
            } else {
                currentUsername = "321";
            }
            cursor.close();
            return currentUsername;
        }

        public String getemail() {


            String[] projection = {
                    UsersMaster.Payment.COL_USER_EMAIL
            };
            SQLiteDatabase db = getWritableDatabase();
            Cursor cursor = db.query(UsersMaster.Users.TABLE_USER,
                    projection,
                    UsersMaster.Users.COL_USER_CURRENT + " LIKE ? ",
                    new String[]{"TRUE"},
                    null, null, null);

            String currentUsername;

            if (cursor.moveToFirst()) {
                do {
                    currentUsername = cursor.getString(cursor.getColumnIndex(UsersMaster.Payment.COL_USER_EMAIL));
                } while (cursor.moveToNext());
            } else {
                currentUsername = "321";

            }
            cursor.close();
            return currentUsername;
        }
        public String getTotal() {
            String[] projection = {
                    UsersMaster.Payment.COLUMN_USER_AMOUNT
            };
            SQLiteDatabase db = getWritableDatabase();


            String selection = UsersMaster.Users.COL_USER_CURRENT + " LIKE ?";
            String[] selectionArgs = {"TRUE"};


            Cursor cursor = db.query(UsersMaster.Users.TABLE_USER,
                    projection,
                    selection,
                    selectionArgs,
                    null, null, null);
            String currentUsername;

            if (cursor.moveToFirst()) {
                do {
                    currentUsername = cursor.getString(cursor.getColumnIndex(UsersMaster.Payment.COLUMN_USER_AMOUNT));
                } while (cursor.moveToNext());
            } else {
                currentUsername = "321";
            }
            cursor.close();
            return currentUsername;
        }
    }

    private class Cart {

        public String Name() {
            String[] projection = {
                    UsersMaster.UserCart.CART_NAME
            };
            SQLiteDatabase db = getWritableDatabase();


            String selection = UsersMaster.Users.COL_USER_CURRENT + " LIKE ?";
            String[] selectionArgs = {"TRUE"};


            Cursor cursor = db.query(UsersMaster.Users.TABLE_USER,
                    projection,
                    selection,
                    selectionArgs,
                    null, null, null);
            String currentUsername;

            if (cursor.moveToFirst()) {
                do {
                    currentUsername = cursor.getString(cursor.getColumnIndex(UsersMaster.UserCart.CART_NAME));
                } while (cursor.moveToNext());
            } else {
                currentUsername = "321";
            }
            cursor.close();
            return currentUsername;
        }


    }
    public  void addfeed(String name,String email,String message,String report){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(UsersMaster.Feedback.COLUMN_NAME_NAME,name);
        values.put(UsersMaster.Feedback.COLUMN_NAME_EMAIL,email);
        values.put(UsersMaster.Feedback.COLUMN_NAME_Report,report);
        values.put(UsersMaster.Feedback.COLUMN_NAME_MESSAGE,message);

        long newRowId = db.insert(UsersMaster.Feedback.TABLE_NAME,null,values);

    }

}

