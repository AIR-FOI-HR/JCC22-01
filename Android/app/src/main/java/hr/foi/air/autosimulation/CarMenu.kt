package hr.foi.air.autosimulation

import android.content.Intent.EXTRA_USER
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import hr.foi.air.autosimulation.databinding.ActivityLoginBinding
import hr.foi.air.autosimulation.databinding.ActivityMainBinding
import hr.foi.air.autosimulation.repos.DataRepository
import hr.foi.air.autosimulation.repos.LoadDataListener
import hr.foi.air.database1.MainDatabase
import hr.foi.air.database1.entities.*
import java.lang.Thread.sleep
import hr.foi.air.core.entities.User
import hr.foi.air.core.entities.Car
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hr.foi.air.autosimulation.recyclerview.CarRecyclerAdapter

class CarMenu : AppCompatActivity() {
    private lateinit var newRecycleview : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        /*var db = MainDatabase.getInstance(this)

        val currentUser = intent.getSerializableExtra(EXTRA_USER) as User
        val userCars: List<Car> = db.getDao().getCars(currentUser.id)

        val carRide: Ride = db.getDao().getRide(userCars[0].id!!)
        Log.d("cars", carRide.distance.toString())

        val obstaclesOnRide: List<Obstacle> = db.getDao().getObstacles(carRide.rideId!!)

        var distance = carRide.distance
        while (distance!! >= 0) {
            Log.d("cars", distance.toString())
            for (Obstacle in obstaclesOnRide) {
                var appearance: IsAppearing =
                    db.getDao().getObstacleAppearance(Obstacle.obstacleId!!)
                if (appearance.occuringDistance == distance) {
                    Log.d("cars", Obstacle.name + " - " + Obstacle.description)
                    var action: Action = db.getDao().getActionForObstacle(Obstacle.actionId!!)
                    Log.d("cars", action.name)
                    sleep(3000)
                }
            }
            distance--
        }

         */

        displayCars(binding)
    }

        fun displayCars(binding: ActivityMainBinding){
            var repository = DataRepository()
            val context = this

            repository.loadData(this, object : LoadDataListener {
                override fun onDataLoaded(
                    users: List<User>?,
                    cars: List<Car>?
                ) {
                    if (cars!=null){
                        Log.d("cars",cars[1].name)
                        //binding.mainRecycler.layoutManager = LinearLayoutManager(context)
                        //binding.mainRecycler.adapter =CarRecyclerAdapter(cars)
                        newRecycleview=findViewById(R.id.main_recycler)
                        newRecycleview.layoutManager = LinearLayoutManager(context)
                        newRecycleview.adapter = CarRecyclerAdapter(cars)
                    }
                }
            })
        }
    }
