package com.red_velvet.flix.ui.search.adapter

import com.red_velvet.flix.R
import com.red_velvet.flix.ui.base.BaseAdapter
import com.red_velvet.flix.ui.base.BaseInteractionListener
import com.red_velvet.flix.ui.search.mediaSearchUiState.MediaUiState

class MediaSearchAdapter(items: List<MediaUiState>, listener: MediaSearchInteractionListener) :
    BaseAdapter<MediaUiState>(items, listener) {
    override val layoutId: Int = R.layout.item_search

}

interface MediaSearchInteractionListener : BaseInteractionListener {
    fun onClickMediaResult(media: MediaUiState)
    fun onClickPersonResult(personId: Int, name:String)
}