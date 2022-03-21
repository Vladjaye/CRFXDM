package com.example.carfaxdemo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Log.INFO
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView


class DetailsActivity : AppCompatActivity() {

    var detailsimage = null
    var carBasics: TextView? = null
    var priceMileage: TextView? = null
    var locationText: TextView? = null
    var cardView: CardView? = null
    var imageView: ImageView? = null
    var button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        carBasics = findViewById(R.id.carbasicsTextView)
        priceMileage = findViewById(R.id.priceMileageTextView)
        locationText = findViewById(R.id.locationTextview)
        cardView = findViewById(R.id.cardView)
        imageView = findViewById(R.id.carImageView)
        button = findViewById(R.id.button)
    }
}