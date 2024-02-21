package com.core.extension

import android.util.Log
import com.core.analytics.AnalyticsAPI
import com.core.analytics.model.AnalyticsChannel
//import com.google.firebase.crashlytics.FirebaseCrashlytics
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


/**
 * Created by Shwet Desai on 14/12/23.
 * All rights reserved.
 * shwet.desai0@gmail.com
 */


const val INTERNET_NOT_FOUND = 502
const val UNKNOWN_ERROR = 999

fun CoroutineScope.safeLaunch(
    launchBody: suspend () -> Unit,
    errorBody: (errorCode: Int, message: String) -> Unit
): Job {
    val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        if (throwable is ResponseErrorException) {
            errorBody.invoke(throwable.error?.errorCode ?: -1, throwable.error?.errorMessage.orEmpty())
        } else if (NetworkUtils.isUnReachIssue(throwable)) {
            errorBody.invoke(
                INTERNET_NOT_FOUND,
                NetworkUtils.wrapUnReachIssue(throwable).error?.errorMessage.orEmpty()
            )
        } else {
//            FirebaseCrashlytics.getInstance().recordException(throwable)
            AnalyticsAPI.getInstance().push(
                "crash_record",
                throwableToMap(throwable),
                channels = listOf(AnalyticsChannel.CHANNEL_FIREBASE)
            )
            errorBody.invoke(UNKNOWN_ERROR, "Something Went wrong")
        }
        Log.d("SAFE_LAUNCH", throwable.stackTraceToString())
    }
    return this.launch(coroutineExceptionHandler) {
        launchBody.invoke()
    }
}

private fun throwableToMap(throwable: Throwable): Map<String, String> {
    val throwableMap = mutableMapOf<String, String>()
    val textLimit = 100
    val stackString = throwable.stackTraceToString()
    for (i in 0..2) {
        if (stackString.length > (textLimit * i)) {
            val endIndex = ((i + 1) * textLimit - 1).coerceAtMost(stackString.length - 1)
            throwableMap["stack_${i + 1}"] =
                stackString.substring(startIndex = i * textLimit, endIndex = endIndex)
        }
    }
    throwableMap["ex_msg"] = throwable.message.orEmpty()
    throwableMap["ex_title"] = throwable.javaClass.canonicalName.orEmpty()
    return throwableMap
}
