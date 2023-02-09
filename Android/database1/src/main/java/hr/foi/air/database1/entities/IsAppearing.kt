package hr.foi.air.database1.entities

import androidx.room.Entity

@Entity(
    primaryKeys = ["obstacleId", "rideId"], tableName = "appearances"
)
data class IsAppearing (
    var obstacleId : Int,
    var rideId : Int,
    var occuringDistance : Int? = null
)
