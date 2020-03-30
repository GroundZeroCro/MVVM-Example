package com.groundzero.mvvm.features.authentication.common.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.groundzero.mvvm.features.authentication.common.api.UserResponse
import java.io.Serializable

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val avatar: String,
    val name: String,
    val email: String
): Serializable {
    companion object{
        fun fromUser(user: UserResponse) = User(0, user.avatar, user.name, user.email)
    }
}