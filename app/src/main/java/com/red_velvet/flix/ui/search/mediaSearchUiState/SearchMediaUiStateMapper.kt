package com.red_velvet.flix.ui.search.mediaSearchUiState

import com.red_velvet.flix.domain.mapper.Mapper
import com.red_velvet.flix.domain.model.movie.Movie
import javax.inject.Inject

class SearchMediaUiStateMapper @Inject constructor() : Mapper<Movie, MediaUiState> {
    override fun map(input: Movie): MediaUiState {
        return MediaUiState(
            input.id,
            input.title,
            input.imageUrl,
            input.voteAverage,
            input.popularity.toString(),
            input.releaseDate.toDouble(),
        )
    }
}