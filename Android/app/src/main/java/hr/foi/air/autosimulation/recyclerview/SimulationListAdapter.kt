package hr.foi.air.autosimulation.recyclerview

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class SimulationListAdapter(private val context: Context, private val simulations: MutableList<String>) :
    BaseAdapter() {

    private var currentIndex = 0

    fun displayNextItem() {
        if (currentIndex < simulations.size) {
            currentIndex++
            notifyDataSetChanged()
        }
    }

    override fun getCount(): Int {
        return currentIndex
    }

    override fun getItem(position: Int): String? {
        return simulations[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val textView = convertView as? TextView ?: TextView(context)
        textView.text = simulations[position]
        return textView
    }
}


