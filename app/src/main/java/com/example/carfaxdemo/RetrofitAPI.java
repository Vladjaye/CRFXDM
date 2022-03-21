package com.example.carfaxdemo;

import com.example.carfaxdemo.jsondata.Model;


import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitAPI {

    //https://carfax-for-consumers.firebaseio.com/

    @GET("assignment.json")
   // Call<Model> getData();
    Observable<Model> getReactiveData();
}