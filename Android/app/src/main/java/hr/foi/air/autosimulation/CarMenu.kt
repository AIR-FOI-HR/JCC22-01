package hr.foi.air.autosimulation

import android.content.Intent.EXTRA_USER
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import hr.foi.air.database1.MainDatabase
import hr.foi.air.database1.entities.*
import java.lang.Thread.sleep

class CarMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var db = MainDatabase.getInstance(this)

        val currentUser = intent.getSerializableExtra(EXTRA_USER) as User
        val userCars : List<Car> = db.getDao().getCars(currentUser.id)

        //val obstacleList : List<Obstacle> = db.getDao().getObstacles()

        /*for (Car in userCars){
            Log.d("cars", Car.name + " - " + Car.speed + "km/h")
        }*/

        val carRide : Ride = db.getDao().getRide(userCars[0].id!!)
        Log.d("cars", carRide.distance.toString())

        val obstaclesOnRide : List<Obstacle> = db.getDao().getObstacles(carRide.rideId!!)

        var distance = carRide.distance
        while(distance!! >= 0){
            Log.d("cars", distance.toString())
            for (Obstacle in obstaclesOnRide){
                var appearance : IsAppearing = db.getDao().getObstacleAppearance(Obstacle.obstacleId!!)
                if (appearance.occuringDistance == distance){
                    Log.d("cars", Obstacle.name + " - " + Obstacle.description)
                    var action : Action = db.getDao().getActionForObstacle(Obstacle.actionId!!)
                    Log.d("cars", action.name)
                    sleep(3000)
                }
            }
            distance--
        }
    }
}