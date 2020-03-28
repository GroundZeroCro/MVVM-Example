package com.groundzero.asynclabs.features.content.common.base

import android.os.Bundle
import com.groundzero.asynclabs.R
import com.groundzero.asynclabs.base.BaseActivity

class ContentActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)
    }
}