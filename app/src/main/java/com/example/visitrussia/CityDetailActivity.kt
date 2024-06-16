package com.example.visitrussia//package com.example.visitrussia
//
//import android.content.Intent
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.visitrussia.DetailActivity.HotelDetailActivity
//import com.example.visitrussia.DetailActivity.PlaceDetailActivity
//import com.example.visitrussia.DetailActivity.RestaurantDetailActivity
//import com.example.visitrussia.Model.City
//import com.example.visitrussia.Model.Hotel
//import com.example.visitrussia.Model.Place
//import com.example.visitrussia.Model.Restaurant
//import com.example.visitrussia.adapter.HotelAdapter
//import com.example.visitrussia.adapter.OnItemClickListener
//import com.example.visitrussia.adapter.PlaceAdapter
//import com.example.visitrussia.adapter.RestaurantAdapter
//
//class CityDetailActivity : AppCompatActivity(), OnItemClickListener {
//
//    private var city: City? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_city_detail)
//
//        // Get the city object from the intent
//        city = intent.getParcelableExtra("city")
//
//        // Set up RecyclerViews for whatToDo, whatToEat, and whereToStay
//        setupRecyclerView(findViewById(R.id.rvWhatToDo), city?.whatToDo ?: emptyList())
//        setupRecyclerView(findViewById(R.id.rvWhatToEat), city?.whatToEat ?: emptyList())
//        setupRecyclerView(findViewById(R.id.rvWhereToStay), city?.whereToStay ?: emptyList())
//    }
//
//    private fun setupRecyclerView(recyclerView: RecyclerView, items: List<Any>) {
//        recyclerView.apply {
//            layoutManager = LinearLayoutManager(this@CityDetailActivity)
//            adapter = when {
//                items.isNotEmpty() && items[0] is Place -> PlaceAdapter(items as List<Place>, this@CityDetailActivity)
//                items.isNotEmpty() && items[0] is Restaurant -> RestaurantAdapter(items as List<Restaurant>, this@CityDetailActivity)
//                items.isNotEmpty() && items[0] is Hotel -> HotelAdapter(items as List<Hotel>, this@CityDetailActivity)
//                else -> null
//            }
//        }
//    }
//
//    // Handle item click
//    override fun onItemClick(item: Any) {
//        // Open details activity based on item type
//        when (item) {
//            is Place -> openPlaceDetailActivity(item)
//            is Restaurant -> openRestaurantDetailActivity(item)
//            is Hotel -> openHotelDetailActivity(item)
//        }
//    }
//
//    private fun openPlaceDetailActivity(place: Place) {
//        // Start PlaceDetailActivity and pass place object
//        val intent = Intent(this, PlaceDetailActivity::class.java)
//        intent.putExtra("place", place)
//        startActivity(intent)
//    }
//
//    private fun openRestaurantDetailActivity(restaurant: Restaurant) {
//        // Start RestaurantDetailActivity and pass restaurant object
//        val intent = Intent(this, RestaurantDetailActivity::class.java)
//        intent.putExtra("restaurant", restaurant)
//        startActivity(intent)
//    }
//
//    private fun openHotelDetailActivity(hotel: Hotel) {
//        // Start HotelDetailActivity and pass hotel object
//        val intent = Intent(this, HotelDetailActivity::class.java)
//        intent.putExtra("hotel", hotel)
//        startActivity(intent)
//    }
//}
