// PlaceAdapter.kt
package com.example.visitrussia.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.visitrussia.DetailActivity.PlaceDetailActivity
import com.example.visitrussia.Model.Place
import com.example.visitrussia.R

class PlaceAdapter(private val places: List<Place>, private val listener: OnItemClickListener) : RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_place, parent, false)
        return PlaceViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        val place = places[position]
        holder.bind(place)
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, PlaceDetailActivity::class.java)
            intent.putExtra("place", place)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return places.size
    }

    class PlaceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.tvPlaceName)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.tvPlaceDescription)
        private val ivHotelImage: ImageView = itemView.findViewById(R.id.ivPlaceImage)



        fun bind(place: Place) {
            nameTextView.text = place.name
            descriptionTextView.text = place.description
            Glide.with(itemView.context).load(place.imageUrl).into(ivHotelImage)
        }
    }
}
