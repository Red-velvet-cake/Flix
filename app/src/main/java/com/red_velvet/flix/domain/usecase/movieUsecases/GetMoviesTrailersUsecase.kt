package com.red_velvet.flix.domain.usecase.movieUsecases

import com.red_velvet.flix.data.repository.MovieRepository
import com.red_velvet.flix.domain.mapper.toModel
import com.red_velvet.flix.domain.model.Trailer
import javax.inject.Inject

class GetMoviesTrailersUsecase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        movieId: Int,
        language: String? = null
    ): List<Trailer> {
        return movieRepository.getMovieTrailers(movieId, language).toModel()
    }
}