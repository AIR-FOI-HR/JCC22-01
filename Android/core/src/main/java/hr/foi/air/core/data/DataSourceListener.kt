package hr.foi.air.core.data

import hr.foi.air.core.entities.Car
import hr.foi.air.core.entities.User

interface DataSourceListener {
    fun onDataLoaded(users: List<User>?, cars: List<Car>?)
}
