package hr.foi.air.autosimulation

import android.content.Intent
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
import java.text.FieldPosition

class CarMenu : AppCompatActivity() {
    private lateinit var newRecycleview : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val binding = ActivityMainBinding.inflate(layoutInflater)

        displayCars()
    }

        fun displayCars(){
            var repository = DataRepository()
            val context = this

            repository.loadData(this, object : LoadDataListener {
                open override fun onDataLoaded(
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
                    var adapter = CarRecyclerAdapter(cars!!)
                    adapter.setOnItemClickListener(object : CarRecyclerAdapter.onItemClickListener{
                        override fun onItemClick(position: Int){
                            val intent = Intent(this@CarMenu, SimulationListView::class.java)
                            intent.putExtra("heading", cars[position].name)

                            startActivity(intent)
                        }
                    })
                }
            })
        }
    }
