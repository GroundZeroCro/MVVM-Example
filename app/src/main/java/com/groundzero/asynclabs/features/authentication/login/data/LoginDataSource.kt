package com.groundzero.asynclabs.features.authentication.login.data

import com.groundzero.asynclabs.api.BaseDataSource
import com.groundzero.asynclabs.data.Result
import com.groundzero.asynclabs.features.authentication.common.api.AuthenticationApi
import com.groundzero.asynclabs.features.authentication.common.api.LoginResponse
import javax.inject.Inject

class LoginDataSource @Inject constructor(private val api: AuthenticationApi) : BaseDataSource() {
    suspend fun login(username: String, password: String):
            Result<LoginResponse> = getResult { api.loginUser(username, password) }
}