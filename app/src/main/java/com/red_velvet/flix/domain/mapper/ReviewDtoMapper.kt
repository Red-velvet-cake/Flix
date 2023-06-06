package com.red_velvet.flix.domain.mapper

import com.red_velvet.flix.data.remote.recoures.review.AuthorDetailsResource
import com.red_velvet.flix.data.remote.recoures.review.ReviewResource
import com.red_velvet.flix.domain.entity.ReviewEntity
import com.red_velvet.flix.domain.entity.movie.AuthorDetailsEntity
import com.red_velvet.flix.domain.utils.orZero


fun ReviewResource.toModel(): ReviewEntity {
    return ReviewEntity(
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

fun AuthorDetailsResource.toModel(): AuthorDetailsEntity {
    return AuthorDetailsEntity(
        avatarPath = avatarPath.orEmpty(),
        name = name.orEmpty(),
        rating = rating.orZero(),
        username = username.orEmpty(),
    )
}

fun List<ReviewResource>.toModel(): List<ReviewEntity> {
    return map { it.toModel() }
}