package hr.foi.air.autosimulation.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import hr.foi.air.autosimulation.R

class SimulationListAdapter(private val context: Context, private val simulationList: List<String>) : BaseAdapter() {
    private var currentIndex = 0

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.activity_simulation_list_view, parent, false)

        val listView = view.findViewById<ListView>(R.id.userlist)
        listView.adapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, simulationList.take(currentIndex + 1))

        currentIndex++

        return view
    }

    override fun getItem(position: Int): Any {
        return simulationList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return simulationList.size
    }
}


