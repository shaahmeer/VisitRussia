package com.example.visitrussia.DetailActivity

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.visitrussia.Model.Hotel
import com.example.visitrussia.R
import com.bumptech.glide.Glide

class HotelDetailActivity : AppCompatActivity() {

    private lateinit var ivHotelImage: ImageView
    private lateinit var tvHotelName: TextView
    private lateinit var tvHotelDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_detail)

        ivHotelImage = findViewById(R.id.ivHotelImage)
        tvHotelName = findViewById(R.id.tvHotelName)
        tvHotelDescription = findViewById(R.id.tvHotelDescription)

        val hotel = intent.getParcelableExtra<Hotel>("hotel")

        hotel?.let {
            showHotelDetails(it)
        }
    }

    override fun onResume() {
        super.onResume()
        val hotel = intent.getParcelableExtra<Hotel>("hotel")

        // Check for any updates to the hotel object and update UI if needed
        hotel?.let {
            showHotelDetails(it)
        }
    }

    private fun showHotelDetails(hotel: Hotel) {
        supportActionBar?.title = hotel.name
        tvHotelName.text = hotel.name
        tvHotelDescription.text = hotel.description
        Glide.with(this).load(hotel.imageUrl).into(ivHotelImage)
    }
}
