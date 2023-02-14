package hr.foi.air.autosimulation.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso
import hr.foi.air.autosimulation.R
import hr.foi.air.core.entities.Car
import org.jetbrains.annotations.NotNull

class CarRecyclerAdapter(context: Context, private val carList : ArrayList<Car>) :
    RecyclerView.Adapter<CarRecyclerAdapter.CarViewHolder>() {

    private lateinit var mListener: onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_car, parent, false)
        return CarViewHolder(itemView, mListener)
    }

    override fun getItemCount(): Int {
        return carList.size
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val currentItem = carList[position]
        Picasso.get().load(currentItem.titleImage).into(holder.titleImage)
        holder.heading.text = currentItem.name
        holder.description.text = currentItem.speed.toString() + " km/h"
    }
    class CarViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val titleImage : ImageView = itemView.findViewById(R.id.car_image)
        val heading : TextView = itemView.findViewById(R.id.car_name)
        val description : TextView = itemView.findViewById(R.id.car_desc)

        init{
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

}
