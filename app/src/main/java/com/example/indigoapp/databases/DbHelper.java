package com.example.indigoapp.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class DbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "indigo.db";

    public static final int SYNC_STATUS_OK = 1;
    public static final int SYNC_STATUS_FAIL = 0;

    //All the Table Names

    @Override
    public void onConfigure(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
    }


    public static final String TABLE_USER = "User";


    //Columns of TABLE_USER
    public static final String COL_USER_USER_ID = "UserID";
    //public static final String COL_USER_USERNAME = "UserName";
    public static final String COL_USER_NAME = "Name";
    public static final String COL_USER_EMAIL = "Email";
    public static final String COL_USER_GENDER = "Gender";
    public static final String COL_USER_ADDRESS = "Address";
    public static final String COL_USER_PASSWORD = "UserPassword";
    public static final String COL_LAST_LOGIN_DATE = "LastLoginDate";
    public static final String COL_USER_TYPE = "UserType";





    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, 4);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql_user = "CREATE TABLE " + TABLE_USER + " ( " +
                COL_USER_USER_ID + " TEXT NOT NULL PRIMARY KEY, " +
                COL_USER_NAME + " TEXT, " +
                COL_USER_EMAIL + " TEXT, " +
                COL_USER_GENDER + " TEXT, " +
                COL_USER_ADDRESS + " TEXT, " +
                COL_USER_PASSWORD + " TEXT, " +
                COL_LAST_LOGIN_DATE + " TEXT, " +
                COL_USER_TYPE + " TEXT );";
        System.out.println("sql_user - " + sql_user);
        db.execSQL(sql_user);





}


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);


    }

    public boolean insertDataAll(ContentValues cv, String tableName) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.insert(tableName, null, cv);

        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }


}
