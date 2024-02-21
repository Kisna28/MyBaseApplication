package com.core.di

import com.bemrr.data.user.local.UserLocalSource
import com.bemrr.data.user.local.UserLocalSourceImpl
import com.bemrr.data.user.local.dao.UserDao
import com.bemrr.data.user.local.dao.UserDaoImpl
//import com.bemrr.data.user.local.dao.UserDao
//import com.bemrr.data.user.local.dao.UserDaoImpl
import com.bemrr.data.user.remote.UserRemoteSource
import com.bemrr.data.user.remote.UserRemoteSourceImpl
import com.bemrr.data.user.repo.UserRepository
import com.bemrr.data.user.repo.UserRepositoryImpl
import com.bemrr.domain.user.UserUseCase
import com.bemrr.domain.user.UserUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppBindingModule {
    @Binds
    abstract fun userDaoBinding(item: UserDaoImpl): UserDao

    @Binds
    abstract fun userLocalSourceBinding(item: UserLocalSourceImpl): UserLocalSource

    @Binds
    abstract fun userRemoteSourceBinding(item: UserRemoteSourceImpl) : UserRemoteSource

    @Binds
    abstract fun userRepositoryBinding(item: UserRepositoryImpl): UserRepository

    @Binds
    abstract fun userUseCaseBinding(item: UserUseCaseImpl): UserUseCase
}