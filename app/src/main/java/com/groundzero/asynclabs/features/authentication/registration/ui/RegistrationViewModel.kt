package com.groundzero.asynclabs.features.authentication.registration.ui

import androidx.lifecycle.ViewModel
import com.groundzero.asynclabs.features.authentication.registration.data.RegistrationRepository
import javax.inject.Inject

class RegistrationViewModel @Inject constructor(private val repository: RegistrationRepository) :
    ViewModel() {
    fun register(username: String, email: String, password: String) =
        repository.register(username, email, password)
}