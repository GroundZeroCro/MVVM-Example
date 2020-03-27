package com.groundzero.asynclabs.features.authentication.login.data

import androidx.lifecycle.LiveData
import com.groundzero.asynclabs.data.Result
import com.groundzero.asynclabs.data.resultLiveData
import com.groundzero.asynclabs.features.authentication.api.LoginResponse
import javax.inject.Inject

class LoginRepository @Inject constructor(private val dataSource: LoginDataSource) {
    val login: LiveData<Result<LoginResponse>> =
        resultLiveData(networkCall = { dataSource.login() })
}