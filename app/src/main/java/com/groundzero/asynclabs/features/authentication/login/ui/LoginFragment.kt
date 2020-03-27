package com.groundzero.asynclabs.features.authentication.login.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.groundzero.asynclabs.R
import com.groundzero.asynclabs.base.BaseFragment
import com.groundzero.asynclabs.data.Result
import com.groundzero.asynclabs.databinding.FragmentLoginBinding
import com.groundzero.asynclabs.di.helper.injectViewModel
import com.groundzero.asynclabs.utils.go

class LoginFragment : BaseFragment() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentLoginBinding.inflate(inflater, container, false).apply {

        viewModel = injectViewModel(viewModelFactory)

        loginButton.setOnClickListener {
            viewModel.login(
                authUsername.text.toString(),
                authPassword.text.toString()
            ).observe(viewLifecycleOwner, Observer {
                if (it.status == Result.Status.SUCCESS) {
                    Toast.makeText(requireContext(), "Registration successfull", Toast.LENGTH_LONG)
                        .show()
                }
            })
        }

        authSignUp.setOnClickListener {
            go(R.id.action_loginFragment_to_registrationFragment)
        }
    }.root
}