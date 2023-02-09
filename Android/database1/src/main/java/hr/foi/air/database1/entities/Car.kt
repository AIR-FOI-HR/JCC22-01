package hr.foi.air.database1.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "cars")
data class Car(
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null,
    @ForeignKey(entity = User::class, parentColumns = ["id"], childColumns = ["useId"])
    var userId : Int? = null,
    var name : String = "",
    var speed : Int? = null
)