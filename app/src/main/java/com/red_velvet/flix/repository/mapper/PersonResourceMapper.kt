package com.red_velvet.flix.data.repository.mapper

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.remote.recoures.person.PersonResource
import com.red_velvet.flix.domain.entity.PersonEntity
import com.red_velvet.flix.domain.utils.orZero

fun PersonResource.toEntity(): PersonEntity {
    return PersonEntity(
        id = id.orZero(),
        name = name.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + profilePath,
        popularity = popularity.orZero(),
        birthday = birthday.orEmpty()

    )
}

fun List<PersonResource>?.toEntity(): List<PersonEntity> {
    return this?.map { it.toEntity() } ?: emptyList()
}