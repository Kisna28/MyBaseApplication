package com.bemrr.data.user.repo

import com.bemrr.data.user.local.UserLocalSource
import com.bemrr.data.user.remote.UserRemoteSource
import javax.inject.Inject

/**
 * Created by Shwet Desai on 19/02/24.
 * All rights reserved.
 * shwet.bemrr@gmail.com
 */

class UserRepositoryImpl @Inject constructor(private val userRemoteSource: UserRemoteSource,
    private val userLocalSource: UserLocalSource) : UserRepository {
}