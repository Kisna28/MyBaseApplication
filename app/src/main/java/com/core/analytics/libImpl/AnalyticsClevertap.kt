package com.core.analytics.libImpl

import android.app.Application
import com.core.analytics.BaseAnalytics
import com.core.analytics.model.AnalyticsChannel

class AnalyticsClevertap(
    application: Application,
    debugBuild: Boolean
) {
//    BaseAnalytics(AnalyticsChannel.CHANNEL_CLEVERTAP) {
//
//    private var cleverTapDefaultInstance: CleverTapAPI? = null
//
//    init {
//        ActivityLifecycleCallback.register(application)
//        CleverTapAPI.setDebugLevel(if (debugBuild) CleverTapAPI.LogLevel.DEBUG else CleverTapAPI.LogLevel.OFF)
//        cleverTapDefaultInstance = CleverTapAPI.getDefaultInstance(application.baseContext)
//    }
//
//    override fun push(eventName: String, params: Map<String, Any>) {
//        cleverTapDefaultInstance?.pushEvent(eventName, params)
//    }
//
//    override fun updateUserProperty(
//        profile: Map<String, Any>,
//        channelSpecificExclusion: Map<AnalyticsChannel, List<String>>
//    ) {
//        var updatedData = profile
//        if (channelSpecificExclusion.isNotEmpty() && !channelSpecificExclusion[AnalyticsChannel.CHANNEL_CLEVERTAP].isNullOrEmpty()
//        ) {
//            updatedData = profile.filterNot {
//                channelSpecificExclusion[AnalyticsChannel.CHANNEL_CLEVERTAP]!!.contains(
//                    it.key
//                )
//            }
//        }
//        cleverTapDefaultInstance?.pushProfile(updatedData)
//    }
//
//    override fun trackScreen(screenName: String, screenClass: String) {
//        cleverTapDefaultInstance?.recordScreen(screenName)
//    }
//
//    override fun updateUserId(userId: String) {
//        //Not Needed
//    }
//
//    override fun updateUserSession(profile: Map<String, Any>) {
//        cleverTapDefaultInstance?.onUserLogin(profile)
//    }
}