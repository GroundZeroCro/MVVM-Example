package com.groundzero.asynclabs.features.authentication.login.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.groundzero.asynclabs.R
import com.groundzero.asynclabs.base.BaseFragment
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

        viewModel.login.observe(viewLifecycleOwner, Observer {
            println(it)
            println(it.data)
            println(it.status)
        })

        authSignUp.setOnClickListener {
            go(R.id.action_loginFragment_to_registrationFragment)
        }
    }.root
}