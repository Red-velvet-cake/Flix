package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.repository.MovieRepository
import javax.inject.Inject

class GetMoviesByKeywordUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        keywordId: Int,
        page: Int? = null,
    ): List<MovieEntity> {
        return movieRepository.getMoviesByKeyword(keywordId, page)
    }
}