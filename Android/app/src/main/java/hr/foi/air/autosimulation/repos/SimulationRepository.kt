package hr.foi.air.autosimulation.repos

import android.content.Context
import android.os.Handler
import android.widget.LinearLayout
import android.widget.TextView

class SimulationRepository {
    fun startRide(context: Context, linearLayout: LinearLayout) {
        val fileRepos = FileRepository(context)
        val listSimulation = fileRepos.initializeSimulation()

        var i = 0
        fun displayNextItem() {
            if (i < listSimulation.size) {
                val textView = TextView(context)
                textView.text = listSimulation[i]
                linearLayout.addView(textView)
                i++
                Handler().postDelayed({ displayNextItem() }, 2000) // wait for 3 second before displaying the next item
            }
        }
        displayNextItem()
    }
}