package com.bemrr.ui.signIn.model


/**
 * Created by Kisna Lunagariya on 21/02/24.
 * All rights reserved.
 * kisna.bemrr@gmail.com
 */
sealed class SignInNavEvents {
    class ShowToast(val enum: SignInToastEnum) : SignInNavEvents()
    object NoEvent : SignInNavEvents()

}