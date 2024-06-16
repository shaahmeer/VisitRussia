package com.example.visitrussia.DetailActivity

import HotelAdapter
import RestaurantAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.visitrussia.Model.City
import com.example.visitrussia.Model.Hotel
import com.example.visitrussia.Model.Place
import com.example.visitrussia.Model.Restaurant
import com.example.visitrussia.R
import com.example.visitrussia.adapter.OnItemClickListener
import com.example.visitrussia.adapter.PlaceAdapter
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class CityDetailActivity : AppCompatActivity(), OnItemClickListener {

    private var city: City? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_detail)

        // Get the city object from the intent
        city = intent.getParcelableExtra("city")

        // Set up RecyclerViews for whatToDo, whatToEat, and whereToStay
        setupRecyclerView(findViewById(R.id.rvWhatToDo), city?.whatToDo ?: emptyList())
        setupRecyclerView(findViewById(R.id.rvWhatToEat), city?.whatToEat ?: emptyList())
        setupRecyclerView(findViewById(R.id.rvWhereToStay), city?.whereToStay ?: emptyList())
    }

    private fun setupRecyclerView(recyclerView: RecyclerView, items: List<Any>) {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@CityDetailActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = when {
                items.isNotEmpty() && items[0] is Place -> PlaceAdapter(items as List<Place>, this@CityDetailActivity)
                items.isNotEmpty() && items[0] is Restaurant -> RestaurantAdapter(items as List<Restaurant>, this@CityDetailActivity)
                items.isNotEmpty() && items[0] is Hotel -> HotelAdapter(items as List<Hotel>, this@CityDetailActivity)
                else -> null
            }
        }
    }

    override fun onItemClick(item: Any) {
        TODO("Not yet implemented")
    }
}
