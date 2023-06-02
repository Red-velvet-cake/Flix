package com.red_velvet.flix.domain.usecase.movieUsecases

import com.red_velvet.flix.data.repository.MovieRepository
import com.red_velvet.flix.domain.mapper.movie.toModel
import com.red_velvet.flix.domain.model.movie.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetNowPlayingMoviesUsecase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        page: Int = 1,
        region: String? = null,
        language: String? = null
    ): Flow<List<Movie>> {
        return movieRepository.getNowPlayingMovies(page, region, language)
            .map { it.toModel() }
    }
}