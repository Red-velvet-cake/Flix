package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.model.movie.MovieEntity
import com.red_velvet.flix.domain.repository.MovieRepository
import javax.inject.Inject

class GetFavoriteMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        accountId: Int,
        language: String? = null,
        page: Int? = null,
        sortBy: String? = null
    ): List<MovieEntity> {
        return movieRepository.getFavoriteMovies(accountId, language, page, sortBy)
    }
}