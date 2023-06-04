package com.red_velvet.flix.domain.mapper

interface Mapper<I, O> {
    fun map(input: I): O
}