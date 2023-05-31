package com.red_velvet.flix.domain.mapper

import com.red_velvet.flix.data.remote.dtos.movie.KeywordDto
import com.red_velvet.flix.data.remote.dtos.movie.KeywordsDto
import com.red_velvet.flix.domain.model.Keyword
import com.red_velvet.flix.domain.model.Keywords
import com.red_velvet.flix.domain.utils.orZero

fun KeywordsDto.toKeyword(): Keywords {
    return Keywords(
        id = id.orZero(),
        keywords = keywords?.map { it?.toKeyword()!! } ?: emptyList()
    )
}

fun KeywordDto.toKeyword(): Keyword {
    return Keyword(
        id = id.orZero(),
        name = name.orEmpty()
    )
}



