package hr.foi.air.database1.entities

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class ObstacleWithRides(
    @Embedded val obstacle: Obstacle,
    @Relation(
        parentColumn = "obstacleId",
        entityColumn = "rideId",
        associateBy = Junction(IsAppearing::class)
    )
    val obstacles : List<Obstacle>
)
