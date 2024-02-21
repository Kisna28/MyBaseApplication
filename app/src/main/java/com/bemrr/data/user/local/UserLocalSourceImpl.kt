package com.bemrr.data.user.local

import com.bemrr.data.user.local.dao.UserDao
import javax.inject.Inject

/**
 * Created by Shwet Desai on 19/02/24.
 * All rights reserved.
 * shwet.bemrr@gmail.com
 */

class UserLocalSourceImpl @Inject constructor(private val userDao: UserDao) : UserLocalSource {
}