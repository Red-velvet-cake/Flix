package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.repository.MovieRepository
import javax.inject.Inject

class DiscoverMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        includeAdult: Boolean = false,
        language: String? = null,
        page: Int? = null,
        sortBy: String? = null,
        voteAverageGte: Double? = null,
        year: Int? = null
    ): List<MovieEntity> {
        return movieRepository.discoverMovies(
            includeAdult,
            language,
            page,
            sortBy,
            voteAverageGte,
            year
        )
    }
}