package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.data.repository.MovieRepository
import com.red_velvet.flix.domain.model.movie.Movie
import javax.inject.Inject

class GetMoviesWatchlistUsecase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        accountId: Int,
        language: String? = null,
        page: Int? = null,
        sortBy: String? = null
    ): List<Movie> {
        return movieRepository.getMoviesWatchlist(accountId, language, page, sortBy)
    }
}