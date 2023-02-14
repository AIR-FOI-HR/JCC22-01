package hr.foi.air.autosimulation

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import hr.foi.air.autosimulation.databinding.ActivitySimulationListViewBinding
import hr.foi.air.autosimulation.repos.SimulationRepository
import hr.foi.air.autosimulation.repos.SimulationRepositoryList

class SimulationListView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = ActivitySimulationListViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonConsoleView.setOnClickListener{
            val intent = Intent(this@SimulationListView, SimulationConsoleView::class.java)
            startActivity(intent)
        }

        val listView = findViewById<ListView>(R.id.userlist)
        val simulationRepos = SimulationRepositoryList()
        binding.buttonStartRide.setOnClickListener{
            simulationRepos.startRide(this, listView)
        }
    }
}