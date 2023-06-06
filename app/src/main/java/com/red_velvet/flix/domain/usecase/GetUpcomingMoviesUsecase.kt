package com.red_velvet.flix.domain.usecase

import android.util.Log
import com.red_velvet.flix.data.repository.MovieRepository
import com.red_velvet.flix.domain.model.movie.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUpcomingMoviesUsecase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        page: Int? = null,
        region: String? = null,
        language: String? = null
    ): Flow<List<Movie>> {
        movieRepository.refreshUpcomingMovies()
        movieRepository.getUpcomingMovies(1).collect {
            Log.i("TAG", "getUpcomingMovies: ${it.size}")
        }
        return movieRepository.getUpcomingMovies(page, region, language)
    }
}