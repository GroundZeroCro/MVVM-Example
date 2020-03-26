package com.groundzero.asynclabs.features.authentication.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.groundzero.asynclabs.R
import com.groundzero.asynclabs.databinding.FragmentLoginBinding
import com.groundzero.asynclabs.utils.go

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentLoginBinding.inflate(inflater, container, false).apply {
        authSignUp.setOnClickListener{
            go(R.id.action_loginFragment_to_registrationFragment)
        }
    }.root
}