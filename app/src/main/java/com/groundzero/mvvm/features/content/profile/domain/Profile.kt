package com.groundzero.mvvm.features.content.profile.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.groundzero.mvvm.features.content.profile.api.ProfileResponse

@Entity(tableName = "profile")
data class Profile(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val username: String,
    val name: String,
    val views: String,
    val avatar: String
) {
    companion object {
        fun fromResponse(response: ProfileResponse): Profile = Profile(
            response.id,
            response.username,
            response.name,
            response.views,
            response.avatar
        )
    }
}