package com.red_velvet.flix.ui.home.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.red_velvet.flix.ui.base.BaseAdapter
import com.red_velvet.flix.BR
import com.red_velvet.flix.R
import com.red_velvet.flix.ui.base.BaseInteractionListener
import com.red_velvet.flix.ui.home.HomeUiState


class TvShowsAdapter(
    private var tvshowTabItems: MutableList<HomeUiState.HomeItem>,
    private val listener: BaseInteractionListener,
) : BaseAdapter<HomeUiState.HomeItem>(tvshowTabItems, listener) {
    override val layoutId: Int = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return ItemViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), viewType, parent, false
            )
        )
    }


    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        if (tvshowTabItems.isNotEmpty()) bind(holder as ItemViewHolder, position)
    }

    private fun bind(holder: ItemViewHolder, position: Int) {
        if (position != -1) {
            val currentItem = tvshowTabItems[position]
            bindMovie(holder, currentItem)
        }
    }


    private fun bindMovie(
        holder: ItemViewHolder,
        currentItem: HomeUiState.HomeItem,
    ) {
        Log.d("TvShowsAdapter", "TvShowsAdapter $currentItem")
        holder.binding.run {
            setVariable(BR.tvshowType, currentItem)
            if (currentItem.title == "Popular Series") {
                setVariable(
                    BR.popularTvShowsAdapterRecycler, PopularTVShowMediaAdapter(
                        currentItem.items, listener as PopularTvShowInteractionListener
                    )
                )
            } else {
                setVariable(
                    BR.adapterRecyclerTVShow, TVShowMediaAdapter(
                        currentItem.items, listener as TvShowInteractionListener
                    )
                )
            }

        }
    }

    override fun setItems(newItems: List<HomeUiState.HomeItem>) {
        tvshowTabItems = newItems.toMutableList()
        super.setItems(tvshowTabItems)
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
        return when (tvshowTabItems[position].title) {
            "Popular Series" -> R.layout.popular_tvshows_list
            else -> R.layout.list_tvshow
        }
    }
}