package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.model.movie.Movie
import com.red_velvet.flix.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTopRatedMoviesUsecase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        page: Int? = null,
        region: String? = null,
        language: String? = null
    ): Flow<List<Movie>> {
        return movieRepository.getTopRatedMovies(page, region, language)
    }
}