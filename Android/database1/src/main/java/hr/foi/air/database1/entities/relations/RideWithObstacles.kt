package hr.foi.air.database1.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import hr.foi.air.database1.entities.IsAppearing
import hr.foi.air.database1.entities.Obstacle
import hr.foi.air.database1.entities.Ride

data class RideWithObstacles(
    @Embedded val ride: Ride,
    @Relation(
        parentColumn = "rideId",
        entityColumn = "obstacleId",
        associateBy = Junction(IsAppearing::class)
    )
    val obstacle : List<Obstacle>
)
