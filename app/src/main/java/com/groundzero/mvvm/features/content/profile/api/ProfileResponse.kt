package com.groundzero.mvvm.features.content.profile.api

data class ProfileResponse(
    val id: Int,
    val username: String,
    val name: String,
    val views: String,
    val avatar: String
)