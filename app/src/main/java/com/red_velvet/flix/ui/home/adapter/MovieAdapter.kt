package com.red_velvet.flix.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.red_velvet.flix.ui.base.BaseAdapter
import com.red_velvet.flix.BR
import com.red_velvet.flix.R
import com.red_velvet.flix.ui.base.BaseInteractionListener
import com.red_velvet.flix.ui.home.MovieUiState

class MovieAdapter(
    private var movieTabItems: MutableList<MovieUiState.MovieTabItem>,
    private val listener: BaseInteractionListener,
) : BaseAdapter<MovieUiState.MovieTabItem>(movieTabItems, listener) {
    override val layoutId: Int = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return ItemViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), viewType, parent, false
            )
        )
    }


    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        if (movieTabItems.isNotEmpty()) bind(holder as ItemViewHolder, position)
    }

    private fun bind(holder: ItemViewHolder, position: Int) {
        if (position != -1) {
            val currentItem = movieTabItems[position]
            bindMovie(holder, currentItem)
        }
    }


    private fun bindMovie(
        holder: ItemViewHolder,
        currentItem: MovieUiState.MovieTabItem,
    ) {
        holder.binding.run {
            setVariable(BR.movieType, currentItem)
            if (currentItem.title == "Popular Movies") {
                setVariable(
                    BR.popularMoviesAdapterRecycler,
                    PopularMovieMediaAdapter(
                        currentItem.movies,
                        listener as PopularMovieInteractionListener
                    )
                )
            } else {
                setVariable(
                    BR.adapterRecycler,
                    MovieMediaAdapter(
                        currentItem.movies,
                        listener as MovieInteractionListener
                    )
                )
            }

        }
    }

    override fun setItems(newItems: List<MovieUiState.MovieTabItem>) {
        movieTabItems = newItems.toMutableList()
        super.setItems(movieTabItems)
    }

    override fun areItemsTheSame(
        oldItem: MovieUiState.MovieTabItem, newItem: MovieUiState.MovieTabItem
    ): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(
        oldItem: MovieUiState.MovieTabItem,
        newItem: MovieUiState.MovieTabItem,
    ): Boolean {
        return oldItem == newItem
    }

    override fun getItemViewType(position: Int): Int {
        return when (movieTabItems[position].title) {
            "Popular Movies" -> R.layout.popular_movies_list
            else -> R.layout.list_movie
        }
    }
}