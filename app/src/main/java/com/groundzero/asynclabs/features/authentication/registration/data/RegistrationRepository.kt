package com.groundzero.asynclabs.features.authentication.login.data

import androidx.lifecycle.LiveData
import com.groundzero.asynclabs.data.Result
import com.groundzero.asynclabs.data.resultLiveData
import com.groundzero.asynclabs.features.authentication.api.RegistrationResponse
import javax.inject.Inject

class RegistrationRepository @Inject constructor(private val dataSource: RegistrationDataSource) {
    val register: LiveData<Result<RegistrationResponse>> =
        resultLiveData(networkCall = { dataSource.register() })
}