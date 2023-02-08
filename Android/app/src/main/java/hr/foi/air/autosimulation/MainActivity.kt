package hr.foi.air.autosimulation

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import hr.foi.air.autosimulation.databinding.ActivityMainBinding
import hr.foi.air.autosimulation.databinding.FragmentMainBinding
import hr.foi.air.database1.data.DataRepository
import hr.foi.air.database1.data.MockData

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = FragmentMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val btnShowData = findViewById<Button>(R.id.btn_show_data)
        binding.btnShowData.setOnClickListener{
            setupDatabase(binding)
        }

    }

    private fun setupDatabase(binding: FragmentMainBinding){
        //unos podataka u bazu
        MockData.insertAllData(this)

        var actions : List<String>? = DataRepository(this).getActionNames()

        //prikaz podataka na zaslonu
        if(actions != null){
            binding.lstActions.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, actions)
        }
    }
}