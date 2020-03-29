package com.groundzero.mvvm.features.authentication.registration.ui

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.groundzero.mvvm.R
import com.groundzero.mvvm.features.authentication.registration.data.RegistrationRepository
import javax.inject.Inject

class RegistrationViewModel @Inject constructor(private val repository: RegistrationRepository) :
    ViewModel() {

    private var invalidCredentialsMessage = MutableLiveData<Int>()

    fun credentialsValid(email: String, username: String, password: String, passwordConfirm: String): Boolean {
        return when {
            email.isEmpty() -> {
                invalidCredentialsMessage.value = R.string.empty_email_warning
                false
            }
            username.isEmpty() -> {
                invalidCredentialsMessage.value = R.string.empty_username_warning
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
            password != passwordConfirm -> {
                invalidCredentialsMessage.value = R.string.passwords_do_not_match
                false
            }
            else -> {
                invalidCredentialsMessage.value = 0
                true
            }
        }
    }

    fun credentialsValidationLive(): LiveData<Int> = invalidCredentialsMessage

    fun register(username: String, email: String, password: String) =
        repository.register(username, email, password)

}