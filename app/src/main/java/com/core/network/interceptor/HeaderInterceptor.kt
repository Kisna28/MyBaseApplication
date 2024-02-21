package com.core.network.interceptor

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class HeaderInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()

        val builder: Request.Builder =
            request.newBuilder()

        return chain.proceed(builder.build())
    }
}