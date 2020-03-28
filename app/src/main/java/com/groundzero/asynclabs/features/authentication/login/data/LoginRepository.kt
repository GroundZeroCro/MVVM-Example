package com.groundzero.asynclabs.features.authentication.login.data

import com.groundzero.asynclabs.data.resultLiveDataPersistant
import com.groundzero.asynclabs.features.authentication.common.persistance.Token
import com.groundzero.asynclabs.features.authentication.common.persistance.TokenDao
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val dataSource: LoginDataSource,
    private val persistenceSource: TokenDao
) {
    fun login(username: String, password: String) =
        resultLiveDataPersistant(
            networkCall = { dataSource.login(username, password) },
            saveLocal = { persistenceSource.insert(Token.fromResponse(it.token)) },
            observeLocal = { persistenceSource.getToken() }
        )
}