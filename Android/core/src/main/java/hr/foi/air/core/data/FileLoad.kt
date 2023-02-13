package hr.foi.air.core.data


import android.content.Context
import java.io.InputStream

interface FileLoad {
    val lineList : ArrayList<String>
    fun loadFile(context: Context) : ArrayList<String>
}