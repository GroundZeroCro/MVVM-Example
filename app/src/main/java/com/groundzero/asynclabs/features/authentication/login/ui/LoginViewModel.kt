package com.groundzero.asynclabs.features.authentication.login.ui

import androidx.lifecycle.ViewModel
import com.groundzero.asynclabs.features.authentication.login.data.LoginRepository
import javax.inject.Inject

class LoginViewModel @Inject constructor(repository: LoginRepository): ViewModel() {
    val login = repository.login
}