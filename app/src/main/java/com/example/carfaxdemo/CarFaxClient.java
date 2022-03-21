package com.example.carfaxdemo;

import com.example.carfaxdemo.jsondata.Model;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class CarFaxClient {
    private static final String URL = "https://carfax-for-consumers.firebaseio.com/";

    private static CarFaxClient instance;
    private RetrofitAPI retrofitapi;

    private CarFaxClient() {
        final Gson gson =
                new GsonBuilder().create();
        final Retrofit retrofit = new Retrofit.Builder().baseUrl(URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        retrofitapi = retrofit.create(RetrofitAPI.class);
    }

    public static CarFaxClient getInstance() {
        if (instance == null) {
            instance = new CarFaxClient();
        }
        return instance;
    }

    public Observable<Model> getData() {
        return retrofitapi.getReactiveData();
    }
}
