package hr.foi.air.autosimulation.repos

import android.content.Context
import hr.foi.air.core.simulation.SolutionMakerClass
import hr.foi.air.database1.data.FileDataSource

class FileRepository(private val context: Context) {
    fun initializeSimulation() : ArrayList<String>{
        var readerLists = FileDataSource()
        var solution = SolutionMakerClass()

        val lista = readerLists.loadFile(context)
        val lista2 : ArrayList<String> = arrayListOf()
        for(a in lista){
            if(a!="-"){
                lista2.add(a)
                var sol  = solution.makeSolution(a)
                lista2.add(sol)
            }
        }
        return lista2
    }
}