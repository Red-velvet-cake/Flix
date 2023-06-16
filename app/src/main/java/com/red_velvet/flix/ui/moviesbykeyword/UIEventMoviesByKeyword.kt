package com.red_velvet.flix.ui.moviesbykeyword

sealed class UIEventMoviesByKeyword {
    data class NavigateToMovieDetail(val movieId: Int) : UIEventMoviesByKeyword()
}