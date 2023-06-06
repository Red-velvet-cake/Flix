package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.model.movie.Movie
import com.red_velvet.flix.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieDetailsUsecase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(movieId: Int): Movie {
        return movieRepository.getMovieDetails(movieId)
    }
}