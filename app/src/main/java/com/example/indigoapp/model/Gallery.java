package com.example.indigoapp.model;

public class Gallery {

    private int id;
    private String email;
    private String hashtag;
    private byte[] image;

    public Gallery(String email, String hashtag, byte[] image, int id) {
        this.email = email;
        this.hashtag = hashtag;
        this.image = image;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
