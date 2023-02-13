package hr.foi.air.autosimulation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import hr.foi.air.core.simulation.FileToList
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
            ListViews.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, lista)
        }


    }
}