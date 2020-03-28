package com.groundzero.asynclabs.features.authentication.registration.data

import com.groundzero.asynclabs.data.resultLiveDataPersistant
import com.groundzero.asynclabs.features.authentication.common.persistance.Token
import com.groundzero.asynclabs.features.authentication.common.persistance.TokenDao
import com.groundzero.asynclabs.features.authentication.common.persistance.User
import com.groundzero.asynclabs.features.authentication.common.persistance.UserDao
import javax.inject.Inject

class RegistrationRepository @Inject constructor(
    private val dataSource: RegistrationDataSource,
    private val userPersistence: UserDao,
    private val tokenPersistence: TokenDao
) {
    fun register(username: String, email: String, password: String) = resultLiveDataPersistant(
        networkCall = { dataSource.register(username, email, password) },
        saveLocal = {
            userPersistence.insert(User.fromUser(it.user))
            tokenPersistence.insert(Token.fromResponse(it.token))
        },
        observeLocal = { userPersistence.getUser() }
    )
}