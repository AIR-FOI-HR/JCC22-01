package hr.foi.air.autosimulation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import hr.foi.air.core.simulation.FileToList
import hr.foi.air.core.simulation.SolutionMakerClass
import java.io.File
import java.io.IOException
import java.io.InputStream

class SimulationListView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simulation_list_view)

        /*val carName :TextView = findViewById(R.id.car_name)

        val bundle: Bundle?= intent.extras
        val heading = bundle!!.getString("heading")

        carName.text = heading*/

        var readerLists = FileToList()
        var solutionn = SolutionMakerClass()

        val path = "textfile.txt"
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
                    var sol  = solutionn.makeSolution(a)
                    lista2.add(sol)
                }
            }

            ListViews.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, lista2)
        }


    }
}