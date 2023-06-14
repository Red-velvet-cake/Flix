package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.repository.MovieRepository
import javax.inject.Inject

class GetFormattedMovieTimeUseCase @Inject constructor(private val movieRepository: MovieRepository) {
    suspend operator fun invoke(movieId: Int): String {
        return convertToFormattedMovieTime(movieRepository.getMovieDetails(movieId).runtime)
    }

    private fun convertToFormattedMovieTime(runtime: String): String {
        val hours = runtime.toInt() / 60
        val minutes = runtime.toInt() % 60
        return "$hours h  $minutes m"
    }
}