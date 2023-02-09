package hr.foi.air.database1.data

import android.content.Context
import hr.foi.air.database1.DAO
import hr.foi.air.database1.MainDatabase
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
            user.email = "marinoroz42@gmail.com"
            user.password = "Marin123"
            user.id = 1

            var car : Car = Car()
            car.name = "Golf 2"
            car.userId = user.id
            car.speed = 50
            car.id = 1

            var ride1 : Ride = Ride()
            ride1.id = 1
            ride1.carId = car.id
            ride1.distance = 2000
            ride1.obstacleCount = 2

            dao.insertUsers(user)
            dao.insertCars(car)
            dao.insertRides(ride1)

            var obstacle : Obstacle = Obstacle()
            obstacle.name = "Pješak"
            obstacle.description = "Uočen je pješak na pješačkom prijelazu"
            obstacle.actionId = action3.id
            obstacle.id = 0

            var obstacle1 : Obstacle = Obstacle()
            obstacle1.name = "Semafor-crveno"
            obstacle1.description = "Upalilo se crveno svjetlo na semaforu"
            obstacle1.actionId = action3.id
            obstacle1.id = 1

            var obstacle2 : Obstacle = Obstacle()
            obstacle2.name = "Desni zavoj"
            obstacle2.description = "Pojavio se desni zavoj"
            obstacle2.actionId = action.id
            obstacle2.id = 2

            var obstacle3 : Obstacle = Obstacle()
            obstacle3.name = "Lijevi zavoj"
            obstacle3.description = "Pojavio se lijevi zavoj"
            obstacle3.actionId = action1.id
            obstacle3.id = 3

            dao.insertObstacles(obstacle, obstacle1, obstacle2, obstacle3)

            /*var appear : IsAppearing = IsAppearing()
            appear.obstacleId = 2
            appear.rideId = 1
            appear.occuringDistance = 500

            var appear1 : IsAppearing = IsAppearing()
            appear1.obstacleId = 0
            appear1.rideId = 1
            appear1.occuringDistance = 1500

            dao.insertAppearances(appear, appear1)*/
        }
    }
}