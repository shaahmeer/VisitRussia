package com.example.visitrussia.adapter

import com.example.visitrussia.Model.City




import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.visitrussia.R

class CityAdapter(
    private var cities: List<City>,
    private val onCityClick: (City) -> Unit
) : RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

    fun updateCities(newCities: List<City>) {
        cities = newCities
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_city, parent, false)
        return CityViewHolder(view)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(cities[position])
    }

    override fun getItemCount(): Int = cities.size

    inner class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ivCityImage: ImageView = itemView.findViewById(R.id.ivCityImage)
        private val tvCityName: TextView = itemView.findViewById(R.id.tvCityName)
//        private val tvCityDescription: TextView = itemView.findViewById(R.id.tvCityDescription)

        fun bind(city: City) {
            Glide.with(itemView.context).load(city.imageUrl).into(ivCityImage)
            tvCityName.text = city.name
//            tvCityDescription.text = city.description

            itemView.setOnClickListener { onCityClick(city) }
        }
    }
}
