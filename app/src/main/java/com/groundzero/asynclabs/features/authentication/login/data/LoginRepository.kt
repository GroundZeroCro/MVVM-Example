package com.groundzero.asynclabs.features.authentication.login.data

import com.groundzero.asynclabs.data.resultLiveData
import com.groundzero.asynclabs.features.authentication.persistance.Token
import com.groundzero.asynclabs.features.authentication.persistance.TokenDao
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val dataSource: LoginDataSource,
    private val persistenceSource: TokenDao
) {
    val login =
        resultLiveData(
            networkCall = { dataSource.login() },
            observeLocal = { persistenceSource.getToken() },
            saveLocal = { persistenceSource.insert(Token.fromResponse(it.token)) }
        )
}