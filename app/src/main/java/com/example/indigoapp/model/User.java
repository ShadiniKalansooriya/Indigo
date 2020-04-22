package com.example.indigoapp.model;

import android.content.ContentValues;
import android.database.Cursor;

public class User {

    private int id;
    public String name;
    public  String email;
    public String password;
    public String confPassword;
    public  String DOB;
    public String gender;
    public byte[] propic;

    public byte[] getPropic() {
        return propic;
    }

    public void setPropic(byte[] propic) {
        this.propic = propic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfPassword() {
        return confPassword;
    }

    public void setConfPassword(String confPassword) {
        this.confPassword = confPassword;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ContentValues getContentValues(){
        ContentValues cv = new ContentValues();
        //cv.put("ID", getId());
        cv.put("name",getName());
        cv.put("email",getEmail());
        cv.put("pwd",getPassword());
        cv.put("conf_Pwd",getConfPassword());
        cv.put("dob",getDOB());
        cv.put("gen",getGender());
        cv.put("propic",getPropic());

        return cv;
    }

    public static User getDBInstance(Cursor cursor)
    {
        User user = new User();
        int index = 0;
        user.setId(cursor.getInt(0));

        return user;
    }
}
