package com.bemrr.ui.signIn

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bemrr.domain.user.UserUseCase
import com.bemrr.ui.signIn.model.SignInNavEvents
import com.bemrr.ui.signIn.model.SignInToastEnum
import com.bemrr.ui.signIn.model.SignInUIEvents
import com.core.extension.safeLaunch
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

/**
 * Created by Kisna Lunagariya on 21/02/24.
 * All rights reserved.
 * kisna.bemrr@gmail.com
 */

@HiltViewModel
class SignInViewModel @Inject constructor(private val userUseCase: UserUseCase) :
    ViewModel() {

    private val _signInNavEvents: MutableStateFlow<SignInNavEvents> =
        MutableStateFlow(SignInNavEvents.NoEvent)
    val signInNavEvents = _signInNavEvents.asStateFlow()

    private val _signInUIEvents: MutableStateFlow<SignInUIEvents> =
        MutableStateFlow(SignInUIEvents.NoEvent)
        val signInUIEvents = _signInUIEvents.asStateFlow()

       fun notifyEvent(event: SignInUIEvents) {
           when (event) {
               is SignInUIEvents.SignInButtonClicked -> {
                   emailOrPhone = event.emailOrPhone
                   password = event.password
                   onSignInButtonClick()
                   makeApiCall()
               }
               SignInUIEvents.NoEvent -> _signInNavEvents.value = SignInNavEvents.NoEvent
               else -> {}
           }
       }


    // State variables to hold email and password values
    private var emailOrPhone: String = ""
    private var password: String = ""

    private fun isEmailOrPhoneEmpty(): Boolean {
        return emailOrPhone.isEmpty()
    }

    private fun isPasswordEmpty(): Boolean {
        return password.isEmpty()
    }


    // Function to check if email is valid
    private fun isEmailOrPhoneValid(): Boolean {
        val emailOrPhonePattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        val phonePattern = "\\d{10}"

        return if (emailOrPhone.contains('@')) {
            emailOrPhone.matches(emailOrPhonePattern.toRegex()) // Check if email is valid
        } else {
            emailOrPhone.matches(phonePattern.toRegex()) // Check if phone number is valid
        }
    }

    private fun isPasswordValid(): Boolean {
        return password.length >= 6
    }

    // Function to handle sign-in button click
    private fun onSignInButtonClick() {
        if (isEmailOrPhoneEmpty()) {
            _signInNavEvents.value = SignInNavEvents.ShowToast(enum = SignInToastEnum.EMPTY_EMAIL)
            return
        }
        if(isPasswordEmpty()){
            _signInNavEvents.value = SignInNavEvents.ShowToast(enum = SignInToastEnum.EMPTY_PASSWORD)
        }
        if (!isEmailOrPhoneValid()) {
             _signInNavEvents.value = SignInNavEvents.ShowToast(enum = SignInToastEnum.INVALID_EMAIL)
            return
        }
        if (!isPasswordValid()) {
              _signInNavEvents.value = SignInNavEvents.ShowToast(enum = SignInToastEnum.INVALID_PASSWORD)
            return
        }
        // Proceed with sign-in
        _signInNavEvents.value = SignInNavEvents.ShowToast(enum = SignInToastEnum.FIELD_COMPLETED)
        // Call sign-in API or navigate to the next screen
    }
    private fun makeApiCall() {
        viewModelScope.safeLaunch({
            userUseCase.makeSignInApiCall()
        }) { errorCode, message ->
         // _signInNavEvents.value = SignInNavEvents.ShowToast(message)
        }
    }
}