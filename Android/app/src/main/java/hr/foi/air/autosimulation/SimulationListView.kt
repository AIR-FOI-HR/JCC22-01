package hr.foi.air.autosimulation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import hr.foi.air.autosimulation.databinding.ActivitySimulationListViewBinding
import hr.foi.air.core.simulation.FileToList
import hr.foi.air.core.simulation.SolutionMakerClass
import java.io.IOException
import java.io.InputStream

class SimulationListView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivitySimulationListViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonStartRide.setOnClickListener{
            loadSimulation()
        }
    }

    fun loadSimulation(binding: ActivitySimulationListViewBinding) {
        var readerLists = FileToList()
        var solutionn = SolutionMakerClass()

        val path = "hr/foi/air/database1/ride/textfile.txt"
        var inputStream: InputStream? = null
        try {
            inputStream = assets.open(path)
        } catch (e: IOException) {
            Log.e("Error", "Failed to open file: $path", e)
        }
        val ListViews = findViewById<ListView>(R.id.userlist)
        if (ListViews == null) {
            Log.e("Error", "ListView with ID R.id.userlist not found")
        } else {
            val lista = readerLists.ReaderFile(inputStream!!)
            val lista2 : ArrayList<String> = arrayListOf()
            for(a in lista){
                if(a!="-"){
                    lista2.add(a)
                    val sol  = solutionn.makeSolution(a)
                    lista2.add(sol)
                }
            }
            ListViews.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, lista2)
        }
    }
}