package hr.foi.air.autosimulation

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import hr.foi.air.autosimulation.databinding.ActivityMainBinding
import hr.foi.air.autosimulation.databinding.FragmentMainBinding
import hr.foi.air.database1.data.DataRepository
import hr.foi.air.database1.data.MockData

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        setupDatabase()
        //}
    }

    private fun setupDatabase(/*binding: FragmentMainBinding*/) {
        //unos podataka u bazu
        MockData.insertAllData(this)
    }
}