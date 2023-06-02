package com.red_velvet.flix.domain.usecase.movieUsecases

import com.red_velvet.flix.data.repository.MovieRepository
import javax.inject.Inject

class DeleteMovieRatingUsecase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(movieId: Int) = movieRepository.deleteMovieRating(movieId)
}