package com.groundzero.asynclabs.features.authentication.persistance

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val avatar: String,
    val name: String,
    val email: String
)