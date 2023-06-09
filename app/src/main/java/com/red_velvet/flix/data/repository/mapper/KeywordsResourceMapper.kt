package com.red_velvet.flix.data.repository.mapper

import com.red_velvet.flix.data.remote.recoures.movie.KeywordsResource

fun KeywordsResource.toEntity(): List<String> {
    return keywords?.map { it?.name.orEmpty() } ?: emptyList()
}