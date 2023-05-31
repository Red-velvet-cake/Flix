package com.red_velvet.flix.domain.model

import com.red_velvet.flix.domain.model.Keyword


data class Keywords(
    val id: Int,
    val keywords: List<Keyword>
)