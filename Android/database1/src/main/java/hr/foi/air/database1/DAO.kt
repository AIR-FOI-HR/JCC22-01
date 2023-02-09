package hr.foi.air.database1

import androidx.room.*
import hr.foi.air.database1.entities.*

@Dao
interface DAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCars(vararg Cars: Car): List<Long>
    @Update
    fun updateCars(vararg Cars: Car)
    @Delete
    fun deleteCars(vararg Cars: Car)

    @Insert
    fun insertRides(vararg Rides: Ride): List<Long>
    @Update
    fun updateRides(vararg Rides: Ride)
    @Delete
    fun deleteRides(vararg Rides: Ride)

    @Insert
    fun insertObstacles(vararg Obstacles: Obstacle)
    @Update
    fun updateObstacles(vararg Obstacles: Obstacle)
    @Delete
    fun deleteObstacles(vararg Obstacles: Obstacle)

    @Insert
    fun insertActions(vararg Actions: Action): List<Long>
    @Update
    fun updateActions(vararg Actions: Action)
    @Delete
    fun deleteActions(vararg Actions: Action)

    @Insert
    fun insertAppearances(vararg Appearances: IsAppearing)
    @Update
    fun updateAppearances(vararg Appearances: IsAppearing)
    @Delete
    fun deleteAppearances(vararg Appearances: IsAppearing)

    @Insert
    fun insertUsers(vararg Users: User): List<Long>
    @Update
    fun updateUsers(vararg Users: User)
    @Delete
    fun deleteUsers(vararg Users: User)

    @Query("SELECT * FROM cars")
    fun getAllCars(): List<Car>

    @Query("SELECT * FROM rides")
    fun getAllRides(): List<Ride>

    @Query("SELECT * FROM obstacles")
    fun getAllObstacles(): List<Obstacle>

    @Query("SELECT * FROM actions")
    fun getAllObstacleTypes(): List<Action>

    @Query("SELECT * FROM appearances")
    fun getAllAppearances(): List<IsAppearing>

    @Query("SELECT * FROM users")
    fun getAllUsers(): List<User>

    @Query("SELECT * FROM cars WHERE name LIKE :name")
    fun getAllCarsByName(name: String): List<Car>

    @Query("SELECT * FROM rides WHERE carId = :carId")
    fun getAllRidesByCar(carId: Int): List<Ride>

    /*@Query("SELECT name FROM obstacles inner join appearances on obstacleId=obstacles.obstacleId")
    fun getObstacles(): List<String>*/
}