package hr.foi.air.core.data


import hr.foi.air.core.R
import java.io.File
import java.io.InputStream

interface FileReader {
    //var inputStream : InputStream
    val lineList : ArrayList<String>

    fun ReaderFile(file:InputStream) : ArrayList<String>
}