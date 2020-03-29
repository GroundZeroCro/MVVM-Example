package com.groundzero.mvvm.features.authentication.login.ui

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.groundzero.mvvm.R
import com.groundzero.mvvm.features.authentication.login.data.LoginRepository
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val repository: LoginRepository) : ViewModel() {

    private var invalidCredentialsMessage = MutableLiveData<Int>()

    fun credentialsValid(email: String, password: String): Boolean {
        return when {
            email.isEmpty() -> {
                invalidCredentialsMessage.value = R.string.empty_email_warning
                false
            }
            password.isEmpty() -> {
                invalidCredentialsMessage.value = R.string.password_empty_warning
                false
            }
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                invalidCredentialsMessage.value = R.string.email_invalid_form
                false
            }
            else -> {
                invalidCredentialsMessage.value = 0
                true
            }
        }
    }

    fun credentialsValidationLive(): LiveData<Int> = invalidCredentialsMessage

    fun login(email: String, password: String) = repository.login(email, password)
}