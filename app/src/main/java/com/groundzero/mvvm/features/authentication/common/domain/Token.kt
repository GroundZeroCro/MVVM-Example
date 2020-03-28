package com.groundzero.mvvm.features.authentication.common.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "token")
data class Token(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val token: String
) {
    companion object {
        fun fromResponse(token: String) = Token(0, token)
    }
}