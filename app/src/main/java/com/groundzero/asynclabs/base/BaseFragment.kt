package com.groundzero.asynclabs.base

import android.content.Context
import androidx.fragment.app.Fragment
import com.groundzero.asynclabs.di.helper.Injectable
import dagger.android.support.AndroidSupportInjection

open class BaseFragment : Fragment(), Injectable {
    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}