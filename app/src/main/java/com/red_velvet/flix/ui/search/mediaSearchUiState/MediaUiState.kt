package com.red_velvet.flix.ui.search.mediaSearchUiState


data class MediaUiState(
    val mediaID: Int,
    val mediaName: String,
    val mediaImage: String,
    val mediaPopularity: Double,
    val mediaReleaseDate: String,
)
