package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.repository.MovieRepository
import javax.inject.Inject

class SearchMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        query: String,
        includeAdult: Boolean = false,
        language: String? = null,
        primaryReleaseYear: Int? = null,
        page: Int? = null,
        region: String? = null
    ): List<MovieEntity>{
      return  movieRepository.searchMovies(
            query,
            includeAdult,
            language,
            primaryReleaseYear,
            page,
            region

        )
    }
}