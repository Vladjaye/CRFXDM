package com.example.carfaxdemo

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.util.Log.INFO
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carfaxdemo.jsondata.Model
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


class MainActivity : AppCompatActivity() {

    lateinit var recyclerViewAdapter: RecyclerViewAdapter
    lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getWindow().getDecorView().setBackgroundColor(Color.LTGRAY);


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerViewAdapter = RecyclerViewAdapter()
        recyclerView.adapter = recyclerViewAdapter

        getJson();
    }

    fun getJson() {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://carfax-for-consumers.firebaseio.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val retrofitAPI = retrofit.create(RetrofitAPI::class.java)


        val call: Call<Model> = retrofitAPI.data
        call.enqueue(object : Callback<Model> {
            override fun onResponse(call: Call<Model>, response: Response<Model>) {
                Log.println(INFO, "RETROFIT", "Response code is ${response.code()}")

                if (response.code() != 200) {
                    //network issue - should load local data if any.
                    Log.println(INFO, "RETROFIT", "Response code is ${response.code()}")
                }

                var jsonresponse: Model? = response.body()
                Log.println(INFO, "RETROFIT", "DATA IS: ${jsonresponse?.listings?.get(0)?.images?.large?.toString()}")
                    recyclerViewAdapter.setData(jsonresponse?.listings)
            }

            override fun onFailure(call: Call<Model>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Failed to Download Data", Toast.LENGTH_SHORT)
                    .show();
                if (t is IOException) {
                    Log.println(INFO, "RETROFIT", "NETWORK ISSUE")
                } else {
                    Log.println(INFO, "RETROFIT", "CONVERSION ISSUE")
                }
            }
        })
    }
}