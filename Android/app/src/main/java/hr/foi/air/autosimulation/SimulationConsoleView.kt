package hr.foi.air.autosimulation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import hr.foi.air.autosimulation.databinding.ActivitySimulationConsoleViewBinding
import hr.foi.air.autosimulation.databinding.ActivitySimulationListViewBinding
import hr.foi.air.autosimulation.repos.SimulationRepository

class SimulationConsoleView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivitySimulationConsoleViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonListView.setOnClickListener{
            val intent = Intent(this@SimulationConsoleView, SimulationListView::class.java)
            startActivity(intent)
        }

        val linearLayout = findViewById<LinearLayout>(R.id.linear_layout)
        val simulationRepos = SimulationRepository()
        binding.buttonStartRide.setOnClickListener{
            simulationRepos.startRide(this, linearLayout)
        }
    }
}