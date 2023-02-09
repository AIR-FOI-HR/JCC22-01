package hr.foi.air.autosimulation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import hr.foi.air.autosimulation.databinding.ActivityMainBinding
import hr.foi.air.autosimulation.databinding.FragmentMainBinding
import hr.foi.air.database1.MainDatabase
import hr.foi.air.database1.data.DataRepository
import hr.foi.air.database1.data.MockData
import hr.foi.air.database1.entities.User

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginbtn = findViewById<Button>(R.id.loginbtn)
        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)

        var db = MainDatabase.getInstance(this)
        val usersList : List<User> = db.getDao().getAllUsers()

        loginbtn.setOnClickListener{
            if(username.text.isNotBlank() && password.text.isNotBlank()){
                for(user in usersList){
                    if(user.username == username.text.toString() && user.password == password.text.toString()){
                        Toast.makeText(this, "Uspjesna prijava", Toast.LENGTH_SHORT).show()
                        Log.d("Provjera", "Uspjesna prijava")
                    }

                }
            }
            else{
                Toast.makeText(this, "Neuspjesna prijava", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun setupDatabase(/*binding: FragmentMainBinding*/) {
        //unos podataka u bazu
        MockData.insertAllData(this)
    }
}