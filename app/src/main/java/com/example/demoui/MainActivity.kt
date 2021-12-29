package com.example.demoui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.demoui.Utils.Companion.getJsonDataFromAsset
import com.example.demoui.databinding.ActivityMainBinding
import com.google.gson.Gson
import android.util.DisplayMetrics





private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val jsonFileString = getJsonDataFromAsset(applicationContext, "widget.json")

        val gson = Gson()

        val widget:Widget = gson.fromJson(jsonFileString,Widget::class.java)
        widget.ascpectRatio?.let { calculateImageDimension(it) }
        Log.d(TAG, "widget: "+widget)
        val items: List<Item> = widget.collections

        binding.recyclerView.layoutManager = GridLayoutManager(this,3)
        binding.recyclerView.adapter = ItemAdapter(items)
    }

    fun calculateImageDimension(aspectRatio:Double){
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
//        val height = displayMetrics.heightPixels
        val width = displayMetrics.widthPixels
        val height = width/aspectRatio
        Log.d(TAG, "calculateImageDimension: width"+width)
        Log.d(TAG, "calculateImageDimension: height"+height)

    }
}