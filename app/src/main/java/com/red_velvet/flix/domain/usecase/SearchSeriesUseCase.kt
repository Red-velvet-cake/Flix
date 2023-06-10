package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.entity.series.SeriesEntity
import com.red_velvet.flix.domain.repository.MovieRepository
import javax.inject.Inject

class SearchSeriesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        query: String,
        firstAirDateYear: Int? = null,
        includeAdult: Boolean = false,
        language: String? = null,
        page: Int? = null,
        year: Int? = null
    ): List<SeriesEntity> {
        return movieRepository.searchTvShows(
            query, firstAirDateYear, includeAdult, language, page, year
        )
    }
}