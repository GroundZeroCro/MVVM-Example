package com.groundzero.mvvm.features.authentication.login.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.groundzero.mvvm.R
import com.groundzero.mvvm.base.BaseFragment
import com.groundzero.mvvm.data.Result
import com.groundzero.mvvm.databinding.FragmentLoginBinding
import com.groundzero.mvvm.di.helper.injectViewModel
import com.groundzero.mvvm.features.content.common.base.ContentActivity
import com.groundzero.mvvm.utils.go

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

                when (it.status) {
                    Result.Status.LOADING ->
                        progressDialog.showDialog(
                            requireContext(),
                            requireContext().getString(R.string.progress_bar_logging_in_message)
                        )
                    Result.Status.SUCCESS -> {
                        progressDialog.cancelDialog()
                        startActivity(Intent(requireContext(), ContentActivity::class.java))
                    }
                    Result.Status.ERROR -> {
                    }
                }
            })
        }

        authSignUp.setOnClickListener {
            go(R.id.action_loginFragment_to_registrationFragment)
        }
    }.root
}