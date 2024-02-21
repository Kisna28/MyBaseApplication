package com.core.network

import android.content.Context
import com.core.network.interceptor.HeaderInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.util.concurrent.TimeUnit

const val DEFAULT_REQUEST_TIMEOUT: Long = 30

class BaseNetwork(
    context: Context,
    private val interceptor: List<Interceptor> = listOf()
) {
    private val httpLoggingInterceptor = HttpLoggingInterceptor()

    private lateinit var headerInterceptor: HeaderInterceptor

    private fun onInit() {
        headerInterceptor = HeaderInterceptor()
    }

    init {
        onInit()
    }

    fun <T> getService(interfaceFile: Class<T>): T {
        return createService(
            interfaceFile,
            "baseUrl",
            provideDefaultOkHttpClient(
                httpLoggingInterceptor,
                headerInterceptor,
                interceptor
            )
        )
    }

    private fun getRetrofit(baseUrl: String, client: OkHttpClient.Builder): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(JacksonConverterFactory.create())
            .client(client.build())
            .build()
    }

    private fun <T> createService(
        interfaceFile: Class<T>,
        baseUrl: String,
        client: OkHttpClient.Builder
    ) = getRetrofit(baseUrl, client).create(interfaceFile)

    private fun provideDefaultOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        headerInterceptor: HeaderInterceptor,
        interceptor: List<Interceptor>
    ): OkHttpClient.Builder {
        val builder = OkHttpClient.Builder()
            .connectTimeout(DEFAULT_REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(DEFAULT_REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(DEFAULT_REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(headerInterceptor)


        interceptor.forEach {
            builder.addInterceptor(it)
        }
        return builder
    }
}