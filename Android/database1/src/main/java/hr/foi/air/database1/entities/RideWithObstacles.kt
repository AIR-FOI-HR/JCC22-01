package hr.foi.air.database1.entities

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class RideWithObstacles(
    @Embedded val ride: Ride,
    @Relation(
        parentColumn = "rideId",
        entityColumn = "id",
        associateBy = Junction(IsAppearing::class)
    )
    val rides : List<Ride>
)
