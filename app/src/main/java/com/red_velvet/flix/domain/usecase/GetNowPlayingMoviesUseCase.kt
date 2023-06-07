package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.repository.MovieRepository
import javax.inject.Inject

class GetNowPlayingMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        page: Int? = null,
        region: String? = null,
        language: String? = null
    ): List<MovieEntity> {
        return movieRepository.getLocalNowPlayingMovies()
    }
}