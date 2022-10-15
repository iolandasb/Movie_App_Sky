package com.example.movieappsky.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieappsky.R
import com.example.movieappsky.data.Constants
import com.example.movieappsky.domain.model.Movies
import com.example.movieappsky.presentation.ClickListener

class MoviesAdapter(
    val context: Context,
    var dataset: MutableList<Movies> = mutableListOf(),
    var datasetFilter: MutableList<Movies> = mutableListOf(),
    var clickListener: ClickListener? = null
) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>()
{


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        var imgMovie: ImageView? = view.findViewById(R.id.imgMovie)
        var titleMovie: TextView? = view.findViewById(R.id.titleMovie)
        var yearMovie: TextView? = view.findViewById(R.id.yearMovie)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder
    {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.movies_items, viewGroup, false)

        val viewHolder = ViewHolder(view)

        view.setOnClickListener {
            clickListener?.onClickListener(
                listOf(datasetFilter[viewHolder.adapterPosition]),
                viewHolder.adapterPosition
            )
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        if (dataset[position].poster !== "")
        {
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
//
//    fun updateList(list: MutableList<Movies>) {
//        dataset = list
//        notifyDataSetChanged()
//    }

    override fun getItemCount() = dataset.size

    fun getFilter(): Filter = MoviesFilter()

    private inner class MoviesFilter : Filter() {
        override fun performFiltering(constraint: CharSequence): FilterResults
        {
            val searchString = constraint.toString()
            val filterResults = FilterResults()
            var filteredList: MutableList<Movies> = mutableListOf()
            if (searchString.isEmpty()) {
                datasetFilter = dataset
            }
            else
            {
                val filteredList: MutableList<Movies> = mutableListOf()
                for (movies in dataset)
                {
                    if (movies.title?.lowercase()?.contains(searchString) == true)
                    {
                        filteredList.plus(movies)
                    }
                }
                datasetFilter = filteredList
            }
            filterResults.values = filteredList
            return filterResults
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            if (results != null && results.count > 0) {
                datasetFilter = (results.values as List<Movies>).toMutableList()
                notifyDataSetChanged()
            }
        }
    }
}