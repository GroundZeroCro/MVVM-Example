package com.groundzero.mvvm.features.authentication.registration.data

import com.groundzero.mvvm.api.BaseDataSource
import com.groundzero.mvvm.data.Result
import com.groundzero.mvvm.features.authentication.common.api.AuthenticationApi
import com.groundzero.mvvm.features.authentication.common.api.RegistrationResponse
import javax.inject.Inject

class RegistrationDataSource @Inject constructor(private val api: AuthenticationApi): BaseDataSource() {
    suspend fun register(username: String, email: String, password: String): Result<RegistrationResponse> =
        getResult{api.registerUser(username, email, password)}
}