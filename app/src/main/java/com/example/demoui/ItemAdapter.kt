package com.example.demoui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(var items:List<Item>): RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.shop_by_price_item, parent, false)
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

//    private val image:ImageView = itemView.findViewById(R.id.iv_item)
    private val itemTitle: TextView = itemView.findViewById(R.id.tv_item_name)
    private val itemSubtitle:TextView = itemView.findViewById(R.id.tv_item_price)

    fun bind(item:Item){
        this.item = item
        itemTitle.text = this.item.tileTitle
        itemSubtitle.text = this.item.tileSubTitle
    }
}