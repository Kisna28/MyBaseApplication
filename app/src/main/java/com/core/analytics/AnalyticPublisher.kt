package com.core.analytics

import com.core.analytics.model.AnalyticsChannel

interface AnalyticPublisher {
    fun push(eventName: String, params: Map<String, Any>, channels: List<AnalyticsChannel> = emptyList())

    fun push(eventName: Pair<String, Map<String, Any>>, channels: List<AnalyticsChannel> = emptyList())

    fun updateUserProperty(userId: String, profile: Map<String, Any>, channelSpecificExclusion: Map<AnalyticsChannel, List<String>> = emptyMap())

    fun trackScreen(screenName: String, screenClass: String, channels: List<AnalyticsChannel>)

    fun updateUserSession(profile: Map<String, Any>)
}