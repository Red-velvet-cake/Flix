package com.red_velvet.flix.ui.moviesbykeyword.uiState

import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.ui.moviesbykeyword.uiState.MovieUiState

fun MovieEntity.toMovieUiStates() : MovieUiState {
    return MovieUiState(
        id = id,
        title = title,
        image = imageUrl,
        releaseDate = releaseDate
    )
}