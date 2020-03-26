package com.groundzero.asynclabs.features.authentication.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.groundzero.asynclabs.R
import com.groundzero.asynclabs.databinding.FragmentRegistrationBinding
import com.groundzero.asynclabs.utils.go

class RegistrationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentRegistrationBinding.inflate(inflater, container, false).apply {
        authLogin.setOnClickListener{
            go(R.id.action_registrationFragment_to_loginFragment)
        }
    }.root
}