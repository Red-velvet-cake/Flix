package com.red_velvet.flix.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.red_velvet.flix.ui.base.BaseAdapter
import com.red_velvet.flix.BR
import com.red_velvet.flix.R
import com.red_velvet.flix.ui.base.BaseInteractionListener
import com.red_velvet.flix.ui.home.TvShowUiState

class TvShowAdapter(
    private var tvshowTabItems: MutableList<TvShowUiState.TvShowItem>,
    private val listener: BaseInteractionListener,
) : BaseAdapter<TvShowUiState.TvShowItem>(tvshowTabItems, listener) {
    override val layoutId: Int = 1
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
        currentItem: TvShowUiState.TvShowItem,
    ) {
        holder.binding.run {
            setVariable(BR.tvshowType, currentItem)
            if (currentItem.title == "Popular Series") {
                setVariable(
                    BR.popularTvShowsAdapterRecycler,
                    PopularMediaAdapter(
                        currentItem.tvshows,
                        listener as PopularTvShowInteractionListener,
                        R.layout.popular_tvshow_item
                    )
                )
            } else {
                setVariable(
                    BR.adapterRecycler,
                    MediaAdapter(
                        currentItem.tvshows,
                        listener as TvShowInteractionListener,
                        R.layout.item_tvshow
                    )
                )
            }

        }
    }

    override fun setItems(newItems: List<TvShowUiState.TvShowItem>) {
        tvshowTabItems = newItems.toMutableList()
        super.setItems(tvshowTabItems)
    }

    override fun areItemsTheSame(
        oldItem: TvShowUiState.TvShowItem, newItem: TvShowUiState.TvShowItem
    ): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(
        oldItem: TvShowUiState.TvShowItem,
        newItem: TvShowUiState.TvShowItem,
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