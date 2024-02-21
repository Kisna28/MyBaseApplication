package com.core.network

import android.content.Context
import com.core.di.GeneralScope
import com.core.network.interceptor.HeaderInterceptor
import kotlinx.coroutines.CoroutineScope

class NetworkModule constructor(
    private val context: Context,
    @GeneralScope private val applicationScope: CoroutineScope

) {

    private val baseNetwork: BaseNetwork by lazy {
        return@lazy BaseNetwork(context, listOf(HeaderInterceptor()))
    }
}