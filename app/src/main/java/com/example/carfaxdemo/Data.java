package com.example.carfaxdemo;

import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("firstPhoto")
    private String firstPhoto;
    @SerializedName("carinfo")
    private String carInfo;
    @SerializedName("phone")
    private String phone;
    @SerializedName("currentPrice")
    private String currentPrice;

    public Data(String firstPhoto, String phone) {
        this.firstPhoto = firstPhoto;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return firstPhoto;
    }

    public void setPhoto(String firstPhoto) {
        this.firstPhoto = firstPhoto;
    }

    public String getPrice() {
        return currentPrice;
    }

    public void setPrice(String currentPrice) {
        this.currentPrice = currentPrice;
    }
}
