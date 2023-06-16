package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.entity.series.SeriesEntity
import com.red_velvet.flix.domain.repository.MovieRepository
import com.red_velvet.flix.domain.repository.SeriesRepository
import javax.inject.Inject

class GetLatestMovieUseCase @Inject constructor(private val movieRepository: MovieRepository) {
    suspend operator fun invoke(): MovieEntity {
        return movieRepository.getLatestMovie()
    }
}