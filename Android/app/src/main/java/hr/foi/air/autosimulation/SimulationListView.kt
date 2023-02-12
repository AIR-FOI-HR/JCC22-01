package hr.foi.air.autosimulation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SimulationListView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simulation_list_view)

        val carName :TextView = findViewById(R.id.car_name)

        val bundle: Bundle?= intent.extras
        val heading = bundle!!.getString("heading")

        carName.text = heading
    }
}