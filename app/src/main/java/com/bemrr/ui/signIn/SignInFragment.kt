package com.bemrr.ui.signIn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bemrr.R
import com.bemrr.databinding.FragmentSignInBinding
import com.bemrr.ui.signIn.model.SignInNavEvents
import com.bemrr.ui.signIn.model.SignInToastEnum
import com.bemrr.ui.signIn.model.SignInToastEnum.*
import com.bemrr.ui.signIn.model.SignInUIEvents
import com.core.extension.repeatOnLifecycleOnStarted
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Kisna Lunagariya on 21/02/24.
 * All rights reserved.
 * kisna.bemrr@gmail.com
 */

@AndroidEntryPoint
class SignInFragment : Fragment() {
    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SignInViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
        setUpObserver()
    }

    private fun setUpView() {
        binding.btSignIn.setOnClickListener {
            val emailOrPhone = binding.edSignInEmail.text.toString()
            val password = binding.edSignInPassword.text.toString()
            viewModel.notifyEvent(SignInUIEvents.SignInButtonClicked(emailOrPhone = emailOrPhone,password = password))
        }
    }

    private fun setUpObserver() {
        repeatOnLifecycleOnStarted {
            viewModel.signInNavEvents.collect { event ->
                when (event) {
                    SignInNavEvents.NoEvent -> {}
                    is SignInNavEvents.ShowToast -> when(event.enum){
                        EMPTY_FIELD -> showToast(getString(R.string.string_empty_fields))
                        INVALID_EMAIL -> showToast(getString(R.string.string_invalid_email))
                        INVALID_PASSWORD -> showToast(getString(R.string.string_invalid_password))
                        EMPTY_EMAIL -> showToast(getString(R.string.string_empty_email))
                        EMPTY_PASSWORD -> showToast(getString(R.string.string_empty_password))
                        FIELD_COMPLETED -> showToast(getString(R.string.string_field_completed))
                    }
                }
                   viewModel.notifyEvent(SignInUIEvents.NoEvent)
            }
        }
    }


    private fun showToast(message: String = "") {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    companion object {

        @JvmStatic
        fun newInstance(): SignInFragment = SignInFragment()

    }
}