package com.example.indigoapp.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.indigoapp.databases.UsersMaster.Users.TABLE_USER;

public class DbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "indigo.db";
    private static final String TAG ="DBHelper" ;


    public static final int SYNC_STATUS_OK = 1;
    public static final int SYNC_STATUS_FAIL = 0;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, 4);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + UsersMaster.Users. TABLE_USER + " (" +
                        UsersMaster.Users._ID+" INTEGER PRIMARY KEY,"+
                        UsersMaster.Users.COL_USER_NAME + " TEXT,"+
                        UsersMaster.Users.COL_USER_EMAIL + " TEXT,"+
                        UsersMaster.Users.COL_USER_PASSWORD + " TEXT,"+
                        UsersMaster.Users.COL_USER_MOBILE + " TEXT,"+
                        UsersMaster.Users.COL_USER_ADDRESS + " TEXT,"+
                        UsersMaster.Users.COL_USER_GENDER + " TEXT,"+
                       UsersMaster.Users.COL_USER_TYPE + " TEXT,"+
                        UsersMaster.Users.COL_USER_CURRENT + " TEXT)";

        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);

    }

    public  void addUser(String userName,String email,String password,String mobile,String address,String gender,String type){

        SQLiteDatabase db = getWritableDatabase();


        ContentValues values = new ContentValues();

        values.put(UsersMaster.Users.COL_USER_NAME,userName);
        values.put(UsersMaster.Users.COL_USER_EMAIL,email);
        values.put(UsersMaster.Users.COL_USER_PASSWORD ,password);
        values.put(UsersMaster.Users.COL_USER_MOBILE,mobile);
        values.put(UsersMaster.Users.COL_USER_ADDRESS,address);
        values.put(UsersMaster.Users.COL_USER_GENDER,gender);
         values.put(UsersMaster.Users.COL_USER_TYPE ,type);
        values.put(UsersMaster.Users.COL_USER_CURRENT,"FALSE");

        long newRowId = db.insert(UsersMaster.Users.TABLE_USER,null,values);



    }

    public String checkUser (String email, String password){
        SQLiteDatabase db = getReadableDatabase();



        Cursor cursor = db.rawQuery("SELECT * from users where Email = ? and UserPassword = ?",new String[]{email,password});

        if (cursor.moveToFirst()) {
            SQLiteDatabase db1 = getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(UsersMaster.Users.COL_USER_CURRENT,"TRUE");
            String selection = UsersMaster.Users.COL_USER_EMAIL+ " LIKE ?";
            String[] selectionArgs = {email};
            db1.update(UsersMaster.Users.TABLE_USER,values,selection,selectionArgs);
           String type = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Users.COL_USER_TYPE));
          return type;
        }
        cursor.close();
        return "";


    }

    public String getUsername() {


        String [] projection = {
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
        String currentUsername ;

        if (cursor.moveToFirst()) {
            do {
                currentUsername = cursor.getString(cursor.getColumnIndex(UsersMaster.Users.COL_USER_NAME));
            } while (cursor.moveToNext());
        }
        else {
            currentUsername = "123";
        }
        cursor.close();
        return currentUsername;
    }


    public String getEmail() {


        String [] projection = {
                UsersMaster.Users.COL_USER_EMAIL
        };
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(UsersMaster.Users.TABLE_USER,
                projection,
                UsersMaster.Users.COL_USER_CURRENT + " LIKE ? ",
                new String []{"TRUE"},
                null, null, null);
//        cursor.moveToFirst();
        String currentUsername ;

     if (cursor.moveToFirst()) {
            do {
                currentUsername = cursor.getString(cursor.getColumnIndex(UsersMaster.Users.COL_USER_EMAIL));
            } while (cursor.moveToNext());
        }
        else {
         currentUsername = "123";

     }
        cursor.close();
        return currentUsername;
    }

    public String getMobile() {


        String [] projection = {
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
        String currentUsername ;

        if (cursor.moveToFirst()) {
            do {
                currentUsername = cursor.getString(cursor.getColumnIndex(UsersMaster.Users.COL_USER_MOBILE));
            } while (cursor.moveToNext());
        }
        else {
            currentUsername = "123";
        }
        cursor.close();
        return currentUsername;
    }




    public String getAddress() {


        String [] projection = {
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
        String currentUsername ;

        if (cursor.moveToFirst()) {
            do {
                currentUsername = cursor.getString(cursor.getColumnIndex(UsersMaster.Users.COL_USER_ADDRESS));
            } while (cursor.moveToNext());
        }
        else {
            currentUsername = "123";
        }
        cursor.close();
        return currentUsername;
    }

    public String getGender() {


        String [] projection = {
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
        String currentUsername ;

        if (cursor.moveToFirst()) {
            do {
                currentUsername = cursor.getString(cursor.getColumnIndex(UsersMaster.Users.COL_USER_GENDER));
            } while (cursor.moveToNext());
        }
        else {
            currentUsername = "123";
        }
        cursor.close();
        return currentUsername;
    }


    public void changeinfo (String Name,String Email, String Mobile,String Address){
        SQLiteDatabase db = getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(UsersMaster.Users.COL_USER_NAME,Name);
        values.put(UsersMaster.Users.COL_USER_EMAIL,Email);
        values.put(UsersMaster.Users.COL_USER_MOBILE,Mobile);
        values.put(UsersMaster.Users.COL_USER_ADDRESS,Address);


        String selection = UsersMaster.Users.COL_USER_CURRENT + " LIKE ?";
        String[] selectionArgs = {"TRUE"};
        db.update(UsersMaster.Users.TABLE_USER,values,selection,selectionArgs);




    }


    public void changepwd (String pwd){
        SQLiteDatabase db = getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(UsersMaster.Users.COL_USER_PASSWORD,pwd);


        String selection = UsersMaster.Users.COL_USER_CURRENT + " LIKE ?";
        String[] selectionArgs = {"TRUE"};
        db.update(UsersMaster.Users.TABLE_USER,values,selection,selectionArgs);




    }


    public void changeuser (){
        SQLiteDatabase db = getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(UsersMaster.Users.COL_USER_CURRENT,"FALSE");


        String selection = UsersMaster.Users.COL_USER_CURRENT + " LIKE ?";
        String[] selectionArgs = {"TRUE"};
        db.update(UsersMaster.Users.TABLE_USER,values,selection,selectionArgs);




    }

    public String getpwd() {


        String [] projection = {
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
        String currentUsername ;

        if (cursor.moveToFirst()) {
            do {
                currentUsername = cursor.getString(cursor.getColumnIndex(UsersMaster.Users.COL_USER_PASSWORD));
            } while (cursor.moveToNext());
        }
        else {
            currentUsername = "123";
        }
        cursor.close();
        return currentUsername;
    }



    public String gettype() {


        String [] projection = {
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
        String currentUsername ;

        if (cursor.moveToFirst()) {
            do {
                currentUsername = cursor.getString(cursor.getColumnIndex(UsersMaster.Users.COL_USER_TYPE));
            } while (cursor.moveToNext());
        }
        else {
            currentUsername = "";
        }
        cursor.close();
        return currentUsername;
    }


    public void deleteAccount (){
        SQLiteDatabase db = getReadableDatabase();


        String selection = UsersMaster.Users.COL_USER_CURRENT + " LIKE ?";
        String[] selectionArgs = {"TRUE"};
        db.delete(UsersMaster.Users.TABLE_USER,selection,selectionArgs);




    }

}
