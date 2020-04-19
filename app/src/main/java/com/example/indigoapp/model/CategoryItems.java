package com.example.indigoapp.model;

import android.graphics.Bitmap;

public class CategoryItems {

    private String name;
    private Bitmap bitmap;
    private String id;

    public CategoryItems(String name, Bitmap bitmap, String id) {
        this.name = name;
        this.bitmap = bitmap;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
