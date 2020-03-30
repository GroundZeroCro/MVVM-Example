package com.groundzero.mvvm.features.content.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.groundzero.mvvm.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private val args: ProfileFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentProfileBinding.inflate(inflater, container, false).apply {
        user = args.User
    }.root
}
