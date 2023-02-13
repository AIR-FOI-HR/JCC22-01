package hr.foi.air.database1.data

import android.content.Context
import hr.foi.air.core.data.FileLoad
import java.io.InputStream

class FileDataSource : FileLoad {
    override val lineList: ArrayList<String> = arrayListOf()
    override fun loadFile(context: Context) : ArrayList<String>{
        var file : InputStream = ReadFile().readInputFile(context)
        file.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it) } }
        return lineList
    }
}