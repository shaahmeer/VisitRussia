package com.example.visitrussia

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.visitrussia.DetailActivity.CityDetailActivity
import com.example.visitrussia.Model.City
import com.example.visitrussia.adapter.CityAdapter
import com.example.visitrussia.databinding.ActivityMainBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.jackandphantom.carouselrecyclerview.CarouselLayoutManager
import com.jackandphantom.carouselrecyclerview.CarouselRecyclerview

class MainActivity : AppCompatActivity() {

    private lateinit var db: FirebaseFirestore
    private lateinit var binding: ActivityMainBinding
    private lateinit var cityAdapter: CityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = FirebaseFirestore.getInstance()

        cityAdapter = CityAdapter(ArrayList(), this::onCityClick)
        binding.cityRecyclerView.adapter = cityAdapter

        configureCarouselRecyclerView()
        fetchCitiesFromFirestore()
    }

    private fun configureCarouselRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.setOrientation(RecyclerView.HORIZONTAL)

        binding.cityRecyclerView.layoutManager = layoutManager
        binding.cityRecyclerView.setHasFixedSize(true)
        binding.cityRecyclerView.setInfinite(true)
        binding.cityRecyclerView.set3DItem(true)
        binding.cityRecyclerView.setAlpha(true)
    }

    private fun fetchCitiesFromFirestore() {
        db.collection("cities")
            .get()
            .addOnSuccessListener { documents ->
                val cities = ArrayList<City>()
                for (document in documents) {
                    val city = document.toObject<City>()
                    cities.add(city)
                }
                cityAdapter.updateCities(cities)
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Failed to fetch cities: $exception", Toast.LENGTH_SHORT).show()
            }
    }

    private fun onCityClick(city: City) {
        val intent = Intent(this, CityDetailActivity::class.java)
        intent.putExtra("city", city)
        startActivity(intent)
    }
}
