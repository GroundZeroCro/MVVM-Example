package com.groundzero.mvvm.features.authentication.login.data

import com.groundzero.mvvm.api.BaseDataSource
import com.groundzero.mvvm.data.Result
import com.groundzero.mvvm.features.authentication.common.api.AuthenticationApi
import com.groundzero.mvvm.features.authentication.common.api.LoginResponse
import javax.inject.Inject

class LoginDataSource @Inject constructor(private val api: AuthenticationApi) : BaseDataSource() {
    suspend fun login(username: String, password: String):
            Result<LoginResponse> = getResult { api.loginUser(username, password) }
}