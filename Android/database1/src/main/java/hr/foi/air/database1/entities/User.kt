package hr.foi.air.database1.entities

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import hr.foi.air.core.entities.User

@Entity(tableName = "users", primaryKeys = ["id"])
class User(): User()
{
    @PrimaryKey(autoGenerate = true)
    @Ignore override var id : Int? = null;
}
