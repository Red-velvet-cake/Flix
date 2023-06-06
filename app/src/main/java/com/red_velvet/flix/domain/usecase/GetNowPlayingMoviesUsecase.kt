package com.red_velvet.flix.domain.usecase

import android.util.Log
import com.red_velvet.flix.data.repository.MovieRepository
import com.red_velvet.flix.domain.model.movie.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNowPlayingMoviesUsecase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        page: Int? = null,
        region: String? = null,
        language: String? = null
    ): Flow<List<Movie>> {
        movieRepository.refreshNowPlayingMovies()
        movieRepository.getNowPlayingMovies(1).collect {
            Log.i("TAG", "getNowPlayingMovies: ${it.size}")
        }
        return movieRepository.getNowPlayingMovies(page, region, language)
    }
}