package hr.foi.air.database1.data

import android.content.Context
import hr.foi.air.database1.DAO
import hr.foi.air.database1.MainDatabase


class DataRepository(context: Context) {
    private var dao: DAO? = null

    init{
        dao = MainDatabase.getInstance(context).getDao()
    }

}