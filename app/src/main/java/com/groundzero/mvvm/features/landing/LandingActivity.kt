package com.groundzero.mvvm.features.landing

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.groundzero.mvvm.R
import com.groundzero.mvvm.base.BaseActivity
import com.groundzero.mvvm.di.helper.injectViewModel
import com.groundzero.mvvm.features.authentication.common.base.AuthenticationActivity
import com.groundzero.mvvm.features.content.common.base.ContentActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LandingActivity : BaseActivity() {

    private lateinit var viewModel: LandingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
        CoroutineScope(IO).launch {
            viewModel = injectViewModel(viewModelFactory)
            delay(1000)
            when (viewModel.goToScreen()) {
                GoScreenType.LOGIN -> nextActivity(AuthenticationActivity::class.java)
                GoScreenType.CONTENT -> nextActivity(ContentActivity::class.java)
            }
        }
    }

    private fun nextActivity(clazz: Class<*>) {
        startActivity(Intent(applicationContext, clazz).apply {
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left)
            finish()
        })
    }
}