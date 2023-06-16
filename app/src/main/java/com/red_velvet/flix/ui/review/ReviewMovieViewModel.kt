package com.red_velvet.flix.ui.review

import com.red_velvet.flix.domain.entity.ReviewEntity
import com.red_velvet.flix.domain.usecase.GetMovieReviewsUseCase
import com.red_velvet.flix.ui.base.BaseViewModel
import com.red_velvet.flix.ui.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ReviewMovieViewModel @Inject constructor(
    private val getMovieReview: GetMovieReviewsUseCase
) : BaseViewModel<ReviewUiState>(), ReviewMovieInteractionListener {
    override val _state = MutableStateFlow(ReviewUiState())
    override val state: StateFlow<ReviewUiState> = _state.asStateFlow()

    init {
        getMovieReviewData()
    }

    private fun getMovieReviewData() {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            { getMovieReview(603692) },
            ::getMovieReviewSuccess,
            ::onError
        )
    }

    private fun getMovieReviewSuccess(review: List<ReviewEntity>) {
        val reviewUiState = review.map(ReviewEntity::toUiState)
        _state.update {
            it.copy(
                reviewResult = reviewUiState,
                isLoading = false,
                isEmpty = false,
                error = null
            )
        }
    }

    private fun onError(errorUiState: ErrorUiState) {
        _state.update { it.copy(error = errorUiState, isLoading = false) }
    }

    override fun onClickCardReview() {
        TODO("Not yet implemented")
    }
}