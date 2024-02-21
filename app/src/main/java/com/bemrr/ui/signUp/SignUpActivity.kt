package com.bemrr.ui.signUp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bemrr.R
import com.bemrr.ui.signIn.SignInFragment
import com.core.extension.openFragmentCommit
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Shwet Desai on 19/02/24.
 * All rights reserved.
 * shwet.bemrr@gmail.com
 */

@AndroidEntryPoint
class SignUpActivity : AppCompatActivity(R.layout.activity_container) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null)
            openFragmentCommit(R.id.container, SignInFragment.newInstance())

    }

}