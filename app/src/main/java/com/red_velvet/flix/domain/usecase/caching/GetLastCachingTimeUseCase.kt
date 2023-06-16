package com.red_velvet.flix.domain.usecase.caching

import com.red_velvet.flix.domain.repository.UserRepository
import javax.inject.Inject

class GetLastCachingTimeUseCase @Inject constructor(
    private val userRepository: UserRepository
) {

    suspend operator fun invoke(key: String): Long {
        return userRepository.getLastCachingTimeStamp(key)
    }

}