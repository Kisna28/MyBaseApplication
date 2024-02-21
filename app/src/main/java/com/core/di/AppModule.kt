package com.core.di

import android.app.Application
import com.core.analytics.AnalyticPublisher
import com.core.analytics.AnalyticsAPI
import com.core.network.BaseNetwork
import com.core.network.NetworkModule
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import javax.inject.Qualifier

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class GeneralScope

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {


    companion object {

        @Provides
        fun getAnalytics(): AnalyticPublisher {
            return AnalyticsAPI.getInstance()
        }

        @Provides
        fun getDemoNetwork(
            context: Application,
            @GeneralScope scope: CoroutineScope
        ): NetworkModule {
            return NetworkModule(context, scope)
        }

    }

}