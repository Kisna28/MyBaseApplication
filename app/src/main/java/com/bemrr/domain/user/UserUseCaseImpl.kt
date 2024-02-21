package com.bemrr.domain.user

import com.bemrr.data.user.repo.UserRepository
import javax.inject.Inject

/**
 * Created by Shwet Desai on 19/02/24.
 * All rights reserved.
 * shwet.bemrr@gmail.com
 */

class UserUseCaseImpl @Inject constructor(private val  userRepository: UserRepository) : UserUseCase {
    override suspend fun makeSignInApiCall() {

    }
}