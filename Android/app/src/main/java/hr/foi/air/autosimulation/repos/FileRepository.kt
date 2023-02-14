package hr.foi.air.autosimulation.repos

import android.content.Context
import hr.foi.air.core.simulation.SolutionMakerClass
import hr.foi.air.database1.data.FileDataSource

class FileRepository(private val context: Context) {
    fun initializeSimulation() : ArrayList<String>{
        var readerLists = FileDataSource()
        var solution = SolutionMakerClass()

        val loadList = readerLists.loadFile(context)
        val readList : ArrayList<String> = arrayListOf()
        for(a in loadList){
            if(a!="-"){
                readList.add(a)
                var sol  = solution.makeSolution(a)
                readList.add(sol)
            }
        }
        return readList
    }
}