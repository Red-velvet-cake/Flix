package com.red_velvet.flix.domain.usecase

import android.util.Log
import com.red_velvet.flix.domain.entity.movie.MovieCastEntity
import com.red_velvet.flix.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieCastUseCase @Inject constructor(private val repository: MovieRepository) {
    suspend operator fun invoke(movieId: Int):List<MovieCastEntity>{
     return   repository.getMovieCredits(movieId)
    }
}