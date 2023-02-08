package hr.foi.air.database1.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "appearances", primaryKeys = ["obstacleId", "rideId"])
data class IsAppearing (
    var obstacleId : Int,
    var rideId : Int,
    var occuringDistance : Int? = null
)
