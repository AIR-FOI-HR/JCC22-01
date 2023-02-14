package hr.foi.air.autosimulation

import android.content.Intent
import android.content.Intent.EXTRA_USER
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hr.foi.air.autosimulation.recyclerview.CarRecyclerAdapter
import hr.foi.air.autosimulation.repos.DataRepository
import hr.foi.air.autosimulation.repos.LoadDataListener
import hr.foi.air.core.entities.Car
import hr.foi.air.core.entities.User

class CarMenu : AppCompatActivity() {
    private lateinit var newRecycleview : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        displayCars()
    }

        fun displayCars(){
            var repository = DataRepository()
            val context = this

            val user = intent.getSerializableExtra(EXTRA_USER) as User
            var carList: ArrayList<Car> = arrayListOf()

            repository.loadData(this, object : LoadDataListener {
                override fun onDataLoaded(users: List<User>?, cars: List<Car>?)
                {
                    if (cars != null) {
                        for (Car in cars){
                            if (Car.userId == user.id)
                                carList.add(Car)
                        }
                    }
                    newRecycleview=findViewById(R.id.main_recycler)
                    newRecycleview.layoutManager = LinearLayoutManager(context)
                    var adapter = CarRecyclerAdapter(context, carList)
                    newRecycleview.adapter = adapter
                    adapter.setOnItemClickListener(object : CarRecyclerAdapter.onItemClickListener
                    {
                        override fun onItemClick(position: Int)
                        {
                            val intent = Intent(this@CarMenu, SimulationListView::class.java)
                            startActivity(intent)
                        }
                    })
                }
            })
        }
    }
