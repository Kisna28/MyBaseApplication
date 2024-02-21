package com.core.extension

import java.util.*

/**
 * Created by Shwet Desai on 14/12/23.
 * All rights reserved.
 * shwet.desai0@gmail.com
 */

class ResponseError {
    var errorCode: Int
        private set
    var errorMessageId = INVALID_ERR_RES_ID
        private set
    var isDbFlushIgnored = false
        private set
    var errorMessage = ""
        private set

    constructor(errorCode: Int, errorMsgId: Int) {
        this.errorCode = errorCode
        errorMessageId = errorMsgId
    }

    @JvmOverloads
    constructor(errorCode: Int, errorMsg: String?, isDbFlushIgnored: Boolean = false) {
        this.errorCode = errorCode
        errorMessageId = INVALID_ERR_RES_ID
        errorMessage = errorMsg ?: ""
        this.isDbFlushIgnored = isDbFlushIgnored
    }

    override fun toString(): String {
        return String.format(
            Locale.getDefault(),
            "{ \"error_code\" : %d, \"error_msg\" : %s }",
            errorCode,
            errorMessage
        )
    }

    companion object {
        const val CUSTOM_ERR = -44
        const val NO_INTERNET_ERROR = 400
        const val INVALID_ERR_RES_ID = -1

        @JvmStatic
        fun customError(msg: String): ResponseError {
            return ResponseError(CUSTOM_ERR, msg)
        }

        @JvmStatic
        fun customError(subErrorCode: Int, msg: String): ResponseError {
            return ResponseError(CUSTOM_ERR, "Err-$subErrorCode: $msg")
        }

    }
}