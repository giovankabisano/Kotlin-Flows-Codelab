package com.giovankabisano.kotlinflow.ui.listMovie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.giovankabisano.kotlinflow.R
import com.giovankabisano.kotlinflow.model.ResultsItem
import kotlinx.android.synthetic.main.item_layout.view.*

class ListMovieAdapter(
    private val movies: ArrayList<ResultsItem>
) : RecyclerView.Adapter<ListMovieAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: ResultsItem) {
            itemView.textViewUserName.text = movie.title
            itemView.textViewUserEmail.text = movie.releaseDate
            Glide.with(itemView.imageViewAvatar.context)
                .load("https://image.tmdb.org/t/p/w185${movie.posterPath}")
                .into(itemView.imageViewAvatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(movies[position])

    fun addData(list: List<ResultsItem>) {
        movies.addAll(list)
    }

}