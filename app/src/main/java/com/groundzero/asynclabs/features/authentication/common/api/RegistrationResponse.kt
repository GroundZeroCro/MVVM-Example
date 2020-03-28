package com.groundzero.asynclabs.features.authentication.common.api

data class RegistrationResponse (
    val token: String,
    val user: UserResponse
)