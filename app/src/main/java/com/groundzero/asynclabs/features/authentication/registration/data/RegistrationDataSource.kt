package com.groundzero.asynclabs.features.authentication.registration.data

import com.groundzero.asynclabs.api.BaseDataSource
import com.groundzero.asynclabs.data.Result
import com.groundzero.asynclabs.features.authentication.common.api.AuthenticationApi
import com.groundzero.asynclabs.features.authentication.common.api.RegistrationResponse
import javax.inject.Inject

class RegistrationDataSource @Inject constructor(private val api: AuthenticationApi): BaseDataSource() {
    suspend fun register(username: String, email: String, password: String): Result<RegistrationResponse> =
        getResult{api.registerUser(username, email, password)}
}