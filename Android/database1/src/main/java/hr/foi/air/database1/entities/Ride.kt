package hr.foi.air.database1.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "rides")
data class Ride(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ForeignKey(entity = Car::class, parentColumns = ["id"], childColumns = ["carId"])
    @ColumnInfo(index = true)
    var carId : Int,
    var distance : Int? = null,
    var obstacleCount : Int? = null,
)

