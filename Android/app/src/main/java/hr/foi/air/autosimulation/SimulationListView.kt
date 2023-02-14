package hr.foi.air.autosimulation

import android.os.Bundle
import android.os.Handler
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import hr.foi.air.autosimulation.databinding.ActivitySimulationListViewBinding
import hr.foi.air.autosimulation.repos.FileRepository

class SimulationListView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = ActivitySimulationListViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.buttonStartRide.setOnClickListener{
            startRide()
        }
    }

    private fun startRide() {
        val linearLayout = findViewById<LinearLayout>(R.id.linear_layout)
        val fileRepos = FileRepository(this)
        val listSimulation = fileRepos.initializeSimulation()

        var i = 0
        fun displayNextItem() {
            if (i < listSimulation.size) {
                val textView = TextView(this)
                textView.text = listSimulation[i]
                linearLayout.addView(textView)
                i++
                Handler().postDelayed({ displayNextItem() }, 2000) // wait for 3 second before displaying the next item
            }
        }
        displayNextItem()
    }

   /* private fun startRide() {
        val listView = findViewById<ListView>(R.id.usertext)
        val fileRepos = FileRepository(this)
        val listSimulation = fileRepos.initializeSimulation()
        val adapter = SimulationListAdapter(this, listSimulation)

        listView.adapter = adapter

        Handler().postDelayed({ adapter.displayNextItem() }, 1000)
    }

    */

}