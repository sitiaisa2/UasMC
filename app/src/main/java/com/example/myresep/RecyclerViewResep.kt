package com.example.myresep

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewResep (
    private  val context : Context,
    private  val reseps : List<Resep>,
    private val listener : (Resep) -> Unit)
    : RecyclerView.Adapter<RecyclerViewResep.ResepViewHolder>() {

    class ResepViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        private val image = view.findViewById<ImageView>(R.id.resepImg)
        private val title = view.findViewById<TextView>(R.id.resepTitle)


        fun bindView(resep: Resep, listener: (Resep) -> Unit) {
            image.setImageResource(resep.R_image)
            title.text = resep.R_title
            itemView.setOnClickListener{ listener (resep)}

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResepViewHolder
    = ResepViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview_item,parent,false))

    override fun getItemCount(): Int = reseps.size

    override fun onBindViewHolder(holder: ResepViewHolder, position: Int) {
        holder.bindView(reseps[position], listener)
    }

}
