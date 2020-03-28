package com.groundzero.mvvm.features.authentication.login.data

import com.groundzero.mvvm.data.resultLiveDataPersistant
import com.groundzero.mvvm.features.authentication.common.persistance.Token
import com.groundzero.mvvm.features.authentication.common.persistance.TokenDao
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