package com.example.demoui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ItemAdapter(var items:List<Item>): RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.top_category_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

}

class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
    private lateinit var item:Item

    private var image:ImageView = itemView.findViewById(R.id.top_iv_item)
    private val title: TextView = itemView.findViewById(R.id.tv_name)

    fun bind(item:Item){
        this.item = item
        Log.d("Picasso", "bind: "+item.imgUrl)
        Picasso.get().load(item.imgUrl).into(image)
        title.text = this.item.tileTitle
    }
}