package hr.foi.air.autosimulation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import hr.foi.air.core.entities.User
import hr.foi.air.database1.data.CheckUserData
import hr.foi.air.database1.data.MockData
import java.io.Serializable


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupDatabase()

        val loginbtn = findViewById<Button>(R.id.loginbtn)
        loginbtn.setOnClickListener{
            checkUser()
        }
    }
    private fun checkUser() {
        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)

        var currentUser : User = CheckUserData.checkUserData(this,username.text.toString(),password.text.toString())

        if(currentUser!=null){
            Toast.makeText(this, "Uspjesna prijava", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, CarMenu::class.java)
            intent.putExtra(Intent.EXTRA_USER, currentUser as Serializable)
            this.startActivity(intent)
        }
        else{
            Toast.makeText(this, "Neuspjesna prijava", Toast.LENGTH_SHORT).show()
        }
    }
    private fun setupDatabase() {
        //unos podataka u bazu
        MockData.insertAllData(this)
    }
}