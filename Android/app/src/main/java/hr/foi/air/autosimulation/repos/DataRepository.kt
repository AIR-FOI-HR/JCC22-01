package hr.foi.air.autosimulation.repos

import android.content.Context
import hr.foi.air.core.data.DataSource
import hr.foi.air.core.data.DataSourceListener
import hr.foi.air.core.entities.Car
import hr.foi.air.core.entities.User
import hr.foi.air.database1.data.DbDataSource

class DataRepository {
    fun loadData(context: Context, listener: LoadDataListener)
    {
        var dataSource : DataSource?
        dataSource = DbDataSource()

        dataSource.loadData(
            object : DataSourceListener{
                override fun onDataLoaded(users: List<User>?, cars: List<Car>?) {
                    listener.onDataLoaded(users, cars)
                }
            },
            context
        )
    }
}