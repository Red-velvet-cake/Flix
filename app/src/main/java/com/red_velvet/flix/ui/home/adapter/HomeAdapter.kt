package com.red_velvet.flix.ui.home.adapter

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
        if (homeItems.isNotEmpty())
            bind(holder as ItemViewHolder, position)
    }

    private fun bind(holder: ItemViewHolder, position: Int) {
        if (position != -1) {
            val currentItem = homeItems[position]
            bindMovie(holder, currentItem.movies, currentItem.title)
        }
    }


    private fun bindMovie(
        holder: ItemViewHolder,
        items: List<HomeUiState.MediaUiState>,
        title: String
    ) {
        holder.binding.run {
            setVariable(
                BR.adapterRecycler,
                MovieAdapter(items, listener as MovieInteractionListener)
            )
            setVariable(BR.movieType, title)
        }
    }

//    override fun setItems(newItems: List<HomeItem>) {
//        homeItems = newItems.sortedBy { it.priority }.toMutableList()
//        super.setItems(homeItems)
//    }

//    override fun areItemsTheSame(oldItem: HomeItem, newItem: HomeItem): Boolean {
//        return oldItem.priority == newItem.priority
//    }
//
//    override fun areContentsTheSame(
//        oldItem: HomeItem,
//        newItem: HomeItem,
//    ): Boolean {
//        return oldItem == newItem
//    }


    override fun getItemViewType(position: Int): Int {
        return R.layout.list_movie
    }
//    override fun getItemViewType(position: Int): Int {
//        if (homeItems.isNotEmpty()) {
//            return when (homeItems[position]) {
//                is HomeItem.Popular -> R.layout.list_movie
//                is HomeItem.NowPlaying -> R.layout.list_movie
//                is HomeItem.Upcoming -> R.layout.list_movie
//                is HomeItem.TopRated -> R.layout.list_movie
//            }
//        }
//        return -1
//    }
}