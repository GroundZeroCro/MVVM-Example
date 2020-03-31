package com.groundzero.mvvm.features.content.feed.ui

import androidx.lifecycle.ViewModel
import com.groundzero.mvvm.features.authentication.registration.data.RegistrationRepository
import com.groundzero.mvvm.features.content.feed.data.FeedRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class FeedViewModel @Inject constructor(
    repository: FeedRepository,
    private val registrationRepository: RegistrationRepository
) : ViewModel() {

    private var logoutTapCount = 0

    fun logoutUser(): Boolean {
        incrementLogoutCount()
        if (logoutConditionMet()) {
            return true
        }
        restartLogoutCount()
        return false
    }

    private fun logoutConditionMet() = logoutTapCount >= 2
    private fun incrementLogoutCount() = logoutTapCount++
    private fun restartLogoutCount() = CoroutineScope(IO).launch {
        delay(LOGOUT_RESET_TIME)
        logoutTapCount = 0
    }

    fun removeUserCredentials() {
        CoroutineScope(IO).launch {
            registrationRepository.deleteToken()
            registrationRepository.deleteUser()
        }
    }

    val feed = repository.feed

    companion object {
        private const val LOGOUT_RESET_TIME = 3000L
    }
}