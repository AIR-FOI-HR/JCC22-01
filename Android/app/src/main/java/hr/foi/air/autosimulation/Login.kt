package hr.foi.air.autosimulation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginbtn = findViewById<Button>(R.id.loginbtn)
        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)

        loginbtn.setOnClickListener{
            if(username.text.toString() == "admin" && password.text.toString() == "admin"){
               Toast.makeText(this, "Uspjesna prijava", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Neuspjesna prijava", Toast.LENGTH_SHORT).show()
            }
        }
    }
}