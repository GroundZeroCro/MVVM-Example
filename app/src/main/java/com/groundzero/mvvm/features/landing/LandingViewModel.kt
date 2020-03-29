package com.groundzero.mvvm.features.landing

import androidx.lifecycle.ViewModel
import com.groundzero.mvvm.features.authentication.common.domain.Token
import com.groundzero.mvvm.features.authentication.common.domain.TokenDao
import javax.inject.Inject

class LandingViewModel @Inject constructor(tokenDao: TokenDao) : ViewModel() {

    private val token: Token? = tokenDao.getTokenSync()

    fun goToScreen(): GoScreenType {
        return if (token == null) {
            GoScreenType.LOGIN
        } else {
            GoScreenType.CONTENT
        }
    }
}