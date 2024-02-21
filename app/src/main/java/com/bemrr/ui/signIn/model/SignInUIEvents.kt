package com.bemrr.ui.signIn.model

/**
 * Created by Kisna Lunagariya on 21/02/24.
 * All rights reserved.
 * kisna.bemrr@gmail.com
 */

sealed class SignInUIEvents {
    class SignInButtonClicked(val emailOrPhone: String, val password: String) : SignInUIEvents()
    object NoEvent : SignInUIEvents()
    
}