package hr.foi.air.database1.data

import android.content.Context
import hr.foi.air.database1.DAO
import hr.foi.air.database1.MainDatabase
import hr.foi.air.database1.entities.Car
import hr.foi.air.database1.entities.Ride

class MockData {
    companion object{
        fun insertAllData(context : Context){
            var dao : DAO = MainDatabase.getInstance(context).getDao()

            var car : Car = Car()
            car.name = "Golf 2"
            car.speed = 50
            car.id = dao.insertCars(car)[0].toInt()

            var ride1 : Ride = Ride()
            ride1.carId = car.id
            ride1.distance = 3000
            ride1.obstacleCount = 2

            dao.insertRides(ride1)
        }
    }
}