package com.groundzero.asynclabs.features.authentication.persistance

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "token")
data class Token(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val token: String
)