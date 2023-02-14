package hr.foi.air.database1.data

import android.content.Context
import hr.foi.air.database1.DAO
import hr.foi.air.database1.MainDatabase
import hr.foi.air.database1.entities.*


class MockData {
    companion object{
        fun insertAllData(context : Context){
            val dao : DAO = MainDatabase.getInstance(context).getDao()

            var user : User = User()
            user.username = "marinoroz"
            user.password = "Marin123"
            user.id = 1

            var user1 : User = User()
            user1.username = "antunsmojvir"
            user1.password = "Antun123"
            user1.id = 2

            var car : Car = Car()
            car.name = "Golf 2"
            car.userId = user.id
            car.speed = 50
            car.id = 1
            car.titleImage = "https://i.imgur.com/DvpvklR.png"

            var car1 : Car = Car()
            car1.name = "Golf 7"
            car1.userId = user.id
            car1.speed = 120
            car1.id = 2
            car1.titleImage = "https://i.imgur.com/DvpvklR.png"

            var car2 : Car = Car()
            car2.name = "Audi A5"
            car2.userId = user1.id
            car2.speed = 250
            car2.id = 3
            car2.titleImage = "https://i.imgur.com/DvpvklR.png"

            dao.insertUsers(user,user1)
            dao.insertCars(car,car1,car2)

        }
    }
}