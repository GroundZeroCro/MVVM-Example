package com.groundzero.mvvm.features.content.profile.data

import com.groundzero.mvvm.data.resultLiveDataPersistant
import com.groundzero.mvvm.features.content.profile.domain.Profile
import com.groundzero.mvvm.features.content.profile.domain.ProfileDao
import javax.inject.Inject

class ProfileRepository @Inject constructor(
    private val profileDataSource: ProfileDataSource,
    private val profileDao: ProfileDao
) {
    /**
     * Fetching remote data then mapping it to domain object. After successful fetch
     * data is stored to SQLite database and observed with LiveData.
     */
    fun profile(id: Int) = resultLiveDataPersistant(
        networkCall = { profileDataSource.profile(id) },
        saveLocal = { profileDao.insert(Profile.fromResponse(it)) },
        observeLocal = { profileDao.getProfile() }
    )
}