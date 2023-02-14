package hr.foi.air.autosimulation

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import hr.foi.air.autosimulation.databinding.ActivitySimulationListViewBinding
import hr.foi.air.autosimulation.repos.FileRepository
import hr.foi.air.autosimulation.repos.SimulationRepository

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

        val linearLayout = findViewById<LinearLayout>(R.id.linear_layout)
        val simulationRepos = SimulationRepository()
        binding.buttonStartRide.setOnClickListener{
            simulationRepos.startRide(this, linearLayout)
        }
    }
}