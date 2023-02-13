package hr.foi.air.core.simulation

import hr.foi.air.core.data.FileReader
import java.io.File
import java.io.InputStream
import kotlin.coroutines.coroutineContext

class FileToList : FileReader {

    //override var inputStream : InputStream  = File("C:/Users/Relaxic/Documents/jcc projekt/Frontend/Android/core/src/main/assets/textfile.txt").inputStream()
    override val lineList: ArrayList<String> = arrayListOf()
    override fun  ReaderFile(file: InputStream) : ArrayList<String>{
        file.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it) } }
        return lineList
    }
}