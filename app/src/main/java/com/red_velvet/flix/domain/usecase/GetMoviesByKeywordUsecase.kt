package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.data.repository.MovieRepository
import com.red_velvet.flix.domain.model.movie.Movie
import javax.inject.Inject

class GetMoviesByKeywordUsecase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        keywordId: Int,
        includeAdult: Boolean = false,
        language: String? = null,
        page: Int? = null,
        region: String? = null
    ): List<Movie> {
        return movieRepository.getMoviesByKeyword(keywordId, includeAdult, language, page, region)
    }
}