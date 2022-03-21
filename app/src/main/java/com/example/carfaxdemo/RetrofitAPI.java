package com.example.carfaxdemo;

import com.example.carfaxdemo.jsondata.Model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitAPI {

    //https://carfax-for-consumers.firebaseio.com/

    @GET("assignment.json")
    //Call<Data> getData();
    Call<Model> getData();
}