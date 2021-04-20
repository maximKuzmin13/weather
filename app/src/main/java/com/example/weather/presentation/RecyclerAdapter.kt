package com.example.weather.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.R
import com.example.weather.data.TempItem

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder>() {

    private var listTemp: List<TempItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_recycler, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val temp : TempItem = getTemp(position)
        holder.titleText.text = temp.day.toString()

    }

    override fun getItemCount(): Int = listTemp.size

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleText: TextView = itemView.findViewById(R.id.text)
    }

    private fun getTemp(position: Int): TempItem{
        return listTemp[position]
    }

    fun setTemp(temp: List<TempItem>) {
        this.listTemp = temp
        notifyDataSetChanged()
    }
}