package com.red_velvet.flix.domain.usecase

import android.util.Log
import com.red_velvet.flix.data.repository.MovieRepository
import com.red_velvet.flix.domain.model.movie.Movie
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
        movieRepository.refreshTopRatedMovies()
        movieRepository.getTopRatedMovies(1).collect {
            Log.i("TAG", "getTopRatedMovies: ${it.size}")
        }
        return movieRepository.getTopRatedMovies(page, region, language)
    }
}