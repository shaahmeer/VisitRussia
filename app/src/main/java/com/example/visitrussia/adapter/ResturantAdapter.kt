import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.visitrussia.DetailActivity.CityDetailActivity
import com.example.visitrussia.DetailActivity.PlaceDetailActivity
import com.example.visitrussia.DetailActivity.RestaurantDetailActivity
import com.example.visitrussia.Model.Restaurant
import com.example.visitrussia.R

class RestaurantAdapter(
    private val restaurants: List<Restaurant>,
    cityDetailActivity: CityDetailActivity
) : RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_resturant, parent, false)
        return RestaurantViewHolder(view)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val restaurant = restaurants[position]
        holder.bind(restaurant)
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, RestaurantDetailActivity::class.java)
            intent.putExtra("restaurant", restaurant)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return restaurants.size
    }

    inner class RestaurantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ivRestaurantImage: ImageView = itemView.findViewById(R.id.ivRestaurantImage)
        private val tvRestaurantName: TextView = itemView.findViewById(R.id.tvRestaurantName)
        private val tvRestaurantDescription: TextView = itemView.findViewById(R.id.tvRestaurantDescription)

        fun bind(restaurant: Restaurant) {
            Glide.with(itemView.context).load(restaurant.imageUrl).into(ivRestaurantImage)
            tvRestaurantName.text = restaurant.name
            tvRestaurantDescription.text = restaurant.address
        }
    }
}
