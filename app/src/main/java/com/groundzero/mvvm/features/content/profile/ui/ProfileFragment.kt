package com.groundzero.mvvm.features.content.profile.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.groundzero.mvvm.R
import com.groundzero.mvvm.base.BaseFragment
import com.groundzero.mvvm.data.Result
import com.groundzero.mvvm.databinding.FragmentProfileBinding
import com.groundzero.mvvm.di.helper.injectViewModel

class ProfileFragment : BaseFragment() {

    private val args: ProfileFragmentArgs by navArgs()
    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentProfileBinding.inflate(inflater, container, false).apply {
        viewModel = injectViewModel(viewModelFactory)
        viewModel.getProfilePerId(args.userId).observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Result.Status.LOADING ->
                    progressDialog.showDialog(
                        requireContext(),
                        requireContext().getString(R.string.progress_bar_loading_profile)
                    )
                Result.Status.SUCCESS -> {
                    progressDialog.cancelDialog()
                    if (it.data != null) {
                        profile = it.data
                    }
                }
                Result.Status.ERROR -> {
                }
            }
        })
    }.root
}
