package com.red_velvet.flix.ui.movieDetails

import com.red_velvet.flix.R
import com.red_velvet.flix.ui.base.BaseAdapter
import com.red_velvet.flix.ui.base.BaseInteractionListener

class MovieKeywordsAdapter(
    keywords:List<MovieUiState.MovieKeywords>,
    listener: BaseInteractionListener
):BaseAdapter<MovieUiState.MovieKeywords>(keywords,listener) {
    override val layoutId: Int = R.layout.item_keywords_movie_details
}
interface MovieKeywordsInteractionListener:BaseInteractionListener
{
    fun onKeywordClick(keyword:String)
}