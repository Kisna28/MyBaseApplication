package com.core.analytics

import android.app.Application
import android.content.Context
import com.core.analytics.libImpl.AnalyticsFacebook
import com.core.analytics.libImpl.AnalyticsFirebase
import com.core.analytics.model.AnalyticsChannel
import com.facebook.appevents.AppEventsLogger

class AnalyticsPublisherImpl : AnalyticPublisher, Builder {

    private val analyticsList = mutableListOf<BaseAnalytics>()
    private var defaultChannel: List<AnalyticsChannel> = AnalyticsChannel.values().toList()
    private var deviceId: String = ""
    override fun initDefaultChannel(channels: List<AnalyticsChannel>) {
        defaultChannel = channels
    }

    override fun initDeviceId(deviceId: String) {
        this.deviceId = deviceId
    }

    override fun initFirebase(context: Context) {
//        analyticsList.add(AnalyticsFirebase(context))
    }

    override fun initFacebook(
        logger: AppEventsLogger
    ) {
        analyticsList.add(AnalyticsFacebook(logger))
    }

    override fun initClevertap(
        application: Application,
        debugBuild: Boolean
    ) {
//        analyticsList.add(AnalyticsClevertap(application, debugBuild))
    }

    override fun push(
        eventName: String,
        params: Map<String, Any>,
        channels: List<AnalyticsChannel>
    ) {

        val additionalParams = params.toMutableMap()
        //Add all general info here like below
        additionalParams["platform"] = "android"
        additionalParams["deviceId"] = deviceId


        analyticsList.filter {
            if (channels.isNotEmpty()) channels.contains(it.getChannel())
            else defaultChannel.contains(it.getChannel())
        }.forEach {
            it.push(eventName, additionalParams)
        }
    }

    override fun push(eventName: Pair<String, Map<String, Any>>, channels: List<AnalyticsChannel>) {
        push(eventName.first, eventName.second, channels)
    }

    override fun updateUserProperty(userId: String, profile: Map<String, Any>, channelSpecificExclusion: Map<AnalyticsChannel, List<String>>) {
        analyticsList.forEach {
            updateUserId(userId)
            it.updateUserProperty(profile, channelSpecificExclusion)
        }
    }

    private fun updateUserId(userId: String) {
        analyticsList.forEach {
            it.updateUserId(userId)
        }
    }

    override fun trackScreen(
        screenName: String,
        screenClass: String,
        channels: List<AnalyticsChannel>
    ) {
        analyticsList.filter {
            channels.contains(it.getChannel())
        }.forEach {
            it.trackScreen(screenName, screenClass)
        }
    }

    override fun updateUserSession(profile: Map<String, Any>) {
        analyticsList.forEach {
            it.updateUserSession(profile)
        }
    }
}

interface Builder {

    fun initDefaultChannel(channels: List<AnalyticsChannel>)
    fun initDeviceId(deviceId: String)
    fun initFirebase(context: Context)
    fun initFacebook(
        logger: AppEventsLogger
    )

    fun initClevertap(
        application: Application,
        debugBuild: Boolean
    )
}
