package hr.foi.air.database1.data

import android.content.Context
import hr.foi.air.core.data.DataSourceListener
import hr.foi.air.database1.DAO
import hr.foi.air.database1.MainDatabase
import hr.foi.air.database1.entities.Car
import hr.foi.air.database1.entities.User
import hr.foi.air.core.data.DataSource

class DbDataSource : DataSource {
    private var dao : DAO? = null

    override fun loadData(dataSourceListener: DataSourceListener, context: Context){
        //Unos podataka u bazu
        dao = MainDatabase.getInstance(context).getDao()

        //val currentUser = intent.getSerializableExtra(Intent.EXTRA_USER) as User
        //val userCars : List<Car>? = dao?.getCars(currentUser.id)

        var users : List<User>? = dao?.getAllUsers()
        var cars : List<Car>? = dao?.getAllCars()

        dataSourceListener.onDataLoaded(users, cars)
    }
}