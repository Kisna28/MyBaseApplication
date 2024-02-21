package com.core.analytics.libImpl

import com.core.analytics.BaseAnalytics
import com.core.analytics.model.AnalyticsChannel
import com.facebook.appevents.AppEventsLogger

class AnalyticsFacebook(
    private val logger: AppEventsLogger
) : BaseAnalytics(AnalyticsChannel.CHANNEL_FACEBOOK) {

    override fun push(eventName: String, params: Map<String, Any>) {
        logger.logEvent(eventName, params.toBundle())
    }

    override fun updateUserProperty(
        profile: Map<String, Any>,
        channelSpecificExclusion: Map<AnalyticsChannel, List<String>>
    ) {
        //Not Needed
    }

    override fun trackScreen(screenName: String, screenClass: String) {
        //Not needed
    }

    override fun updateUserId(userId: String) {
        //Not needed
    }
    override fun updateUserSession(profile: Map<String, Any>) {
        //Not needed
    }

}