package com.groundzero.asynclabs.features.authentication.api

data class RegistrationResponse (
    val token: String,
    val user: UserResponse
)