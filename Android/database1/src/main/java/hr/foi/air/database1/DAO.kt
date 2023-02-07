package hr.foi.air.database1

import androidx.room.*
import hr.foi.air.database1.entities.*

@Dao
interface DAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCars(vararg Cars: Car) : List<Long>
    @Update fun updateCars(vararg Cars: Car)
    @Delete fun deleteCars(vararg Cars: Car)

    @Insert fun insertRides(vararg Rides: Ride)
    @Update fun updateRides(vararg Rides: Ride)
    @Delete fun deleteRides(vararg Rides: Ride)

    @Insert fun insertObstacles(vararg Obstacles: Obstacle)
    @Update fun updateObstacles(vararg Obstacles: Obstacle)
    @Delete fun deleteObstacles(vararg Obstacles: Obstacle)

    @Insert fun insertObstacleTypes(vararg ObstacleTypes: ObstacleType)
    @Update fun updateObstacleTypes(vararg ObstacleTypes: ObstacleType)
    @Delete fun deleteObstacleTypes(vararg ObstacleTypes: ObstacleType)

    @Insert fun insertAppearances(vararg Appearances: IsAppearing)
    @Update fun updateAppearances(vararg Appearances: IsAppearing)
    @Delete fun deleteAppearances(vararg Appearances: IsAppearing)

    @Query("SELECT * FROM cars")
    fun getAllCars(): List<Car>

    @Query("SELECT * FROM rides")
    fun getAllRides(): List<Ride>

    @Query("SELECT * FROM obstacles")
    fun getAllObstacles(): List<Obstacle>

    @Query("SELECT * FROM obstacleTypes")
    fun getAllObstacleTypes(): List<ObstacleType>

    @Query("SELECT * FROM appearances")
    fun getAllAppearances(): List<IsAppearing>

    @Query("SELECT * FROM Cars WHERE name LIKE :name")
    fun getAllCarsByName(name: String): List<Car>

    @Query("SELECT * FROM Rides WHERE carId = :carId")
    fun getAllRidesByCar(carId: Int): List<Ride>
}