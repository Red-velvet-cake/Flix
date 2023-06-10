package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.entity.PersonEntity
import com.red_velvet.flix.domain.repository.MovieRepository
import javax.inject.Inject

class SearchPersonUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        query: String,
        includeAdult: Boolean = false,
        language: String? = null,
        page: Int? = null,
    ): List<PersonEntity>{
       return movieRepository.searchPeople(query, includeAdult, language, page)
    }
}
