package com.example.indigoapp.model;

public class Vouchers {

    private String voucher_id;
    private String voucher_price;
    private String voucher_count;


    public Vouchers(String voucher_id, String voucher_price, String voucher_count) {
        this.voucher_id = voucher_id;
        this.voucher_price = voucher_price;
        this.voucher_count = voucher_count;
    }

    public String getVoucher_id() {
        return voucher_id;
    }

    public void setVoucher_id(String voucher_id) {
        this.voucher_id = voucher_id;
    }

    public String getVoucher_price() {
        return voucher_price;
    }

    public void setVoucher_price(String voucher_price) {
        this.voucher_price = voucher_price;
    }

    public String getVoucher_count() {
        return voucher_count;
    }

    public void setVoucher_count(String voucher_count) {
        this.voucher_count = voucher_count;
    }
}
