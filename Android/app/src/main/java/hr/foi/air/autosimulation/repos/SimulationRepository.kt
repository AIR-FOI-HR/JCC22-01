package hr.foi.air.autosimulation.repos

import android.content.Context
import android.os.Handler
import android.widget.LinearLayout
import android.widget.TextView
import hr.foi.air.autosimulation.recyclerview.SimulationListAdapter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class SimulationRepository {
   fun startRide(context: Context, linearLayout: LinearLayout) {
       val fileRepos = FileRepository(context)
       val listSimulation = fileRepos.initializeSimulation()

       var i = 0
       fun displayNextItem() {
           if (i < listSimulation.size) {
               val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
               val current = LocalDateTime.now().format(formatter)
               val textView = TextView(context)
               textView.text ="${current} - " + listSimulation[i]
               linearLayout.addView(textView)
               i++
               Handler().postDelayed({ displayNextItem() }, 2000) // wait for 2 second before displaying the next item
           }
       }
       displayNextItem()
   }
}