package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.data.repository.MovieRepository
import javax.inject.Inject

class GetMovieKeywordsUsecase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(movieId: Int): List<String> {
        return movieRepository.getMovieKeywords(movieId)
    }
}