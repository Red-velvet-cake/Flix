package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.data.repository.MovieRepository
import com.red_velvet.flix.domain.model.Keyword
import javax.inject.Inject

class GetMovieKeywordsUsecase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(movieId: Int): List<Keyword> {
        TODO("Create mapper for Keyword")
//        return movieRepository.getMovieKeywords(movieId)
    }
}