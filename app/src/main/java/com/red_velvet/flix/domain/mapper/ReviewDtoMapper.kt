package com.red_velvet.flix.domain.mapper

import com.red_velvet.flix.data.remote.dtos.review.AuthorDetailsDto
import com.red_velvet.flix.data.remote.dtos.review.ReviewDto
import com.red_velvet.flix.domain.model.Review
import com.red_velvet.flix.domain.model.movie.AuthorDetails
import com.red_velvet.flix.domain.utils.orZero


fun ReviewDto.toModel(): Review {
    return Review(
        id = id.orEmpty(),
        author = authorDetails?.toModel()!!,
        content = content.orEmpty(),
        createdAt = createdAt.orEmpty(),
        updatedAt = updatedAt.orEmpty(),
        imageUrl = authorDetails.avatarPath.orEmpty(),
        rating = authorDetails.rating.orZero(),
        username = authorDetails.username.orEmpty(),
    )
}

fun AuthorDetailsDto.toModel(): AuthorDetails {
    return AuthorDetails(
        avatarPath = avatarPath.orEmpty(),
        name = name.orEmpty(),
        rating = rating.orZero(),
        username = username.orEmpty(),
    )
}

fun List<ReviewDto>.toModel(): List<Review> {
    return map { it.toModel() }
}