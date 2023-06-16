package com.red_velvet.flix.domain.usecase.caching

import java.util.Date
import javax.inject.Inject

class GetCurrentTimestampUseCase @Inject constructor(
    private val date: Date
) {
    operator fun invoke(): Long {
        return date.time
    }
}