package com.core.extension

/**
 * Created by Shwet Desai on 14/12/23.
 * All rights reserved.
 * shwet.desai0@gmail.com
 */

class ResponseErrorException : RuntimeException {

    var error: ResponseError?

    constructor(error: ResponseError?) : super(error?.toString() ?: "") {
        this.error = error
    }

    constructor(
        error: ResponseError?,
        cause: Throwable?
    ) : super(error?.toString() ?: "", cause) {
        this.error = error
    }

}