package com.groundzero.mvvm.features.content.profile.ui

import androidx.lifecycle.ViewModel
import com.groundzero.mvvm.features.content.profile.data.ProfileRepository
import javax.inject.Inject

class ProfileViewModel @Inject constructor(private val repository: ProfileRepository) :
    ViewModel() {
    fun getProfilePerId(id: Int) = repository.profile(id)
}