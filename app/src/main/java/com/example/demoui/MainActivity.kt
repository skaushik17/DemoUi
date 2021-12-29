package com.example.demoui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.demoui.Utils.Companion.getJsonDataFromAsset
import com.example.demoui.databinding.ActivityMainBinding
import com.google.gson.Gson


private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val jsonFileString = getJsonDataFromAsset(applicationContext, "widget.json")

        val gson = Gson()

        val widget:Widget = gson.fromJson(jsonFileString,Widget::class.java)
        Log.d(TAG, "widget: "+widget)
        val items: List<Item> = widget.collections

        binding.recyclerView.layoutManager = GridLayoutManager(this,2)
        binding.recyclerView.adapter = ItemAdapter(items)
    }
}