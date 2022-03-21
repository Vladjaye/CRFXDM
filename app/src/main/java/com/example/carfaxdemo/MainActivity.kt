package com.example.carfaxdemo

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carfaxdemo.jsondata.Model
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


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

        // getJson(); //Call method
        getRJson();


    }

    fun getRJson() {
        CarFaxClient.getInstance().data.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribeWith(object : Observer<Model> {
                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(value: Model) {
                    recyclerViewAdapter.setData(value.listings)
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                }

                override fun onComplete() {
                }

            })
    }

    fun getJson() { //Call Method
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://carfax-for-consumers.firebaseio.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val retrofitAPI = retrofit.create(RetrofitAPI::class.java)

//Retrofit Call
        /*      val call: Call<Model> = retrofitAPI.data
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
              })*/

        //End
    }
}