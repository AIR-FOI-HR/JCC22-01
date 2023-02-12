package hr.foi.air.autosimulation.repos

import hr.foi.air.core.entities.Car
import hr.foi.air.core.entities.User

interface LoadDataListener {
    fun onDataLoaded(users: List<User>?, cars: List<Car>?)
}
