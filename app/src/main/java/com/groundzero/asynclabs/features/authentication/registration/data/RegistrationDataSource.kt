package com.groundzero.asynclabs.features.authentication.login.data

import com.groundzero.asynclabs.api.BaseDataSource
import com.groundzero.asynclabs.data.Result
import com.groundzero.asynclabs.features.authentication.api.AuthenticationApi
import com.groundzero.asynclabs.features.authentication.api.LoginResponse
import com.groundzero.asynclabs.features.authentication.api.RegistrationResponse
import javax.inject.Inject

class RegistrationDataSource @Inject constructor(private val api: AuthenticationApi): BaseDataSource() {
    suspend fun register(): Result<RegistrationResponse> = getResult{api.registerUser()}
}