package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.repository.MovieRepository
import javax.inject.Inject

class SearchUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        query: String,
        page: Int? = null
    ): List<MovieEntity> {
        return movieRepository.search(query, page)
    }
}