package com.red_velvet.flix.ui.home.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.red_velvet.flix.ui.base.BaseAdapter
import com.red_velvet.flix.BR
import com.red_velvet.flix.R
import com.red_velvet.flix.ui.base.BaseInteractionListener
import com.red_velvet.flix.ui.home.HomeUiState

class HomeAdapter(
    private var homeItems: MutableList<HomeUiState.HomeItem>,
    private val listener: BaseInteractionListener,
) : BaseAdapter<HomeUiState.HomeItem>(homeItems, listener) {
    override val layoutId: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return ItemViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), viewType, parent, false
            )
        )
    }


    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        if (homeItems.isNotEmpty()) bind(holder as ItemViewHolder, position)
    }

    private fun bind(holder: ItemViewHolder, position: Int) {
        if (position != -1) {
            val currentItem = homeItems[position]
            bindMovie(holder, currentItem)
        }
    }


    private fun bindMovie(
        holder: ItemViewHolder,
        currentItem: HomeUiState.HomeItem,
    ) {
        holder.binding.run {
            setVariable(BR.movieType, currentItem)
            setVariable(
                BR.adapterRecycler,
                MovieAdapter(currentItem.movies, listener as MovieInteractionListener)
            )
        }
    }

    override fun setItems(newItems: List<HomeUiState.HomeItem>) {
        homeItems = newItems.toMutableList()
        super.setItems(homeItems)
    }

    override fun areItemsTheSame(
        oldItem: HomeUiState.HomeItem, newItem: HomeUiState.HomeItem
    ): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(
        oldItem: HomeUiState.HomeItem,
        newItem: HomeUiState.HomeItem,
    ): Boolean {
        return oldItem == newItem
    }

    override fun getItemViewType(position: Int): Int {
        return when (homeItems[position].title) {

            "Popular" -> {
                Log.d(
                    "TAG",
                    "homeItems[position].title: ${homeItems[position].movies.first()}"
                )
                R.layout.item_popular_movie
            }

            else -> R.layout.list_movie
        }
    }
}