package hr.foi.air.autosimulation

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import hr.foi.air.autosimulation.repos.FileRepository

class SimulationListView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simulation_list_view)

        val fileRepos = FileRepository(this)
        val listSimulation = fileRepos.initializeSimulation()

        val ListViews = findViewById<ListView>(R.id.userlist)
        ListViews.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listSimulation)

    }
}