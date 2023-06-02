package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.data.repository.MovieRepository
import com.red_velvet.flix.domain.mapper.movie.toPopularMoviesModels
import com.red_velvet.flix.domain.model.movie.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetPopularMoviesUsecase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        page: Int? = null,
        region: String? = null,
        language: String? = null
    ): Flow<List<Movie>> {
        return movieRepository.getPopularMovies(page, region, language)
            .map { it.toPopularMoviesModels() }
    }
}