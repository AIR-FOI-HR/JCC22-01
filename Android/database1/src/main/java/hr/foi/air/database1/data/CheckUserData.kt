package hr.foi.air.database1.data

import android.content.Context
import android.content.Intent
import android.widget.Toast
import hr.foi.air.database1.MainDatabase
import hr.foi.air.database1.entities.User
import java.io.Serializable


class CheckUserData {
    companion object{
        fun checkUserData(context: Context, username:String, password:String) : User{
            var db = MainDatabase.getInstance(context)
            val usersList : List<User> = db.getDao().getAllUsers()
            if(username.isNotBlank() && password.isNotBlank()){
                for(user in usersList){
                    if(user.username == username && user.password == password){
                        return user
                    }
                }
            }
            return null!!
        }
    }
}