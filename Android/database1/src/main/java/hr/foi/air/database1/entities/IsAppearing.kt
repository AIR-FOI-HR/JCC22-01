package hr.foi.air.database1.entities

import androidx.room.Entity

@Entity(
    primaryKeys = ["obstacleId", "rideId"], tableName = "appearances"
)
data class IsAppearing (
    var obstacleId : Int=0,
    var rideId : Int=0,
    var occuringDistance : Int? = null
)
