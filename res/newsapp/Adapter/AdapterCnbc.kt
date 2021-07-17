package com.pedro.newsapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pedro.newsapp.Model.dataModelCnbc
import com.pedro.newsapp.R
import com.squareup.picasso.Picasso

class AdapterCnbc (private val list: ArrayList<dataModelCnbc>) : RecyclerView.Adapter<AdapterCnbc.CnbcViewHolder>() {
    inner class CnbcViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bind(dataModelCnbc: dataModelCnbc){
            with(itemView){

                val title : TextView = findViewById(R.id.judul)
                val description : TextView = findViewById(R.id.deskripsi)
                val tanggal : ImageView = findViewById(R.id.thumb)

                title.text = "${dataModelCnbc.title}"
                description.text = "${dataModelCnbc.genre}"

                Picasso.get()
                    .load(dataModelCnbc.thumbnail)
                    .resize(400, 240)
                    .centerCrop()
                    .into(tanggal)



            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CnbcViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.data_cnbc , parent , false)
        return CnbcViewHolder(view)
    }

    override fun onBindViewHolder(holder: CnbcViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}