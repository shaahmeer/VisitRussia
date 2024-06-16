import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.visitrussia.DetailActivity.CityDetailActivity
import com.example.visitrussia.DetailActivity.HotelDetailActivity
import com.example.visitrussia.DetailActivity.RestaurantDetailActivity
import com.example.visitrussia.Model.Hotel
import com.example.visitrussia.R

class HotelAdapter(private val hotels: List<Hotel>, cityDetailActivity: CityDetailActivity) : RecyclerView.Adapter<HotelAdapter.HotelViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hotel, parent, false)
        return HotelViewHolder(view)
    }

    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {
        val hotel = hotels[position]
        holder.bind(hotel)
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, HotelDetailActivity::class.java)
            intent.putExtra("hotel", hotel)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return hotels.size
    }

    inner class HotelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ivHotelImage: ImageView = itemView.findViewById(R.id.ivHotelImage)
        private val tvHotelName: TextView = itemView.findViewById(R.id.tvHotelName)
        private val tvHotelDescription: TextView = itemView.findViewById(R.id.tvHotelDescription)

        fun bind(hotel: Hotel) {
            Glide.with(itemView.context).load(hotel.imageUrl).into(ivHotelImage)
            tvHotelName.text = hotel.name
            tvHotelDescription.text = hotel.description
        }
    }
}
