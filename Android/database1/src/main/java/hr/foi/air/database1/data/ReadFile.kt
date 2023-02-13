package hr.foi.air.database1.data

import android.content.Context
import android.util.Log
import android.widget.ListView
import hr.foi.air.database1.R
import java.io.IOException
import java.io.InputStream

class ReadFile {
    fun readInputFile(context: Context) : InputStream{
        val assetManager = context.assets
        val inputStream = assetManager.open("textfile.txt")
        return inputStream
    }
        /*val path = "textfile.txt"
        var inputStream: InputStream? = null
        try {
            inputStream =
        } catch (e: IOException) {
            Log.e("Error", "Failed to open file: $path", e)
        }
        val ListViews = findViewById<ListView>(R.id.userlist)
        if (ListViews == null) {
            Log.e("Error", "ListView with ID R.id.userlist not found")
    }*/
}