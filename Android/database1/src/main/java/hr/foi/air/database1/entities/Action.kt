package hr.foi.air.database1.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "actions")
data class Action(
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null,
    var name : String = ""
)