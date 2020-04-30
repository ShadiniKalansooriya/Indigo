package com.example.indigoapp.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.EditText;

import com.example.indigoapp.model.Products;
import com.example.indigoapp.model.Vouchers;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

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
                        UsersMaster.Users.COL_USER_PROPIC + " LONGBLOB," +
                        UsersMaster.Users.COL_USER_CURRENT + " TEXT)";


        System.out.println("User table"+SQL_CREATE_ENTRIES);

        String sql = "CREATE TABLE " + UsersMaster.Gallery.GALLERY + " (" +
                UsersMaster.Gallery.COLUMN_GALLERY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                UsersMaster.Gallery.COLUMN_GALLERY_EMAIL + " TEXT," +
                UsersMaster.Gallery.COLUMN_GALLERY_HASHTAG + " TEXT," +
                UsersMaster.Gallery.COLUMN_GALLERY_IMAGE + " LONGBLOB)";
//                        UsersMaster.Gallery.COLUMN_GALLERY_CURRENT + " TEXT)";
//                " FOREIGN KEY (" + UsersMaster.Gallery.COLUMN_GALLERY_EMAIL + ") REFERENCES " + UsersMaster.Users.TABLE_USER +"("+ UsersMaster.Users.COL_USER_EMAIL+"));";


        System.out.println("Gallery Table" +sql);

//        String SQL_CREATE_GALLERY =
//                "CREATE TABLE "+ UsersMaster.Gallery.GALLERY + "(" +
//                UsersMaster.Gallery._ID + " INTEGER PRIMARY KEY," +
//                UsersMaster.Gallery.COL_USER_EMAIL +" TEXT,", price VARCHAR, image BLOB


        String PAYMENT_DETAILS_ENTRIES ="CREATE TABLE"+ UsersMaster.Payment.TABLE_NAME +"(" +
                UsersMaster.Payment.COL_USER_NAME + "TEXT," +
                UsersMaster.Payment.COL_USER_EMAIL + "TEXT," +
                UsersMaster.Payment.COLUMN_USER_AMOUNT + "TEXT," +
                UsersMaster.Payment.COL_USER_ADDRESS  + "TEXT)" ;


        String  CUSTOMER_CART_CREATES_ENTRIES ="CREATE TABLE"+ UsersMaster.UserCart.CART_NAME_USER + "(" +
                UsersMaster.UserCart.CART_NAME +" TEXT, "+
                UsersMaster.UserCart.COLUMN_NUMBER +" TEXT,"+
                UsersMaster.UserCart.COLUMN_DATE +" TEXT)";


        String  CUSTOMER_PRICE_CONFORM ="CREATE TABLE"+ UsersMaster.PriceConform.PRICE_CONFORM_USER + "(" +
                UsersMaster.PriceConform.COLUMN_NAME_ID +" NTEGER PRIMARY KEY AUTOINCREMENT,, "+
                UsersMaster.PriceConform.COLUMN_NAME_PRODUCT_NAME +" TEXT,"+
                UsersMaster.PriceConform.COLUMN_NAME_PRICE +" TEXT,"+
                UsersMaster.PriceConform.COLUMN_NAME_COUNT +" TEXT,"+")";
