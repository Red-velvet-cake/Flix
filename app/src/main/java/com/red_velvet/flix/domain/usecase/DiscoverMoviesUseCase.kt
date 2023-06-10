package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.repository.MovieRepository
import javax.inject.Inject

class DiscoverMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        page: Int? = null,
        sortBy: String? = null,
        rate: Float? = null,
        year: Int? = null
    ): List<MovieEntity> {
        return movieRepository.discoverMovies(page, sortBy, rate, year)
    }
}