package hr.foi.air.autosimulation.repos

import android.content.Context
import android.os.Handler
import android.widget.ArrayAdapter
import android.widget.ListView


class SimulationRepositoryList {
    fun startRide(context: Context, listView: ListView) {
        val fileRepos = FileRepository(context)
        val listSimulation = fileRepos.initializeSimulation()

        var i = 0
        val adapter = ArrayAdapter<String>(context, android.R.layout.simple_list_item_1)
        listView.adapter = adapter
        fun displayNextItem() {
            if (i < listSimulation.size) {
                adapter.add(listSimulation[i])
                i++
                Handler().postDelayed({ displayNextItem() }, 2000) // wait for 2 seconds before displaying the next item
            }
        }
        displayNextItem()
    }
}