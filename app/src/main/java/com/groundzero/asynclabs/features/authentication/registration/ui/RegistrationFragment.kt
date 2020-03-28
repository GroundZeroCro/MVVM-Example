package com.groundzero.asynclabs.features.authentication.registration.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.groundzero.asynclabs.R
import com.groundzero.asynclabs.base.BaseFragment
import com.groundzero.asynclabs.data.Result
import com.groundzero.asynclabs.databinding.FragmentRegistrationBinding
import com.groundzero.asynclabs.di.helper.injectViewModel
import com.groundzero.asynclabs.features.content.common.base.ContentActivity
import com.groundzero.asynclabs.utils.go

class RegistrationFragment : BaseFragment() {

    private lateinit var viewModel: RegistrationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentRegistrationBinding.inflate(inflater, container, false).apply {
        viewModel = injectViewModel(viewModelFactory)

        registerButton.setOnClickListener {
            viewModel.register(
                authUsername.text.toString(),
                authEmail.text.toString(),
                authPassword.text.toString()
            ).observe(viewLifecycleOwner, Observer {

                when(it.status) {
                    Result.Status.LOADING ->
                        progressDialog.showDialog(requireContext(), requireContext().getString(R.string.progress_bar_logging_in_message))
                    Result.Status.SUCCESS -> {
                        progressDialog.cancelDialog()
                        startActivity(Intent(requireContext(), ContentActivity::class.java))
                    }
                    Result.Status.ERROR -> {}
                }
            })
        }

        authLogin.setOnClickListener {
            go(R.id.action_registrationFragment_to_loginFragment)
        }
    }.root
}