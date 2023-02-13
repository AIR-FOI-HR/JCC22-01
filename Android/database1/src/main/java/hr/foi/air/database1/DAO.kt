package hr.foi.air.database1

import androidx.room.*
import hr.foi.air.database1.entities.*

@Dao
interface DAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE) fun insertCars(vararg Cars: Car): List<Long>
    @Update fun updateCars(vararg Cars: Car)
    @Delete fun deleteCars(vararg Cars: Car)

    @Insert fun insertUsers(vararg Users: User): List<Long>
    @Update fun updateUsers(vararg Users: User)
    @Delete fun deleteUsers(vararg Users: User)

    @Query("SELECT * FROM cars") fun getAllCars(): List<Car>

    @Query("SELECT * FROM users") fun getAllUsers(): List<User>

    @Query("SELECT * FROM cars WHERE name LIKE :name") fun getAllCarsByName(name: String): List<Car>

    @Query("SELECT * FROM cars WHERE cars.userId = :userId") fun getCars(userId: Int?):List<Car>

    }