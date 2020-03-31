package com.groundzero.mvvm.features.content.common.base

import android.os.Bundle
import com.groundzero.mvvm.R
import com.groundzero.mvvm.base.BaseActivity


class ContentActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)
    }
}