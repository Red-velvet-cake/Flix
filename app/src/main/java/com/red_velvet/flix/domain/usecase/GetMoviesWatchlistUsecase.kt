package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.data.repository.UserRepository
import com.red_velvet.flix.domain.model.movie.Movie
import javax.inject.Inject

class GetMoviesWatchlistUsecase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(
        language: String? = null,
        page: Int? = null,
        sortBy: String? = null
    ): List<Movie> {
        return userRepository.getMoviesWatchList(language, page, sortBy)
    }
}