package hr.foi.air.database1.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null,
    var username : String = "",
    var password : String = ""
) : Serializable
