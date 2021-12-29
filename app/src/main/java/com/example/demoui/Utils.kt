package com.example.demoui

import android.content.Context
import java.io.IOException

import java.io.InputStream
import java.text.SimpleDateFormat
import java.util.*


class Utils {

    companion object{
        fun getJsonDataFromAsset(context: Context, fileName: String): String? {
            val jsonString: String
            try {
                jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
            } catch (ioException: IOException) {
                ioException.printStackTrace()
                return null
            }
            return jsonString
        }

        fun epochToTime(timeinepoch: Long):String?
        {
            //Unix seconds
            val unix_seconds: Long =timeinepoch
            //convert seconds to milliseconds
            val date = Date(unix_seconds * 1000L)
            // format of the date
            val jdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss z")
            jdf.timeZone = TimeZone.getTimeZone("GMT-4")
            return jdf.format(date).toString()
        }
    }
}