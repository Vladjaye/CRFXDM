package com.example.carfaxdemo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    lateinit var firstphoto: ImageView
    lateinit var cardview: CardView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firstphoto = findViewById(R.id.firstPhoto)
        cardview = findViewById(R.id.card_view)
        button = findViewById(R.id.button_call)

        getData();

        button.setOnClickListener {
            makeCall("123")
        }
    }

    fun getData() {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://carfax-for-consumers.firebaseio.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val retrofitAPI = retrofit.create(RetrofitAPI::class.java)
        val call: Call<Data> = retrofitAPI.data
        call.enqueue(object : Callback<Data> {
            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                val model: Data? = response.body()
                //location.text = model?.phone.orEmpty()
/*                button.setOnClickListener{
                    if (model != null) {
                        makeCall(model.phone)
                    }
                }*/
                Picasso.get().load(model?.photo).into(firstphoto)

            }

            override fun onFailure(call: Call<Data>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Failed to Download Data", Toast.LENGTH_SHORT)
                    .show();
            }
        })
    }

    fun makeCall(number: String) {
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
        startActivity(intent)
    }
}