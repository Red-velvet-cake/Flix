package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.entity.movie.MovieImageEntity
import com.red_velvet.flix.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieImagesUseCase @Inject constructor(private val movieRepository: MovieRepository) {
    suspend operator fun invoke(movieId: Int): List<MovieImageEntity> {
        return movieRepository.getMovieImages(movieId).posters
    }
}