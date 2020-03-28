package com.groundzero.mvvm.features.authentication.common.base

import android.os.Bundle
import com.groundzero.mvvm.R
import com.groundzero.mvvm.base.BaseActivity

class AuthenticationActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)
    }
}