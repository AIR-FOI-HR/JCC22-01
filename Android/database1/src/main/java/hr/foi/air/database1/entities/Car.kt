package hr.foi.air.database1.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cars")
data class Car(
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null,
    var name : String = "",
    var speed : Int? = null
)