//                UsersMaster.PriceConform.COLUMN_NAME_IMAGE + "LONGBLOB,"+")";


        String ADMIN_PRODUCT_DETAILS_ENTRIES="CREATE TABLE "+ UsersMaster.ProductsItems.TABLE_NAME +"("+
                UsersMaster.ProductsItems.COLUMN_NAME_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                UsersMaster.ProductsItems.COLUMN_NAME_PRODUCT_NAME + " TEXT,"+
                UsersMaster.ProductsItems.COLUMN_NAME_COUNT +" INTEGER,"+
                UsersMaster.ProductsItems.COLUMN_NAME_DESCRIPTION +" TEXT,"+
                UsersMaster.ProductsItems.COLUMN_NAME_PRICE + " TEXT,"+
                //UsersMaster.ProductsItems.COLUMN_NAME_PRODUCTIMAGE + " LONGBLOB,"+
                UsersMaster.ProductsItems.COLUMN_NAME_CATEGORY_NAME +" TEXT," +
                UsersMaster.ProductsItems.COLUMN_NAME_FOREIGNKEY+" INTEGER,CONSTRAINT fk_pro_cat FOREIGN KEY ("+
                UsersMaster.ProductsItems.COLUMN_NAME_FOREIGNKEY + ") REFERENCES "+ UsersMaster.ProductsItems.TABLE_NAME+"("+
                UsersMaster.ProductsItems.COLUMN_NAME_ID +") ON DELETE CASCADE ON UPDATE CASCADE)";

        String ADMIN_VOUCHER_DETAILS_ENTRIES="CREATE TABLE "+ UsersMaster.Vouchers.TABLE_NAME +"("+
                UsersMaster.Vouchers.COLUMN_NAME_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                UsersMaster.Vouchers.COLUMN_NAME_COUNT +" INTEGER,"+
                UsersMaster.Vouchers.COLUMN_NAME_PRICE + " TEXT,"+
                UsersMaster.Vouchers.COLUMN_NAME_VOUCHERIMAGE + " LONGBLOB,"+
                UsersMaster.Vouchers.COLUMN_NAME_FOREIGNKEY+" INTEGER,CONSTRAINT fk_vou_cat FOREIGN KEY ("+
                UsersMaster.Vouchers.COLUMN_NAME_FOREIGNKEY + ") REFERENCES "+ UsersMaster.Vouchers.TABLE_NAME+"("+
                UsersMaster.Vouchers.COLUMN_NAME_ID +") ON DELETE CASCADE ON UPDATE CASCADE)";

        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
        sqLiteDatabase.execSQL(PAYMENT_DETAILS_ENTRIES);
        sqLiteDatabase.execSQL(CUSTOMER_CART_CREATES_ENTRIES);
        sqLiteDatabase.execSQL(CUSTOMER_PRICE_CONFORM);
        sqLiteDatabase.execSQL(ADMIN_PRODUCT_DETAILS_ENTRIES);
        sqLiteDatabase.execSQL(ADMIN_VOUCHER_DETAILS_ENTRIES);
        sqLiteDatabase.execSQL(sql);



        String SQL_CREATE_FEED_ENTRIES =
                "CREATE TABLE " +   UsersMaster.Feedback.TABLE_NAME + " ("+
                        "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                        UsersMaster.Feedback.COLUMN_NAME_NAME + " TEXT,"+
                        UsersMaster.Feedback.COLUMN_NAME_EMAIL + " TEXT," +
                        UsersMaster.Feedback.COLUMN_NAME_Report + " TEXT," +
                        UsersMaster.Feedback.COLUMN_NAME_MESSAGE + " TEXT)";

        sqLiteDatabase.execSQL(SQL_CREATE_FEED_ENTRIES);

    }

    //Gallery
    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + UsersMaster.Payment.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ UsersMaster.UserCart.CART_NAME_USER);
        db.execSQL("DROP TABLE IF EXISTS "+ UsersMaster.PriceConform.PRICE_CONFORM_USER);
        db.execSQL("DROP TABLE IF EXISTS "+ UsersMaster.ProductsItems.TABLE_NAME);
        //db.execSQL("DROP TABLE IF EXISTS "+ UsersMaster.Products.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ UsersMaster.Vouchers.TABLE_NAME);


        onCreate(db);
    }

    public void addUser(String userName, String email, String password, String mobile, String address, String gender, String type, byte[]propic) {

        SQLiteDatabase db = getWritableDatabase();


        ContentValues values = new ContentValues();

        values.put(UsersMaster.Users.COL_USER_NAME, userName);
        values.put(UsersMaster.Users.COL_USER_EMAIL, email);
        values.put(UsersMaster.Users.COL_USER_PASSWORD, password);
        values.put(UsersMaster.Users.COL_USER_MOBILE, mobile);
        values.put(UsersMaster.Users.COL_USER_ADDRESS, address);
        values.put(UsersMaster.Users.COL_USER_GENDER, gender);
        values.put(UsersMaster.Users.COL_USER_TYPE, type);
        values.put(UsersMaster.Users.COL_USER_PROPIC,propic);
        values.put(UsersMaster.Users.COL_USER_CURRENT, "FALSE");

        long newRowId = db.insert(UsersMaster.Users.TABLE_USER, null, values);


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




    public void Customer_insert_payment_details(String username, String email, String total, String Address) {
        SQLiteDatabase db = getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(UsersMaster.Payment.COL_USER_NAME,username);
        values.put(UsersMaster.Payment.COL_USER_EMAIL, email);
        values.put(UsersMaster.Payment.COLUMN_USER_AMOUNT, total);
        values.put(UsersMaster.Payment.COL_USER_ADDRESS, Address);
        long newRowId = db.insert(UsersMaster.Payment.TABLE_NAME, null, values);
    }

    public String getName() {
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

    public String editTextEmail() {


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
    public String sub() {
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


    public void User_insert_cart_details(String Name, String Numb, String Date){
        SQLiteDatabase db=getWritableDatabase();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        ContentValues values=new ContentValues();
        values.put( UsersMaster.UserCart.CART_NAME,Name);
        values.put(UsersMaster.UserCart.COLUMN_NUMBER,Numb);
        values.put(UsersMaster.UserCart.COLUMN_DATE,Date);
        long newRowId =db.insert(UsersMaster.UserCart.CART_NAME_USER,null,values);

    }

    public boolean delete_cart_details(EditText cardNo){
        try{
            SQLiteDatabase db=getReadableDatabase();
            String selection=UsersMaster.UserCart.CART_NAME_USER + " = ?";
            String[] selectionArgs = {String.valueOf(cardNo)};
            int rowsAffected=db.delete(UsersMaster.UserCart.CART_NAME,selection,selectionArgs);
            return rowsAffected > 0;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean Crate_cart_info(String name, String numb, String date) {
        try {
            SQLiteDatabase db = getReadableDatabase();
            ContentValues values = new ContentValues();
            values.put(UsersMaster.UserCart.CART_NAME, name);
            values.put(UsersMaster.UserCart.COLUMN_NUMBER, numb);
            values.put(UsersMaster.UserCart.COLUMN_DATE, date);

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return false;
    }

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

    public void User_insert_price_details(String name, String price) {
        SQLiteDatabase db=getWritableDatabase();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        ContentValues values=new ContentValues();
//        values.put( UsersMaster.PriceConform.COLUMN_NAME_ID,id);
        values.put( UsersMaster.PriceConform.COLUMN_NAME_PRODUCT_NAME,name);
        values.put(UsersMaster.PriceConform.COLUMN_NAME_PRICE,price);

        long newRowId =db.insert(UsersMaster.PriceConform.PRICE_CONFORM_USER,null,values);
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




    public String getname() {
        String[] projection = {
                UsersMaster.Feedback.COLUMN_NAME_NAME
        };
        SQLiteDatabase db = getWritableDatabase();


        String selection = UsersMaster.Feedback.COLUMN_NAME_NAME + " LIKE ?";
        String[] selectionArgs = {"TRUE"};


        Cursor cursor = db.query( UsersMaster.Feedback.TABLE_NAME ,
                projection,
                selection,
                selectionArgs,
                null, null, null);
        String currentUsername;

        if (cursor.moveToFirst()) {
            do {
                currentUsername = cursor.getString(cursor.getColumnIndex(UsersMaster.Feedback.COLUMN_NAME_NAME));
            } while (cursor.moveToNext());
        } else {
            currentUsername = "Thanuri";
        }
        cursor.close();
        return currentUsername;
    }

    public String getemail11() {
        String[] projection = {
                UsersMaster.Feedback.COLUMN_NAME_EMAIL
        };
        SQLiteDatabase db = getWritableDatabase();


        String selection = UsersMaster.Feedback.COLUMN_NAME_EMAIL + " LIKE ?";
        String[] selectionArgs = {"TRUE"};


        Cursor cursor = db.query( UsersMaster.Feedback.TABLE_NAME ,
                projection,
                selection,
                selectionArgs,
                null, null, null);
        String currentUsername;

        if (cursor.moveToFirst()) {
            do {
                currentUsername = cursor.getString(cursor.getColumnIndex(UsersMaster.Feedback.COLUMN_NAME_EMAIL));
            } while (cursor.moveToNext());
        } else {
            currentUsername = "Thanuri@gmail.com";
        }
        cursor.close();
        return currentUsername;
    }

    public String getreport() {
        String[] projection = {
                UsersMaster.Feedback.COLUMN_NAME_Report
        };
        SQLiteDatabase db = getWritableDatabase();


        String selection = UsersMaster.Feedback.COLUMN_NAME_Report + " LIKE ?";
        String[] selectionArgs = {"TRUE"};


        Cursor cursor = db.query( UsersMaster.Feedback.TABLE_NAME ,
                projection,
                selection,
                selectionArgs,
                null, null, null);
        String currentUsername;

        if (cursor.moveToFirst()) {
            do {
                currentUsername = cursor.getString(cursor.getColumnIndex(UsersMaster.Feedback.COLUMN_NAME_Report));
            } while (cursor.moveToNext());
        } else {
            currentUsername = "123";
        }
        cursor.close();
        return currentUsername;
    }



    public String getmessage() {
        String[] projection = {
                UsersMaster.Feedback.COLUMN_NAME_MESSAGE
        };
        SQLiteDatabase db = getWritableDatabase();


        String selection = UsersMaster.Feedback.COLUMN_NAME_MESSAGE + " LIKE ?";
        String[] selectionArgs = {"TRUE"};


        Cursor cursor = db.query( UsersMaster.Feedback.TABLE_NAME ,
                projection,
                selection,
                selectionArgs,
                null, null, null);
        String currentUsername;

        if (cursor.moveToFirst()) {
            do {
                currentUsername = cursor.getString(cursor.getColumnIndex(UsersMaster.Feedback.COLUMN_NAME_MESSAGE));
            } while (cursor.moveToNext());
        } else {
            currentUsername = "123";
        }
        cursor.close();
        return currentUsername;
    }




    //Retrieve selected item data from database
    public ArrayList<Products> Retrive_selected_product_details(String category){
        ArrayList<Products> list=new ArrayList<>();
        SQLiteDatabase db=getReadableDatabase();

        String sql="SELECT * FROM "+ UsersMaster.ProductsItems.TABLE_NAME+ " WHERE "+  UsersMaster.ProductsItems.COLUMN_NAME_CATEGORY_NAME + " LIKE '"+ category +"'";

        Cursor cu=db.rawQuery(sql,null);
        //byte[] image;
        String name;
        String desc;
        String count;
        String price;
        String id;
        String cna;
        String cid;

        while(cu.moveToNext()){
            id=cu.getString(0);
            name=cu.getString(1);
            count=cu.getString(2);
            desc=cu.getString(3);
            price=cu.getString(4);
            //image=cu.getBlob(5);
            cna = cu.getString(6);
            //cid=cu.getString(7);
            //Bitmap bitmap;

            //bitmap= BitmapFactory.decodeByteArray(image,0,image.length);

            Products products=new Products(id,name,desc,price,count,cna);
            list.add(products);
        }
        cu.close();

        return list;
    }

    //Retrieve all item data from database
    public ArrayList<Products> Retrive_admin_product_details(){
        ArrayList<Products> list=new ArrayList<>();
        SQLiteDatabase db=getReadableDatabase();

        String sql="SELECT * FROM "+ UsersMaster.ProductsItems.TABLE_NAME;

        Cursor cu=db.rawQuery(sql,null);
        //byte[] image;
        String name;
        String desc;
        String count;
        String price;
        String id;
        String cna;
        String cid;

        while(cu.moveToNext()){
            id=cu.getString(0);
            name=cu.getString(1);
            count=cu.getString(2);
            desc=cu.getString(3);
            price=cu.getString(4);
            //image=cu.getBlob(5);
            cna = cu.getString(5);
            //cid=cu.getString(7);
            Bitmap bitmap;

            //bitmap= BitmapFactory.decodeByteArray(image,0,image.length);

            Products products=new Products(id,name,desc,price,count,cna);
            list.add(products);
        }
        cu.close();

        return list;
    }

    //Search item
    public ArrayList<Products> Retrive_admin_search_product_details(String pname){
        ArrayList<Products> list=new ArrayList<>();
        SQLiteDatabase db=getReadableDatabase();

        String sql="SELECT * FROM "+ UsersMaster.ProductsItems.TABLE_NAME + " WHERE "+ UsersMaster.ProductsItems.COLUMN_NAME_PRODUCT_NAME
                +" LIKE ? OR " +UsersMaster.ProductsItems.COLUMN_NAME_CATEGORY_NAME + " LIKE ?" ;
        String []selectionArgs={"%" + pname + "%",pname +"%"};

        Cursor cu=db.rawQuery(sql,selectionArgs);
        //byte[] image;
        String name;
        String desc;
        String count;
        String price;
        String cna;
        String id;
        String fid;


        while(cu.moveToNext()){
            id=cu.getString(0);
            name=cu.getString(1);
            desc=cu.getString(3);
            count=cu.getString(2);
            price=cu.getString(4);
            //image=cu.getBlob(5);
            cna=cu.getString(5);
            fid=cu.getString(6);
            Bitmap bitmap;

            //bitmap= BitmapFactory.decodeByteArray(image,0,image.length);

            Products product =new Products(id,name,desc,price,count,cna);
            list.add(product);
        }
        cu.close();

        return list;
    }

    //Delete a product item
    public boolean Admin_delete_current_product(String id){
        try{
            SQLiteDatabase db=getReadableDatabase();
            String selection=UsersMaster.ProductsItems.COLUMN_NAME_ID + " = ?";
            String[] selectionArgs = {id};
            int rowsAffected=db.delete(UsersMaster.ProductsItems.TABLE_NAME,selection,selectionArgs);
            return rowsAffected > 0;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    //Update Product Item
    public boolean Admin_update_product_info(String id,String name,String des,String price,String count, String cname){
        try {
            SQLiteDatabase db = getReadableDatabase();
            ContentValues values = new ContentValues();
            values.put(UsersMaster.ProductsItems.COLUMN_NAME_PRODUCT_NAME, name);
            values.put(UsersMaster.ProductsItems.COLUMN_NAME_COUNT, count);
            values.put(UsersMaster.ProductsItems.COLUMN_NAME_DESCRIPTION, des);
            values.put(UsersMaster.ProductsItems.COLUMN_NAME_PRICE, price);
            //values.put(UsersMaster.ProductsItems.COLUMN_NAME_PRODUCTIMAGE, image);
            values.put(UsersMaster.ProductsItems.COLUMN_NAME_CATEGORY_NAME, cname);
            String selection = UsersMaster.ProductsItems.COLUMN_NAME_ID + " = ?";
            String[] selectionArgs = {id};

            int counts = db.update(UsersMaster.ProductsItems.TABLE_NAME, values, selection, selectionArgs);
            return counts > 0;
        }
        catch (SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }

    //Retrieve all voucher data from database
    public ArrayList<Vouchers> Retrive_admin_voucher_details(){
        ArrayList<Vouchers> list=new ArrayList<>();
        SQLiteDatabase db=getReadableDatabase();


        String sql="SELECT * FROM "+ UsersMaster.Vouchers.TABLE_NAME;

        Cursor cu=db.rawQuery(sql,null);
        //byte[] image;

        String count;
        String price;
        String id;
//        String cna;
//        String cid;

        while(cu.moveToNext()){
            id=cu.getString(0);
            count=cu.getString(1);
            price=cu.getString(2);
            //cna = cu.getString(6);
            //cid=cu.getString(7);
            //Bitmap bitmap;

            Vouchers voucher=new Vouchers(id,price,count);
            list.add(voucher);
        }
        cu.close();

        return list;
    }

    //Search Voucher
    public ArrayList<Vouchers> Retrive_admin_search_voucher_details(String pname){
        ArrayList<Vouchers> list=new ArrayList<>();
        SQLiteDatabase db=getReadableDatabase();

        String sql="SELECT * FROM "+ UsersMaster.Vouchers.TABLE_NAME + " WHERE "+ UsersMaster.Vouchers.COLUMN_NAME_PRICE
                +" LIKE ?";
        String []selectionArgs={pname +"%"};

        Cursor cu=db.rawQuery(sql,selectionArgs);
        //byte[] image;

        String count;
        String price;
        String id;
        String fid;


        while(cu.moveToNext()){
            id=cu.getString(0);
            count=cu.getString(1);
            price=cu.getString(2);
            fid=cu.getString(3);
            Bitmap bitmap;

            //bitmap= BitmapFactory.decodeByteArray(image,0,image.length);

            Vouchers voucher =new Vouchers(id,price,count);
            list.add(voucher);
        }
        cu.close();

        return list;
    }

    //Delete a voucher item
    public boolean Admin_delete_current_voucher(String id){
        try{
            SQLiteDatabase db=getReadableDatabase();
            String selection=UsersMaster.Vouchers.COLUMN_NAME_ID + " = ?";
            String[] selectionArgs = {id};
            int rowsAffected=db.delete(UsersMaster.Vouchers.TABLE_NAME,selection,selectionArgs);
            return rowsAffected > 0;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    //Update voucher Item
    public boolean Admin_update_voucher_info(String id, String price,String count){
        try {
            SQLiteDatabase db = getReadableDatabase();
            ContentValues values = new ContentValues();
            values.put(UsersMaster.Vouchers.COLUMN_NAME_COUNT, count);
            values.put(UsersMaster.Vouchers.COLUMN_NAME_PRICE, price);
            //values.put(UsersMaster.Vouchers.COLUMN_NAME_VOUCHERIMAGE, image);
            String selection = UsersMaster.Vouchers.COLUMN_NAME_ID + " = ?";
            String[] selectionArgs = {id};

            int counts = db.update(UsersMaster.Vouchers.TABLE_NAME, values, selection, selectionArgs);
            return counts > 0;
        }
        catch (SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }


    public void addProduct(String prodName, String prodCount ,String prodDesc, String price, String category) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(UsersMaster.ProductsItems.COLUMN_NAME_PRODUCT_NAME, prodName);
        values.put(UsersMaster.ProductsItems.COLUMN_NAME_COUNT, prodCount);
        values.put(UsersMaster.ProductsItems.COLUMN_NAME_DESCRIPTION, prodDesc);
        values.put(UsersMaster.ProductsItems.COLUMN_NAME_PRICE, price);
        //values.put(UsersMaster.ProductsItems.COLUMN_NAME_PRODUCTIMAGE, image);
        values.put(UsersMaster.ProductsItems.COLUMN_NAME_CATEGORY_NAME, category);

        db.insert(UsersMaster.ProductsItems.TABLE_NAME, null, values);
    }


    public void addVoucher(String vouPrice, String vouQty ) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(UsersMaster.Vouchers.COLUMN_NAME_PRICE, vouPrice);
        values.put(UsersMaster.Vouchers.COLUMN_NAME_COUNT, vouQty);


        db.insert(UsersMaster.Vouchers.TABLE_NAME, null, values);
    }

//    public void initialize_details(String prodName, String price) {
//
//        SQLiteDatabase db = getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//
//        values.put(UsersMaster.ProductsItems.COLUMN_NAME_PRODUCT_NAME, prodName);
//        //values.put(UsersMaster.ProductsItems.COLUMN_NAME_COUNT, prodCount);
//        values.put(UsersMaster.ProductsItems.COLUMN_NAME_PRICE, price);
//        //values.put(UsersMaster.ProductsItems.COLUMN_NAME_PRODUCTIMAGE, image);
//
//        db.insert(UsersMaster.ProductsItems.TABLE_NAME, null, values);
//    }

//    public boolean User_insert_cart_details(Cart cart){
//        SQLiteDatabase db=getWritableDatabase();
//        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//
//         //cart.getImage().compress(Bitmap.CompressFormat.PNG, 100, stream);
//         byte[] photo = stream.toByteArray();
//
//
//        ContentValues values=new ContentValues();
//        values.put(UsersMaster.PriceConform.COLUMN_NAME_PRODUCT_NAME,cart.getName());
//        //values.put(UsersMaster.PriceConform.COLUMN_NAME_COUNT,cart.getCount());
//        values.put(UsersMaster.PriceConform.COLUMN_NAME_PRICE,cart.getPrice());
//        values.put(UsersMaster.PriceConform.COLUMN_NAME_IMAGE,cart.getImage());
//
//
//        long rowId=db.insert(UsersMaster.PriceConform.PRICE_CONFORM_USER ,null,values);
//        return rowId != -1;
//    }


//    public void addToCart(String prodName, String prodCount ,String price, String image) {
//        SQLiteDatabase db = getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//
//        values.put(UsersMaster.ProductsItems.COLUMN_NAME_PRODUCT_NAME, prodName);
//        values.put(UsersMaster.ProductsItems.COLUMN_NAME_COUNT, prodCount);
//        values.put(UsersMaster.ProductsItems.COLUMN_NAME_PRICE, price);
//        values.put(UsersMaster.ProductsItems.COLUMN_NAME_PRODUCTIMAGE, image);
//
//        db.insert(UsersMaster.ProductsItems.TABLE_NAME, null, values);
//    }



    public void insertGallery(String email, String hashtag, byte[] image){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO GALLERY VALUES (NULL, ?, ?, ?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, email);
        statement.bindString(2, hashtag);
        statement.bindBlob(3, image);

        statement.executeInsert();
    }

    public void updateGallery(String email, String hashtag, byte[] image, int id) {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "UPDATE GALLERY SET email = ?, hashtag = ?, image = ? WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);

        statement.bindString(1, email);
        statement.bindString(2, hashtag);
        statement.bindBlob(3, image);
        statement.bindDouble(4, (double)id);

        statement.execute();
        database.close();
    }

    public  void deleteGallery(int id) {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "DELETE FROM GALLERY WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1, (double)id);

        statement.execute();
        database.close();
    }

    public Cursor getGallery(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }







    private class Date {
    }

    private class Numb {
    }

    public  Bitmap getProPic() {


        String[] projection = {
                UsersMaster.Users.COL_USER_PROPIC
        };
        SQLiteDatabase db = getWritableDatabase();


        String selection = UsersMaster.Users.COL_USER_CURRENT + " LIKE ?";
        String[] selectionArgs = {"TRUE"};

        Bitmap bitmap;

        Cursor cursor = db.query(UsersMaster.Users.TABLE_USER,
                projection,
                selection,
                selectionArgs,
                null, null, null);
        byte []currentUsername ;

        if (cursor.moveToFirst()) {
            do {
                currentUsername = cursor.getBlob(cursor.getColumnIndex(UsersMaster.Users.COL_USER_PROPIC));
                // bitmap = BitmapFactory.decodeByteArray(currentUsername,0,currentUsername.length);
            } while (cursor.moveToNext());
        } else {
            return null;
        }
        cursor.close();
        return  BitmapFactory.decodeByteArray(currentUsername, 0, currentUsername.length);


    }


    public  void changeProPic(byte[] propic){
        SQLiteDatabase db = getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(UsersMaster.Users.COL_USER_PROPIC, propic);

        String selection = UsersMaster.Users.COL_USER_CURRENT + " LIKE ?";
        String[] selectionArgs = {"TRUE"};
        db.update(UsersMaster.Users.TABLE_USER, values, selection, selectionArgs);
    }



        }

