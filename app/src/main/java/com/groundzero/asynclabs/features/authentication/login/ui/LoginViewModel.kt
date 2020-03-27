package com.groundzero.asynclabs.features.authentication.login.ui

import androidx.lifecycle.ViewModel
import com.groundzero.asynclabs.features.authentication.login.data.LoginRepository
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val repository: LoginRepository) : ViewModel() {
    fun login(username: String, password: String) = repository.login(username, password)
}