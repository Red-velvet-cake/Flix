package com.red_velvet.flix.domain.mapper.account

import com.red_velvet.flix.data.remote.recoures.list.CustomListDetailsResource
import com.red_velvet.flix.domain.mapper.movie.toModel
import com.red_velvet.flix.domain.model.account.CustomListDetails
import com.red_velvet.flix.domain.utils.orZero

fun CustomListDetailsResource.toModel(): CustomListDetails {
    return CustomListDetails(
        createdBy = createdBy.orEmpty(),
        description = description.orEmpty(),
        id = id.orEmpty(),
        items = items?.map { it?.toModel()!! }.orEmpty(),
        name = name.orEmpty(),
        itemCount = itemCount.orZero(),
    )
}

