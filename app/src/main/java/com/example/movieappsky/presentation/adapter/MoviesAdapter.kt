package com.example.movieappsky.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieappsky.R
import com.example.movieappsky.data.Constants
import com.example.movieappsky.domain.model.Movies

class MoviesAdapter(
    val context: Context,
    var dataset: MutableList<Movies> = mutableListOf(),
    var datasetFull: MutableList<Movies> = mutableListOf()
) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imgMovie: ImageView? = view.findViewById(R.id.imgMovie)
        var titleMovie: TextView? = view.findViewById(R.id.titleMovie)
        var yearMovie: TextView? = view.findViewById(R.id.yearMovie)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.movies_items, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (dataset[position].poster !== "") {
            holder.imgMovie?.let {
                Glide.with(context)
                    .load(Constants.BASE_URL_IMAGE.value + dataset[position].poster)
                    .placeholder(R.drawable.img_reference)
                    .into(it)
            }
        }
        holder.titleMovie?.text = dataset[position].title
        holder.yearMovie?.text = dataset[position].year
    }

    fun searchList(dataset: MutableList<Movies>) {
        this.dataset = dataset
        datasetFull = ArrayList(dataset)
    }

    fun updateList(list: MutableList<Movies>){
        dataset = list
        notifyDataSetChanged()
    }

    override fun getItemCount() = dataset.size
}