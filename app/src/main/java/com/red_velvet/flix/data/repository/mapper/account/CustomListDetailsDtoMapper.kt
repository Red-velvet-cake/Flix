package com.red_velvet.flix.data.repository.mapper.account

import com.red_velvet.flix.data.remote.recoures.list.CustomListDetailsResource
import com.red_velvet.flix.data.repository.mapper.movie.toEntity
import com.red_velvet.flix.domain.entity.account.CustomListDetailsEntity
import com.red_velvet.flix.domain.utils.orZero

fun CustomListDetailsResource.toModel(): CustomListDetailsEntity {
    return CustomListDetailsEntity(
        createdBy = createdBy.orEmpty(),
        description = description.orEmpty(),
        id = id.orEmpty(),
        items = items?.map { it?.toEntity()!! }.orEmpty(),
        name = name.orEmpty(),
        itemCount = itemCount.orZero(),
    )
}

