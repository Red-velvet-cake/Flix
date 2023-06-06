package com.red_velvet.flix.domain.mapper

import com.red_velvet.flix.data.remote.recoures.review.AuthorDetailsResource
import com.red_velvet.flix.data.remote.recoures.review.ReviewResource
import com.red_velvet.flix.domain.model.Review
import com.red_velvet.flix.domain.model.movie.AuthorDetails
import com.red_velvet.flix.domain.utils.orZero


fun ReviewResource.toModel(): Review {
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

fun AuthorDetailsResource.toModel(): AuthorDetails {
    return AuthorDetails(
        avatarPath = avatarPath.orEmpty(),
        name = name.orEmpty(),
        rating = rating.orZero(),
        username = username.orEmpty(),
    )
}

fun List<ReviewResource>.toModel(): List<Review> {
    return map { it.toModel() }
}