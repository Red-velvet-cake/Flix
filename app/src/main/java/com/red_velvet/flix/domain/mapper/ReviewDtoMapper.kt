package com.red_velvet.flix.domain.mapper

import com.red_velvet.flix.data.remote.dtos.review.AuthorDetailsDto
import com.red_velvet.flix.data.remote.dtos.review.ReviewDto
import com.red_velvet.flix.domain.model.movie.AuthorDetails
import com.red_velvet.flix.domain.model.Review
import com.red_velvet.flix.domain.utils.orZero


fun ReviewDto.toReview(): Review {
    return Review(
        id = id.orEmpty(),
        author = authorDetails?.toAuthorDetails()!!,
        content = content.orEmpty(),
        createdAt = createdAt.orEmpty(),
        updatedAt = updatedAt.orEmpty(),
        imageUrl = authorDetails.avatarPath.orEmpty(),
        rating = authorDetails.rating.orZero(),
        username = authorDetails.username.orEmpty(),
    )
}

fun AuthorDetailsDto.toAuthorDetails(): AuthorDetails {
    return AuthorDetails(
        avatarPath = avatarPath.orEmpty(),
        name = name.orEmpty(),
        rating = rating.orZero(),
        username = username.orEmpty(),
    )
}