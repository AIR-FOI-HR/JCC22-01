package hr.foi.air.autosimulation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import hr.foi.air.autosimulation.databinding.ActivityMainBinding
import hr.foi.air.autosimulation.databinding.FragmentMainBinding
import hr.foi.air.database1.data.DataRepository
import hr.foi.air.database1.data.MockData

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginbtn = findViewById<Button>(R.id.loginbtn)
        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)

        loginbtn.setOnClickListener {
            if (username.text.toString() == "admin" && password.text.toString() == "admin") {
                Toast.makeText(this, "Uspjesna prijava", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Neuspjesna prijava", Toast.LENGTH_SHORT).show()
            }
        }
        setupDatabase()
        //}
    }

    private fun setupDatabase(/*binding: FragmentMainBinding*/) {
        //unos podataka u bazu
        MockData.insertAllData(this)
    }
}