package hr.foi.air.autosimulation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import hr.foi.air.autosimulation.repos.FileRepository
import hr.foi.air.core.simulation.SolutionMakerClass
import hr.foi.air.database1.data.FileDataSource
import java.io.IOException
import java.io.InputStream

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