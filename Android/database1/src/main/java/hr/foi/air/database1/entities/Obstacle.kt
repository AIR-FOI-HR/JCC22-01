package hr.foi.air.database1.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "obstacles")
data class Obstacle(
    @PrimaryKey(autoGenerate = false)
    var obstacleId : Int? = null,
    @ForeignKey(entity = Action::class, parentColumns = ["id"], childColumns = ["actionId"])
    @ColumnInfo(index = true)
    var actionId : Int? = null,
    var name : String = "",
    var description : String = "",
)