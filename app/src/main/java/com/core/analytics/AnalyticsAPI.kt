package com.core.analytics

object AnalyticsAPI {
    private val analyticsPublisherImpl = AnalyticsPublisherImpl()

    fun config(analyticsInitializer: Builder.() -> Unit) {
        analyticsPublisherImpl.apply {
            analyticsInitializer()
        }
    }

    @JvmStatic
    fun getInstance(): AnalyticPublisher {
        return analyticsPublisherImpl
    }
}