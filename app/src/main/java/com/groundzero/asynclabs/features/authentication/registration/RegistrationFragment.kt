package com.groundzero.asynclabs.features.authentication.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.groundzero.asynclabs.R
import com.groundzero.asynclabs.base.BaseFragment
import com.groundzero.asynclabs.databinding.FragmentRegistrationBinding
import com.groundzero.asynclabs.utils.go

class RegistrationFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentRegistrationBinding.inflate(inflater, container, false).apply {
        authLogin.setOnClickListener {
            go(R.id.action_registrationFragment_to_loginFragment)
        }
    }.root
}