package hr.foi.air.database1.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "obstacles")
data class Obstacle(
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null,
    @ForeignKey(entity = ObstacleType::class, parentColumns = ["id"], childColumns = ["typeId"])
    var typeId : Int,
    var name : String = "",
    var description : String = ""
)