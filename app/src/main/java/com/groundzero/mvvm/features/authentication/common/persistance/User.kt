package com.groundzero.mvvm.features.authentication.common.persistance

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.groundzero.mvvm.features.authentication.common.api.UserResponse

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val avatar: String,
    val name: String,
    val email: String
) {
    companion object{
        fun fromUser(user: UserResponse) = User(0, user.avatar, user.name, user.email)
    }
}