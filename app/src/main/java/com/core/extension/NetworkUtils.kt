package com.core.extension

import android.system.ErrnoException
import android.system.OsConstants
import com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException
import com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException
import java.net.*
import java.util.*
import javax.net.ssl.SSLException

/**
 * Created by Shwet Desai on 14/12/23.
 * All rights reserved.
 * shwet.desai0@gmail.com
 */

object NetworkUtils {
    fun isUnReachIssue(e: Throwable?): Boolean {
        if (e == null) return false
        if (isUnReachException(e)) return true
        val cause = e.cause ?: return false
        return if (isUnReachException(cause)) true else getSourceCauseOfUnReach(cause) !== cause
    }

    /**
     * Finds the source cause of Un reach issue.
     * Will dig the causes at max of 5 times to find the source.
     *
     *
     * If nothing found, returns the original throwable.
     */
    private fun getSourceCauseOfUnReach(e: Throwable?): Throwable? {
        if (e == null) return e
        var currentCause = e
        var count = 0
        val limit = 5
        while (currentCause != null && count < limit) {
            count++
            if (isUnReachException(currentCause)) return currentCause
            currentCause = currentCause.cause
        }
        return e
    }

    private fun isUnReachException(e: Throwable): Boolean {
        return e is SocketTimeoutException ||
                e is SocketException ||
                e is UnknownHostException ||
                isUnReachHttpDataSourceEx(e) ||
                isUnReachConnectEx(e) ||
                isInvalidResponseCodeExceptionEx(e) ||
                isSSLConnectionAbort(e)
    }

    private fun isSSLConnectionAbort(e: Throwable): Boolean {
        return e is SSLException && (isExceptionMsgHasText(
            e,
            "connection abort"
        ) || isExceptionMsgHasText(e, "connection reset"))
    }

    private fun isUnReachConnectEx(e: Throwable): Boolean {
        return e is ConnectException && isExceptionMsgHasText(e, "failed to connect to")
    }

    private fun isUnReachHttpDataSourceEx(e: Throwable): Boolean {
        return e is HttpDataSourceException && isExceptionMsgHasText(e, "unable to connect to")
    }

    private fun isInvalidResponseCodeExceptionEx(e: Throwable): Boolean {
        return e is InvalidResponseCodeException
    }

    fun wrapUnReachIssue(throwable: Throwable?): ResponseErrorException {
        var throwable = throwable
        throwable = getSourceCauseOfUnReach(throwable)
        val error: ResponseError
        error = if (throwable is SocketTimeoutException) {
            ResponseError.customError("Unable to communicate with App services.")
        } else if (throwable is UnknownHostException) {
            ResponseError.customError("Please check your internet connection")
        } else if (throwable is HttpDataSourceException) {
            if (isUnReachHttpDataSourceEx(throwable)) {
                ResponseError.customError("Please check your internet connection")
            } else {
                ResponseError.customError("Unable to communicate with App services.")
            }
        } else if (throwable is ConnectException) {
            if (isAborted(throwable)) {
                ResponseError.customError("Please check your internet connection")
            } else {
                ResponseError.customError("Unable to communicate with App services.")
            }
        } else if (throwable is SocketException) {
            ResponseError.customError("Unable to communicate with App services.")
        } else {
            ResponseError.customError("Some error occurred")
        }
        return ResponseErrorException(error, throwable)
    }

    fun isUnReachCdnIssue(throwable: Throwable?): Boolean {
        var throwable = throwable
        throwable = getSourceCauseOfUnReach(throwable)
        val isCdnError: Boolean
        isCdnError = if (throwable is SocketTimeoutException) {
            true
        } else if (throwable is UnknownHostException) {
            false
        } else if (throwable is HttpDataSourceException) {
            isUnReachHttpDataSourceEx(throwable) || isInvalidResponseCodeExceptionEx(throwable)
        } else if (throwable is ConnectException) {
            !isAborted(throwable)
        } else throwable is SocketException
        return isCdnError
    }

    private fun isAborted(connectException: ConnectException): Boolean {
        val max = 3
        var cause = connectException.cause
        var count = 0
        while (count < max) {
            if (cause is ErrnoException) {
                val code = cause.errno
                if (code == OsConstants.ECONNABORTED || code == OsConstants.ENETUNREACH) {
                    return true
                }
            } else if (cause != null) {
                cause = cause.cause
            } else {
                break
            }
            count++
        }
        return false
    }

    private fun isExceptionMsgHasText(t: Throwable?, containsText: String): Boolean {
        var containsText = containsText
        containsText = containsText.lowercase(Locale.getDefault())
        if (t == null) return false
        val message = t.message
        return message != null && message.lowercase(Locale.getDefault()).contains(containsText)
    }

    fun checkInternet(): Boolean {
        return try {
            val inAddress = InetAddress.getByName("www.google.com")
            inAddress.hostName != ""
        } catch (e: Exception) {
            false
        }
    }
}