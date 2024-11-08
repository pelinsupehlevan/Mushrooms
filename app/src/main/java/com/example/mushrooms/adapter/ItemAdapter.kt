package com.example.mushrooms.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mushrooms.R
import com.example.mushrooms.model.Mushrooms

class ItemAdapter(private val context : Context, private val mushroomsList : List<Mushrooms>)
    : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{

            fun onItemClick(position : Int)

    }

    fun setOnItemClickListener(listener: onItemClickListener){

        mListener = listener

    }


    class ItemViewHolder(private val view: View, listener: onItemClickListener) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.mushroom_image)
        //val imageView2: ImageView = view.findViewById(R.id.mushroom_image2)
        val textView: TextView = view.findViewById(R.id.mushroom_name)
        val textView2: TextView = view.findViewById(R.id.species)

        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.mushroom, parent, false)
        return ItemViewHolder(itemView, mListener);
    }

    override fun getItemCount(): Int {
        return mushroomsList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = mushroomsList[position]
        holder.imageView.setImageResource(currentItem.titleImage)
        holder.textView.text = currentItem.mushroomName
        holder.textView2.text = currentItem.species
    }
}