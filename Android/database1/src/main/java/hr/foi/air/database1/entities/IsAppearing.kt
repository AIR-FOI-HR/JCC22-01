package hr.foi.air.database1.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "appearances")
data class IsAppearing (
    @PrimaryKey(autoGenerate = false)
    var obstacleId : Int? = null,
    @PrimaryKey(autoGenerate = false)
    var rideId : Int? = null,
    var occuringDistance : Int? = null
)
