package com.core.analytics

import android.os.Bundle
import androidx.core.os.bundleOf
import com.core.analytics.model.AnalyticsChannel

abstract class BaseAnalytics(private val channel: AnalyticsChannel) {
    fun getChannel(): AnalyticsChannel = channel
    abstract fun push(eventName: String, params: Map<String, Any>)
    abstract fun updateUserProperty(profile: Map<String, Any>, channelSpecificExclusion: Map<AnalyticsChannel, List<String>> = emptyMap())
    abstract fun trackScreen(screenName: String, screenClass: String)
    abstract fun updateUserId(userId: String)
    abstract fun updateUserSession(profile: Map<String, Any>)
    fun Map<String, Any?>.toBundle(): Bundle = bundleOf(*this.toList().toTypedArray())
}