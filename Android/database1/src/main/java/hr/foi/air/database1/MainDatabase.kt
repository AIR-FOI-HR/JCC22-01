package hr.foi.air.database1

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import hr.foi.air.database1.entities.Car
import hr.foi.air.database1.entities.User

@Database(version = 1, entities = [Car::class, User::class] , views = [], exportSchema = false )
abstract class MainDatabase : RoomDatabase() {
    abstract fun getDao() : DAO
    companion object{
        private var instance : MainDatabase? = null
        fun getInstance(context : Context) : MainDatabase{
            if (instance == null){
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    MainDatabase::class.java, "autoSim.db"
                ).allowMainThreadQueries().build()
            }
            return instance as MainDatabase
        }
    }
}