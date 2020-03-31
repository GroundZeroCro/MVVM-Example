package com.groundzero.mvvm.base

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.groundzero.mvvm.R
import com.groundzero.mvvm.di.helper.Injectable
import com.groundzero.mvvm.ui.ProgressDialog
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

open class BaseFragment : Fragment(), Injectable {

    @Inject
    lateinit var progressDialog: ProgressDialog

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    fun showToastMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

    protected fun nextActivity(clazz: Class<*>) {
        startActivity(Intent(requireContext(), clazz).apply {
            requireActivity().overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left)
        })
    }
}