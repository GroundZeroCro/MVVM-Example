package com.groundzero.mvvm.features.authentication.registration.data

import com.groundzero.mvvm.data.resultLiveDataPersistant
import com.groundzero.mvvm.features.authentication.common.domain.Token
import com.groundzero.mvvm.features.authentication.common.domain.TokenDao
import com.groundzero.mvvm.features.authentication.common.domain.User
import com.groundzero.mvvm.features.authentication.common.domain.UserDao
import javax.inject.Inject

class RegistrationRepository @Inject constructor(
    private val dataSource: RegistrationDataSource,
    private val userDao: UserDao,
    private val tokenDao: TokenDao
) {
    fun register(username: String, email: String, password: String) = resultLiveDataPersistant(
        networkCall = { dataSource.register(username, email, password) },
        saveLocal = {
            userDao.insert(User.fromUser(it.user))
            tokenDao.insert(Token.fromResponse(it.token))
        },
        observeLocal = { userDao.getUser() }
    )
}