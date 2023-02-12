package hr.foi.air.database1.data

import android.content.Context
import hr.foi.air.database1.DAO
import hr.foi.air.database1.MainDatabase
import hr.foi.air.database1.R
import hr.foi.air.database1.entities.*

class MockData {
    companion object{
        fun insertAllData(context : Context){
            var dao : DAO = MainDatabase.getInstance(context).getDao()

            var action : Action = Action()
            action.name = "skreni-desno"
            action.id = 0

            var action1 : Action = Action()
            action1.name = "skreni-lijevo"
            action1.id = 1

            var action2 : Action = Action()
            action2.name = "kreni"
            action2.id = 2

            var action3 : Action = Action()
            action3.name = "stani"
            action3.id = 3

            dao.insertActions(action, action1, action2, action3)

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
            car.titleImage = 0

            var car1 : Car = Car()
            car1.name = "Golf 7"
            car1.userId = user.id
            car1.speed = 120
            car1.id = 2
            car1.titleImage = 1

            var car2 : Car = Car()
            car2.name = "Audi A5"
            car2.userId = user1.id
            car2.speed = 250
            car2.id = 3
            car2.titleImage = 2

            var ride1 : Ride = Ride()
            ride1.rideId = 1
            ride1.carId = car.id
            ride1.distance = 50
            ride1.obstacleCount = 2

            dao.insertUsers(user,user1)
            dao.insertCars(car,car1,car2)
            dao.insertRides(ride1)

            var obstacle : Obstacle = Obstacle()
            obstacle.name = "Pješak"
            obstacle.description = "Uočen je pješak na pješačkom prijelazu"
            obstacle.actionId = action3.id
            obstacle.obstacleId = 0

            var obstacle1 : Obstacle = Obstacle()
            obstacle1.name = "Semafor-crveno"
            obstacle1.description = "Upalilo se crveno svjetlo na semaforu"
            obstacle1.actionId = action3.id
            obstacle1.obstacleId = 1

            var obstacle2 : Obstacle = Obstacle()
            obstacle2.name = "Desni zavoj"
            obstacle2.description = "Pojavio se desni zavoj"
            obstacle2.actionId = action.id
            obstacle2.obstacleId = 2

            var obstacle3 : Obstacle = Obstacle()
            obstacle3.name = "Lijevi zavoj"
            obstacle3.description = "Pojavio se lijevi zavoj"
            obstacle3.actionId = action1.id
            obstacle3.obstacleId = 3

            dao.insertObstacles(obstacle, obstacle1, obstacle2, obstacle3)

            var appear : IsAppearing = IsAppearing()
            appear.obstacleId = 2
            appear.rideId = 1
            appear.occuringDistance = 15

            var appear1 : IsAppearing = IsAppearing()
            appear1.obstacleId = 0
            appear1.rideId = 1
            appear1.occuringDistance = 40

            dao.insertAppearances(appear, appear1)
        }
    }
}