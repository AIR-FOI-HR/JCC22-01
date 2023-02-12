package hr.foi.air.database1.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Ignore
import androidx.room.PrimaryKey
import hr.foi.air.core.entities.Car

@Entity(tableName = "cars", primaryKeys = ["id"])
class Car() : Car()
{
    @PrimaryKey(autoGenerate = true)
    @Ignore
    override var id: Int? = null

    @ForeignKey(entity = User::class, parentColumns = ["id"], childColumns = ["userId"])
    @Ignore
    override var userId: Int? = null
}