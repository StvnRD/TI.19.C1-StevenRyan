package com.stevenryandarmawan.listfilmterbaik.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdapterFilm(private val  context : Context,
                  private var data : List<Film>?,
                  private val itemclick : OnClickListener)
    : RecyclerView.Adapter<AdapterFilm.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val  binding = ListItemFilmBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data?.get(position)
        holder.foto.setImageResource(item?.foto ?:0)
        holder.nama.text = item?.judul

        holder.itemView.setOnClickListener {
            itemclick.detailData(item)
        }
    }

    override fun getItemCount(): Int = data?.size ?:0

    inner class ViewHolder( val binding: ListItemFilmBinding): RecyclerView.ViewHolder(binding.root)   {
        var foto = binding.image
        var nama = binding.txtnama

    }

    interface OnClickListener {
        fun detailData(item : Film?)
    }
}