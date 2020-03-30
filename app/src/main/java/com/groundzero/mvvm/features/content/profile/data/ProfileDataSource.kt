package com.groundzero.mvvm.features.content.profile.data

import com.groundzero.mvvm.api.BaseDataSource
import com.groundzero.mvvm.features.content.profile.api.ProfileApi
import javax.inject.Inject

class ProfileDataSource @Inject constructor(private val profileApi: ProfileApi) : BaseDataSource() {
    suspend fun profile(id: Int) = getResult { profileApi.getUserProfile(id) }
}