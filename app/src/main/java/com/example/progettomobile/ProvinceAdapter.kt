package com.example.progettomobile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview.view.*

class ProvinceAdapter(
    private val list: List<ProvinceModel>,
    private val listener: OnItemClickListener
) :
    RecyclerView.Adapter<ProvinceAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview,
            parent, false)
        return ViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = list[position]

        holder.imageView.setImageResource(currentItem.img)
        holder.textView.setText(currentItem.text)

    }
    override fun getItemCount() = list.size

    //inner è l'equivalente a static in java
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val imageView: ImageView = itemView.img
        val textView: TextView = itemView.text
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}