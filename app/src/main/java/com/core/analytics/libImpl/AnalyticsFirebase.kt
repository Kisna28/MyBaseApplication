package com.core.analytics.libImpl

import android.content.Context
import android.os.Bundle
import com.core.analytics.BaseAnalytics
import com.core.analytics.model.AnalyticsChannel
//import com.google.firebase.analytics.FirebaseAnalytics

class AnalyticsFirebase(context: Context) /*:
    BaseAnalytics(AnalyticsChannel.CHANNEL_FIREBASE)*/ {
////    private var firebaseAnalytics: FirebaseAnalytics
//
//    init {
////        firebaseAnalytics = FirebaseAnalytics.getInstance(context)
//    }
//
//    override fun push(eventName: String, params: Map<String, Any>) {
////        firebaseAnalytics.logEvent(eventName, params.toBundle())
//    }
//
//    override fun updateUserProperty(
//        profile: Map<String, Any>,
//        channelSpecificExclusion: Map<AnalyticsChannel, List<String>>
//    ) {
//        var updatedData = profile
//        if (channelSpecificExclusion.isNotEmpty() && !channelSpecificExclusion[AnalyticsChannel.CHANNEL_FIREBASE].isNullOrEmpty()
//        ) {
//            updatedData = profile.filterNot {
//                channelSpecificExclusion[AnalyticsChannel.CHANNEL_FIREBASE]!!.contains(
//                    it.key
//                )
//            }
//        }
//        updatedData.forEach {
//            firebaseAnalytics.setUserProperty(it.key, it.value.toString())
//        }
//    }
//
//    override fun trackScreen(screenName: String, screenClass: String) {
//        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, Bundle().apply {
//            putString(FirebaseAnalytics.Param.SCREEN_NAME, screenName)
//            putString(FirebaseAnalytics.Param.SCREEN_CLASS, screenClass)
//        })
//    }
//
//    override fun updateUserId(userId: String) {
//        firebaseAnalytics.setUserId(userId)
//    }
//
//    override fun updateUserSession(profile: Map<String, Any>) {
//        //Not needed
//    }
}