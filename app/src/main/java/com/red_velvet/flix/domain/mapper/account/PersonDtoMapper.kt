package com.red_velvet.flix.domain.mapper.account

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.remote.dtos.person.PersonResource
import com.red_velvet.flix.domain.model.account.Person
import com.red_velvet.flix.domain.utils.orZero

fun PersonResource.toModel(): Person {
    return Person(
        id = id.orZero(),
        name = name.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + profilePath.orEmpty(),
        biography = biography.orEmpty(),
        birthday = birthday.orEmpty(),
        knownForDepartment = knownForDepartment.orEmpty(),
        placeOfBirth = placeOfBirth.orEmpty(),
    )
}