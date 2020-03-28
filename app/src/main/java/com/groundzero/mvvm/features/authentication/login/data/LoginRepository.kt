package com.groundzero.mvvm.features.authentication.login.data

import com.groundzero.mvvm.data.resultLiveDataPersistant
import com.groundzero.mvvm.features.authentication.common.domain.Token
import com.groundzero.mvvm.features.authentication.common.domain.TokenDao
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val dataSource: LoginDataSource,
    private val tokenDao: TokenDao
) {
    fun login(username: String, password: String) =
        resultLiveDataPersistant(
            networkCall = { dataSource.login(username, password) },
            saveLocal = { tokenDao.insert(Token.fromResponse(it.token)) },
            observeLocal = { tokenDao.getToken() }
        )
}