package com.red_velvet.flix.domain.mapper

import com.red_velvet.flix.data.remote.recoures.movie.KeywordsResource

fun KeywordsResource.toModel(): List<String> {
    return keywords?.map { it?.name.orEmpty() } ?: emptyList()
}