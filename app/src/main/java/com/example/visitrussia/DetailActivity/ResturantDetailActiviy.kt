package com.example.visitrussia.DetailActivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.visitrussia.Model.Restaurant
import com.example.visitrussia.R
import com.bumptech.glide.Glide
import android.widget.ImageView
import android.widget.TextView

class RestaurantDetailActivity : AppCompatActivity() {

    private lateinit var tvRestaurantName: TextView
    private lateinit var tvRestaurantAddress: TextView
    private lateinit var ivRestaurantImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_detail)

        tvRestaurantName = findViewById(R.id.tvRestaurantName)
        tvRestaurantAddress = findViewById(R.id.tvRestaurantAddress)
        ivRestaurantImage = findViewById(R.id.ivRestaurantImage)

        val restaurant = intent.getParcelableExtra<Restaurant>("restaurant")

        restaurant?.let {
            showRestaurantDetails(it)
        }
    }

    private fun showRestaurantDetails(restaurant: Restaurant) {
        supportActionBar?.title = restaurant.name
        tvRestaurantName.text = restaurant.name
        tvRestaurantAddress.text = restaurant.address
        Glide.with(this).load(restaurant.imageUrl).into(ivRestaurantImage)
    }
}
