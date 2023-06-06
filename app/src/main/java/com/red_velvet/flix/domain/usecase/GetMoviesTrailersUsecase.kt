package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.model.Trailer
import com.red_velvet.flix.domain.repository.MovieRepository
import javax.inject.Inject

class GetMoviesTrailersUsecase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        movieId: Int,
        language: String? = null
    ): List<Trailer> {
        return movieRepository.getMovieTrailers(movieId, language)
    }
}