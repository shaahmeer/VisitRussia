package com.example.visitrussia.DetailActivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.visitrussia.Model.Place
import com.example.visitrussia.R
import com.bumptech.glide.Glide
import android.widget.ImageView
import android.widget.TextView

class PlaceDetailActivity : AppCompatActivity() {

    private lateinit var tvPlaceName: TextView
    private lateinit var tvPlaceDescription: TextView
    private lateinit var ivPlaceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_detail)

        tvPlaceName = findViewById(R.id.tvPlaceName)
        tvPlaceDescription = findViewById(R.id.tvPlaceDescription)
        ivPlaceImage = findViewById(R.id.ivPlaceImage)

        val place = intent.getParcelableExtra<Place>("place")

        place?.let {
            showPlaceDetails(it)
        }
    }

    private fun showPlaceDetails(place: Place) {
        supportActionBar?.title = place.name
        tvPlaceName.text = place.name
        tvPlaceDescription.text = place.description
        Glide.with(this).load(place.imageUrl).into(ivPlaceImage)
    }
}
