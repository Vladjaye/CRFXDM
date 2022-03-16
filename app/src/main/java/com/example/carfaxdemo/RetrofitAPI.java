package com.example.carfaxdemo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitAPI {
    @GET("assignment.json")
    Call<Data> getData();
}