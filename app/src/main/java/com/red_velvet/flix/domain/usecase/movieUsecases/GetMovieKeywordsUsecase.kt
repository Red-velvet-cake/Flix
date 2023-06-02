package com.red_velvet.flix.domain.usecase.movieUsecases

import com.red_velvet.flix.data.repository.MovieRepository
import com.red_velvet.flix.domain.mapper.toModel
import javax.inject.Inject

class GetMovieKeywordsUsecase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(movieId: Int): List<String> {
        return movieRepository.getMovieKeywords(movieId)
            .toModel()
    }
}