package com.red_velvet.flix.ui.review

import com.red_velvet.flix.domain.entity.ReviewEntity
import com.red_velvet.flix.ui.base.BaseUiState
import com.red_velvet.flix.ui.base.ErrorUiState

data class ReviewUiState(
    val reviewResult: List<MovieReview> = emptyList(),
    val isLoading: Boolean = false,
    val isEmpty: Boolean = false,
    val error: ErrorUiState? = null
) : BaseUiState{
    data class MovieReview(
        val reviewID: Int = 0,
        val content: String = "",
        val createDate: String = "",
        val name: String = "",
        val rating: Int = 0
    )
}




internal fun ReviewEntity.toUiState(): ReviewUiState.MovieReview {
    return ReviewUiState.MovieReview(
        reviewID = id.toInt(),
        content = content,
        createDate = createdAt,
        rating = rating,
        name = author.name
    )
}
