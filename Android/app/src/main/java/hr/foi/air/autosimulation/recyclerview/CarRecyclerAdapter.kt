package hr.foi.air.autosimulation.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import hr.foi.air.autosimulation.R
import hr.foi.air.core.entities.Car

class CarRecyclerAdapter(private val carList : List<Car>) :
    RecyclerView.Adapter<CarRecyclerAdapter.CarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_car, parent, false)
        return CarViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return carList.size
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val currentItem = carList[position]
        //holder.titleImage.setImageResource(currentItem.titleImage)
        holder.heading.text = currentItem.name
        holder.description.text = currentItem.speed.toString()
    }
    class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        //val titleImage : ShapeableImageView = itemView.findViewById(R.id.car_image)
        val heading : TextView = itemView.findViewById(R.id.car_name)
        val description : TextView = itemView.findViewById(R.id.car_desc)

    }
}
